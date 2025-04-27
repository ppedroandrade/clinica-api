# Clínica API

API desenvolvida em **Spring Boot** para o gerenciamento de **pacientes** e **consultas médicas**.

## 📋 Funcionalidades

- **CRUD de Pacientes**
  - Nome
  - CPF
  - Email
  - Telefone
  - Endereço (Estado, Cidade, Rua, Número, CEP)

- **CRUD de Consultas**
  - Data e Hora da consulta
  - Associação a um Paciente

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Spring Validation

## 🔗 Endpoints

### Pacientes
| Método | Endpoint | Descrição |
|:---|:---|:---|
| POST | `/pacientes` | Criar paciente |
| GET | `/pacientes` | Listar todos os pacientes |
| GET | `/pacientes/{id}` | Buscar paciente por ID |
| PUT | `/pacientes/{id}` | Atualizar paciente |
| DELETE | `/pacientes/{id}` | Deletar paciente |

### Consultas
| Método | Endpoint | Descrição |
|:---|:---|:---|
| POST | `/consultas` | Criar consulta |
| GET | `/consultas` | Listar todas as consultas |
| GET | `/consultas/{id}` | Buscar consulta por ID |
| PUT | `/consultas/{id}` | Atualizar consulta |
| DELETE | `/consultas/{id}` | Deletar consulta |

## ⚙️ Configuração do Banco de Dados

A aplicação utiliza o **MySQL**.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/clinica_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=Pedro123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.port=8080
```

> Certifique-se de que o banco `clinica_db` já existe no seu MySQL.

## ▶️ Como Rodar o Projeto

1. Clone o repositório:

2. Importe o projeto na sua IDE.

3. Rode a aplicação:
   - Executando a classe `ClinicaApiApplication`.
   - Ou pelo terminal:
     ```bash
     ./mvnw spring-boot:run
     ```
## 📬 Exemplos de Requisições

### Criar um Paciente (POST `/pacientes`)
```json
{
  "nome": "João Silva",
  "cpf": "12345678900",
  "email": "joao@email.com",
  "telefone": "11999999999",
  "endereco": {
    "estado": "SP",
    "cidade": "São Paulo",
    "rua": "Avenida Paulista",
    "numero": "1000",
    "cep": "01310000"
  }
}
```

### Criar uma Consulta (POST `/consultas`)
```json
{
  "dataHora": "2025-04-30T14:30:00",
  "paciente": {
    "id": 1
  }
}
```

## ✍️ Autor

Pedro Andrade
