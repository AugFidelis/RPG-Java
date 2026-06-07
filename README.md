# 🎮 RPG-Java: Invasão Alienígena na Universidade

Um jogo de RPG em modo texto desenvolvido em Java, onde você deve sobreviver a uma invasão alienígena campus universitário da PUC-Campinas. Escolha sua classe, explore diferentes locais, enfrente inimigos e gerencie seu inventário para sobreviver!

## 📋 Sobre o Projeto

Durante uma tarde comum de aulas, uma nave alienígena cai no campus universitário. Você e outros estudantes ficam presos e devem lutar pela sobrevivência. Explore diferentes áreas do campus, enfrente inimigos alienígenas e use itens estrategicamente para se manter vivo.

## ✨ Características

- **Sistema de Classes**: Escolha entre três classes diferentes, cada uma com atributos únicos
- **Sistema de Combate**: Batalhas baseadas em turnos com rolagem de dados
- **Sistema de Inventário**: Colete e use itens durante sua jornada
- **Exploração**: Navegue por diferentes locais do campus universitário
- **Eventos Aleatórios**: Encontros com inimigos e itens são determinados por chance
- **Gestão de Recursos**: Gerencie seus pontos de vida e itens cuidadosamente

## 🎯 Classes de Personagens

### 1. O Atleta (Guerreiro)
- **Curso**: Educação Física
- **HP Inicial**: 120
- **Ataque**: 8
- **Defesa**: 15
- **Especialidade**: Alta resistência e defesa, ideal para jogadores que preferem tanques

### 2. O Programador (Mago)
- **Curso**: Engenharia de Software
- **HP Inicial**: 70
- **Ataque**: 16
- **Defesa**: 8
- **Especialidade**: Alto poder de ataque, mas frágil - jogue com estratégia

### 3. O Arquiteto (Arqueiro)
- **Curso**: Arquitetura
- **HP Inicial**: 90
- **Ataque**: 12
- **Defesa**: 10
- **Especialidade**: Atributos balanceados, ideal para iniciantes

## 🗺️ Locais Exploráveis

- **Sala de Aula - Bloco C**: Local inicial do jogo
- **Pátio Central**: Área de grande circulação, cuidado com patrulhas!
- **Cantina**: Bom lugar para encontrar comida e itens de cura
- **Biblioteca**: Local mais perigoso com inimigos mais fortes
- **Prédio H (Laboratórios)**: Área de risco com possibilidade de encontrar componentes eletrônicos

## 🎮 Como Jogar

### Compilação e Execução

1. **Clone o repositório**:
```bash
git clone https://github.com/AugFidelis/RPG-Java.git
cd RPG-Java
```

2. **Compile o projeto**:
```bash
javac -d out src/dominio/*.java src/aplicacao/*.java src/ui/*.java
```

3. **Execute o jogo**:
```bash
java -cp out ui.Main
```

### Controles do Jogo

Durante o jogo, você terá várias opções:

1. **Menu Principal**:
   - `1` - Explorar o local atual
   - `2` - Mover-se para outro local
   - `3` - Ver/Usar itens do inventário

2. **Durante o Combate**:
   - `1` - Atacar o inimigo
   - `2` - Usar item do inventário
   - `3` - Tentar fugir (50% de chance)

### Mecânicas de Jogo

- **Combate**: O sistema usa rolagem de dados (1d6) para determinar o sucesso dos ataques
- **Dano**: Calculado como `(Ataque + Dado) - Defesa do Oponente`
- **Exploração**: Cada exploração tem chance de encontrar itens ou inimigos
- **Cura**: Use salgados e outros itens para recuperar HP (não pode exceder HP máximo)

## 📁 Estrutura do Projeto

```
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

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal
- **IntelliJ IDEA**: IDE de desenvolvimento
- **Git**: Controle de versão

## 🎓 Contexto Acadêmico

Este projeto foi desenvolvido como parte de um trabalho acadêmico, demonstrando conceitos de:
- Programação Orientada a Objetos (POO)
- Herança e Polimorfismo
- Encapsulamento
- Tratamento de exceções
- Estruturas de dados (ArrayList)
- Interfaces (Comparable, Cloneable)

## 📝 Licença

Este projeto é de código aberto e está disponível para fins educacionais.
