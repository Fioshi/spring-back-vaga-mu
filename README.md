# 🌱 Guia de Instalação e Execução da API Spring Boot

Este guia fornece instruções para configurar e rodar a API desenvolvida com Spring Boot.

## 📌 Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)

## 📥 Clonando o Repositório

```sh
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

## 📦 Configuração do Banco de Dados

Este projeto usa [Flyway](https://flywaydb.org/) para versionamento do banco de dados.

1. Configure o banco de dados no arquivo `application.yml` ou `application.properties`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/seu_banco
    username: seu_usuario
    password: sua_senha
  flyway:
    enabled: true
```

## ▶️ Rodando a API

### Com Maven
```sh
mvn spring-boot:run
```

### Com Java
```sh
mvn clean package
java -jar target/nome-do-seu-projeto.jar
```

A API estará disponível em `http://localhost:8080/`.

## 📖 Documentação com Swagger

A API possui documentação interativa com Swagger. Para acessá-la, abra:

```
http://localhost:8080/swagger-ui/index.html
```
## Script

O próprio flyway já roda os scripts com INSERT necessarios no momento em que é rodado o projeto, mas segue abaixo o script utilizado e os inserts para teste :)

```sql
CREATE TABLE tb_cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    endereco VARCHAR(255)
);

CREATE TABLE tb_contato (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    valor VARCHAR(100) NOT NULL,
    observacao VARCHAR(255),
    FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id) ON DELETE CASCADE
);

INSERT INTO tb_cliente (nome, cpf, data_nascimento, endereco) VALUES
('João Silva', '123.456.789-01', '1985-06-15', 'Rua das Palmeiras, 123, São Paulo - SP'),
('Maria Souza', '234.567.890-12', '1990-02-20', 'Avenida Brasil, 456, Rio de Janeiro - RJ'),
('Carlos Oliveira', '345.678.901-23', '1982-11-30', 'Rua XV de Novembro, 789, Curitiba - PR'),
('Ana Lima', '456.789.012-34', '1995-09-10', 'Praça da Liberdade, 101, Belo Horizonte - MG'),
('Fernando Alves', '567.890.123-45', '1988-04-25', 'Rua das Rosas, 202, Porto Alegre - RS'),
('Patrícia Mendes', '678.901.234-56', '1993-07-18', 'Avenida Paulista, 303, São Paulo - SP'),
('Ricardo Santos', '789.012.345-67', '1980-12-05', 'Rua do Comércio, 404, Salvador - BA'),
('Juliana Martins', '890.123.456-78', '1997-01-22', 'Avenida das Américas, 505, Brasília - DF'),
('Gabriel Costa', '901.234.567-89', '1986-08-14', 'Rua Independência, 606, Fortaleza - CE'),
('Larissa Ferreira', '012.345.678-90', '1992-03-27', 'Alameda Santos, 707, Recife - PE');

INSERT INTO tb_contato (id_cliente, tipo, valor, observacao) VALUES
(1, 'TELEFONE', '+55 11 99999-1111', 'Telefone principal'),
(1, 'EMAIL', 'joao.silva@email.com', 'E-mail pessoal'),
(1, 'TELEFONE', '+55 11 95555-2222', 'WhatsApp'),
(2, 'EMAIL', 'maria.souza@email.com', 'E-mail pessoal'),
(2, 'TELEFONE', '+55 21 97777-3333', 'Número alternativo'),
(2, 'TELEFONE', '+55 21 96666-4444', 'Telefone do trabalho'),
(3, 'TELEFONE', '+55 41 98888-2222', 'WhatsApp'),
(3, 'EMAIL', 'carlos.oliveira@email.com', 'E-mail profissional'),
(3, 'TELEFONE', '+55 41 95555-6666', 'Telefone fixo'),
(3, 'EMAIL', 'carlos.oliveira@empresa.com', 'E-mail corporativo'),
(4, 'EMAIL', 'ana.lima@email.com', 'E-mail secundário'),
(4, 'TELEFONE', '+55 31 97777-5555', 'Contato do trabalho'),
(5, 'TELEFONE', '+55 51 97777-3333', 'Contato do trabalho'),
(5, 'EMAIL', 'fernando.alves@email.com', 'E-mail principal'),
(5, 'TELEFONE', '+55 51 98888-7777', 'WhatsApp pessoal'),
(6, 'EMAIL', 'patricia.mendes@email.com', 'E-mail profissional'),
(6, 'TELEFONE', '+55 71 95555-4444', 'Telefone residencial'),
(6, 'TELEFONE', '+55 71 96666-8888', 'Número de emergência'),
(7, 'TELEFONE', '+55 71 95555-4444', 'Telefone residencial'),
(7, 'EMAIL', 'ricardo.santos@email.com', 'E-mail secundário'),
(7, 'TELEFONE', '+55 71 97777-9999', 'Telefone alternativo'),
(7, 'EMAIL', 'ricardo.santos@empresa.com', 'E-mail corporativo'),
(7, 'TELEFONE', '+55 71 91111-0000', 'Telefone de recado'),
(8, 'EMAIL', 'juliana.martins@email.com', 'E-mail principal'),
(8, 'TELEFONE', '+55 61 97777-2222', 'Telefone do trabalho'),
(9, 'TELEFONE', '+55 85 96666-5555', 'Telefone alternativo'),
(9, 'EMAIL', 'gabriel.costa@email.com', 'E-mail pessoal'),
(9, 'TELEFONE', '+55 85 95555-1111', 'WhatsApp'),
(9, 'EMAIL', 'gabriel.costa@empresa.com', 'E-mail corporativo'),
(10, 'EMAIL', 'larissa.ferreira@email.com', 'E-mail para notificações'),
(10, 'TELEFONE', '+55 81 98888-2222', 'WhatsApp'),
(10, 'EMAIL', 'larissa.ferreira@empresa.com', 'E-mail corporativo');
```
