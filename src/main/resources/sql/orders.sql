DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    `order_id`             bigint       NOT NULL,
    `member_id`            bigint       NOT NULL,
    `address_id`           bigint       NOT NULL,
    `created_at`           timestamp    NOT NULL,
    `status`               varchar(255) NOT NULL,
    `total_shipping_price` int          NOT NULL,
    `total_products_price` int          NOT NULL,
    `payment_method`       varchar(255) NOT NULL,
    `total_payment_price`  int          NOT NULL
);

ALTER TABLE orders
    ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
                                           `order_id`
        );

ALTER TABLE `orders`
    ADD CONSTRAINT `FK_member_TO_orders_1` FOREIGN KEY (`member_id`)
        REFERENCES `member` (`member_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE;


ALTER TABLE `orders`
    ADD CONSTRAINT `FK_address_TO_orders_1` FOREIGN KEY (`address_id`)
        REFERENCES `address` (`address_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE;



ALTER TABLE orders
    DROP FOREIGN KEY `FK_member_TO_orders_1`;


SHOW CREATE TABLE orders;
SHOW CREATE TABLE address;
SHOW CREATE TABLE member;

select *
from information_schema.TABLE_CONSTRAINTS;


ALTER TABLE orders
    DROP PRIMARY KEY;


DELETE
FROM orders;


SELECT *
FROM orders;


INSERT INTO orders (order_id, member_id, address_id, created_at, status, total_shipping_price, total_products_price,
                    payment_method, total_payment_price)
VALUES ('14241232', '242', '334', CURRENT_TIMESTAMP, 'WAITING', '3000', '50000', 'CARD', '53000');
