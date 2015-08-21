
    create table BOOK (
        BOOK_ID int8 not null,
        AUTHOR varchar(80) not null,
        TITLE varchar(80) not null,
        CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        MODIFIED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        primary key (BOOK_ID)
    );

    create table EMPLOYEE (
        EMPLOYEE_ID int8 not null,
        CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        MODIFIED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        FIRSTNAME varchar(80) not null,
        LASTNAME varchar(80) not null,
        primary key (EMPLOYEE_ID)
    );

    create table PHONE (
        PHONE_ID int8 not null,
        CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        MODIFIED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        PHONENUMBER varchar(80) not null,
        PHONETYPE varchar(80) not null,
        EmployeeId int8 not null,
        primary key (PHONE_ID)
    );

    create table SKILL (
        SKILL_ID int8 not null,
        CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        MODIFIED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        EMPLOYEEID varchar(80) not null,
        SKILLNAME varchar(80) not null,
        primary key (SKILL_ID)
    );

    alter table PHONE 
        add constraint FK489454E6B236B0D 
        foreign key (EmployeeId) 
        references EMPLOYEE;

    create sequence SEQ_BOOK_ID start 1 increment 50;

    create sequence SEQ_EMPLOYEE_ID start 1 increment 50;

    create sequence SEQ_PHONE_ID start 1 increment 50;

    create sequence SEQ_SKILL_ID start 1 increment 50;
