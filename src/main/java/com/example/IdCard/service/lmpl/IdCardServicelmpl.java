package com.example.IdCard.service.lmpl;

import com.example.IdCard.mapper.IdCardMapper;
import com.example.IdCard.model.dto.reponse.IdCardResponse;
import com.example.IdCard.model.dto.request.IdCardRequest;
import com.example.IdCard.model.entity.IdCard;
import com.example.IdCard.repository.IdCardRepository;
import com.example.IdCard.service.IdCardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IdCardServicelmpl implements IdCardService {

    private IdCardMapper idCardMapper;
    private IdCardRepository idCardRepository;
    public IdCardServicelmpl(IdCardMapper idCardMapper,IdCardRepository idCardRepositor){
        this.idCardMapper=idCardMapper;
        this.idCardRepository=idCardRepositor;
    }

    @Override
    public List<IdCardResponse> getAllIdCards() {

        List<IdCard> idCards = idCardRepository.getAll();// This line calls a method named getAll() on a idCardRepository object.
        List<IdCardResponse> idCardResponseList= idCardMapper.toIdCardResponselist(idCards);//This method converts the list of IdCard objects into a list of IdCardResponse objects

        return idCardResponseList;
    }

    @Override
    public IdCardResponse getIdCardById(Long id) {
        IdCard idCard = idCardRepository.getById(id);

        return idCardMapper.toIdCardResponse(idCard);
    }

    @Override
    public void addIdCard(IdCardRequest idCardRequest) {
       IdCard idCard = idCardMapper.toIdCard(idCardRequest);
        idCardRepository.insert(idCard);
    }

    @Override
    public void updateIdCard(Long id, IdCardRequest idCardRequest) {
     IdCard idCard = idCardMapper.toIdCard(id, idCardRequest);
     idCardRepository.update(idCard);
    }


    @Override
    public void updateIdCardAge(Long id, Integer age) {
        idCardRepository.updateAge(id, age);
    }

    @Override
    public void deleteIdCard(Long id) {
        idCardRepository.delete(id);
    }


}
