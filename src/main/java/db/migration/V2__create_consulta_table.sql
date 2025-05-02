CREATE TABLE IF NOT EXISTS clinica.consulta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_hora DATETIME NOT NULL,
    paciente_id BIGINT NOT NULL,
    FOREIGN KEY (paciente_id) REFERENCES clinica.paciente(id) ON DELETE CASCADE
);