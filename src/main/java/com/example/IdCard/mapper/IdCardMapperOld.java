//package com.example.IdCard.mapper;
//
//import com.example.IdCard.model.dto.reponse.IdCardResponse;
//import com.example.IdCard.model.dto.request.IdCardRequest;
//import com.example.IdCard.model.entity.IdCard;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component //This annotation indicates that this class is a Spring component, meaning it can be automatically detected and managed by Spring during application startup.
//public class IdCardMapper {
//
//    public List<IdCardResponse> toIdCardResponselist(List<IdCard> idCardList){
//        List<IdCardResponse> idCardResponseList = new ArrayList<>();
//        for (IdCard idCard : idCardList){
//            IdCardResponse idCardResponse = toIdCardResponse(idCard);
//            idCardResponseList.add(idCardResponse);
//        }
//
//        return idCardResponseList;
//    }
//
//    public IdCardResponse toIdCardResponse(IdCard idCard){
//        IdCardResponse idCardResponse = IdCardResponse.builder()
//                .id(idCard.getId())
//                .name(idCard.getName())
//                .surname(idCard.getSurname())
//                .age(idCard.getAge())
//                .finCode(idCard.getFinCode())
//                .series(idCard.getSeries())
//                .serialNumber(idCard.getSerialNumber())
//                .build();
//        return idCardResponse;
//    }
//
//    public IdCard toIdCard(IdCardRequest idCardRequest) {
//        return IdCard.builder()
//                .name(idCardRequest.getName())
//                .surname(idCardRequest.getSurname())
//                .age(idCardRequest.getAge())
//                .finCode(idCardRequest.getFinCode())
//                .series(idCardRequest.getSeries())
//                .serialNumber(idCardRequest.getSerialNumber())
//                .build();
//    }
//    public IdCard toIdCard(Long id, IdCardRequest idCardRequest) {
//        return IdCard.builder()
//                .id(id)
//                .name(idCardRequest.getName())
//                .surname(idCardRequest.getSurname())
//                .age(idCardRequest.getAge())
//                .finCode(idCardRequest.getFinCode())
//                .series(idCardRequest.getSeries())
//                .serialNumber(idCardRequest.getSerialNumber())
//                .build();
//    }
//
//}
