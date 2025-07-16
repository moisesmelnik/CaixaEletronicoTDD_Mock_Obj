# 💳 CaixaEletronicoTDD_Mock_Obj

Este projeto simula o comportamento de um **Caixa Eletrônico Bancário** utilizando os princípios do **TDD (Test-Driven Development)** e a prática de **Mock Objects** para isolar dependências externas, como hardware e serviços remotos.

---

## 🧪 Desenvolvimento Guiado por Testes (TDD)

O projeto foi implementado utilizando o ciclo **Red → Green → Refactor**, que caracteriza o processo de TDD:

1. **Red** – Escreve-se um teste que falha.
2. **Green** – Escreve-se o código mínimo para passar no teste.
3. **Refactor** – Refatora-se o código mantendo todos os testes verdes.

Todos os requisitos do sistema foram implementados primeiramente como testes automatizados com **JUnit**.

---

## 🧱 Estrutura do Projeto

```text
CaixaEletronicoTDD_Mock_Obj/
├── src/
│   └── br/com/banco/
│       ├── CaixaEletronico.java         # Classe principal com lógica do caixa
│       ├── ContaCorrente.java           # Modelagem da conta bancária
│       ├── Hardware.java                # Interface de hardware real
│       ├── ServicoRemoto.java           # Interface de serviço remoto real
│       ├── ProblemaNoHardware.java      # Exceção simulando falhas físicas
│
├── test/
│   └── br/com/banco/test/
│       ├── CaixaEletronicoTest.java     # Testes unitários com mocks
│       ├── MockHardware.java            # Mock do hardware (injeção)
│       ├── MockServicoRemoto.java       # Mock do serviço remoto
```

---

## 🧪 Testes e Mocks

Para garantir o isolamento das dependências físicas, os testes utilizam **mocks personalizados** ao invés de dependências reais:

- `MockHardware` simula o leitor de cartão.
- `MockServicoRemoto` simula um banco de dados remoto.

Exemplo de teste com uso de mock:
```java
@Before
public void setup() {
    mockHardware = new MockHardware();
    mockServicoRemoto = new MockServicoRemoto();
    caixa = new CaixaEletronico(mockHardware, mockServicoRemoto);
}
```

Isso permite testar **somente a lógica do sistema**, sem dependências externas.

---

## 🧠 Ciclos de Refatoração e Bad Smells

Durante o desenvolvimento foram identificados e corrigidos diversos **"bad smells"**, aplicando boas práticas de refatoração como:

- Extração de métodos;
- Encapsulamento de responsabilidades;
- Isolamento de dependências;
- Criação de interfaces para facilitar a inversão de controle (IoC).

---

## 💻 Tecnologias e Ferramentas

- Linguagem: **Java**
- IDE: **Eclipse**
- Testes: **JUnit 4**
- Paradigmas: **POO**, **TDD**
- Design: **Mock Objects**, **Inversão de Dependência**

---

## 👨‍🏫 Origem do Projeto

Este projeto foi desenvolvido como parte do curso:

> **"Desenvolvimento de Software Guiado por Testes (TDD)"**,  
> ministrado pelo **Instituto Tecnológico de Aeronáutica (ITA)**  
> através da plataforma de ensino online.

---

## 📁 Como Executar

1. Importe o projeto como Java Project no Eclipse.
2. Execute a classe `CaixaEletronicoTest.java` como JUnit Test.
3. Certifique-se de que todos os testes passem (`green bar`).

---

## 📄 Licença

Este projeto é de uso educacional.  
Sinta-se livre para estudar, modificar e reaproveitar conforme desejar.

---

Desenvolvido por **Moisés D’Anthony Melnik**  
Eng. da Computação · Eng. Elétrica · Matemático · Economista