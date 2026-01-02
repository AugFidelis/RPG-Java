# 🎮 RPG-Java: Invasão Alienígena na Universidade

Um jogo de RPG em modo texto desenvolvido em Java, onde você deve sobreviver a uma invasão alienígena em um campus universitário. Escolha sua classe, explore diferentes locais, enfrente inimigos e gerencie seu inventário para sobreviver!

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
javac -d out src/*.java
```

3. **Execute o jogo**:
```bash
java -cp out RPG.Main
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

## 🎒 Sistema de Itens

- **Salgado**: Restaura 20 HP (encontrado principalmente na Cantina)
- **Componentes Eletrônicos**: Coletáveis no Prédio H (planejado para crafting futuro)
- **Buffs de Ataque/Defesa**: Sistema planejado para itens temporários

## 👾 Inimigos

### Áreas Fáceis (Bloco C, Cantina, Pátio)
- **Drone de Patrulha**: HP 40, ATK 10, DEF 5 (Nível 1)
- **Soldado Invasor**: HP 70, ATK 15, DEF 8 (Nível 3)

### Áreas Difíceis (Biblioteca, Prédio H)
- **Soldado Invasor**: HP 70, ATK 15, DEF 8 (Nível 3)
- **Drone Sentinela**: HP 90, ATK 8, DEF 15 (Nível 3) - Focado em defesa

## 📁 Estrutura do Projeto

```
RPG-Java/
├── src/
│   ├── Main.java           # Ponto de entrada do jogo
│   ├── Jogo.java           # Lógica principal do jogo
│   ├── Personagem.java     # Classe abstrata base para personagens
│   ├── Guerreiro.java      # Classe Guerreiro (Atleta)
│   ├── Mago.java           # Classe Mago (Programador)
│   ├── Arqueiro.java       # Classe Arqueiro (Arquiteto)
│   ├── Inimigo.java        # Classe de inimigos
│   ├── Item.java           # Classe de itens
│   ├── Inventario.java     # Sistema de inventário
│   └── Teclado.java        # Utilitário para entrada de dados
├── out/                    # Arquivos compilados
└── README.md              # Este arquivo
```

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal
- **IntelliJ IDEA**: IDE de desenvolvimento
- **Git**: Controle de versão

## 🔮 Melhorias Futuras (TODOs)

O código contém vários comentários indicando áreas para expansão:

- [ ] Sistema de drop de itens pelos inimigos
- [ ] Definir história final e nomes definitivos das classes
- [ ] Adicionar mais variedade de inimigos por localização
- [ ] Sistema de crafting com componentes eletrônicos
- [ ] Valores configuráveis para cura/buff de itens (atualmente hardcoded)
- [ ] Sistema de experiência e level-up
- [ ] Mais locais para explorar
- [ ] Habilidades especiais por classe
- [ ] Sistema de salvamento de progresso

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

## 👨‍💻 Autor

Desenvolvido por [AugFidelis](https://github.com/AugFidelis)

---

**Divirta-se jogando e boa sorte na sua sobrevivência! 🚀👽**
