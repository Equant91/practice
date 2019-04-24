package com.equant.practice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
public class Office {

    /* Уникальный идентификатор*/
    @Getter
    private long id;

    /*Служебное поле hibernate*/
    private long version;

    /*Название офиса*/
    @Getter @Setter
    private String name;

    /*Адрес офиса*/
    @Getter @Setter
    private String address;

    /*Телефон*/
    @Getter @Setter
    private String phone;

    /*Активность*/
    @Getter @Setter
    private boolean is_active;
}






