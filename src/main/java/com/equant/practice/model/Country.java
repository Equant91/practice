package com.equant.practice.model;

import lombok.Data;
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
@Data
@Entity
@Table(name = "country")
public class Country {

    /*Уникальный идентификатор*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
    @SequenceGenerator(name = "country_seq", sequenceName = "country_seq",allocationSize = 0)
    private Long id;

    /*Служебное поле hibernate*/
    @Version
    private long version;

    /*Номер страны*/
    @Column(name = "citizenship_code")
    private String citizenshipCode;

    /*Название страны*/
    @Column(name = "citizenship_name" )
    private String citizenshipName;

    @OneToMany(mappedBy = "country")
    private Set<User> users;

}
