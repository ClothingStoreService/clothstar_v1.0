DROP TABLE IF EXISTS member;

create table member (
                        id BIGINT AUTO_INCREMENT,
                        email varchar(200) NOT NULL,
                        password varchar(200) NOT NULL,

                        PRIMARY KEY (id),
                        CONSTRAINT unique_email UNIQUE (email)
);