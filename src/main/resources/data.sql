INSERT INTO organization (version, name, full_name, inn, kpp, address) VALUES ( 0, 'Гармония', 'Центр социального обслудивания Гармония', 3903245641, 321456456, 'ул.Цюрупы'  );
INSERT INTO office(version, org_id, name, address, phone) VALUES ( 0,1,'Центральный','ул.Цюрупы', 567645  );
INSERT INTO user(version, office_id, first_name, position, phone, doc_id, doc_number, doc_date, country_id) VALUES ( 0, 1, 'Андрей', 'менеджер', 796412, 1, 123212, 20.12-2000, 1);
INSERT INTO doc (doc_code, doc_name) VALUES ( 3, 'Свидетельство о рождение' );
INSERT INTO country(citizenship_code, citizenship_name) VALUES ( 643, 'Российская Федерация' );