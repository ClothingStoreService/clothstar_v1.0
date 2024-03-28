DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail`
(
    `order_detail_id` BIGINT NOT NULL,
    `product_id`      BIGINT NOT NULL,
    `order_id`        BIGINT NOT NULL,
    `option_id`       BIGINT NOT NULL,
    `quantity`        int    NOT NULL
);

ALTER TABLE `order_detail`
    ADD CONSTRAINT `PK_ORDERDETAIL` PRIMARY KEY (
                                                 `order_detail_id`
        );

ALTER TABLE `order_detail`
    ADD CONSTRAINT `FK_Product_TO_orderDetail_1` FOREIGN KEY (`product_id`)
        REFERENCES `product` (`product_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE `order_detail`
    ADD CONSTRAINT `FK_orders_TO_orderDetail_1` FOREIGN KEY (`order_id`)
        REFERENCES `orders` (`order_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE;


ALTER TABLE `order_detail`
    ADD CONSTRAINT `FK_Option_TO_orderDetail_1` FOREIGN KEY (`option_id`)
        REFERENCES `option` (`option_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE;


ALTER TABLE order_detail
    DROP FOREIGN KEY `FK_Product_TO_orderDetail_1`;