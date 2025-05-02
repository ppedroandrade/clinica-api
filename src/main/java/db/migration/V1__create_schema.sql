CREATE SCHEMA IF NOT EXISTS clinica;

CREATE TABLE IF NOT EXISTS clinica.paciente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(15),
    estado VARCHAR(2),
    cidade VARCHAR(50),
    rua VARCHAR(100),
    numero VARCHAR(10),
    cep VARCHAR(8)
);