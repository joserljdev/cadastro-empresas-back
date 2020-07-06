# Cadastro-Empresa-API

**Cadastro-Empresa-API** fornece endpoints para criar, alterar, excluir e filtrar empresas.

Uma das regras impostas para esta api foi que empresa matriz não pode ser excluída, somente filial. Ao validar essa e outras regras, a api retorna um objeto contendo as seguintes propriedades:
código do status HTTP do erro, mensagem informando o ocorrido e o tempo em milissegundo indicando o momento em que o erro ocorreu.


Este projeto consome a api de endereços fornecida pelo site https://viacep.com.br.

## Tecnologias utilizadas no desenvolvimento
* Spring Boot
* Spring Rest
* Spring Data JPA
* MySQL
* Maven
