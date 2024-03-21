DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS cateory;
DROP TABLE IF EXISTS `option`;

CREATE TABLE `product` (
                           `product_id`	BIGINT	NOT NULL AUTO_INCREMENT,
                           `member_id`	BIGINT,
                           `category_id`	INT	,
                           `name`	varchar(30)	NOT NULL,
                           `price`	INT	NOT NULL,
                           `stock`	INT	NOT NULL,
                           `status`	varchar(20)	NOT NULL	DEFAULT 'COMING_SOON' COMMENT '준비중, 판매중, 할인중, 품절. 숨김, 단종',
                           `created_at`	DATETIME	NOT NULL DEFAULT (NOW()),
                           `modified_at`	DATETIME,
                           `deleted_at`	DATETIME,
                           constraint pk_product primary key (product_id)
);

CREATE TABLE `cateory` (
                           `category_id`	BIGINT	NOT NULL AUTO_INCREMENT,
                           `name`	varchar(20)	NOT NULL,
                           constraint pk_category primary key (category_id)
);

CREATE TABLE `option` (
                          `option_id`	BIGINT	NOT NULL AUTO_INCREMENT,
                          `product_id`	BIGINT	,
                          `order_detail_id`	BIGINT	,
                          `name`	varchar(20)	NOT NULL,
                          `value`	varchar(20)	NOT NULL,
                          constraint pk_option primary key (option_id)
);

select * from product