--INITIALISATION TABLE ROLE
INSERT INTO ROLE(ROLE_ID,ROLE_NAME) VALUES (1,'ROLE_ADMIN');
INSERT INTO ROLE(ROLE_ID,ROLE_NAME) VALUES (2,'ROLE_USER');

--INITIALISATION TABLE UTILISATEURS
INSERT INTO UTILISATEUR(USER_ID, LOGIN, USER_PASSWORD, USER_ACTIVE) values (1, 'admin', 'admin', 1);
INSERT INTO UTILISATEUR(USER_ID, LOGIN, USER_PASSWORD, USER_ACTIVE) values (2, 'login2', 'user', 1);
INSERT INTO UTILISATEUR(USER_ID, LOGIN, USER_PASSWORD, USER_ACTIVE) values (3, 'login3', 'user1', 0);-- 0 signifie user inactif

-- TABLE DE JOINTURE
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (1,2);
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (2,2);
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (3,2);



INSERT INTO STUDENT (ID,LAST_NAME,FIST_NAME,sexe,email) values (1,'tra','kaba','M','kaba@gmail.com');
INSERT INTO STUDENT (ID,LAST_NAME,FIST_NAME,sexe,email) values (2,'keita','mamady','M','kaba@gmail.com');
INSERT INTO STUDENT (ID,LAST_NAME,FIST_NAME,sexe,email) values (3,'tra','kaman','M','kaman@gmail.com');
INSERT INTO STUDENT (ID,LAST_NAME,FIST_NAME,sexe,email) values (5,'tra','koman','M','koman@gmail.com');


INSERT INTO TEACHER (ID,LAST_NAME,FIST_NAME,sexe,email) values (1,'tra','kaman','M','kaman@gmail.com');
INSERT INTO TEACHER (ID,LAST_NAME,FIST_NAME,sexe,email) values (2,'tra','koman','M','koman@gmail.com');


INSERT INTO COURSE (ID,TITLE,DESCRIPTION,coefcicient,teacher_id) values (1,'Physique','physique matiere',3,1);

INSERT INTO COURSE (ID,TITLE,DESCRIPTION,coefcicient,teacher_id) values (2,'MATHS','Mathematiques',4,2);
INSERT INTO COURSE (ID,TITLE,DESCRIPTION,coefcicient,teacher_id) values (3,'Chimie','Chimie important',3,2);

--- Association student course

  INSERT INTO  student_course  (student_id, COURSE_id) values(1,1);
  INSERT INTO  student_course  (student_id, COURSE_id) values(1,2);
  INSERT INTO  student_course  (student_id, COURSE_id) values(2,1);
  INSERT INTO  student_course  (student_id, COURSE_id) values(5,2);


COMMIT;

