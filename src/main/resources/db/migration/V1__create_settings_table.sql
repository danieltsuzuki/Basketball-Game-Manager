CREATE TABLE IF NOT EXISTS settings
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    time             INT     NOT NULL,
    max_score        INT     NOT NULL,
    is_active_player BOOLEAN NOT NULL
);