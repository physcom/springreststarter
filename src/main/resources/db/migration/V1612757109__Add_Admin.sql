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
INSERT INTO users (created_at, password, first_name, last_name, email, enabled, auth_provider)
values (
    now(),
   crypt('123456', gen_salt('bf', 8)),
   'Admin',
   'Online tutors',
   'admin@qtechdigital.com',
   true,
   0
);


/* Admin User and Role*/
INSERT INTO user_roles
  (user_id, role_id)
SELECT
  u.id, r.id
FROM
  users u, roles r
WHERE
  u.email='admin@qtechdigital.com'
  AND r.code='ROLE_SUPER_ADMIN';