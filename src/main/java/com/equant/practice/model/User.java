package com.equant.practice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
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
import javax.persistence.Version;

@NoArgsConstructor
@EqualsAndHashCode(exclude = {"office","document", "country"})
@Entity
@Data
public class User {

    /*Уникальный идентификатор*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq",allocationSize = 0)
    private Long id;

    /*Служебное поле hibernate*/
    @Version
    private Long version;

    /*Уникальный идентификатор офиса*/
   /*office_id*/
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    private Office office;

    /* Имя*/
    @Column(name = "first_name")
    private String firstName;

    /*Фамилия*/
    @Column(name = "second_name")
    private String secondName;

    /* Второе имя*/
    @Column(name = "middle_name")
    private String middleName;

    /* Должность*/
    @Column
    private String position;

    /* Телефон*/
    @Column
    private String phone;

    /*Уникальный идентификатор конкретного документа*/
    /*certain_doc_id;*/
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
     private Document document;


    /* Уникальный идентификатор страны гражданства*/
    /*country_id*/
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "country_id")
    private Country country;

    /* Индефицирован*/
    @Column(name = "is_identified")
    private Boolean isIdentified;
}










