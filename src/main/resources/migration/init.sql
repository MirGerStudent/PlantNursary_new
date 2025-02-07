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


--INSERT INTO event_type (name) VALUES ('Обработка фунгицидом');
