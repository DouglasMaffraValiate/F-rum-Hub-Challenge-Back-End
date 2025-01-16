CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL,
    status VARCHAR(255) NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    CONSTRAINT fk_topicos_autor FOREIGN KEY (autor_id) REFERENCES usuarios (id),
    CONSTRAINT fk_topicos_curso FOREIGN KEY (curso_id) REFERENCES cursos (id)
);