alter table usuario add constraint CK_CORREO 
check(correo like '%_@gmail.com' or correo like '%_@mail.escuelaing.edu.co' or correo like '%_@escuelaing.edu.co');

alter table usuario add constraint CK_NOMBRE 
check(nombre ~ '^[a-zA-Z .]*$');
