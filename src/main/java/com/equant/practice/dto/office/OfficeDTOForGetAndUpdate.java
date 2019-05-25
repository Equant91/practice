package com.equant.practice.dto.office;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OfficeDTOForGetAndUpdate {


    /* Уникальный идентификатор*/
    @NotNull
    private Long id;

    /*Название офиса*/
    @NotNull
    private String name;

    /*Адрес офиса*/
    @NotNull
    private String address;

    /*Телефон*/
    private String phone;

    /*Активность*/
    private Boolean isActive;
}

