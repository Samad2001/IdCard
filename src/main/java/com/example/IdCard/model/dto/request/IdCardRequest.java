package com.example.IdCard.model.dto.request;

import com.example.IdCard.model.dto.reponse.IdCardResponse;
import com.example.IdCard.model.entity.IdCard;

import java.util.Objects;

public class IdCardRequest {

    private String name;
    private String surname;
    private Integer age;
    private String finCode;
    private String series;
    private String serialNumber;


    public IdCardRequest(String name,
                         String surname,
                         Integer age,
                         String finCode,
                         String series,
                         String serialNumber) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.finCode = finCode;
        this.series = series;
        this.serialNumber = serialNumber;
    }

//    public static IdCardResponse.IdCardBuilder builder() {
//        return new IdCardResponse.IdCardBuilder();
//    }


    public static class IdCardBuilder{
        private String name;
        private String surname;
        private Integer age;
        private String finCode;
        private String series;
        private String serialNumber;


        public IdCardBuilder name(String name){
            this.name=name;
            return this;
        }
        public IdCardBuilder surname(String surname){
            this.surname=surname;
            return this;
        }


        public IdCardBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public IdCardBuilder finCode(String finCode) {
            this.finCode = finCode;
            return this;
        }

        public IdCardBuilder series(String series) {
            this.series = series;
            return this;
        }

        public IdCardBuilder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public IdCardRequest build(){
            IdCardRequest idCardRequest= new IdCardRequest(
                    this.name,
                    this.surname,
                    this.age,
                    this.finCode,
                    this.series,
                    this.serialNumber
            );
            return idCardRequest;
        }




    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFinCode() {
        return finCode;
    }

    public void setFinCode(String finCode) {
        this.finCode = finCode;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdCardRequest that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(age, that.age) && Objects.equals(finCode, that.finCode) && Objects.equals(series, that.series) && Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, finCode, series, serialNumber);
    }

    @Override
    public String toString() {
        return "IdCardRequst{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", finCode='" + finCode + '\'' +
                ", series='" + series + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
