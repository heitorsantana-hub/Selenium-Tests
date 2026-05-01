# TesteSelenium - Projeto de Automação de Testes Web

Projeto de automação de testes web utilizando **Selenium WebDriver** com **Java** e **Maven**, desenvolvido para validar funcionalidades de login em uma página HTML local.

## 📋 Visão Geral

Este projeto implementa testes automatizados para simular interações de usuário em uma página de login, verificando cenários de sucesso e falha através de múltiplos desafios de teste.

## 🏗️ Estrutura do Projeto

```
selenium-atividade/
├── TesteSelenium/
│   ├── src/main/java/com/aula/selenium/
│   │   ├── Desafio1LoginValido.java      # Teste de login bem-sucedido
│   │   ├── Desafio2LoginInvalido.java    # Teste de login com credenciais inválidas
│   │   ├── Desafio3CamposVazios.java     # Teste de submissão com campos vazios
│   │   ├── Desafio4SemPerfil.java        # Teste de login sem seleção de perfil
│   │   ├── DesafioBonusRelatorio.java    # Relatório consolidado dos testes
│   │   └── CapturaTela.java              # Utilitário para captura de screenshots
│   ├── pom.xml                           # Configurações Maven e dependências
│   └── .mvn/                             # Configurações do Maven wrapper
├── site-teste-simples.html               # Página HTML de teste (login)
├── desafio1-sucesso.png                  # Screenshot do teste 1
├── desafio2-erro.png                     # Screenshot do teste 2
├── desafio3-campos-vazios.png            # Screenshot do teste 3
└── desafio4-sem-perfil.png               # Screenshot do teste 4
```

## 🧪 Desafios Implementados

| Desafio | Descrição | Resultado Esperado |
|---------|-----------|-------------------|
| **Desafio 1** | Login válido (admin/123 + perfil) | Mensagem de sucesso |
| **Desafio 2** | Login com credenciais inválidas | Mensagem de erro |
| **Desafio 3** | Submissão com campos vazios | Mensagem de erro |
| **Desafio 4** | Login sem selecionar perfil | Mensagem de erro |
| **Bônus** | Geração de relatório dos testes | Console com resultados |

## 🛠️ Tecnologias e Dependências

- **Java 11**
- **Selenium WebDriver 4.14.0** - Automação de browsers
- **WebDriverManager 5.5.3** - Gerenciamento automático de drivers
- **SLF4J 2.0.9** - Logging
- **Maven** - Gerenciamento de build e dependências
- **Google Chrome** - Browser alvo para testes

## 📦 Pré-requisitos

- JDK 11 ou superior instalado
- Maven instalado
- Google Chrome instalado

## 🚀 Como Executar

### 1. Clone ou navegue até o diretório do projeto

```bash
cd TesteSelenium
```

### 2. Compile o projeto

```bash
mvn clean compile
```

### 3. Execute os testes

Execute individualmente cada classe de teste:

```bash
# Desafio 1 - Login válido
mvn exec:java -Dexec.mainClass="com.aula.selenium.Desafio1LoginValido"

# Desafio 2 - Login inválido
mvn exec:java -Dexec.mainClass="com.aula.selenium.Desafio2LoginInvalido"

# Desafio 3 - Campos vazios
mvn exec:java -Dexec.mainClass="com.aula.selenium.Desafio3CamposVazios"

# Desafio 4 - Sem perfil
mvn exec:java -Dexec.mainClass="com.aula.selenium.Desafio4SemPerfil"

# Bônus - Relatório
mvn exec:java -Dexec.mainClass="com.aula.selenium.DesafioBonusRelatorio"
```

## 📸 Capturas de Tela

Cada teste gera automaticamente uma screenshot do resultado, salva na raiz do projeto:

- `desafio1-sucesso.png` - Login realizado com sucesso
- `desafio2-erro.png` - Login com credenciais inválidas
- `desafio3-campos-vazios.png` - Tentativa com campos vazios
- `desafio4-sem-perfil.png` - Login sem seleção de perfil

## 🎯 Funcionalidades da Página de Teste

A página `site-teste-simples.html` contém:

- Campo de **Usuário** (texto)
- Campo de **Senha** (password)
- Dropdown de **Perfil de Acesso** (Admin/Cliente/Convidado)
- Botão **Entrar**
- Mensagens de feedback (sucesso/erro)

**Regra de validação:** Login válido apenas com usuário `admin`, senha `123` e perfil selecionado.

## 📝 Observações

- O projeto utiliza caminhos absolutos locais para abertura da página HTML
- As screenshots são salvas automaticamente após cada teste
- O ChromeDriver é configurado automaticamente via WebDriverManager
