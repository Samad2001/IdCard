package com.example.IdCard.service.lmpl;

import com.example.IdCard.mapper.IdCardMapper;
import com.example.IdCard.model.dto.response.IdCardResponse;
import com.example.IdCard.model.dto.request.IdCardRequest;
import com.example.IdCard.model.entity.IdCard;
import com.example.IdCard.repository.mapper.IdCardMyBatisRepository;
import com.example.IdCard.service.IdCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class IdCardServicelmpl implements IdCardService {

    private final IdCardMapper idCardMapper;
    private final IdCardMyBatisRepository idCardMyBatisRepository;

    @Override
    public List<IdCardResponse> getAllIdCards() {
//
//        List<IdCard> idCards = idCardMyBatisRepository.findAll();
//        List<IdCardResponse> idCardResponseList = idCardMapper.toIdCardResponselist(idCards);

        List<IdCardResponse> idCardResponseList = new ArrayList<>();
        IdCardResponse idCardResponse = new IdCardResponse();
        idCardResponse.setName("Murad");
        idCardResponse.setId(2L);
        idCardResponse.setFinCode("7cdhsq1");
        idCardResponseList.add(idCardResponse);
        return idCardResponseList;
    }

    @Override
    public IdCardResponse getIdCardById(Long id) {
        Optional<IdCard> idCardOptional = idCardMyBatisRepository.findById(id);

        return idCardOptional
                .map(idCardMapper::toIdCardResponse)
                .orElse(null);
    }

    @Override
    public void addIdCard(IdCardRequest idCardRequest) {
        log.info("AddIdCard request received. IdCardRequest: {}", idCardRequest);
        IdCard idCard = idCardMapper.toIdCard(idCardRequest);
//        log.info("IdCardRequest mapped to IdCard. IdCard: {}", idCard);

        idCardMyBatisRepository.insert(idCard);
        log.info("Add process was successful");
//        log.warn("just  warning {}", idCardRequest);
//        log.error("just error {}", idCardRequest);
    }

    @Override
    public void updateIdCard(Long id, IdCardRequest idCardRequest) {
        IdCard idCard = idCardMapper.toIdCard(id, idCardRequest);
        idCardMyBatisRepository.update(idCard);
    }


    @Override
    public void updateIdCardAge(Long id, Integer age) {
        idCardMyBatisRepository.updateAge(id, age);
    }

    @Override
    public void deleteIdCard(Long id) {
        idCardMyBatisRepository.delete(id);
    }


}
