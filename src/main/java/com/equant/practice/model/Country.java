package com.equant.practice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Country {

    /*Уникальный идентификатор*/
    @Getter
    private long id;

    /*Служебное поле hibernate*/
    private long version;

    /*Номер страны*/
    @Getter @Setter
    private int citizenship_code;

    /*Название страны*/
    @Getter @Setter
    private String citizenship_name;

}
