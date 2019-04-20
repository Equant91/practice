package com.equant.practice.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
public class Organization {

    /*Уникальный идентификатор*/
    @Getter
    private long id;

    /* Служебное поле hibernate*/
    private long version;

    /* Название организации*/
    @Getter @Setter
    private String name;

    /*Полное Название организации*/
    @Getter @Setter
    private String full_name;

    /* ИНН*/
    @Getter @Setter
    private String inn;

    /* КПП*/
    @Getter @Setter
    private String kpp;

    /* Адрес*/
    @Getter @Setter
    private String address;

    /*  Телефон*/
    @Getter @Setter
    private String phone;

    /* Активность*/
    @Getter @Setter
    private boolean is_active;



}








