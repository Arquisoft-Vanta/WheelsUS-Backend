/**
 * Author:  gonza
 * Created: 1-Oct-2020
 */
TRUNCATE TABLE example_table CASCADE;
INSERT INTO example_table (id_example, name, city, birthday, has_credit_card) VALUES
(1, 'Gonzalo Diaz', 'Bogota', '1998-05-07', FALSE),
(2, 'Cesar Pineda', 'Bogota', '1999-09-11', TRUE);

    