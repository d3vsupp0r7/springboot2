CREATE TABLE IF NOT EXISTS employee(

   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name varchar(255) not null,
   surname varchar(255) not null,
   --
   departmentcode varchar(255) not null,
   primary key(id)

);

CREATE SEQUENCE EMPLOYEE_SEQ;