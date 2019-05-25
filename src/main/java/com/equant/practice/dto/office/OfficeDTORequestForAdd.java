package com.equant.practice.dto.office;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
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
