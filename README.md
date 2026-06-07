# RPG-Java: Invasão Alienígena na Universidade

Um jogo de RPG em modo texto desenvolvido em Java, onde você deve sobreviver a uma invasão alienígena no campus universitário da PUC-Campinas. Escolha sua classe, explore diferentes locais, enfrente inimigos e gerencie seu inventário para sobreviver.

## Sobre o Projeto

Durante uma tarde comum de aulas, uma nave alienígena cai no campus universitário. Você e outros estudantes ficam presos e devem lutar pela sobrevivência. Explore diferentes áreas do campus, enfrente inimigos alienígenas e use itens estrategicamente para se manter vivo.

## Características

- **Sistema de Classes**: escolha entre três classes diferentes, cada uma com atributos próprios.
- **Sistema de Combate**: batalhas baseadas em turnos com rolagem de dados.
- **Sistema de Inventário**: colete e use itens durante sua jornada.
- **Exploração**: navegue por diferentes locais do campus universitário.
- **Eventos Aleatórios**: encontros com inimigos e itens são determinados por chance.
- **Gestão de Recursos**: gerencie seus pontos de vida e itens cuidadosamente.

## Classes de Personagens

### 1. O Atleta (Guerreiro)

- **Curso**: Educação Física
- **HP Inicial**: 120
- **Ataque**: 8
- **Defesa**: 15
- **Especialidade**: alta resistência e defesa, ideal para jogadores que preferem tanques.

### 2. O Programador (Mago)

- **Curso**: Engenharia de Software
- **HP Inicial**: 70
- **Ataque**: 16
- **Defesa**: 8
- **Especialidade**: alto poder de ataque, mas frágil; jogue com estratégia.

### 3. O Arquiteto (Arqueiro)

- **Curso**: Arquitetura
- **HP Inicial**: 90
- **Ataque**: 12
- **Defesa**: 10
- **Especialidade**: atributos balanceados, ideal para iniciantes.

## Locais Exploráveis

- **Sala de Aula - Bloco C**: local inicial do jogo.
- **Pátio Central**: área de grande circulação; cuidado com patrulhas.
- **Cantina**: bom lugar para encontrar comida e itens de cura.
- **Biblioteca**: local mais perigoso, com inimigos mais fortes.
- **Prédio H (Laboratórios)**: área de risco com possibilidade de encontrar componentes eletrônicos.

## Como Jogar

### Compilação e Execução

1. Clone o repositório:

```bash
git clone https://github.com/AugFidelis/RPG-Java.git
cd RPG-Java
```

2. Compile o projeto:

```bash
javac -d out src/dominio/*.java src/aplicacao/*.java src/ui/*.java
```

3. Execute o jogo:

```bash
java -cp out ui.Main
```

### Controles do Jogo

Durante o jogo, você terá várias opções:

Menu principal:

- `1` - Explorar o local atual.
- `2` - Mover-se para outro local.
- `3` - Ver/usar itens do inventário.

Durante o combate:

- `1` - Atacar o inimigo.
- `2` - Usar item do inventário.
- `3` - Tentar fugir.

### Mecânicas de Jogo

- **Combate**: o sistema usa rolagem de dados (1d6) para determinar o sucesso dos ataques.
- **Dano**: calculado como `(Ataque + Dado) - Defesa do Oponente`.
- **Exploração**: cada exploração tem chance de encontrar itens ou inimigos.
- **Cura**: use salgados e outros itens para recuperar HP, sem exceder o HP máximo.

## Estrutura do Projeto

```text
RPG-Java/
├── adrs/                   # Registros de decisões arquiteturais
├── diagrams/               # Diagramas Mermaid versionados
├── docs/                   # Evidências e textos auxiliares da documentação
├── src/
│   ├── aplicacao/          # Casos de uso, serviços e comandos do jogo
│   ├── dominio/            # Entidades e regras centrais do RPG
│   ├── infra/              # Reservado para detalhes de infraestrutura
│   └── ui/                 # Entrada via terminal e ponto de entrada
├── out/                    # Arquivos compilados, ignorados pelo Git
└── README.md
```

### Organização Arquitetural

O projeto está organizado como um monólito modular com separação por camadas/pacotes:

- `dominio`: concentra as regras principais do jogo, como personagens, inimigos, itens e inventário.
- `aplicacao`: coordena os fluxos de uso, como menu principal, combate e inventário.
- `ui`: contém a entrada do usuário via terminal e a classe `Main`.
- `infra`: reservado para futuras integrações externas ou persistência.

## Tecnologias Utilizadas

- **Java**: linguagem de programação principal.
- **IntelliJ IDEA**: IDE de desenvolvimento.
- **Git**: controle de versão.

## Contexto Acadêmico

Este projeto foi desenvolvido como parte de um trabalho acadêmico, demonstrando conceitos de:

- Programação orientada a objetos (POO).
- Herança e polimorfismo.
- Encapsulamento.
- Tratamento de exceções.
- Estruturas de dados (`ArrayList`).
- Interfaces e padrões de projeto.

## Licença

Este projeto é de código aberto e está disponível para fins educacionais.
