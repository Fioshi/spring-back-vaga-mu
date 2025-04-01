CREATE TABLE tb_contato (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    valor VARCHAR(100) NOT NULL,
    observacao VARCHAR(255),
    FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id) ON DELETE CASCADE
);