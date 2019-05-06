package com.equant.practice.dto.office;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OfficeDTORequestForAdd {
    /* Уникальный идентификатор*/
    @NotNull
    private Long orgId;

    /*Название офиса*/
    private String name;

    /*Адрес офиса*/
    private String address;

    /*Телефон*/
    private String phone;

    /*Активность*/
    private Boolean isActive;
}
