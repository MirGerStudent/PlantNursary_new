-- Тип обработки растений
CREATE TABLE IF NOT EXISTS event_type (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

-- Тип почвы для растений
CREATE TABLE IF NOT EXISTS ground_type (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

-- Тип морозостойкости растений
CREATE TABLE IF NOT EXISTS winter_hardiness_type (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

-- Тип растения
CREATE TABLE IF NOT EXISTS plant_type (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

-- Тип местности для растений
CREATE TABLE IF NOT EXISTS place_type (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

--
CREATE TABLE IF NOT EXISTS Plant (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    plant_type_id BIGINT REFERENCES plant_type(id),
    height FLOAT NOT NULL,
    diameter FLOAT NOT NULL,
    winter_hardiness_type_id BIGINT REFERENCES winter_hardiness_type(id),
    place_type_id BIGINT REFERENCES place_type(id),
    ground_type_id BIGINT REFERENCES ground_type(id),
    peculiarities VARCHAR(4095) NOT NULL
);



--INSERT INTO event_type (name) VALUES ('Обработка фунгицидом');
