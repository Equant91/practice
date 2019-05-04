package com.equant.practice.dto.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {

    /*Код документа*/
    @NotNull
    private long docCode;

    /*Название документа*/
    @NotEmpty
    private String docName;
}
