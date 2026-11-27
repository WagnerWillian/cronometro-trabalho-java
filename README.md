
# ⏱️ Cronômetro de Trabalho — Java

Aplicação de console desenvolvida em Java para controlar e contabilizar o tempo dedicado a atividades profissionais.

O projeto surgiu da necessidade de acompanhar o tempo gasto na execução de tarefas, especialmente em trabalhos freelancer, permitindo medir com maior precisão a duração das atividades.

Além de sua finalidade prática, o projeto tem como objetivo consolidar conhecimentos de **Java, Programação Orientada a Objetos (POO), lógica de programação e organização de código**.

## 🚀 Funcionalidades

- **Iniciar cronômetro:** inicia a contagem do tempo.
- **Identificação da sessão:** permite informar o nome da atividade realizada.
- **Pausar cronômetro:** interrompe temporariamente a contagem.
- **Retomar cronômetro:** continua a contagem sem contabilizar o período pausado.
- **Encerrar sessão:** finaliza a contagem, apresenta o tempo total e registra a atividade.
- **Histórico de sessões:** permite consultar as atividades concluídas e seus respectivos tempos.
- **Validação de operações:** impede ações incompatíveis com o estado atual do cronômetro.
- **Validação de entradas:** impede nomes vazios e trata opções inválidas do menu.
- **Confirmação de saída:** evita o encerramento acidental da aplicação durante uma sessão ativa.

## 🛠️ Tecnologias utilizadas

- Java 21
- IntelliJ IDEA
- Git e GitHub

## 🧠 Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Classes, objetos e métodos
- Encapsulamento e separação de responsabilidades
- Estruturas condicionais e de repetição
- Validação de regras de negócio
- Controle de estados da aplicação
- Escopo de variáveis
- Métodos com retorno
- Java Collections (`List` e `ArrayList`)
- Records
- Formatação de informações com `printf()`
- Medição de intervalos utilizando `System.nanoTime()`

## ⚙️ Como funciona

O cronômetro utiliza `System.nanoTime()` para medir intervalos de tempo, permitindo controlar a duração das atividades sem depender do horário do sistema.

Durante a execução, o usuário pode iniciar, pausar, retomar e encerrar o cronômetro.

O tempo transcorrido durante as pausas não é contabilizado no resultado final.

Ao encerrar uma sessão, seu nome e tempo acumulado são armazenados em uma lista, permitindo a consulta posterior pelo menu de histórico.

A aplicação também realiza validações para evitar operações inválidas, como tentar pausar um cronômetro que ainda não foi iniciado.

> **Nota:** nesta versão, os registros são armazenados apenas em memória. O histórico é perdido ao encerrar a aplicação.

## 📦 Instalação e execução

### Pré-requisitos

- JDK 21 instalado.
- Git instalado, caso utilize a clonagem do repositório.

Para verificar a instalação do Java, execute:

```bash
java -version
javac -version
```

### 1. Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
cd cronometro-trabalho-java
```

Também é possível baixar o projeto diretamente pelo GitHub, utilizando a opção **Code > Download ZIP**.

### 2. Compilar o projeto

Na pasta raiz do projeto, execute:

```bash
javac -encoding UTF-8 -d out src/com/wagner/cronometro/*.java
```

Os arquivos compilados serão armazenados na pasta `out`.

### 3. Executar a aplicação

```bash
java -cp out com.wagner.cronometro.Main
```

### Executar pelo IntelliJ IDEA

1. Abra o IntelliJ IDEA.
2. Selecione a opção **Open**.
3. Selecione a pasta do projeto.
4. Configure o JDK 21.
5. Localize a classe `Main.java`.
6. Execute o método `main()`.

## 📖 Como utilizar

Ao executar a aplicação, será apresentado o seguinte menu:

```text
====CRONOMETRO====
=                =
= 1 - INICIAR    =
= 2 - PAUSAR     =
= 3 - RETOMAR    =
= 4 - ENCERRAR   =
= 5 - HISTÓRICO  =
= 0 - SAIR       =
=                =
==================
```

| Opção | Descrição |
|:---:|---|
| 1 | Informar o nome da atividade e iniciar a contagem. |
| 2 | Pausar a contagem do tempo. |
| 3 | Retomar uma sessão pausada. |
| 4 | Encerrar e registrar a sessão atual. |
| 5 | Consultar o histórico de sessões concluídas. |
| 0 | Encerrar a aplicação. |

O histórico pode ser consultado durante uma sessão ativa ou pausada, sem interferir na contagem do tempo.

## 🧪 Testes

Foram realizados testes manuais para verificar o comportamento das principais funcionalidades, incluindo:

- Início da contagem.
- Pausa e retomada.
- Encerramento da sessão.
- Cálculo do tempo acumulado.
- Tentativas de executar operações inválidas.
- Validação de nomes de sessões.
- Registro e consulta do histórico.
- Consulta do histórico vazio.
- Confirmação e cancelamento da saída.
- Tratamento de entradas inválidas.

## 📌 Roadmap

### Funcionalidades implementadas

- [x] Controle de início, pausa, retomada e encerramento.
- [x] Validação de operações e entradas.
- [x] Cadastro do nome da tarefa.
- [x] Registro das sessões realizadas.
- [x] Histórico de atividades e tempos registrados.
- [x] Confirmação de saída.

### Próximas melhorias

- [ ] Formatação do tempo em horas, minutos e segundos (`HH:mm:ss`).
- [ ] Persistência dos dados.
- [ ] Implementação de testes automatizados com JUnit.
- [ ] Desenvolvimento de interface gráfica.

## 📚 Sobre o projeto

Este projeto faz parte dos meus estudos de desenvolvimento de software com Java e está em evolução contínua.

Seu desenvolvimento busca aplicar conceitos aprendidos em situações práticas, com foco na organização do código, implementação de regras de negócio e resolução de problemas.
