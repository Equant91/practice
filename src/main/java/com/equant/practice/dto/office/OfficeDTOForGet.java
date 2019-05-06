package com.equant.practice.dto.office;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OfficeDTOForGet {


    /* Уникальный идентификатор*/
    private Long id;

    /*Название офиса*/
    private String name;

    /*Адрес офиса*/
    private String address;

    /*Телефон*/
    private String phone;

    /*Активность*/
    private Boolean isActive;
}

