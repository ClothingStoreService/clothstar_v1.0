DROP TABLE IF EXISTS `seller_info`;
DROP TABLE IF EXISTS `member`;

CREATE TABLE `member`
(
    `member_id`   BIGINT       NOT NULL AUTO_INCREMENT,
    `seller_id`   BIGINT       NULL COMMENT 'SELLER의 경우만 NULL이 아님',
    `email`       varchar(255) NOT NULL,
    `password`    varchar(255) NOT NULL,
    `name`        varchar(255) NOT NULL,
    `tel_no`      varchar(255) NOT NULL,
    `role`        varchar(100) NOT NULL DEFAULT 'USER' COMMENT 'ADMIN, SELLER, USER',
    `buy_amt`     INT          NULL     default 0,
    `grade`       varchar(100) NOT NULL DEFAULT 'BRONZE' COMMENT 'BRONZE, SILVER, GOLD, PLATINUM, DIAMOND',
    `created_at`  datetime     NOT NULL DEFAULT now(),
    `modified_at` datetime     NULL,
    `deleted_at`  datetime     NULL,

    CONSTRAINT PK_MEMBER PRIMARY KEY (member_id)
);

insert into member(email, password, name, tel_no)
values ("email", "password", "name", "0212-2sd");

select *
from member;

select *
from address_info;

select *
from seller_info;

DROP TABLE IF EXISTS `address_info`;

CREATE TABLE `address_info`
(
    `delivery_id`  BIGINT       NOT NULL NOT NULL AUTO_INCREMENT,
    `member_id`    BIGINT       NOT NULL,
    `receiver_nm`  varchar(255) NULL,
    `zip_no`       varchar(255) NOT NULL,
    `address1`     varchar(255) NOT NULL,
    `address2`     varchar(255) NOT NULL,
    `tel_no`       varchar(255) NOT NULL,
    `delivery_req` varchar(255) NULL,
    `default_fg`   char(1)      NOT NULL DEFAULT 'N',

    CONSTRAINT PK_ADDRESS_INFO PRIMARY KEY (delivery_id)
);
select *
from address_info;

insert into address_info(member_id, receiver_nm, zip_no, address1, address2, tel_no, delivery_req)
values (1, '받는사람', '121-2', '주소1', '주소2', '2192-323', '문앞');

update address_info
set default_fg = 23
where member_id = 1;

ALTER TABLE `address_info`
    ADD CONSTRAINT `PK_ADDRESS_INFO` PRIMARY KEY (
                                                  `delivery_id`
        );



CREATE TABLE `seller_info`
(
    `seller_id` BIGINT       NOT NULL,
    `brand_nm`  varchar(255) NOT NULL,
    `biz_no`    varchar(255) NULL
);


ALTER TABLE `member`
    ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
                                            `member_id`
        );

ALTER TABLE `address_info`
    ADD CONSTRAINT `PK_ADDRESS_INFO` PRIMARY KEY (
                                                  `delivery_id`
        );

ALTER TABLE `seller_info`
    ADD CONSTRAINT `PK_SELLER_INFO` PRIMARY KEY (
                                                 `seller_id`
        );

# ALTER TABLE `member`
#     ADD CONSTRAINT `FK_seller_info_TO_member_1` FOREIGN KEY (
#                                                              `seller_id`
#         )
#         REFERENCES `seller_info` (
#                                   `seller_id`
#             );
#
#
# ALTER TABLE `address_info`
#     ADD CONSTRAINT `FK_member_TO_address_info_1` FOREIGN KEY (
#                                                               `member_id`
#         )
#         REFERENCES `member` (
#                              `member_id`
#             );