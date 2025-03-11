INSERT INTO roles (name) VALUES
    ('ADMINISTRATOR'),
    ('VIEWER');

INSERT INTO users (username, password, role_id) VALUES
    ('admin', '$2a$10$ZlVz/5NcA8vKgi23ms1mf.T3Y9xChkDetH.2dvhIOHiwTaVLiwoUm', (SELECT id FROM roles WHERE name = 'ADMINISTRATOR')),
    ('user', '$2a$10$ZlVz/5NcA8vKgi23ms1mf.T3Y9xChkDetH.2dvhIOHiwTaVLiwoUm', (SELECT id FROM roles WHERE name = 'VIEWER'));

INSERT INTO sensor_types (name) VALUES
    ('PRESSURE'),
    ('VOLTAGE'),
    ('TEMPERATURE'),
    ('HUMIDITY');

INSERT INTO units (name) VALUES
    ('BAR'),
    ('VOLTAGE'),
    ('CELSIUS'),
    ('PERCENT'); 