package com.equant.practice.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserDTORequestForList {

    /*Уникальный идентификатор*/
    @NotNull
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
    private String citizenshipCode;



}
