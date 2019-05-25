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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(exclude = {"organizations", "users"})
@Entity
@Data
public class Office {


    /* Уникальный идентификатор*/

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "office_seq")
    @SequenceGenerator(name = "office_seq", sequenceName = "office_seq",allocationSize = 0)
    private Long id;

    /*Служебное поле hibernate*/

    @Version
    private Long version;

    /*Название офиса*/
   @Column
    private String name;

    /*Адрес офиса*/
    @Column
    private String address;

    /*Телефон*/
    @Column
    private String phone;

    /*Активность*/
    @Column(name = "is_active")
    private Boolean isActive;


    @ManyToMany(mappedBy = "offices")
    private Set<Organization> organizations;

    public Set<Organization> getOrganizations() {
        if (organizations == null) {
            organizations = new HashSet<>();
        }
        return organizations;
    }
    public void addOrganizations(Organization organization){
        getOrganizations().add(organization);
        organization.getOffices().add(this);

    }
    @OneToMany(mappedBy = "office" )
    private Set<User> users;
}






