package com.equant.practice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class HandbookDocument {

    /*Уникальный идентификатор*/
    @Getter
    private long id;

    /*Служебное поле hibernate*/
    private long version;

    /*Код документа*/
    @Getter @Setter
    private long doc_code;

    @Getter @Setter
    /*Название документа*/
    private String doc_name;
}
