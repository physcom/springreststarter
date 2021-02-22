create extension if not exists pgcrypto;

/* All Roles */
INSERT INTO roles (created_at, title, code)
VALUES (now(), 'SUPER ADMIN ROLE', 'ROLE_SUPER_ADMIN');

INSERT INTO roles (created_at, title, code)
VALUES (now(), 'ADMIN ROLE', 'ROLE_ADMIN');

INSERT INTO roles (created_at, title, code)
VALUES (now(), 'INSTRUCTOR ROLE', 'ROLE_INSTRUCTOR');

INSERT INTO roles (created_at, title, code)
VALUES (now(), 'STUDENT ROLE', 'ROLE_STUDENT');

/* Admin User */
INSERT INTO users (created_at, username, password, first_name, last_name, email, enabled)
values (
    now(),
   'admin',
   crypt('123456', gen_salt('bf', 8)),
   'Admin',
   'Online tutors',
   'support@qtechdigital.com',
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