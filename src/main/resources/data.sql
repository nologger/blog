INSERT INTO CATEGORY(sequence, id, part, title, link, createdAt, modifiedAt)
VALUES(1, 'about', 'main', 'About', '/about', now(), now());

INSERT INTO CATEGORY(sequence, id, part, title, link, createdAt, modifiedAt)
VALUES(2, 'posts', 'main', 'Posts', '/posts', now(), now());

INSERT INTO CATEGORY(sequence, id, part, title, link, createdAt, modifiedAt)
VALUES(101, 'posting', 'admin', 'Posting', '/admin/posting', now(), now());

INSERT INTO CATEGORY(sequence, id, part, title, link, createdAt, modifiedAt)
VALUES(102, 'edit', 'admin', 'Edit', '/admin/edit', now(), now());


INSERT INTO ADMIN(sequence, account, password, authority, createdAt, lastAccessed)
VALUES(1, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'su', now(), now());