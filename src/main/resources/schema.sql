DROP TABLE IF EXISTS CATEGORY;
CREATE TABLE CATEGORY (
    sequence BIGINT,
    id VARCHAR2(255) NOT NULL PRIMARY KEY,
    part VARCHAR2(255),
    title VARCHAR2(255),
    link VARCHAR2(255),
    createdAt DATE,
    modifiedAt DATE
);

DROP TABLE IF EXISTS POSTS;
CREATE TABLE POSTS (
    sequence BIGINT,
    category VARCHAR2(255),
    title VARCHAR2(255),
    content CLOB,
    createdAt DATE,
    modifiedAt DATE
);

DROP TABLE IF EXISTS ADMIN;
CREATE TABLE ADMIN (
    sequence BIGINT,
    account VARCHAR2(255),
    password VARCHAR2(255),
    authority VARCHAR2(255),
    createdAt DATE,
    lastAccessed DATE
);

DROP TABLE IF EXISTS MEMBER;
CREATE TABLE MEMBER (
    sequence BIGINT,
    account VARCHAR2(80),
    password VARCHAR2(255),
    authority VARCHAR2(10),
    createdAt DATE
);