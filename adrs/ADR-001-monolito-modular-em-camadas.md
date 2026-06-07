# ADR-001: Organizar o jogo como monolito modular em camadas

## Status

Accepted

## Contexto

O projeto e um jogo de RPG em modo texto, executado localmente em uma unica JVM. Ele nao possui servidor, banco de dados, comunicacao em rede ou necessidade de escalar para varios usuarios. Mesmo assim, o codigo precisa continuar evoluindo com novas classes de personagem, inimigos, itens, regras de combate e fluxos de jogo.

Manter todas as classes no mesmo pacote dificultaria a manutencao e deixaria responsabilidades diferentes misturadas. Por outro lado, adotar microsservicos, Clean Architecture completa ou arquitetura hexagonal criaria complexidade desnecessaria para o tamanho do sistema e da equipe.

## Decisao

O sistema foi organizado como um monolito modular em camadas, usando pacotes Java com responsabilidades separadas:

- `ui`: ponto de entrada e leitura de dados do usuario.
- `aplicacao`: fluxo da partida, comandos de menu, combate e inventario.
- `dominio`: entidades e regras centrais do RPG.
- `infra`: reservado para detalhes tecnicos futuros.

## Consequencias

A organizacao melhora a manutenibilidade porque deixa mais claro onde cada mudanca deve ser feita. Regras de dominio ficam separadas da entrada pelo terminal, e a camada de aplicacao coordena os fluxos sem concentrar todas as entidades.

O custo e que o projeto passa a ter mais pacotes e imports entre classes. Esse custo e aceitavel porque a separacao ajuda o grupo a dividir tarefas e facilita a documentacao arquitetural do trabalho.
