# Cadastro-Empresa-Back

**Cadastro-Empresa-Back** fornece endpoints para criar, alterar, excluir e filtrar empresas.

Uma das regras impostas para esta api foi que empresa matriz não pode ser excluída, somente filial. Ao validar essa e outras regras, a api retorna um objeto contendo as seguintes propriedades:
código do status HTTP do erro, mensagem informando o ocorrido e o tempo em milissegundo indicando o momento em que o erro ocorreu.
Outra regra imposta foi que os filtros de pesquisa deveriam contar com paginação, a qual também foi prontamente atendida.

Este projeto consome a api de endereços fornecida pelo site https://viacep.com.br.

## Tecnologias utilizadas no desenvolvimento
* Spring Boot
* Spring Rest
* Spring Data JPA
* MySQL (porta 3306, usuario: root, senha: 123456)
* Maven

*A API roda na porta 8080
