-- Crear la tabla 'topic' con los campos necesarios
CREATE TABLE topic (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    author VARCHAR(100) NOT NULL,
    course VARCHAR(100) NOT NULL
);
