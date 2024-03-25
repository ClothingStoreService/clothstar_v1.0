DROP TABLE IF EXISTS `orderDetail`;

CREATE TABLE `orderDetail`
(
    `order_detail_id` BIGINT NOT NULL,
    `product_id`      BIGINT NOT NULL,
    `order_id`        BIGINT NOT NULL,
    `option_id`       BIGINT NOT NULL,
    `quantity`        int    NOT NULL
);

ALTER TABLE `orderDetail`
    ADD CONSTRAINT `PK_ORDERDETAIL` PRIMARY KEY (
                                                 `order_detail_id`
        );

ALTER TABLE `orderDetail`
    ADD CONSTRAINT `FK_Product_TO_orderDetail_1` FOREIGN KEY (`product_id`)
        REFERENCES `product` (`product_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE `orderDetail`
    ADD CONSTRAINT `FK_orders_TO_orderDetail_1` FOREIGN KEY (`order_id`)
        REFERENCES `orders` (`order_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE;


ALTER TABLE `orderDetail`
    ADD CONSTRAINT `FK_Option_TO_orderDetail_1` FOREIGN KEY (`option_id`)
        REFERENCES `option` (`option_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE;


ALTER TABLE orderDetail
    DROP FOREIGN KEY `FK_Product_TO_orderDetail_1`;