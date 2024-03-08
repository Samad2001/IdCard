package com.example.IdCard.service;

import com.example.IdCard.model.dto.reponse.IdCardResponse;
import com.example.IdCard.model.dto.request.IdCardRequest;

import java.util.List;

public interface IdCardService {
    List<IdCardResponse> getAllIdCards();
    IdCardResponse getIdCardById(Long id);
    void addIdCard(IdCardRequest idCardRequest);
    void updateIdCard(Long id, IdCardRequest idCardRequest);
    void updateIdCardAge(Long id, Integer age);
    void deleteIdCard(Long id);
}
