package com.equant.practice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
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
@EqualsAndHashCode(exclude = "certainDocuments")
@Entity
@Table(name = "handbook_doc")
public class Document {

    /*Уникальный идентификатор*/
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_seq")
    @SequenceGenerator(name = "document_seq", sequenceName = "handbook_doc_seq")
    private Long id;

    /*Служебное поле hibernate*/
    @Version
    private Long version;

    /*Код документа*/
    @Column(name = "doc_code")
    @Getter @Setter
    private Long docCode;

    /*Название документа*/
    @Getter @Setter
    @Column(name = "doc_name")
    private String docName;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private Set<CertainDocument> certainDocuments;
}
