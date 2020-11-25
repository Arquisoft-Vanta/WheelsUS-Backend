/**
 * Author:  gonza and cesaineam
 * Created: 1-Oct-2020 
 */
TRUNCATE TABLE vehicle CASCADE;
TRUNCATE TABLE users CASCADE;


INSERT INTO vehicle (id_vehicle, vehicle_owner, vehicle_licenseplate, vehicle_type, vehicle_model,  vehicle_year,vehicle_color, vehicle_registry_datetime, vehicle_picture, vehicle_capacity) VALUES
(1, 1, 'ABC123', 2, 'Sedan', 2010, 'Azul', '2020-09-30@10:11:30', 'imagen', 3),
(2, 1, 'RMN741', 2, 'Sedan', 2020, 'Rojo', '2020-09-30@10:11:30', 'imagen', 3);


INSERT INTO users (id_user, name, document, phone, user_university, mail,address, password, registry_datatime,  rh) VALUES
(1,'Cristian','123456789','7777','U nacional','cesaineam','en bogota', 'el pass', '2020-09-30@10:11:30','0-' ),
(2,'Esteban','987654321','9999','U nacional','cesteban','en bogota1', 'el pass1', '2020-09-30@10:11:50','0+' );
