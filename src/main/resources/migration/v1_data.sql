-----------
-- ROLES --
-----------

INSERT INTO roles (id, description, role_code)
VALUES (1, 'admin', 'ADMIN');

insert into roles (id, description, role_code)
values(2,'user','USER');

-----------------
-- FIRST ADMIN --
-----------------

INSERT INTO users
(id, first_name, is_account_locked, last_name, "password", username, contact_info_id, role_id)
VALUES(1, 'Tariel', true, 'Beishenaliev',
       '$2a$10$h0UjPK68OEdztOduYSNBAeXuv/hWBUk/dmNAE3lhtbhVZ1oIOot5.',
       'tarik', NULL, 1);