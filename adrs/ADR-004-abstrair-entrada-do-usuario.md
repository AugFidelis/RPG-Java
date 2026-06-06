# ADR-004: Abstrair entrada do usuário

## Status
Accepted

## Contexto
O jogo recebia dados do usuário por chamadas diretas à classe `Teclado`, como `Teclado.getUmInt()` e `Teclado.getUmString()`, espalhadas por classes da camada de aplicação. Essa decisão acoplava as regras do jogo a uma implementação concreta de entrada via terminal.

Esse acoplamento dificultava testes automatizados, porque qualquer teste de `Jogo`, `ServicoCombate` ou `ServicoInventario` dependeria de entrada real do console. Além disso, a classe `Teclado` possuía vários métodos que não eram necessários para o jogo, como leitura de `byte`, `short`, `long`, `float`, `double`, `char` e `boolean`, o que deixava a interface pública maior do que o necessário.

## Decisão
Criar a interface `EntradaUsuario`, contendo apenas os métodos necessários para o sistema atual: `lerInteiro()` e `lerTexto()`.

A classe `Teclado` passa a implementar essa interface, e as classes de aplicação passam a depender de `EntradaUsuario` em vez de depender diretamente de `Teclado`.

## Consequências
Benefícios esperados:

- Redução do acoplamento entre a camada de aplicação e a infraestrutura de entrada via console.
- Aplicação do princípio de Inversão de Dependência, pois a aplicação depende de uma abstração.
- Aplicação do princípio de Segregação de Interfaces, pois a interface expõe apenas os métodos usados pelo jogo.
- Melhora da testabilidade, pois uma implementação falsa de `EntradaUsuario` pode ser usada em testes.
- Tratamento explícito de erros de leitura, substituindo blocos `catch` vazios.

Custos esperados:

- Pequeno aumento no número de classes do projeto.
- Necessidade de passar a dependência `EntradaUsuario` para os serviços que precisam ler dados do jogador.
