# Operações com Strings Java

#### You:
Java f String

#### ChatGPT:
A `String` em Java é uma classe imutável que representa uma sequência de caracteres. Vamos explorar como ela funciona e como é usada:

---

## Criação de Strings

Há duas maneiras principais de criar Strings em Java:

1. **Usando aspas duplas**:
   ```java
   String nome = "João";
   ```

2. **Usando o construtor da classe `String`**:
   ```java
   String nome = new String("João");
   ```

---

## Principais Métodos e Operações com Strings

### 1. **Concatenação**

Você pode concatenar Strings com o operador `+` ou o método `concat()`:

```java
String nome = "João";
String sobrenome = "Cruz";
String completo = nome + " " + sobrenome; // Usando operador +
System.out.println(completo); // João Cruz
```

### 2. **Comparação**

- **`equals()`**: Compara o conteúdo de duas Strings.
- **`equalsIgnoreCase()`**: Ignora maiúsculas e minúsculas.

```java
String a = "Manga";
String b = "manga";

System.out.println(a.equals(b)); // false
System.out.println(a.equalsIgnoreCase(b)); // true
```
