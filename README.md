# Repositório do desafio sobre padrões de projeto e Spring

## Visão Geral

O repositório apresenta a implementação de um API REST para a manipulação de dados de clientes e seus endereços.O projeto foi desenvolvido com base no desafio apresentado na trilha **Ganhando Produtividade com Spring Framework** do bootcamp **Banco PAN Java Developers** da DIO.  


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
- Na classe ClienteServiceImpl foi criado um método para obter o endereço de determinado cliente. Tal método é adotado nas operações de cadastro e atualização de clientes
- A interface EnderecoRepository apresenta o método personalizado findByCep para recuperados os dados de endereço pelo cep
- O retorno das operações da classe ClienteRestController foram incrementados e adotam a classe ResponseEntity para especificar os status das requisições realizadas

