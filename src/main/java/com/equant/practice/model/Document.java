package com.equant.practice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode(exclude = "documentType")
@Entity
@Table(name = "document")
@Data
public class Document {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_seq")
    @SequenceGenerator(name = "document_seq", sequenceName = "document_seq",allocationSize = 0)
    /*Уникальный идентификатор*/
    private Long id;

    /* Служебное поле hibernate*/
    @Version
    private Long version;

    /*Уникальный идентификатор документа из справочника*/
   /*  idHandbookDoc;*/
   @ManyToOne()
   @JoinColumn(name = "id_document_type")
   private DocumentType documentType;


    /*Номер документа*/
    @Column(name = "doc_number")
    private Long docNumber;


    /*Дата документа*/
    @Column(name = "doc_date" )
    @Temporal(TemporalType.DATE)
    private Date docDate;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "document")
    private User user;

}
