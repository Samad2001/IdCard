package com.example.IdCard.util;

import com.example.IdCard.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.*;
import java.util.function.Function;

@Component
public class JwtProvider {

    @Value("${security.secret-key}")
    private String secretKey ;

    @Value("${security.expration}")
    private Long expiration;

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }


    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())  /*username yada email olur adeten  unique olur adeten*/
                .setIssuedAt(new Date(System.currentTimeMillis())) //cari vaxti date cevirir
                .setExpiration(new Date(System.currentTimeMillis() +expiration)) //token 5 deqiqe kecerli olacaq
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();//tokeni generate edir
    }


    public String extractUsername(String token) {
//        extractClaims(token, (claims)->claims.getSubject());
       return extractClaims(token, Claims::getSubject);//Claims::getSubject = (claims)->claims.getSubject()
    }

    public boolean isValid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        boolean isUserNameEquals = Objects.equals(username, userDetails.getUsername());
        boolean isExpired = isExpired(token);
        return isUserNameEquals && !isExpired;
    }

    private boolean isExpired(String token) {
        Date expirationDate = extractExpiration(token);
        Date now = new Date();
        return expirationDate.before(now);
    }


    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }


    private <T> T extractClaims(String token, Function<Claims, T> claimsFunction) {
        Claims claims = extractAllClaims(token);
        return claimsFunction.apply(claims);
    }


    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey()) /*tokende edit olsa ya  basqa signkey olsa burdan kecmir*/
                .build()
                .parseClaimsJws(token)
                .getBody();//claimsi return edir
    }


    private SecretKey getSignKey(){
        byte[] secretKeyBytes = Decoders.BASE64.decode(secretKey); //decode baytlara cevrir
        return Keys.hmacShaKeyFor(secretKeyBytes);
    }

}
