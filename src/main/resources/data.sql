-- DROP TABLES
DROP TABLE employee IF EXISTS;
DROP TABLE salary IF EXISTS;

-- CREATE TABLES
CREATE sequence employee_seq start WITH 1 increment BY 1;
CREATE TABLE employee (
                      emp_no INT DEFAULT NEXT VALUE FOR employee_seq PRIMARY KEY NOT NULL,
                      first_name VARCHAR(50),
                      last_name VARCHAR(50),
                      gender VARCHAR(50),
                      birth_date TIMESTAMP(6),
                      hire_date TIMESTAMP(6)
);

CREATE sequence salary_seq start WITH 1 increment BY 1;
CREATE TABLE salary (
                      id INT DEFAULT NEXT VALUE FOR salary_seq PRIMARY KEY NOT NULL,
                      emp_no INT,
                      salary DOUBLE,
                      from_date TIMESTAMP(6),
                      to_date TIMESTAMP(6)
);

-- CREATE FOREIGN KEY
ALTER TABLE salary
    ADD CONSTRAINT fk_salary_employee
    FOREIGN KEY (emp_no)
    REFERENCES employee(emp_no)
    ON DELETE CASCADE;

-- FILL TABLES
INSERT INTO employee(emp_no, first_name, last_name, gender, birth_date, hire_date) values (DEFAULT, 'Bruce', 'Wayne', 'male', '1990-02-05', '2013-12-12');
INSERT INTO salary (id, emp_no, salary, from_date, to_date) VALUES (DEFAULT, (SELECT MAX(emp_no) FROM employee), 50000, '2013-12-12', '2020-02-04');
INSERT INTO salary (id, emp_no, salary, from_date, to_date) VALUES (DEFAULT, (SELECT MAX(emp_no) FROM employee), 65000, '2020-12-12', null);

INSERT INTO employee(emp_no, first_name, last_name, gender, birth_date, hire_date) values (DEFAULT, 'Gwen', 'Stacy', 'female', '2000-08-14', '2020-02-06');
INSERT INTO salary (id, emp_no, salary, from_date, to_date) VALUES (DEFAULT, (SELECT MAX(emp_no) FROM employee), 45000, '2020-02-06', null);

INSERT INTO employee(emp_no, first_name, last_name, gender, birth_date, hire_date) values (DEFAULT, 'Matt', 'Murdock', 'male', '1980-10-31', '2021-06-21');
INSERT INTO salary (id, emp_no, salary, from_date, to_date) VALUES (DEFAULT, (SELECT MAX(emp_no) FROM employee), 35000, '2021-06-21', null);

INSERT INTO employee(emp_no, first_name, last_name, gender, birth_date, hire_date) values (DEFAULT, 'Dinah', 'Drake', 'female', '1999-12-31', '2023-07-24');
INSERT INTO salary (id, emp_no, salary, from_date, to_date) VALUES (DEFAULT, (SELECT MAX(emp_no) FROM employee), 85000, '2023-07-24', null);