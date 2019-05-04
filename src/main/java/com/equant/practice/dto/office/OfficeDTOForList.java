package com.equant.practice.dto.office;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OfficeDTOForList {
    @NotNull
    private long id;

    @NotEmpty
    /* Название организации*/
    private String name;

    @NotNull
    /* Активность*/
    private Boolean isActive;

}
