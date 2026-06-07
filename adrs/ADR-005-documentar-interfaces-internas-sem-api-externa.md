# ADR-005: Documentar interfaces internas em vez de API externa

## Status

Accepted

## Contexto

O enunciado do trabalho pede a documentacao do design de API. No entanto, o sistema desenvolvido e um jogo de terminal executado localmente. Ele nao expoe REST, GraphQL, gRPC ou outro contrato de rede para consumidores externos.

Criar uma API externa artificial apenas para cumprir o formato aumentaria a complexidade do projeto sem trazer beneficio real ao usuario ou ao dominio do jogo.

## Decisao

Foi decidido documentar as interfaces internas entre os pacotes e classes principais do sistema. As interfaces mais relevantes sao `EntradaUsuario`, que separa a entrada via terminal da camada de aplicacao, `EfeitoItem`, que define o contrato dos efeitos de item, e `ComandoMenu`, que define o contrato das acoes do menu principal.

## Consequencias

A documentacao fica fiel ao sistema real e evita a criacao de uma API externa sem utilidade pratica. Tambem reforca a separacao entre `ui`, `aplicacao` e `dominio`.

O custo e que a secao de API do relatorio precisa explicar explicitamente por que nao ha OpenAPI, SDL GraphQL ou arquivo `.proto`, substituindo esses contratos por uma descricao das interfaces internas.
