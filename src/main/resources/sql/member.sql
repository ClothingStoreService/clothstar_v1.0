drop table member;

create table member (
    id int(10) AUTO_INCREMENT,
    email varchar(200) NOT NULL,
    password varchar(200) NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT unique_email UNIQUE (email)
);

select * from member;