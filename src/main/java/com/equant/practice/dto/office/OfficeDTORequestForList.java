package com.equant.practice.dto.office;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OfficeDTORequestForList {

    /*ID организации*/
    @NotNull
    private Long orgId;

    /* Название организации*/
    private String name;

    /*Телефон*/
    private String phone;

    /* Активность*/
    private Boolean isActive;


}
