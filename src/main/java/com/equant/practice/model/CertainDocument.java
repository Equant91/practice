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
import java.util.GregorianCalendar;

@NoArgsConstructor
@EqualsAndHashCode(exclude = "document")
@Entity
@Table(name = "certain_doc")
@Data
public class CertainDocument {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certain_doc_seq")
    @SequenceGenerator(name = "certain_doc_seq", sequenceName = "certain_doc_seq")
    /*Уникальный идентификатор*/
    private Long id;

    /* Служебное поле hibernate*/
    @Version
    private Long version;

    /*Уникальный идентификатор документа из справочника*/
   /*  idHandbookDoc;*/
   @ManyToOne()
   @JoinColumn(name = "id_handbook_doc")
   private Document document;


    /*Номер документа*/
    @Column(name = "doc_number")
    private Long docNumber;


    /*Дата документа*/
    @Column(name = "doc_date" )
    @Temporal(TemporalType.DATE)
    private Date docDate;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "certainDocument")
    private User user;

}
