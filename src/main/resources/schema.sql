CREATE TABLE IF NOT EXISTS organization(
  id        INTEGER NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
  version   INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
  name      VARCHAR(30) NOT NULL COMMENT 'Название организации',
  full_name VARCHAR(50) NOT NULL COMMENT 'Полное Название организации',
  inn       VARCHAR(20)     NOT NULL COMMENT 'ИНН',
  kpp       VARCHAR(20)     NOT NULL COMMENT 'КПП',
  address   VARCHAR(50) NOT NULL COMMENT 'Адрес',
  phone     INTEGER COMMENT 'Телефон',
  is_active BOOLEAN COMMENT 'Активность'
);
COMMENT ON TABLE organization IS 'Организация';

CREATE TABLE IF NOT EXISTS office(
  id        INTEGER NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
  version   INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
  name      VARCHAR(30)  COMMENT 'Название офиса',
  address   VARCHAR(50)  COMMENT 'Адрес офиса',
  phone     INTEGER COMMENT 'Телефон',
  is_active BOOLEAN COMMENT 'Активность'
);
COMMENT ON TABLE office IS 'Офис';

CREATE TABLE IF NOT EXISTS organization_office(
  org_id    INTEGER NOT NULL COMMENT 'Уникальный идентификатор организации',
  office_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор офиса',
  PRIMARY KEY (org_id, office_id)
);
COMMENT ON TABLE organization_office IS 'join-таблица для связи офиса и организации';

CREATE TABLE IF NOT EXISTS user(
  id               INTEGER  NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
  version          INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
  office_id        INTEGER     NOT NULL COMMENT 'Уникальный идентификатор офиса',
  first_name       VARCHAR(30) NOT NULL COMMENT 'Имя',
  second_name      VARCHAR(30) COMMENT 'Фамилия',
  middle_name      VARCHAR(30) COMMENT 'Второе имя',
  position         VARCHAR(30) NOT NULL COMMENT 'Должность',
  phone            INTEGER COMMENT 'Телефон',
  doc_id           INTEGER COMMENT 'Уникальный идентификатор документа',
  doc_number       VARCHAR(20) COMMENT 'Номер документа',
  doc_date         DATE COMMENT 'Дата документа',
  country_id       INTEGER COMMENT 'Уникальный идентификатор страны гражданства',
  isIdentified     BOOLEAN COMMENT 'Индефицирован'
);
COMMENT ON TABLE user IS 'Работник';

CREATE TABLE IF NOT EXISTS doc_(
  id       INTEGER NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
  doc_code INTEGER NOT NULL COMMENT 'Код документа',
  doc_name VARCHAR(30) NOT NULL COMMENT 'Название документа'
);
COMMENT ON TABLE doc IS 'Справочник документов';

CREATE TABLE IF NOT EXISTS country(
  id               INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
  citizenship_code INTEGER NOT NULL COMMENT 'Номер страны',
  citizenship_name VARCHAR(30) NOT NULL COMMENT 'Название страны',
);
COMMENT ON TABLE doc IS 'Справочник стран';


CREATE INDEX IX_Organization_Office_Id ON organization_office(org_id);
ALTER TABLE organization_office ADD FOREIGN KEY (org_id) REFERENCES organization(id);

CREATE INDEX IX_Office_Organization_Id ON organization_office(office_id);
ALTER TABLE organization_office ADD FOREIGN KEY (office_id) REFERENCES office(id);

CREATE INDEX IX_User_OfficeId ON user (office_id);
ALTER TABLE user ADD FOREIGN KEY (office_id) REFERENCES office(id);

CREATE INDEX IX_User_DocId ON user (doc_id);
ALTER TABLE user ADD FOREIGN KEY (doc_id) REFERENCES doc(id);

CREATE INDEX IX_User_CountryId ON user (country_id);
ALTER TABLE user ADD FOREIGN KEY (country_id) REFERENCES country(id);