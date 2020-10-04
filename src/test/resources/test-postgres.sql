/**
 * Author:  gonza
 * Created: 1-Oct-2020
 */
TRUNCATE TABLE example_table CASCADE;
TRUNCATE TABLE vehicle CASCADE;

INSERT INTO example_table (id_example, name, city, birthday, has_credit_card) VALUES
(1, 'Gonzalo Diaz', 'Bogota', '1998-05-07', FALSE),
(2, 'Cesar Pineda', 'Bogota', '1999-09-11', TRUE);

INSERT INTO vehicle (id_vehicle, vehicle_owner, vehicle_licenseplate, vehicle_type, vehicle_model,  vehicle_year,vehicle_color, vehicle_registry_datetime, vehicle_picture, vehicle_capacity) VALUES
(1, 1, 'ABC123', 2, 'Sedan', 2010, 'Azul', '2020-09-30@10:11:30', 'imagen', 3),
(2, 1, 'RMN741', 2, 'Sedan', 2020, 'Rojo', '2020-09-30@10:11:30', 'imagen', 3);