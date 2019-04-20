package com.equant.practice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
public class CentrainDocument {

    @Getter
    /*Уникальный идентификатор*/
    private long id;

    /* Служебное поле hibernate*/
    private long version;

    /*Уникальный идентификатор документа из справочника*/
    private long id_handbook_doc;

    @Getter @Setter
    /*Номер документа*/
    private long doc_number;

    @Getter @Setter
    /*Дата документа*/
    private Date doc_date;
}
