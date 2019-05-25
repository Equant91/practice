INSERT INTO document_type ( id,version, doc_code, doc_name)
VALUES (document_type_seq.nextval, 0,3, 'Свидетельство о рождение' );

INSERT INTO country(id, version, citizenship_code, citizenship_name)
VALUES ( country_seq.nextval,0, '643', 'Российская Федерация' );

INSERT INTO organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES ( org_seq.nextval,0, 'Гармония', 'Центр социального обслуживания Гармония', 3903243212, 321456123, 'ул.Цюрупы' , 408090, true );

INSERT INTO office(id, version, name, address, phone, is_active)
VALUES ( office_seq.nextval, 0,'Центральный','ул.Цюрупы', 567645 , true);

INSERT INTO document(id, version,id_document_type, doc_number, doc_date)
VALUES (document_seq.nextval, 0, document_type_seq.currval, 123212, '2003-03-30' );

INSERT INTO user(id, version, office_id, first_name, position, phone, document_id, country_id)
VALUES (user_seq.nextval, 0, office_seq.currval, 'Андрей', 'менеджер', 796412, document_seq.currval,  country_seq.currval);

INSERT INTO organization_office(org_id, office_id)
VALUES( org_seq.currval,office_seq.currval );

INSERT INTO country(id, version, citizenship_code, citizenship_name)
VALUES ( country_seq.nextval,0, '032', 'Аргентина' );

INSERT INTO document_type ( id,version, doc_code, doc_name)
VALUES (document_type_seq.nextval, 0,7, 'Военный билет' );

