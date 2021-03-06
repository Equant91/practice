package com.equant.practice.dto.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {


    /*Номер страны*/
    @NotNull
    private Integer citizenshipCode;

    /*Название страны*/
    @NotEmpty
    private String citizenshipName;
}
