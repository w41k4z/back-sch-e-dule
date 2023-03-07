create table sch_e_dule owner walker;


create sequence user_sequence;
create table user (
    user_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL
    -- add here for another information
);

create sequence user_account_sequence;
create table user_account (
    user_account_id VARCHAR(10) PRIMARY KEY,
    user_id VARCHAR(10) REFERENCES user(user_id), 
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    creation_date DATE NOT NULL
);


create table schedule (
    schedule_id VARCHAR(12) PRIMARY KEY,

);