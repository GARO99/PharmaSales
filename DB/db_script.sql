DROP DATABASE PHARMASALES;
CREATE DATABASE PHARMASALES;
USE PHARMASALES;

CREATE TABLE IDENTIFICATION_TYPE (
    ID_IDENTIFICATION_TYPE INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `DESCRIPTION` VARCHAR(20) NOT NULL,
    ABBREVIATION VARCHAR(4) NOT NULL
);

CREATE TABLE EMPLOYEE (
    IDENTIFICATION_NUMBER_EMPLOYEE VARCHAR(20) NOT NULL PRIMARY KEY,
    FIRSTNAME VARCHAR(25) NOT NULL,
    LASTNAME VARCHAR(25) NOT NULL,
    PHONE VARCHAR(15) NOT NULL,
    `ADDRESS` VARCHAR(60) NOT NULL,
    FK_ID_IDENTIFICATION_TYPE INT NOT NULL
);

CREATE TABLE USERS (
    ID_USERS INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    EMAIL VARCHAR(100) NOT NULL,
    USERNAME VARCHAR(20) NOT NULL,
    `PASSWORD` VARCHAR(64) NOT NULL,
    FK_IDENTIFICATION_NUMBER_EMPLOYEE VARCHAR(20) NOT NULL
);

CREATE TABLE CLIENT (
    IDENTIFICATION_NUMBER_CLIENT VARCHAR(20) NOT NULL PRIMARY KEY,
    FIRSTNAME VARCHAR(25) NOT NULL,
    LASTNAME VARCHAR(25) NOT NULL,
    PHONE VARCHAR(15) NOT NULL,
    `ADDRESS` VARCHAR(60) NOT NULL,
    FK_ID_IDENTIFICATION_TYPE INT NOT NULL
);

CREATE TABLE PRODUCT_COST (
    ID_PRODUCT_COST INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    PRICE DECIMAL(10, 2) NOT NULL,
    `START_DATE` DATETIME NOT NULL,
    END_DATE DATETIME,
    FK_PRODUCT_CODE VARCHAR(10) NOT NULL
);

CREATE TABLE PRODUCT (
    PRODUCT_CODE VARCHAR(10) NOT NULL PRIMARY KEY,
    PRODUCT_NAME VARCHAR(20) NOT NULL,
    IVA_PERCENT DECIMAL(10, 2) NOT NULL,
    STOCKABLE BOOLEAN NOT NULL
);

CREATE TABLE STOCK (
    ID_STOCK INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    QUANTITY INT NOT NULL,
    UPDATE_AT DATETIME NOT NULL,
    FK_PRODUCT_CODE VARCHAR(10) NOT NULL
);

CREATE TABLE `ORDER` (
    ID_ORDER INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FK_IDENTIFICATION_NUMBER_EMPLOYEE VARCHAR(20) NOT NULL,
    FK_IDENTIFICATION_NUMBER_CLIENT VARCHAR(20) NOT NULL,
    DATE_ORDER DATETIME NOT NULL,
    SUBTOTAL DECIMAL(10, 2) NOT NULL,
    TOTAL DECIMAL(10, 2) NOT NULL
);

CREATE TABLE ORDER_DETAILS(
    ID_ORDER_DETAILS INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    QUANTITY INT NOT NULL,
    COST DECIMAL(10, 2) NOT NULL,
    FK_ID_ORDER INT NOT NULL,
    FK_PRODUCT_CODE VARCHAR(10) NOT NULL
);

-- CREACION DE FOREIGN KEYS

ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_EMPLOYEE_IDENTIFICATION_TYPE FOREIGN KEY (FK_ID_IDENTIFICATION_TYPE) REFERENCES IDENTIFICATION_TYPE(ID_IDENTIFICATION_TYPE) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE CLIENT
ADD CONSTRAINT FK_CLIENT_IDENTIFICATION_TYPE FOREIGN KEY (FK_ID_IDENTIFICATION_TYPE) REFERENCES IDENTIFICATION_TYPE(ID_IDENTIFICATION_TYPE) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE USERS
ADD CONSTRAINT FK_USERS_EMPLOYEE FOREIGN KEY (FK_IDENTIFICATION_NUMBER_EMPLOYEE) REFERENCES EMPLOYEE(IDENTIFICATION_NUMBER_EMPLOYEE) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE PRODUCT_COST
ADD CONSTRAINT FK_PRODUCT_COST_PRODUCT FOREIGN KEY (FK_PRODUCT_CODE) REFERENCES PRODUCT(PRODUCT_CODE) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE STOCK
ADD CONSTRAINT FK_STOCK_PRODUCT FOREIGN KEY (FK_PRODUCT_CODE) REFERENCES PRODUCT(PRODUCT_CODE) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `ORDER`
ADD CONSTRAINT FK_ORDER_EMPLOYEE FOREIGN KEY (FK_IDENTIFICATION_NUMBER_EMPLOYEE) REFERENCES EMPLOYEE(IDENTIFICATION_NUMBER_EMPLOYEE) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT FK_ORDER_CLIENT FOREIGN KEY (FK_IDENTIFICATION_NUMBER_CLIENT) REFERENCES CLIENT(IDENTIFICATION_NUMBER_CLIENT) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE ORDER_DETAILS
ADD CONSTRAINT FK_ORDER_DETAILS_ORDER FOREIGN KEY (FK_ID_ORDER) REFERENCES `ORDER`(ID_ORDER) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT FK_ORDER_DETAILS_PRODUCT FOREIGN KEY (FK_PRODUCT_CODE) REFERENCES PRODUCT(PRODUCT_CODE) ON DELETE NO ACTION ON UPDATE NO ACTION;
