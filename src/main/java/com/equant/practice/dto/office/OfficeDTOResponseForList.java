package com.equant.practice.dto.office;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OfficeDTOResponseForList {

    private Long id;

    /* Название организации*/
    private String name;

    /* Активность*/
    private Boolean isActive;

}
