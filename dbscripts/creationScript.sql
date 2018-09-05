DROP TABLE IF EXISTS PRODUCTS;
DROP SEQUENCE IF EXISTS products_seq;

BEGIN;

CREATE SEQUENCE products_seq
  START WITH     1
  INCREMENT BY   1;

CREATE TABLE PRODUCTS(
  ID   INT                    NOT NULL,
  NAME VARCHAR(100)           NOT NULL,
  CATEGORY VARCHAR(50)        NOT NULL,
  SUB_CATEGORY_1 VARCHAR(50)  NOT NULL,
  SUB_CATEGORY_2 VARCHAR(50)  NOT NULL,
  PRICE  NUMERIC (5, 2),
  CREATE_DATE DATE,
  PRIMARY KEY (ID)
);

INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Filter Coffee','DRINK', 'COFFEE', 'HOT', 1.50, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Filter Coffee','DRINK', 'COFFEE', 'HOT', 2.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Americano','DRINK', 'COFFEE', 'HOT', 2.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Americano','DRINK', 'COFFEE', 'HOT', 3.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Cortado','DRINK', 'COFFEE', 'HOT', 3.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Latte','DRINK', 'COFFEE', 'HOT', 4.00, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Latte','DRINK', 'COFFEE', 'HOT', 4.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'espresso','DRINK', 'COFFEE', 'HOT', 2.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'decaf espresso','DRINK', 'COFFEE', 'HOT', 2.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Decaf','DRINK', 'COFFEE', 'HOT', 1.50, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Decaf','DRINK', 'COFFEE', 'HOT', 2.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small TEA','DRINK', 'TEA', 'HOT', 2.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large TEA','DRINK', 'TEA', 'HOT', 2.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Ice Coffee','DRINK', 'COFFEE', 'COLD', 3.00, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Ice Coffee','DRINK', 'COFFEE', 'COLD', 3.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Ice Latte','DRINK', 'COFFEE', 'COLD', 4.00, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Ice Latte', 'DRINK', 'COFFEE', 'COLD', 4.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Caramel Frappuccino','DRINK', 'COFFEE', 'COLD', 4.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Chocolat Frappuccino','DRINK', 'COFFEE', 'COLD', 4.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Caffeine Free Caramel Frappuccino','DRINK', 'COFFEE', 'COLD', 4.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Caffeine Free Chocolate Frappuccino','DRINK', 'COFFEE', 'COLD', 4.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Ice Tea','DRINK', 'TEA', 'COLD', 3.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Ice Tea','DRINK', 'TEA', 'COLD', 3.75, current_timestamp );


COMMIT;