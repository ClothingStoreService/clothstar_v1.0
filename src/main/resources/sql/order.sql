DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    `order_id`       bigint       NOT NULL,
    `member_id`      bigint       NOT NULL,
    `delivery_id`    bigint       NOT NULL,
    `created_date`   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_at`     timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `status`         varchar(255) NOT NULL DEFAULT 'APPROVE',
    `shipping_amt`   int          NOT NULL,
    `products_amt`   int          NOT NULL,
    `payment_method` varchar(255) NOT NULL,
    `payment_amt`    int          NOT NULL
);

ALTER TABLE orders
    ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
                                           `order_id`
        );

ALTER TABLE orders
    DROP PRIMARY KEY;

SELECT *
FROM orders;


INSERT INTO orders (order_id, member_id, delivery_id, created_date, created_at, status, shipping_amt, products_amt,
                    payment_method, payment_amt)
VALUES ('14241232', '242', '334', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'APPROVE', '3000', '50000', 'CARD', '53000');

INSERT INTO orders (order_id, member_id, delivery_id, shipping_amt,
                    products_amt,
                    payment_method, payment_amt)
VALUES ('142412321', '242', '334', '3000', '50000', 'CARD', '53000');
