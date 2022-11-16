CREATE TABLE CATEGORY (
    sequence BIGINT,
    id VARCHAR2(255) NOT NULL PRIMARY KEY,
    part VARCHAR2(255),
    title VARCHAR2(255),
    link VARCHAR2(255),
    createdAt DATE,
    modifiedAt DATE
);

CREATE TABLE POSTS (
    sequence BIGINT,
    category VARCHAR2(255),
    title VARCHAR2(255),
    content CLOB,
    createdAt DATE,
    modifiedAt DATE
);
