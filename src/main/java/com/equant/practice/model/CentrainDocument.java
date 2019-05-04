package com.equant.practice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode

public class CentrainDocument {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certain_doc_seq")
    @SequenceGenerator(name = "certain_doc_seq", sequenceName = "certain_doc_seq")
    /*Уникальный идентификатор*/
    private long id;

    /* Служебное поле hibernate*/
    @Version
    private long version;

    @Getter @Setter
    /*Уникальный идентификатор документа из справочника*/
    private long id_handbook_doc;

    @Getter @Setter
    /*Номер документа*/
    private long doc_number;

    @Getter @Setter
    /*Дата документа*/
    private Date doc_date;
}
