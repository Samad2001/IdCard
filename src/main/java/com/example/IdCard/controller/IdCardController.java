package com.example.IdCard.controller;

import com.example.IdCard.model.dto.reponse.IdCardResponse;
import com.example.IdCard.model.dto.request.IdCardRequest;
import com.example.IdCard.service.IdCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("id-cards")
public class IdCardController {

    private final IdCardService idCardService;

    public IdCardController(IdCardService idCardService){
        this.idCardService=idCardService;
    }

    @GetMapping("/no-auth")
    public ResponseEntity<List<IdCardResponse>> getAllIdCards(){
       List<IdCardResponse> idCards = idCardService.getAllIdCards();

        return ResponseEntity.ok(idCards);
    }

    @GetMapping("/no-auth/id/{id}")// {id} pathvariable ile eyni olmalidi

    public ResponseEntity<IdCardResponse> getIdCardById(@PathVariable Long id){
     IdCardResponse idCard = idCardService.getIdCardById(id);
     return ResponseEntity.ok(idCard);
    }

    @PostMapping
    public ResponseEntity<Void> addIdCard(@RequestBody IdCardRequest idCardRequest){
        idCardService.addIdCard(idCardRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity <Void> updateIdCard (@PathVariable Long id,
                                            @RequestBody IdCardRequest idCardRequest){

        idCardService.updateIdCard(id, idCardRequest);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/id/{id}")
    public ResponseEntity <Void> updateIdCardAge(@PathVariable Long id,
                                            @RequestParam Integer age){

        idCardService.updateIdCardAge( id, age);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteIdCardById(@PathVariable Long id){
        idCardService.deleteIdCard(id);
        return ResponseEntity.ok().build();
    }

}
