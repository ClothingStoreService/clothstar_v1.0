DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    `order_id`             bigint       NOT NULL,
    `member_id`            bigint       NOT NULL,
    `delivery_id`          bigint       NOT NULL,
    `created_at`           timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `status`               varchar(255) NOT NULL DEFAULT 'APPROVE',
    `total_shipping_price` int          NOT NULL,
    `total_products_price` int          NOT NULL,
    `payment_method`       varchar(255) NOT NULL,
    `total_payment_price`  int          NOT NULL
);

ALTER TABLE orders
    ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
                                           `order_id`
        );

ALTER TABLE orders
    DROP PRIMARY KEY;

SELECT *
FROM orders;


INSERT INTO orders (order_id, member_id, delivery_id, created_at, status, total_shipping_price, total_products_price,
                    payment_method, total_payment_price)
VALUES ('14241232', '242', '334', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'APPROVE', '3000', '50000', 'CARD', '53000');


INSERT INTO orders (order_id, member_id, delivery_id, total_shipping_price,
                    total_products_price,
                    payment_method, total_payment_price)
VALUES ('142412321', '242', '334', '3000', '50000', 'CARD', '53000');
