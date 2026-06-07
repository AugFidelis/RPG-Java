# ADR-003: Usar fabricas para criacao de personagens e inimigos

## Status

Accepted

## Contexto

A classe `Jogo` precisava criar personagens e inimigos durante o fluxo da partida. Quando essa criacao fica diretamente dentro da classe de aplicacao, `Jogo` passa a conhecer detalhes das classes concretas, como `Guerreiro`, `Mago`, `Arqueiro` e os diferentes tipos de `Inimigo`.

Esse acoplamento dificulta a extensao do jogo. Cada nova classe de personagem ou nova regra de geracao de inimigos exigiria alterar o fluxo principal da partida, mesmo que a mudanca esteja relacionada ao dominio.

## Decisao

Foram criadas as classes `FabricaPersonagem` e `FabricaInimigo`, no pacote `dominio`.

`FabricaPersonagem` recebe a escolha do jogador e devolve um objeto do tipo `Personagem`. `FabricaInimigo` recebe a localizacao atual e devolve um `Inimigo` adequado ao local.

## Consequencias

A classe `Jogo` fica menos acoplada as classes concretas do dominio e passa a delegar a criacao para fabricas especializadas. Isso facilita adicionar novos personagens e inimigos em evolucoes futuras.

O custo da decisao e a criacao de mais classes e a necessidade de manter as regras de fabrica atualizadas. Ainda assim, a separacao torna o codigo mais claro e ajuda a demonstrar o padrao Factory Method no projeto.
