package com.equant.practice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
public class User {

    /*Уникальный идентификатор*/
    @Getter
    private long id;

    /*Служебное поле hibernate*/
    private long version;

    /*Уникальный идентификатор офиса*/
    @Getter @Setter
    private long office_id;

    /* Имя*/
    @Getter @Setter
    private String first_name;

    /*Фамилия*/
    @Getter @Setter
    private String second_name;

    /* Второе имя*/
    @Getter @Setter
    private String middle_name;

    /* Должность*/
    @Getter @Setter
    private String position;

    /* Телефон*/
    @Getter @Setter
    private String phone;

    /*Уникальный идентификатор конкретного документа*/
    @Getter @Setter
    private long certain_doc_id;

    /* Уникальный идентификатор страны гражданства*/
    @Getter @Setter
    private long country_id;

    /* Индефицирован*/
    @Getter @Setter
    private boolean isIdentified;
}










