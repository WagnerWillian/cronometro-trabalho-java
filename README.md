# ⏱️ Cronômetro de Trabalho — Java



Aplicação de console desenvolvida em Java para controlar e contabilizar o tempo dedicado a atividades profissionais.



O projeto surgiu da necessidade de acompanhar o tempo gasto na execução de tarefas, especialmente em trabalhos freelancer, permitindo medir com maior precisão a duração das atividades.



Além de sua finalidade prática, o projeto tem como objetivo consolidar conhecimentos de \*\*Java, Programação Orientada a Objetos (POO), lógica de programação e organização de código\*\*.



\## 🚀 Funcionalidades



\- \*\*Iniciar cronômetro:\*\* inicia a contagem do tempo.

\- \*\*Pausar cronômetro:\*\* interrompe temporariamente a contagem.

\- \*\*Retomar cronômetro:\*\* continua a contagem sem contabilizar o período pausado.

\- \*\*Encerrar sessão:\*\* finaliza a contagem e apresenta o tempo total.

\- \*\*Validação de operações:\*\* impede ações incompatíveis com o estado atual do cronômetro.



\## 🛠️ Tecnologias utilizadas



\- Java 21

\- IntelliJ IDEA

\- Git e GitHub



\## 🧠 Conceitos aplicados



\- Programação Orientada a Objetos (POO)

\- Classes, objetos e métodos

\- Encapsulamento e separação de responsabilidades

\- Estruturas condicionais

\- Validação de regras de negócio

\- Controle de estados da aplicação

\- Medição de intervalos utilizando `System.nanoTime()`



\## ⚙️ Como funciona



O cronômetro utiliza `System.nanoTime()` para medir intervalos de tempo, permitindo controlar a duração das atividades sem depender do horário do sistema.



Durante a execução, o usuário pode iniciar, pausar, retomar e encerrar o cronômetro.



O tempo transcorrido durante as pausas não é contabilizado no resultado final.



A aplicação também realiza validações para evitar operações inválidas, como tentar pausar um cronômetro que ainda não foi iniciado.



\## 🧪 Testes



Foram realizados testes manuais para verificar o comportamento das principais funcionalidades, incluindo:



\- Início da contagem.

\- Pausa e retomada.

\- Encerramento da sessão.

\- Cálculo do tempo acumulado.

\- Tentativas de executar operações inválidas.



\## 📌 Próximas melhorias



\- \[ ] Cadastro do nome da tarefa.

\- \[ ] Registro das sessões realizadas.

\- \[ ] Histórico de atividades e tempos registrados.

\- \[ ] Persistência dos dados.

\- \[ ] Desenvolvimento de interface gráfica.



\## 📚 Sobre o projeto



Este projeto faz parte dos meus estudos de desenvolvimento de software com Java e está em evolução contínua.



Seu desenvolvimento busca aplicar conceitos aprendidos em situações práticas, com foco na organização do código, implementação de regras de negócio e resolução de problemas.

