CREATE TABLE `member`
(
    `member_id`           BIGINT       NOT NULL auto_increment,
    `email`               varchar(255) NOT NULL,
    `password`            varchar(255) NOT NULL,
    `name`                varchar(255) NOT NULL,
    `tel_no`              varchar(255) NOT NULL,
    `total_payment_price` INT          NULL,
    `role`                varchar(100) NOT NULL COMMENT 'ADMIN, SELLER, USER',
    `grade`               varchar(100) NOT NULL COMMENT 'BRONZE, SILVER, GOLD, PLATINUM, DIAMOND',
    `created_at`          timestamp    NOT NULL,
    `modified_at`         timestamp    NULL,
    `deleted_at`          timestamp    NULL,

    CONSTRAINT PK_MEMBER PRIMARY KEY (member_id)
);

DROP TABLE IF EXISTS `member`;

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address`
(
    `address_id`       BIGINT       NOT NULL auto_increment,
    `member_id`        BIGINT       NOT NULL,
    `receiver_name`    varchar(255) NULL,
    `zip_no`           varchar(255) NOT NULL,
    `address_basic`    varchar(255) NOT NULL,
    `address_detail`   varchar(255) NOT NULL,
    `tel_no`           varchar(255) NOT NULL,
    `delivery_request` varchar(255) NULL,
    `default_address`  boolean      NOT NULL DEFAULT 0,

    CONSTRAINT PK_ADDRESS PRIMARY KEY (address_id)
);

DROP TABLE IF EXISTS `seller`;

CREATE TABLE `seller`
(
    `member_id`        BIGINT       NOT NULL,
    `brand_name`       varchar(255) NOT NULL,
    `biz_no`           varchar(255) NULL,
    `total_sell_price` int          NULL,
    `authority`        varchar(255) NULL,
    `created_at`       timestamp    NOT NULL
);

select *
from member;
select *
from address;
select *
from seller;