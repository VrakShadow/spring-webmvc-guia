CREATE TABLE IF NOT EXISTS Student(
student_id int NOT NULL AUTO_INCREMENT COMMENT 'Id de Estudiante',
 student_nombre varchar(100) NOT NULL COMMENT 'Nombres del Estudiante',
 student_dni varchar(10) NOT NULL COMMENT 'dni del Estudiante',
 student_codigo varchar(12) NOT NULL COMMENT 'codigo del Estudiante',
 student_anio_ingreso varchar(10) NOT NULL COMMENT 'Año de ingreso del Estudiante',
 personal_estado varchar(50) COMMENT 'estado del Estudiante ACTIVO o INACTIVO',
 PRIMARY KEY (`student_id`)
);

INSERT INTO Student VALUES (1, "Jose Miguel Fernandez", "54512101","2022454982",
"2022","ACTIVO");
INSERT INTO Student VALUES (2, "Fernanda Villegas Manrique", "75451211","2022242651",
"2022","ACTIVO");
INSERT INTO Student VALUES (3, "Julio Morales Quintana", "71145001","2022121344",
"2022","ACTIVO");
INSERT INTO Student VALUES (4, "Moises Alvarez Castro", "54577421","2022454982",
"2022","ACTIVO");