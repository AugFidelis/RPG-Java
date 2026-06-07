# ADR-002: Substituir switch de efeitos por Strategy

## Status

Accepted

## Contexto

A classe `Item` concentrava a regra de uso de itens dentro de um `switch` baseado em strings, como `CURA_HP`, `BUFF_ATK` e `BUFF_DEF`. Essa solução funcionava para poucos efeitos, mas dificultava a evolução do jogo: cada novo efeito obrigava a alterar a própria classe `Item`, aumentando o acoplamento e o risco de regressão em efeitos já existentes.

Além disso, a implementação antiga deixava a classe `Item` com mais de uma responsabilidade. Ela armazenava os dados do item, controlava quantidade e também conhecia os detalhes de cada regra de efeito. Isso contrariava a ideia de manter o domínio aberto para novas mecânicas sem modificar código estável.

## Decisão

Foi criada a interface `EfeitoItem`, com o método `aplicar(Personagem alvo)`. Cada efeito passou a ser representado por uma classe própria, como `CuraHP`, `BuffAtaque`, `BuffDefesa` e `SemEfeito`.

Com isso, `Item` passou a guardar uma referência para `EfeitoItem` e delegar a execução do efeito para essa estratégia. A classe `Item` não precisa mais testar strings nem conhecer todos os efeitos possíveis.

## Consequências

A principal consequência positiva é a aderência ao Open-Closed Principle: para adicionar um novo efeito, basta criar uma nova classe que implementa `EfeitoItem`, sem alterar `Item.usar`. A mudança também deixou o código mais coeso, porque a regra de cura, ataque e defesa ficou isolada nas classes específicas.

O custo da decisão foi o aumento no número de classes. Para um projeto pequeno, isso adiciona um pouco mais de estrutura, mas o custo é aceitável porque o jogo tende a crescer com novos itens, buffs e mecânicas de combate.
