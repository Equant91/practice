package com.equant.practice.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTORequestForList {

    /*Уникальный идентификатор*/
    private Long officeId;

    /* Имя*/
    private String firstName;

    /*Фамилия*/
    private String secondName;

    /* Второе имя*/
    private String middleName;

    /* Должность*/
    private String position;



    /*Код документа*/
    private Long docCode;



    /*Код страны*/
    private Integer citizenshipCode;



}
