# API de Gerenciamento de Empreendimentos
API REST desenvolvida com Spring Boot para cadastro e gerenciamento de empreendimentos.

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.2
- Spring Data JPA + Hibernate
- H2 Database (em memória ou arquivo – sem necessidade de banco externo)
- SpringDoc OpenAPI / Swagger UI
- Maven

## Funcionalidades Principais
- CRUD completo de empreendimentos
- Campos: nome, nome do empreendedor, município, segmento, e-mail de contato, status (ativo/inativo)
- Listagem paginada
- Validações automáticas
- Alteração de status via PATCH
- Documentação interativa com Swagger

## Pré-requisitos
- **Java 17**
- **Maven** 3.8+

## Como Executar via Linha de Comando

### 1. Clonar o repositório
```sh
git clone https://github.com/filiperesende/sctec.git
cd sctec
```

### 2. Executar no ambiente local
```sh
mvn clean spring-boot:run
```

### 3. Acessar a aplicação
 - Swagger UI (testar endpoints) -> http://localhost:8080/swagger-ui.html
