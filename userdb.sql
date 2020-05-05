CREATE TABLE userdb.users (
	userid INT auto_increment NOT NULL,
	firstname varchar(45) NULL,
	lastname varchar(45) NULL,
	dob DATE NULL,
	email varchar(100) null,
	PRIMARY KEY (`userid`)
)
ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8

INSERT INTO userdb.users
(userid, firstname, lastname, dob, email)
VALUES(1, 'John', 'Doe', '2020-05-01', 'jdoe@email.com');
INSERT INTO userdb.users
(userid, firstname, lastname, dob, email)
VALUES(2, 'Ray', 'Palmer', '1987-03-15', 'rpalmer@email.com');
INSERT INTO userdb.users
(userid, firstname, lastname, dob, email)
VALUES(3, 'Jose ', 'Perez', '2020-05-18', 'jperez@correo.com');