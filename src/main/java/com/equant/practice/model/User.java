package com.equant.practice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class User {

    /*Уникальный идентификатор*/
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    private long id;

    /*Служебное поле hibernate*/
    @Version
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
    private Boolean isIdentified;
}










