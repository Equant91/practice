package com.equant.practice.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTOResponseForList {

    /*Уникальный идентификатор*/
    private Long Id;

    /* Имя*/
    private String firstName;

    /*Фамилия*/
    private String secondName;

    /* Второе имя*/
    private String middleName;

    /* Должность*/
    private String position;





}
