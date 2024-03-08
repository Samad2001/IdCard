package com.example.IdCard.repository;

import com.example.IdCard.model.entity.IdCard;

import java.util.List;

public interface IdCardRepository {
    List<IdCard> getAll();
    IdCard getById(Long id);
    boolean insert(IdCard idCard);
    boolean update(IdCard idCard);
    boolean updateAge(Long id, Integer age);
    boolean delete(Long id);
}
