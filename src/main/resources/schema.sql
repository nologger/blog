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

DROP TABLE IF EXISTS PATHINFO;
CREATE TABLE PATHINFO (
    SEQUENCE    BIGINT,
    URI         VARCHAR2(255),
    TITLE       VARCHAR2(50),
    PART        VARCHAR2(50),
    AUTHORITY   VARCHAR2(10),
    CREATEDAT   DATE
)