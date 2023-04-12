use quanlythuvien;

CREATE TABLE account (
   id bigint NOT NULL AUTO_INCREMENT,
   user_name varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   password varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   role varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   PRIMARY KEY (id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

 CREATE TABLE author (
   id bigint NOT NULL AUTO_INCREMENT,
   author_name varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   PRIMARY KEY (id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

 CREATE TABLE book (
   id bigint NOT NULL AUTO_INCREMENT,
   book_name varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   book_category varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   description longtext COLLATE utf8mb4_unicode_ci NOT NULL,
   publish varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   publish_year date NOT NULL,
   entry_date date NOT NULL,
   book_position varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   PRIMARY KEY (id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

 CREATE TABLE book_author (
   id bigint NOT NULL AUTO_INCREMENT,
   book_id bigint NOT NULL,
   author_id bigint NOT NULL,
   PRIMARY KEY (id),
   UNIQUE KEY book_author_book_id_author_id_b1cc0e03_uniq (book_id,`author_id`),
   KEY book_author_author_id_b283416c_fk_author_id (author_id),
   CONSTRAINT book_author_author_id_b283416c_fk_author_id FOREIGN KEY (author_id) REFERENCES author (id),
   CONSTRAINT book_author_book_id_8194d3b0_fk_book_id FOREIGN KEY (book_id) REFERENCES book (id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

 CREATE TABLE call_card (
   id bigint NOT NULL AUTO_INCREMENT,
   date_call_card datetime(6) NOT NULL,
   return_date datetime(6) NOT NULL,
   employee_id bigint NOT NULL,
   reader_id bigint NOT NULL,
   PRIMARY KEY (id),
   KEY call_card_employee_id_e788156b_fk_employee_id (employee_id),
   KEY call_card_reader_id_67ea0b54_fk_reader_id (reader_id),
   CONSTRAINT call_card_employee_id_e788156b_fk_employee_id FOREIGN KEY (employee_id) REFERENCES employee (id),
   CONSTRAINT call_card_reader_id_67ea0b54_fk_reader_id FOREIGN KEY (reader_id) REFERENCES reader (id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

 CREATE TABLE call_card_detail (
   id bigint NOT NULL AUTO_INCREMENT,
   quantity int NOT NULL,
   book_id bigint NOT NULL,
   call_card_id bigint NOT NULL,
   PRIMARY KEY (id),
   KEY call_card_detail_book_id_bb8a9885_fk_book_id (book_id),
   KEY call_card_detail_call_card_id_29dc3321_fk_call_card_id (call_card_id),
   CONSTRAINT call_card_detail_book_id_bb8a9885_fk_book_id FOREIGN KEY (book_id) REFERENCES book (id),
   CONSTRAINT call_card_detail_call_card_id_29dc3321_fk_call_card_id FOREIGN KEY (call_card_id) REFERENCES call_card (id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

 CREATE TABLE employee (
   id bigint NOT NULL AUTO_INCREMENT,
   employee_name varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   phone varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
   cmnd varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
   account_id bigint NOT NULL,
   PRIMARY KEY (id),
   KEY employee_account_id_9bc3db3a_fk_account_id (account_id),
   CONSTRAINT employee_account_id_9bc3db3a_fk_account_id FOREIGN KEY (account_id) REFERENCES account (id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

 CREATE TABLE reader (
   id bigint NOT NULL AUTO_INCREMENT,
   reader_name varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   gender varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
   date_of_birth date NOT NULL,
   reader_role varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   position varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   date_of_call_card datetime(6) NOT NULL,
   email varchar(254) COLLATE utf8mb4_unicode_ci NOT NULL,
   address varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
   phone varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
   borrowing_availability int NOT NULL,
   account_id bigint NOT NULL,
   PRIMARY KEY (id),
   KEY reader_account_id_163db319_fk_account_id (account_id),
   CONSTRAINT reader_account_id_163db319_fk_account_id FOREIGN KEY (account_id) REFERENCES account (id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


 CREATE TABLE return_book (
   id bigint NOT NULL AUTO_INCREMENT,
   date_return_book datetime(6) NOT NULL,
   fine int NOT NULL,
   call_card_id bigint NOT NULL,
   employee_id bigint NOT NULL,
   PRIMARY KEY (id),
   KEY return_book_call_card_id_fb332010_fk_call_card_id (call_card_id),
   KEY return_book_employee_id_83e6c4ae_fk_employee_id (employee_id),
   CONSTRAINT return_book_call_card_id_fb332010_fk_call_card_id FOREIGN KEY (call_card_id) REFERENCES call_card (id),
   CONSTRAINT return_book_employee_id_83e6c4ae_fk_employee_id FOREIGN KEY (employee_id) REFERENCES employee (id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;