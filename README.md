# Mini Projetos JavaFX

Coleção de 9 mini-aplicações desktop com interface gráfica, feitas com **JavaFX + FXML** dentro de um único projeto Maven.

## Projetos

| Projeto | Descrição |
|---|---|
| `cadastroDePessoa` | Formulário de cadastro de pessoa. |
| `cadastroSimples` | Cadastro simples de aluno. |
| `calculadoraDeOperacoesBasicas` | Calculadora com as quatro operações básicas. |
| `contaDeLuz` | Cálculo de conta de luz por tipo de ligação (residencial, comercial, industrial). |
| `conversorDeTemperatura` | Conversor entre escalas de temperatura. |
| `jogoDeAdivinhacao` | Jogo de adivinhar um número sorteado. |
| `mediaEscolar` | Cálculo de média escolar. |
| `montagemDeLanche` | Montagem de pedido de lanche com cálculo de valor. |
| `semaforoTimer` | Simulação de um semáforo com temporizador. |

## Tecnologias

- Java 24
- JavaFX 21 (Controls + FXML)
- Maven

## Como executar

Cada mini-projeto tem sua própria classe `Launcher` com `main()`. Para rodar um deles:

- **Pela IDE:** abra o projeto Maven, localize `src/main/java/projetos/<nome-do-projeto>/Launcher.java` e execute.
- **Pela linha de comando:**
  ```bash
  ./mvnw javafx:run -Djavafx.mainClass=projetos.<nome-do-projeto>.Launcher
  ```
  Exemplo: `./mvnw javafx:run -Djavafx.mainClass=projetos.jogoDeAdivinhacao.Launcher`
