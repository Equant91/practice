package com.equant.practice.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Data
public class Organization {

    /*Уникальный идентификатор*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_seq")
    @SequenceGenerator(name = "org_seq", sequenceName = "org_seq",allocationSize = 0)
    private long id;

    /* Служебное поле hibernate*/
    @Version
    private long version;

    /* Название организации*/
    @Column
    private String name;

    /*Полное Название организации*/
    @Column(name = "full_name")
    private String fullName;

    /* ИНН*/
    @Column
    private String inn;

    /* КПП*/
    @Column
    private String kpp;

    /* Адрес*/
    @Column
    private String address;

    /*  Телефон*/
    @Column
    private String phone;

    /* Активность*/
    @Column(name = "is_active")
    private Boolean isActive;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE })
            @JoinTable (name = "organization_office",
            joinColumns = @JoinColumn(name = "org_id"),
            inverseJoinColumns = @JoinColumn(name = "office_id"))
    private Set<Office> offices;


    public Set<Office> getOffices() {
        if (offices == null) {
            offices = new HashSet<>();
        }
        return offices;
    }
    public void addOffices(Office office){
        getOffices().add(office);

    }
}








