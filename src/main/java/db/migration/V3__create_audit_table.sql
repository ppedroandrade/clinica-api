CREATE TABLE audit_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    action VARCHAR(20) NOT NULL,
    user_id BIGINT NOT NULL,
    entity VARCHAR(100) NOT NULL,
    entity_id BIGINT NOT NULL,
    timestamp TIMESTAMP NOT NULL
);