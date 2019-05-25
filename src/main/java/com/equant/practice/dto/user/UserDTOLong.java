package com.equant.practice.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserDTOLong {
interface MyValidate {}
public interface MyValidateForAdd extends MyValidate {}
public interface MyValidateForUpdate extends MyValidate {}

    /*Уникальный идентификатор*/
@NotNull(groups = MyValidateForUpdate.class )
@Null(groups = MyValidateForAdd.class)
    private Long id;

@NotNull(groups = MyValidateForAdd.class)
    private Long officeId;


    /* Имя*/
    @NotNull(groups = MyValidate.class)
    private String firstName;

    /*Фамилия*/
    private String secondName;

    /* Второе имя*/
    private String middleName;

    /* Должность*/
    @NotNull(groups = MyValidate.class)
    private String position;

    /* Телефон*/
    private String phone;


    /*document_id*/

        /*document_type*/

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
    private String citizenshipCode;

    /*Название страны*/
    private String citizenshipName;

    /* Индефицирован*/
    private Boolean isIdentified;



}
