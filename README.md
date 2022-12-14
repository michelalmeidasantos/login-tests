# login-tests

Este repositorio é destinado a Aceleração Automação de Testes #TQI - Appium em Java
https://www.dio.me/acceleration/aceleracao-automacao-de-testes-tqi

## Índice

-   [Instalação](#install)
-   [Rodando o projeto](#start)
-   [Estrutura do projeto](#structure)

## <a name="install"></a>Instalação

```shell
cd ~/workspace
git clone https://github.com/michelalmeidasantos/login-tests.git
```
**Obs.:** É necessário ter configurado todas as dependencias do appium:
ANDROID_HOME, JAVA_HOME, node, appium server (npm install -g appium) e [appium inspector](https://github.com/appium/appium-inspector/releases).

**Obs. 2:** É possível utilizar appium doctor (npm install -g appium-doctor) para verificar se sua instalação está OK.

## <a name="start"></a>Rodando o projeto
### Localmente
Abrir o emulador e clicar no Run de um teste, direto do IntelliJ, ou utilizar o comando para rodar o projeto:

| Comando                                                                              | Uso                                                                                                  |
|--------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|
| `./gradlew test --tests br.com.tqi.tests.v1.LoginAndroidTests.logarAposCriarUsuario` | Roda os testes usando Gradle, caso desejado passar a opção `--tests` + `package` + `metodo de teste` |

## <a name="structure"></a>Estrutura do projeto
src\
└─test\
└─└─java\
└─└─└─br.com.tqi.tests\
└─└─└─└─v1\
└─└─└─└─v2\
└─└─└─└─v3\
└─└─└─└─v4\
└─└─└─└─v5\
└─└─resources\
└─└─└─app\
└─└─└─└─login.apk

### v1

Pasta contendo a forma mais simples de um teste em appium

### v2

Pequena organização do teste e adicionando @BeforeEach e @AfterEach

### v3

Utilização de Page Objects para organizar o teste

### v4

Ajuste do driver para rodar o teste no [BrowserStack](https://www.browserstack.com/)

### v5

Cópia da v3, utilizando o appium java-client 8.1.1, para visualizar mudanças da nova versão
