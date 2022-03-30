CREATE TABLE IF NOT EXISTS manager(

   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name varchar(255) not null,
   surname varchar(255) not null,
   --
   departmentcode varchar(255) not null,
   primary key(id)

);

CREATE SEQUENCE MANAGER_SEQ;