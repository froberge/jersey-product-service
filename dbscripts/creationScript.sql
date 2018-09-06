DROP TABLE IF EXISTS PRODUCTS;
DROP SEQUENCE IF EXISTS products_seq;

BEGIN;

CREATE SEQUENCE products_seq
  START WITH     1
  INCREMENT BY   1;

CREATE TABLE PRODUCTS(
  ID   INT                    NOT NULL,
  NAME VARCHAR(100)           NOT NULL,
  DESCRIPTION VARCHAR(5000)   NOT NULL,
  CATEGORY VARCHAR(50)        NOT NULL,
  SUB_CATEGORY_1 VARCHAR(50)  NOT NULL,
  SUB_CATEGORY_2 VARCHAR(50)  NOT NULL,
  PRICE  NUMERIC (5, 2),
  CREATE_DATE DATE,
  PRIMARY KEY (ID)
);

INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Filter Coffee','Description for the drink #1', 'DRINK', 'COFFEE', 'HOT', 1.50, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION,  CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Filter Coffee','Description for the drink #2', 'DRINK', 'COFFEE', 'HOT', 2.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Americano','Description for the drink #3', 'DRINK', 'COFFEE', 'HOT', 2.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Americano','Description for the drink #4', 'DRINK', 'COFFEE', 'HOT', 3.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Cortado','Description for the drink #5', 'DRINK', 'COFFEE', 'HOT', 3.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Latte','Description for the drink #6', 'DRINK', 'COFFEE', 'HOT', 4.00, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Latte','Description for the drink #7', 'DRINK', 'COFFEE', 'HOT', 4.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'espresso','Description for the drink #8', 'DRINK', 'COFFEE', 'HOT', 2.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'decaf espresso','Description for the drink #9', 'DRINK', 'COFFEE', 'HOT', 2.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Decaf','Description for the drink #10', 'DRINK', 'COFFEE', 'HOT', 1.50, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Decaf','Description for the drink #11', 'DRINK', 'COFFEE', 'HOT', 2.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small TEA','Description for the drink #12', 'DRINK', 'TEA', 'HOT', 2.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large TEA','Description for the drink #13', 'DRINK', 'TEA', 'HOT', 2.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Ice Coffee','Description for the drink #14', 'DRINK', 'COFFEE', 'COLD', 3.00, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Ice Coffee','Description for the drink #15', 'DRINK', 'COFFEE', 'COLD', 3.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Ice Latte','Description for the drink #16', 'DRINK', 'COFFEE', 'COLD', 4.00, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Ice Latte', 'Description for the drink #17', 'DRINK', 'COFFEE', 'COLD', 4.75, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Caramel Frappuccino','Description for the drink #18', 'DRINK', 'COFFEE', 'COLD', 4.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Chocolat Frappuccino','Description for the drink #19', 'DRINK', 'COFFEE', 'COLD', 4.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Caffeine Free Caramel Frappuccino','Description for the drink #20', 'DRINK', 'COFFEE', 'COLD', 4.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Caffeine Free Chocolate Frappuccino','Description for the drink #21', 'DRINK', 'COFFEE', 'COLD', 4.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Small Ice Tea','Description for the drink #22', 'DRINK', 'TEA', 'COLD', 3.25, current_timestamp );
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, CATEGORY, SUB_CATEGORY_1, SUB_CATEGORY_2, PRICE,CREATE_DATE) VALUES
  (nextval('products_seq'), 'Large Ice Tea','Description for the drink #23', 'DRINK', 'TEA', 'COLD', 3.75, current_timestamp );


COMMIT;