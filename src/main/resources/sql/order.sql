DROP TABLE IF EXISTS `orderline`;

CREATE TABLE `orderline`
(
    `order_id`       bigint       NOT NULL,
    `member_id`      bigint       NOT NULL,
    `delivery_id`    BIGINT       NOT NULL,
    `created_dt`     varchar(255) NOT NULL,
    `created_at`     datetime     NOT NULL DEFAULT now(),
    `status`         varchar(255) NOT NULL DEFAULT 'approve',
    `shipping_amt`   int          NOT NULL,
    `products_amt`   int          NOT NULL,
    `payment_method` varchar(255) NOT NULL,
    `payment_amt`    int          NOT NULL
);

ALTER TABLE `orderline`
    ADD CONSTRAINT `PK_ORDERLINE` PRIMARY KEY (
                                               `order_id`
        );

SELECT *
FROM orderline;


INSERT INTO orderline (order_id, member_id, delivery_id, created_dt, created_at, status, shipping_amt, products_amt,
                       payment_method, payment_amt)
VALUES ('1', '2', '3', 'a', now(), 'b', '4', '5', '6', '7');

