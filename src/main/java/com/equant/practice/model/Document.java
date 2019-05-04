package com.equant.practice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "handbook_doc")
public class Document {

    /*Уникальный идентификатор*/
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_seq")
    @SequenceGenerator(name = "document_seq", sequenceName = "handbook_doc_seq")
    private long id;

    /*Служебное поле hibernate*/
    @Version
    private long version;

    /*Код документа*/
    @Column(name = "doc_code")
    @Getter @Setter
    private long docCode;

    /*Название документа*/
    @Getter @Setter
    @Column(name = "doc_name")
    private String docName;
}
