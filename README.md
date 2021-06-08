# Gerenciamento de Contas e Pagamentos 
[![NPM](https://img.shields.io/github/license/caeab/bank-account-management?style=plastic)](https://github.com/caeab/bank-account-management/blob/main/LICENSE) 

# Sobre o projeto

Esse projeto traz uma API restfull para gerenciamento de contas e pagamentos, feita como um desafio para desenvolvedores back-end no [Social Bank](https://socialbank.com.br/ "Site Social Bank").

A aplicação consiste em um CRUD de conta bancária, com a possibilidade de fazer algumas operações financeiras, como entrada de créditos e transferência entre contas internas.

## Layout pelo Swagger UI
![Layout Swagger UI]() 

## Modelo conceitual
![Modelo Conceitual]()

# Tecnologias utilizadas
## Back end
- Java 11
- Spring Boot
- JPA / Hibernate
- H2 Database
- Maven
- Swagger UI

O projeto foi feito seguindo os princípios do SOLID e com um padrão de desenvolvimento em camadas.

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/caeab/bank-account-management.git

# entrar na pasta do projeto bank-account-management
cd backend

# executar o projeto
./mvnw spring-boot:run
```

## Endpoints

A lista completa de endpoints pode ser encontrada usando o Swagger UI.

Você consegue acessar o Swagger UI acessando a url: `/swagger-ui.html`.



# Autor

Caetano Alcantara Borges

[Mais sobre Caetano](https://www.linkedin.com/in/caetano-alcantara-borges-7ba8b3101/ "Linkedin de Caetano")
