**Sistema de Coleta Sustentável - Cidade Inteligente**



**1. Escopo do Sistema**



O **Sistema de Coleta Sustentável** é uma aplicação Java que simula um sistema inteligente de gerenciamento de coleta de lixo urbano. O sistema utiliza conceitos de IoT (Internet das Coisas) e inteligência artificial para otimizar rotas de coleta, monitorar lixeiras em tempo real e promover práticas sustentáveis de gestão de resíduos.



**2. Finalidade e Funcionalidades**



2.1 Objetivo Principal

Demonstrar como tecnologias modernas podem ser aplicadas para criar cidades mais inteligentes e sustentáveis, otimizando a coleta de lixo e reduzindo custos operacionais.



2.2 Funcionalidades Principais



2.2.1.  Monitoramento em Tempo Real

  - Visualização do status de todas as lixeiras

  - Indicadores visuais por nível de capacidade

  - Alertas automáticos para lixeiras críticas



2.2.2 Roteirização Inteligente

  - Estratégia por urgência (prioriza lixeiras mais cheias)

  - Estratégia por proximidade (otimiza percurso)

  - Seleção dinâmica de estratégias



2.2.3. Simulação de Sensores IoT

  - Sensores virtuais funcionando em paralelo

  - Atualização automática dos níveis

  - Monitoramento contínuo



2.2.4. Persistência de Dados

  - Salvamento automático dos dados das lixeiras

  - Logs detalhados de todas as operações

  - Carregamento automático na inicialização



2.2.5. Interface Gráfica Intuitiva

  - Painel visual com status das lixeiras

  - Controles para simulação e monitoramento

  - Relatórios em tempo real



2.2.6. Execução de Comandos

  - Sistema de comandos para operações de coleta

  - Possibilidade de desfazer operações

  - Histórico completo de ações



**3. Arquitetura e Padrões de Projeto**



3.1 Padrões GoF Implementados



3.1.1. Strategy Pattern

\- Localização: `strategy/RoteirizacaoStrategy.java`

\- Implementações: 

 - `RoteirizacaoPorUrgencia`: Prioriza lixeiras mais cheias

 - `RoteirizacaoPorProximidade`: Otimiza por distância

\- Vantagem: Permite trocar algoritmos de roteirização dinamicamente



3.1.2. Observer Pattern

\- Localização: `observer/LixeiraObserver.java`

\- Implementação: `MonitorColeta.java`

\- Uso: Notifica quando lixeiras atingem níveis críticos

\- Vantagem: Desacopla o monitoramento da lógica das lixeiras



3.1.3.  Factory Method Pattern

\- Localização: `factory/LixeiraFactory.java`

\- Implementação: `LixeiraComumFactory.java`

\- Uso: Cria instâncias de lixeiras de forma padronizada

\- Vantagem: Centraliza a criação de objetos



3.1.4.  Singleton Pattern

\- Localização: `controller/CentralColeta.java`

\- Uso: Garante uma única instância da central de controle

\- Vantagem: Coordenação centralizada do sistema



3.1.5.  Decorator Pattern

\- Localização: `decorator/LixeiraDecorator.java`

\- Implementação: `LixeiraComSensor.java`

\- Uso: Adiciona funcionalidades extras às lixeiras

\- Vantagem: Extensibilidade sem modificar classes base



3.1.6. Command Pattern

\- Localização: `command/ColetaCommand.java`

\- Implementação: `ColetarLixeiraCommand.java`

\- Uso: Encapsula operações de coleta

\- Vantagem: Permite desfazer operações e criar macros



**4. Funcionalidades Obrigatórias Implementadas**



4.1 Leitura/Gravação de Arquivos

\- Arquivo: `utils/ArquivoManager.java`

\- Funcionalidades:

 - Salva dados das lixeiras em `lixeiras.txt`

 - Carrega dados na inicialização

 - Gera logs em `coleta_log.txt`



4.2 Tratamento de Exceções

\- Arquivo: `utils/LixeiraException.java`

\- Uso: Tratamento de erros em operações de arquivo

\- Locais: Carregamento, salvamento e operações críticas



4.3 Threads

\- Localização: `controller/CentralColeta.java`

\- Uso: Simula sensores funcionando em paralelo

\- Implementação: `ExecutorService` com pool de threads



4.4 Testes Automatizados

\- Arquivo: `test/ColetaSustentavelTest.java`

\- Framework: JUnit 5 5

\- Cobertura: Testa todos os padrões e funcionalidades principais



**5. Estrutura do Projeto**



```

src/

├── command/

│   ├── ColetaCommand.java

│   └── ColetarLixeiraCommand.java

├── controller/

│   └── CentralColeta.java

├── decorator/

│   ├── LixeiraDecorator.java

│   └── LixeiraComSensor.java

├── factory/

│   ├── LixeiraFactory.java

│   └── LixeiraComumFactory.java

├── model/

│   └── Lixeira.java

├── observer/

│   ├── LixeiraObserver.java

│   └── MonitorColeta.java

├── strategy/

│   ├── RoteirizacaoStrategy.java

│   ├── RoteirizacaoPorUrgencia.java

│   └── RoteirizacaoPorProximidade.java

├── utils/

│   ├── ArquivoManager.java

│   └── LixeiraException.java

├── view/

│   └── TelaPrincipal.java

└── test/

   └── ColetaSustentavelTest.java

```



**6. Instruções de Execução**



6.1. Pré-requisitos

\- Java 8 ou superior

\- JUnit 5 5 (para testes)

\- IDE Java (Eclipse, IntelliJ, VSCode)



6.2. Passos para Execução



1\. Clonar/Baixar o Projeto

  ```bash

  # Extrair arquivos para uma pasta

  mkdir coleta-sustentavel

  cd coleta-sustentavel

  ```



2\. Compilar o Projeto

  ```bash

  # Compilar todas as classes

  javac -cp ".:lib/\*" src/\*\*/\*.java -d bin/

  ```



3\. Executar a Aplicação

  ```bash

  # Executar a interface gráfica

  java -cp "bin:lib/\*" view.TelaPrincipal

  ```



4\. Executar os Testes

  ```bash

  # Executar testes JUnit 5

  java -cp "bin:lib/\*" org.junit.platform.console.ConsoleLauncher --scan-classpath

  ```



6.3 Usando IDE

1\. Importar projeto na IDE

2\. Configurar bibliotecas (JUnit 5 5)

3\. Executar `TelaPrincipal.main()`

4\. Para testes: executar `ColetaSustentavelTest`



6.4 Como Usar o Sistema



6.4.1 Interface Principal

1\. Painel de Lixeiras: Mostra status visual de todas as lixeiras

2\. Relatório de Atividades: Log em tempo real das operações

3\. Controles: Botões para simular e gerenciar o sistema



6.4.2 Operações Disponíveis

\- Atualizar Lixeiras: Atualiza a visualização

\- Simular Coleta: Executa coleta inteligente

\- Simular Sensores: Atualiza níveis das lixeiras

\- Salvar Dados: Persiste informações



6.4.3 Indicadores Visuais

\- 🟢 Verde: Nível baixo (0-49%)

\- 🟡 Amarelo: Nível médio (50-69%)

\- 🟠 Laranja: Nível alto (70-89%)

\- 🔴 Vermelho: Nível crítico (90-100%)



**7. Diagrama de Classes**

classDiagram

   class Lixeira {

       -int id

       -String localizacao

       -int nivel

       -List~LixeiraObserver~ observers

       +adicionarObserver(observer)

       +adicionarLixo(quantidade)

       +getNivel()

       +getLocalizacao()

   }

   

   class CentralColeta {

       -static CentralColeta instancia

       -List~Lixeira~ lixeiras

       -MonitorColeta monitor

       +getInstancia()

       +designarRota(strategy)

       +simularSensores()

   }

   

   class RoteirizacaoStrategy {

       <<interface>>

       +definirRota(lixeiras)

   }

   

   class RoteirizacaoPorUrgencia {

       +definirRota(lixeiras)

   }

   

   class RoteirizacaoPorProximidade {

       +definirRota(lixeiras)

   }

   

   class LixeiraObserver {

       <<interface>>

       +onLixeiraCheia(lixeira)

       +onLixeiraVazia(lixeira)

       +onNivelCritico(lixeira)

   }

   

   class MonitorColeta {

       +onLixeiraCheia(lixeira)

       +onLixeiraVazia(lixeira)

       +onNivelCritico(lixeira)

   }

   

   class LixeiraFactory {

       <<abstract>>

       +criarLixeira(id, localizacao, nivel)

   }

   

   class LixeiraComumFactory {

       +criarLixeira(id, localizacao, nivel)

   }

   

   class ColetaCommand {

       <<interface>>

       +executar()

       +desfazer()

   }

   

   class ColetarLixeiraCommand {

       -Lixeira lixeira

       +executar()

       +desfazer()

   }

   

   class ArquivoManager {

       +salvarLixeiras(lixeiras)

       +carregarLixeiras()

       +salvarLog(mensagem)

   }

   

   class TelaPrincipal {

       -JTextArea log

       -JPanel painelLixeiras

       +simularColeta()

       +atualizarPainelLixeiras()

   }

   

   CentralColeta ||--o{ Lixeira : gerencia

   CentralColeta --> RoteirizacaoStrategy : usa

   RoteirizacaoStrategy <|.. RoteirizacaoPorUrgencia : implementa

   RoteirizacaoStrategy <|.. RoteirizacaoPorProximidade : implementa

   Lixeira --> LixeiraObserver : notifica

   LixeiraObserver <|.. MonitorColeta : implementa

   LixeiraFactory <|-- LixeiraComumFactory : herda

   LixeiraFactory --> Lixeira : cria

   ColetaCommand <|.. ColetarLixeiraCommand : implementa

   ColetarLixeiraCommand --> Lixeira : opera

   TelaPrincipal --> CentralColeta : controla

   CentralColeta --> ArquivoManager : usa

```



**8. Tecnologias Utilizadas**



\- Java 8+: Linguagem principal

\- Swing: Interface gráfica

\- JUnit 5 5: Framework de testes

\- Threads: Programação concorrente

\- I/O: Manipulação de arquivos

\- Padrões GoF: Arquitetura robusta



**9. Benefícios do Sistema**



9.1 Sustentabilidade

\- Redução de rotas desnecessárias

\- Otimização do consumo de combustível

\- Diminuição da pegada de carbono



9.2 Eficiência Operacional

\- Coleta apenas quando necessário

\- Priorização automática por urgência

\- Monitoramento em tempo real



9.3 Escalabilidade

\- Fácil adição de novas lixeiras

\- Múltiplas estratégias de roteamento

\- Arquitetura extensível



**10. Possíveis Melhorias Futuras**



1\. Integração com GPS: Rotas baseadas em coordenadas reais

2\. Machine Learning: Predição de enchimento das lixeiras

3\. API REST: Comunicação com dispositivos IoT reais

4\. Dashboard Web: Interface web para monitoramento

5\. Notificações Push: Alertas para operadores

6\. Análise de Dados: Relatórios estatísticos avançados



**11. Contribuições**



Este projeto foi desenvolvido como trabalho acadêmico demonstrando a aplicação prática de:

\- Padrões de Projeto GoF

\- Programação Orientada a Objetos

\- Interfaces Gráficas em Java

\- Testes Automatizados

\- Gestão de Arquivos e Exceções



---



Sistema de Coleta Sustentável v1.0

Transformando cidades em ambientes mais inteligentes e sustentáveis 🌱

