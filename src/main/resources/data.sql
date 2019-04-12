INSERT INTO handbook_doc ( id, doc_code, doc_name)
VALUES (handbook_doc_seq.nextval, 3, 'Свидетельство о рождение' );

INSERT INTO country(id, citizenship_code, citizenship_name)
VALUES ( country_seq.nextval, 643, 'Российская Федерация' );

INSERT INTO organization (id, version, name, full_name, inn, kpp, address)
VALUES ( org_seq.nextval,0, 'Гармония', 'Центр социального обслудивания Гармония', 3903243212, 321456123, 'ул.Цюрупы'  );

INSERT INTO office(id, version, name, address, phone)
VALUES ( office_seq.nextval, 0,'Центральный','ул.Цюрупы', 567645  );

INSERT INTO certain_doc(id, id_handbook_doc, doc_number, doc_date)
VALUES (certain_doc_seq.nextval,handbook_doc_seq.currval, 123212, '2003-03-30' );

INSERT INTO user(id, version, office_id, first_name, position, phone, certain_doc_id, country_id)
VALUES (user_seq.nextval, 0, office_seq.currval, 'Андрей', 'менеджер', 796412, certain_doc_seq.currval,  country_seq.currval);

INSERT INTO organization_office(org_id, office_id)
VALUES( org_seq.currval,office_seq.currval );
