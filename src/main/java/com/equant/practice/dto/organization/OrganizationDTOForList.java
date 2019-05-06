package com.equant.practice.dto.organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTOForList {

   @NotNull
    private Long id;

   @NotEmpty
    /* Название организации*/
    private String name;

    @NotNull
    /* Активность*/
    private Boolean isActive;


}
