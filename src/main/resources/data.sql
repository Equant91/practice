INSERT INTO organization (id, version, name, full_name, inn, kpp, address) VALUES ( 1,0, 'Гармония', 'Центр социального обслудивания Гармония', 3903245641, 321456456, 'ул.Цюрупы'  );
INSERT INTO office(id, version, org_id, name, address, phone) VALUES ( 1, 0,1,'Центральный','ул.Цюрупы', 567645  );
INSERT INTO user(id, version, office_id, first_name, position, phone, doc_id, doc_number, doc_date, country_id) VALUES (1, 0, 1, 'Андрей', 'менеджер', 796412, 1, 123212, 20.12-2000, 1);
INSERT INTO doc (id, doc_code, doc_name) VALUES (1, 3, 'Свидетельство о рождение' );
INSERT INTO country(id, citizenship_code, citizenship_name) VALUES ( 1, 643, 'Российская Федерация' );