create extension if not exists pgcrypto;

/* All Roles */
INSERT INTO roles (created_at, title, code)
VALUES (now(), 'Admin User', 'ROLE_ADMIN');

INSERT INTO roles (created_at, title, code)
VALUES (now(), 'Simple User', 'ROLE_USER');

/* Admin User */
INSERT INTO users (created_at, username, password, first_name, last_name, email, enabled)
values (
    now(),
   'admin',
   crypt('123456', gen_salt('bf', 8)),
   'Администратор',
   'ИВС',
   'admin@test.kg',
   true);


/* Admin User and Role*/
INSERT INTO user_roles
  (user_id, role_id)
SELECT
  u.id, r.id
FROM
  users u, roles r
WHERE
  u.username='admin'
  AND r.code='ROLE_ADMIN';