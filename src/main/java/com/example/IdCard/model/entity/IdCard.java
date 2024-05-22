package com.example.IdCard.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdCard {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String finCode;
    private String series;
    private String serialNumber;
    }