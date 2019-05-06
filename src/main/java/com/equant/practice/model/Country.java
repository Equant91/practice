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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(exclude = "users")
@Entity
@Table(name = "country")
public class Country {

    /*Уникальный идентификатор*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
    @SequenceGenerator(name = "country_seq", sequenceName = "country_seq")
    @Getter
    private Long id;

    /*Служебное поле hibernate*/
    @Version
    private long version;

    /*Номер страны*/
    @Getter @Setter
    @Column(name = "citizenship_code")
    private Integer citizenshipCode;

    /*Название страны*/
    @Getter @Setter
    @Column(name = "citizenship_name" )
    private String citizenshipName;

    @OneToMany(mappedBy = "country")
    private Set<User> users;

}
