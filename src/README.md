````md
# 💳 Sistema de Cartão de Crédito em Java

Aplicação **console em Java** para simulação de transações de cartão de crédito, focada no gerenciamento de limite e ordenação de extrato.

---

## 📌 Funcionalidades

- Definição de limite inicial  
- Registro de compras com validação de saldo  
- Armazenamento de histórico em lista dinâmica  
- Exibição de extrato ordenado por valor (crescente)  
- Demonstração de uso da interface `Comparable`  

---

## 🏗 Estrutura do Projeto

O sistema utiliza os seguintes componentes principais:

| Classe            | Responsabilidade |
|------------------|------------------|
| `Main`           | Gerencia o fluxo de entrada (`Scanner`) e interação com o usuário |
| `CartaoDeCredito`| Controla o limite, saldo disponível e a lista de objetos `Compra` |
| `Compra`         | Representa a entidade da transação (descrição e valor) |

---

## 🚀 Como Executar

### 1️⃣ Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

### 2️⃣ Compile o projeto

```bash
javac Main.java
```

### 3️⃣ Inicie a aplicação

```bash
java Main
```

---

## 💻 Implementação Técnica

### 🔹 Ordenação (Interface Comparable)

A classe `Compra` implementa `Comparable<Compra>` para permitir a ordenação nativa através do `Collections.sort()`.

```java
@Override
public int compareTo(Compra outraCompra) {
    return Double.valueOf(this.valor)
           .compareTo(Double.valueOf(outraCompra.valor));
}
```

---

### 🔹 Lógica de Transação

O método `lancaCompra` valida a viabilidade da operação antes de subtrair do saldo:

```java
public boolean lancaCompra(Compra compra) {
    if (this.saldo >= compra.getValor()) {
        this.saldo -= compra.getValor();
        this.compras.add(compra);
        return true;
    }
    return false;
}
```

---

## ▶️ Exemplo de Uso

### 📥 Entrada

```
Digite o limite do cartão: 1000
Digite a descrição da compra: Mouse
Digite o valor da compra: 150
```

### 📤 Saída (Extrato Ordenado)

```
***********************
COMPRAS REALIZADAS:

Mouse - 150.0
Notebook - 700.0

***********************
Saldo do cartão: 150.0
```

---

## 🧠 Conceitos Aplicados

- **POO**: Encapsulamento e Composição  
- **Collections Framework**: Uso de `ArrayList` e ordenação com `Collections.sort()`  
- **Interfaces**: Implementação de `Comparable`  

---

## 🛠 Melhorias Futuras

- [ ] Implementar parcelamento de compras  
- [ ] Adicionar opção de ordenação por descrição alfabética  
- [ ] Persistência de dados em arquivo `.txt` ou `.json`  
- [ ] Tratamento de exceções para entradas inválidas no terminal  
````
