package com.equant.practice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
public class Document {

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
