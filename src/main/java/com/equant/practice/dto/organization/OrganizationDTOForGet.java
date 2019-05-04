package com.equant.practice.dto.organization;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTOForGet {

    /*Уникальный идентификатор*/
    private long id;

    /* Название организации*/

    private String name;

    /*Полное Название организации*/

    private String fullName;

    /* ИНН*/

    private String inn;

    /* КПП*/

    private String kpp;

    /* Адрес*/

    private String address;

    /*  Телефон*/

    private String phone;

    /* Активность*/

    private Boolean isActive;


}
