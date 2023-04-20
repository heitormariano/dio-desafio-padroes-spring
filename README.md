# Repositório do desafio sobre padrões de projeto e framework Spring

## Visão Geral

Repositório criado para conter a implementação do desafio proposto.  
O projeto faz parte da trilha **Ganhando Produtividade com Spring Framework** do bootcamp **Banco PAN Java Developers** da DIO.  
O repositório apresenta a implementação de um API REST para a manipulação de dados de clientes e seus endereços.

## Objetivos

- Definir estrutura do projeto (pacotes específicos e suas entidades)
- Conhecer na prática determinados padrões empregados pelo Spring Boot
  - Singleton: anotações @Bean e @Autowired
  - Strategy: anotações @Service e @Repository
  - Facade: criação da API REST com auxílio desse padrão.
    - ClienteRestController: classe que "implementa" o padrão Facade
    - Abstrai a complexidade das funcionalidades do Spring Data JPA e do serviço ViaCEP (openfeign)
- Testar os serviços (endpoints) da API por meio do Postman

## Particularidades do projeto

- A API desenvolvida usa o banco de dados MySQL
- A versão do Java adotada é a 17 (LTS)
- A porta padrão do servidor web (tomcat) foi definida para a 8081 no application.properties

