package com.equant.practice.dto.organization;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OrganizationDTOForAdd {

    /* Название организации*/
    @NotNull
    private String name;

    /*Полное Название организации*/
    @NotNull
    private String fullName;

    /* ИНН*/
    @NotNull
    private String inn;

    /* КПП*/
    @NotNull
    private String kpp;

    /* Адрес*/
    @NotNull
    private String address;

    /*  Телефон*/
    private String phone;

    /* Активность*/
    private Boolean isActive;


}
