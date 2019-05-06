package com.equant.practice.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDTOForGet {

    /*Уникальный идентификатор*/
    private Long id;

    /* Имя*/
    private String firstName;

    /*Фамилия*/
    private String secondName;

    /* Второе имя*/
    private String middleName;

    /* Должность*/
    private String position;

    /* Телефон*/
    private String phone;


    /*certain_doc_id*/

        /*id_handbook_doc*/

    /*Название документа*/
    private String docName;

    /*Код документа*/
    private Long docCode;
       /**/

    /*Номер документа*/
    private Long docNumber;


    /*Дата документа*/
    private Date docDate;

    /*country_id*/

    /*Код страны*/
    private Integer citizenshipCode;

    /*Название страны*/
    private String citizenshipName;

    /* Индефицирован*/
    private Boolean isIdentified;



}
