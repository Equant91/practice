package com.equant.practice.model;

import lombok.Data;
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
@EqualsAndHashCode(exclude = "documents")
@Entity
@Data
@Table(name = "document_type")
public class DocumentType {

    /*Уникальный идентификатор*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_type_seq")
    @SequenceGenerator(name = "document_type_seq", sequenceName = "document_type_seq",allocationSize = 0)
    private Long id;

    /*Служебное поле hibernate*/
    @Version
    private Long version;

    /*Код документа*/
    @Column(name = "doc_code")
    private Long docCode;

    /*Название документа*/
    @Column(name = "doc_name")
    private String docName;

    @OneToMany(mappedBy = "documentType", cascade = CascadeType.ALL)
    private Set<Document> documents;
}
