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
@Table(name = "country")
public class Country {

    /*Уникальный идентификатор*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
    @SequenceGenerator(name = "country_seq", sequenceName = "country_seq")
    @Getter
    private long id;

    /*Служебное поле hibernate*/
    @Version
    private long version;

    /*Номер страны*/
    @Getter @Setter
    @Column(name = "citizenship_code")
    private int citizenshipCode;

    /*Название страны*/
    @Getter @Setter
    @Column(name = "citizenship_name" )
    private String citizenshipName;

}
