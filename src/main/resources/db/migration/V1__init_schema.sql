CREATE TABLE roles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    role_id BIGINT NOT NULL REFERENCES roles(id)
);

CREATE TABLE sensor_types (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE units (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE sensors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    model VARCHAR(15) NOT NULL,
    range_from INTEGER NOT NULL,
    range_to INTEGER NOT NULL,
    type_id BIGINT NOT NULL REFERENCES sensor_types(id),
    unit_id BIGINT REFERENCES units(id),
    location VARCHAR(40),
    description VARCHAR(200),
    CONSTRAINT range_check CHECK (range_from < range_to)
); 