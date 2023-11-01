DROP TABLE IF EXISTS PRICE;
DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS BRAND;

CREATE TABLE BRAND
  (
     ID                     BIGINT          NOT NULL auto_increment,
     CREATED_AT             DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
     NAME                   VARCHAR(255)    NOT NULL,
     UPDATE_AT              DATETIME,
     VERSION                INTEGER         NOT NULL DEFAULT 0,
     PRIMARY KEY (ID)
  )
engine=innodb;

CREATE TABLE PRODUCT
  (
     ID                     BIGINT          NOT NULL auto_increment,
     CREATED_AT             DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
     NAME                   VARCHAR(255)    NOT NULL,
     UPDATE_AT              DATETIME,
     VERSION                INTEGER         NOT NULL DEFAULT 0,
     PRIMARY KEY (ID)
  )
engine=innodb;

CREATE TABLE PRICE
  (
     ID                     BIGINT          NOT NULL auto_increment,
     CREATED_AT             DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
     BRAND_ID               BIGINT          NOT NULL,
     START_DATE             DATETIME        NOT NULL,
     END_DATE               DATETIME        NOT NULL,
     PRICE_LIST_ID          BIGINT          NOT NULL,
     PRODUCT_ID             BIGINT          NOT NULL,
     PRIORITY               INTEGER         NOT NULL,
     PRICE                  DECIMAL(19,2)   NOT NULL,
     CURR                   VARCHAR(4)      NOT NULL,
     UPDATE_AT              DATETIME,
     VERSION                INTEGER         NOT NULL DEFAULT 0,
     PRIMARY KEY (ID)
  )
engine=innodb;

ALTER TABLE PRICE
   ADD CONSTRAINT PRICE_BRAND_FK
   FOREIGN KEY (BRAND_ID)
   REFERENCES BRAND (ID);

ALTER TABLE PRICE
  ADD CONSTRAINT PRICE_PRODUCT_FK
  FOREIGN KEY (PRODUCT_ID)
  REFERENCES PRODUCT (ID);

ALTER TABLE PRICE
  ADD CONSTRAINT PRICE_UK UNIQUE (BRAND_ID, START_DATE, END_DATE, PRICE_LIST_ID, PRODUCT_ID, PRIORITY, CURR)
