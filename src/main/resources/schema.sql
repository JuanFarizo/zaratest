DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS price;

CREATE TABLE brand
  (
     id                     BIGINT          NOT NULL auto_increment,
     created_at             DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
     name                   VARCHAR(255)    NOT NULL,
     updated_at              DATETIME,
     version                INTEGER         NOT NULL DEFAULT 0,
     PRIMARY KEY (id)
  );

CREATE TABLE product
  (
     id                     BIGINT          NOT NULL auto_increment,
     created_at             DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
     name                   VARCHAR(255)    NOT NULL,
     updated_at              DATETIME,
     version                INTEGER         NOT NULL DEFAULT 0,
     PRIMARY KEY (id)
  );

CREATE TABLE price
  (
     id                     BIGINT          NOT NULL auto_increment,
     created_at             DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
     brand_id               BIGINT          NOT NULL,
     start_date             DATETIME        NOT NULL,
     end_date               DATETIME        NOT NULL,
     price_list_id          BIGINT          NOT NULL,
     product_id             BIGINT          NOT NULL,
     priority               INTEGER         NOT NULL,
     price                  DECIMAL(19,2)   NOT NULL,
     curr                   VARCHAR(4)      NOT NULL,
     updated_at              DATETIME,
     version                INTEGER         NOT NULL DEFAULT 0,
     PRIMARY KEY (id)
  );

ALTER TABLE price
   ADD CONSTRAINT price_brand_fk
   FOREIGN KEY (brand_id)
   REFERENCES brand (id);

ALTER TABLE price
  ADD CONSTRAINT price_product_fk
  FOREIGN KEY (product_id)
  REFERENCES product (id);

ALTER TABLE price
  ADD CONSTRAINT price_uk UNIQUE (brand_id, start_date, end_date, price_list_id, product_id, priority, curr)
