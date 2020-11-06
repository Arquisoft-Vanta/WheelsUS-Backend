/*Modificación campo passowrd en la tabla user para tamaño hash*/
ALTER TABLE "user" ALTER password TYPE varchar(257);