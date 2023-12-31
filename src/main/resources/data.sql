INSERT INTO brand (id, created_at, name)
VALUES (1,CURRENT_TIMESTAMP(),  'ZARA');

INSERT INTO brand (id, created_at, name)
VALUES (2, CURRENT_TIMESTAMP(), 'BERSHKA');

INSERT INTO product (id, created_at, name)
VALUES (1, CURRENT_TIMESTAMP(), 'JEAN');

INSERT INTO product (id, created_at, name)
VALUES (2, CURRENT_TIMESTAMP(), 'SWEATER');

INSERT INTO product (id, created_at, name)
VALUES (35455, CURRENT_TIMESTAMP(), 'SHIRT');

INSERT INTO price (id, created_at, brand_id, start_date, end_date, price_list_id, product_id,
                    priority, price, curr)
VALUES (1, CURRENT_TIMESTAMP(), 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455,
0, 23.50, 'EUR');

INSERT INTO price (id, created_at, brand_id, start_date, end_date, price_list_id, product_id,
                    priority, price, curr)
VALUES (2, CURRENT_TIMESTAMP(), 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455,
1, 25.45, 'EUR');

INSERT INTO price (id, created_at, brand_id, start_date, end_date, price_list_id, product_id,
                    priority, price, curr)
VALUES (3, CURRENT_TIMESTAMP(), 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455,
1, 30.50, 'EUR');

INSERT INTO price (id, created_at, brand_id, start_date, end_date, price_list_id, product_id,
                  priority, price, curr)
VALUES (4, CURRENT_TIMESTAMP(), 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455,
1, 38.95, 'EUR');
