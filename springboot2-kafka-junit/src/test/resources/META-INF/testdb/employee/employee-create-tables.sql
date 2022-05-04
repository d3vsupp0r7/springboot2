-- EMPLOYEE TABLE
create table if not exists employee(

   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name varchar(255) not null,
   surname varchar(255) not null,
   primary key(id)

);

CREATE SEQUENCE IF NOT EXISTS EMPLOYEE_SEQ INCREMENT BY 1 MAXVALUE 9999 MINVALUE 1 NOCACHE;