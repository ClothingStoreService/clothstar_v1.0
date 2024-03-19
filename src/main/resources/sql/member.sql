DROP TABLE IF EXISTS `member`;

CREATE TABLE `member`
(
    `member_id`   BIGINT       NOT NULL AUTO_INCREMENT,
    `seller_id`   BIGINT       NULL COMMENT 'SELLER의 경우만 NULL이 아님',
    `email`       varchar(255) NOT NULL,
    `password`    varchar(255) NOT NULL,
    `name`        varchar(255) NOT NULL,
    `tel_no`      varchar(255) NOT NULL,
    `buy_amt`     INT          NULL     default 0,
    `role`        varchar(100) NOT NULL DEFAULT 'USER' COMMENT 'ADMIN, SELLER, USER',
    `grade`       varchar(100) NOT NULL DEFAULT 'BRONZE' COMMENT 'BRONZE, SILVER, GOLD, PLATINUM, DIAMOND',
    `created_at`  datetime     NOT NULL DEFAULT now(),
    `modified_at` datetime     NULL,
    `deleted_at`  datetime     NULL,

    CONSTRAINT PK_MEMBER PRIMARY KEY (member_id)
);

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address`
(
    `address_id`   BIGINT       NOT NULL NOT NULL AUTO_INCREMENT,
    `member_id`    BIGINT       NOT NULL,
    `receiver_nm`  varchar(255) NULL,
    `zip_no`       varchar(255) NOT NULL,
    `address1`     varchar(255) NOT NULL,
    `address2`     varchar(255) NOT NULL,
    `tel_no`       varchar(255) NOT NULL,
    `delivery_req` varchar(255) NULL,
    `default_fg`   char(1)      NOT NULL DEFAULT 'N',

    CONSTRAINT PK_ADDRESS PRIMARY KEY (address_id)
);

DROP TABLE IF EXISTS `seller`;

CREATE TABLE `seller`
(
    `member_id`  BIGINT       NOT NULL,
    `brand_nm`   varchar(255) NOT NULL,
    `biz_no`     varchar(255) NULL,
    `sell_amt`   int          NULL     DEFAULT 0,
    `sell_fg`    char(1)      NULL     DEFAULT 'N' COMMENT 'N, Y',
    `created_at` datetime     NOT NULL DEFAULT now()
);

insert into seller(member_id, brand_nm, biz_no)
values (1, '아이다스', 'ad');


select *
from seller
where member_id = 1;
select *
from address;

