package com.example.IdCard.repository.lmpl;

import com.example.IdCard.model.entity.IdCard;
import com.example.IdCard.repository.IdCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
//@RequiredArgsConstructor
public class IdCardRepositorylmpl implements IdCardRepository {
    private final JdbcTemplate jdbcTemplate;

    public IdCardRepositorylmpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<IdCard> getAll() {
        String query = "select i.id, i.name, i.surname,i.age , i.fin_code, i.series, i.serialnumber from id_card i;";


        RowMapper<IdCard> rowMapper=  new RowMapper<>(){
            @Override
            public IdCard mapRow(ResultSet rs, int rowNum) throws SQLException {
                return buildIdcard(rs);
            }

    };

        return jdbcTemplate.query(query, rowMapper);

    }

    @Override
    public IdCard getById(Long id) {

        String query = "SELECT i.id, i.name, i.surname, i.age, i.fin_code, i.series, i.serialnumber FROM vs_learning.id_card i where i.id=?";

        RowMapper<IdCard> rowMapper = new RowMapper<IdCard>() {
            @Override
            public IdCard mapRow(ResultSet rs, int rowNum) throws SQLException {
                return  buildIdcard(rs);
            }
        };

      List<IdCard> idCards = jdbcTemplate.query(query, rowMapper, id);

    if (idCards.isEmpty()){
        return IdCard.builder().build();// TODO error
    }
return idCards.get(0);
    }

    @Override
    public boolean insert(IdCard idCard) {


            String query = "insert into id_card(name, surname, age, fin_code, series, serialnumber) values( ?, ?, ?, ?, ?, ?)";

           int res= jdbcTemplate.update(query, idCard.getName(), idCard.getSurname(), idCard.getAge(), idCard.getFinCode(), idCard.getSeries() , idCard.getSerialNumber());

           return res != 0;
    }

    @Override
    public boolean update(IdCard idCard) {
        String query = "update id_card i\n" +
                "set  i.name = ?,i.surname = ?, i.age = ?, i.fin_code = ?,series = ?, serialnumber =? \n" +
                "where i.id =?";

        int res= jdbcTemplate.update(query, idCard.getName(), idCard.getSurname(), idCard.getAge(), idCard.getFinCode(), idCard.getSeries() , idCard.getSerialNumber(), idCard.getId());

        return res != 0;
    }

    @Override
    public boolean updateAge(Long id, Integer age) {

       String  query = " UPDATE vs_learning.id_card i  SET i.age = ? WHERE i.id = ?";
       int res = jdbcTemplate.update(query, age,id);

        return res != 0;
    }

    @Override
    public boolean delete(Long id) {
        String query = "delete from id_card i where i.id = ?";
        int res = jdbcTemplate.update(query, id);

        return res!=0;
    }



    private IdCard buildIdcard(ResultSet rs)throws SQLException{
    return  IdCard.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .age(rs.getInt("age"))
                .finCode(rs.getString("fin_code"))
                .series(rs.getString("series"))
                .serialNumber(rs.getString("serialnumber"))
                .build();

    }
}
