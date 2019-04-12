INSERT INTO doc ( id, doc_code, doc_name)
VALUES (1, 3, 'Свидетельство о рождение' );

INSERT INTO country(id, citizenship_code, citizenship_name)
VALUES ( 1, 643, 'Российская Федерация' );

INSERT INTO organization (id, version, name, full_name, inn, kpp, address)
VALUES ( 1,0, 'Гармония', 'Центр социального обслудивания Гармония', 3903243212, 321456123, 'ул.Цюрупы'  );

INSERT INTO office(id, version, name, address, phone)
VALUES ( 1, 0,'Центральный','ул.Цюрупы', 567645  );

INSERT INTO user(id, version, office_id, first_name, position, phone, doc_id, doc_number, doc_date, country_id)
VALUES (1, 0, 1, 'Андрей', 'менеджер', 796412, 1, 123212, '2003-03-30', 1);

INSERT INTO organization_office(org_id, office_id)
VALUES( 1,1 );
