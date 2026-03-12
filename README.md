# API de Gerenciamento de Empreendimentos
API REST desenvolvida com Spring Boot para cadastro e gerenciamento de empreendimentos.

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.2
- Spring Data JPA + Hibernate
- H2 Database (em memória – sem necessidade de banco externo)
- SpringDoc OpenAPI / Swagger UI
- Maven

## Visão em camadas (arquitetura)
O projeto segue o padrão camadas, muito comum em projetos Spring Boot:
- Controller → recebe requisições HTTP, valida entrada, chama service
- Service → contém a lógica de negócio, regras, orquestração
- Repository → acesso ao banco de dados (abstração via Spring Data JPA)
- Domain / Entity → modelo central da aplicação (o que realmente importa no negócio)
- DTO → separa o modelo interno (Entity) do que é exposto na API (segurança e flexibilidade)

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
 - Swagger UI (testar endpoints) -> <a href="http://localhost:8080/swagger-ui.html" target="_blank">http://localhost:8080/swagger-ui.html</a>



### 4. Vídeo da apresentação
- <a href="https://www.youtube.com/watch?v=m6btAlwO7p0" target="_blank">https://www.youtube.com/watch?v=m6btAlwO7p0</a>