# Gerenciamento de Contas e Pagamentos 
[![NPM](https://img.shields.io/github/license/caeab/bank-account-management?style=plastic)](https://github.com/caeab/bank-account-management/blob/main/LICENSE) 

# Sobre o projeto

Esse projeto traz uma API restfull para gerenciamento de contas e pagamentos, feita como um desafio para desenvolvedores back-end no [Social Bank](https://socialbank.com.br/ "Site Social Bank").

A aplicação consiste em um CRUD de conta bancária, com a possibilidade de fazer algumas operações financeiras, como entrada de créditos e transferência entre contas internas.

## Endpoints pelo Swagger UI
![Endpoints Swagger UI](https://github.com/caeab/bank-account-management/blob/main/images/layout-endpoints.PNG) 

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

Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/caeab/bank-account-management.git

# executar o projeto
./mvnw spring-boot:run

# acessar <http://localhost:8080/swagger-ui.html>
```


## Endpoints

A lista completa de endpoints pode ser encontrada usando o Swagger UI.

Você consegue acessar o Swagger UI acessando a url: `/swagger-ui.html`.

# Itens do desafio realizados:

## Requisitos funcionais:
1. API deve CRIAR/RETORNAR/EDITAR/CANCELAR uma Conta.
a. Segue exemplo de payload de criação
{
 "idenfifier":"12350",
 "name":"John's Account",
 "description": "Checking account",
 "status": "ACTIVE"
}
2. Deve conter um endpoint para retornar o saldo atual da conta pelo identificador da
conta.
3. Deve possibilitar a entrada de créditos.
4. Deve possibilitar a transferência entre contas internas.
5. Deve possibilitar os seguintes tipos de pagamentos:
a. Pagamento de Boletos
{
 "barcode":"123900000500000000060000000007856760000015075",
 "expiration_date": "2022-04-12T23:59:59",
 "amount":56.12
}
6. Deve retornar o extrato da conta pelo identificador (diferencial: Paginado).

## Requisitos não funcionais:
1. Utilizar as linguagens/frameworks Java/Spring Boot ou C#/.NetCore;
a. Projetos Java utilizar Maven/Gradle;
b. Projetos C# utilizar o NuGet.
2. Integrar a aplicação a um Banco de Dados em memória (qualquer um);
3. Disponibilizar o projeto em um repositório público do GitHub com um arquivo
.README com instruções de utilização da API;
4. Embutir o SwaggerUI;
6. Aplicar conceitos de SOLID e Padrões de Projeto;


# Autor

Caetano Alcantara Borges

[Mais sobre Caetano](https://www.linkedin.com/in/caetano-alcantara-borges-7ba8b3101/ "Linkedin de Caetano")
