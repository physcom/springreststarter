create extension if not exists pgcrypto;
/* Simple User */
INSERT INTO users (created_at, username, password, first_name, last_name, email, enabled)
values (
    now(),
   'test',
   crypt('123456', gen_salt('bf', 8)),
   'Elaman',
   'Nazarkulov',
   'test@test.kg',
   true);


/* Test User and Role*/
INSERT INTO user_roles
  (user_id, role_id)
SELECT
  u.id, r.id
FROM
  users u, roles r
WHERE
  u.username='test'
  AND r.code='ROLE_USER';