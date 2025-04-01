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
