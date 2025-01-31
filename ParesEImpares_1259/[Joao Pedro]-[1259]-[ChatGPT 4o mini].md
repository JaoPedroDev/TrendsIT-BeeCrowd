# Ordenando Array Inteiro

#### You:
java sorted Integer array

#### ChatGPT:
Se você quer trabalhar com um **array de inteiros ordenado** em Java, há algumas formas de fazer isso:

### 1. **Ordenando um array de inteiros usando `Arrays.sort()`**

O jeito mais simples de ordenar um array é usando o método `Arrays.sort()`:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6};
        
        Arrays.sort(numbers); // Ordena o array em ordem crescente
        
        System.out.println(Arrays.toString(numbers)); // Saída: [1, 2, 5, 5, 6, 9]
    }
}
```

### 2. **Ordenando em ordem decrescente**

Se quiser a ordem decrescente, use um `Integer[]` (em vez de `int[]`) e `Arrays.sort()` com um **comparador reverso**:

```java
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 5, 6};
        
        Arrays.sort(numbers, Collections.reverseOrder()); // Ordem decrescente
        
        System.out.println(Arrays.toString(numbers)); // Saída: [9, 6, 5, 5, 2, 1]
    }
}
```

> ⚠️ **Por que usar `Integer[]` e não `int[]`?**\
> O método `Collections.reverseOrder()` só funciona com `Integer[]`, pois `int` é um tipo primitivo e não pode ser usado com `Comparator`.

Se precisar de mais alguma coisa, me avisa! 🚀


#### You:
Java sort array while adding int to it

#### ChatGPT:
Se você deseja manter um array de inteiros **sempre ordenado enquanto adiciona elementos**, existem algumas abordagens em Java:

---

## 🔹 **1. Usar `TreeSet<Integer>` (Automático e Eficiente)**

A estrutura `TreeSet` mantém os elementos **sempre ordenados** automaticamente.

```java
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> sortedNumbers = new TreeSet<>();

        sortedNumbers.add(5);
        sortedNumbers.add(2);
        sortedNumbers.add(9);
        sortedNumbers.add(1);
        sortedNumbers.add(5); // Duplicatas são ignoradas no TreeSet

        System.out.println(sortedNumbers); // Saída: [1, 2, 5, 9]
    }
}
```

✅ **Vantagens:**

- Mantém os números ordenados automaticamente.
- Melhor eficiência: **O(log N)** para inserção.
- Não permite duplicatas.

❌ **Desvantagens:**

- Não aceita números repetidos.
- **Não é um array**, mas uma estrutura de árvore ordenada.

Se precisar de repetição de elementos, use **PriorityQueue** (abaixo).

---

## 🔹 **2. Usar `PriorityQueue<Integer>` (Fila de Prioridade)**

Se quiser permitir **valores duplicados** e manter a ordenação automática:

```java
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> sortedQueue = new PriorityQueue<>();

        sortedQueue.add(5);
        sortedQueue.add(2);
        sortedQueue.add(9);
        sortedQueue.add(1);
        sortedQueue.add(5); // Permite duplicatas

        System.out.println(sortedQueue); // A ordem da impressão pode não parecer ordenada
        while (!sortedQueue.isEmpty()) {
            System.out.print(sortedQueue.poll() + " "); // Remove e imprime ordenado
        }
        // Saída: 1 2 5 5 9
    }
}
```

✅ **Vantagens:**

- Mantém a ordem automaticamente.
- Permite números repetidos.

❌ **Desvantagens:**

- Não é um array tradicional.
- Precisa chamar `poll()` para acessar os elementos ordenados.

---

## 🔹 **3. Usar `ArrayList<Integer>` e Ordenar Sempre que Adicionar**

Se precisar de um **array dinâmico e ordenado**, pode usar `ArrayList<Integer>` e chamar `Collections.sort()` após cada inserção:

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> sortedList = new ArrayList<>();

        addSorted(sortedList, 5);
        addSorted(sortedList, 2);
        addSorted(sortedList, 9);
        addSorted(sortedList, 1);
        addSorted(sortedList, 5);

        System.out.println(sortedList); // Saída: [1, 2, 5, 5, 9]
    }

    public static void addSorted(ArrayList<Integer> list, int number) {
        list.add(number);
        Collections.sort(list); // Ordena após cada inserção
    }
}
```

✅ **Vantagens:**

- Permite duplicatas.
- Funciona como um array.

❌ **Desvantagens:**

- Ineficiente para grandes conjuntos (**O(N log N)** a cada adição).

---

## 🔹 **4. Usar `ArrayList` com Inserção Ordenada (Eficiente)**

Ao invés de ordenar sempre, podemos **inserir o número já na posição correta**, usando **busca binária** (`Collections.binarySearch()`). Isso melhora o desempenho para grandes conjuntos de dados:

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> sortedList = new ArrayList<>();

        addSorted(sortedList, 5);
        addSorted(sortedList, 2);
        addSorted(sortedList, 9);
        addSorted(sortedList, 1);
        addSorted(sortedList, 5);

        System.out.println(sortedList); // Saída: [1, 2, 5, 5, 9]
    }

    public static void addSorted(ArrayList<Integer> list, int number) {
        int index = Collections.binarySearch(list, number);
        if (index < 0) {
            index = -(index + 1); // Converte para a posição correta
        }
        list.add(index, number); // Insere diretamente no local correto
    }
}
```

✅ **Vantagens:**

- Mais eficiente que `Collections.sort()`.
- Mantém o array ordenado sem precisar ordenar tudo sempre.

❌ **Desvantagens:**

- **O(N)** no pior caso (por causa do `add(index, number)`).

---

## 🔥 **Qual Método Escolher?**

| Método                     | Aceita Duplicatas? | Sempre Ordenado? | Eficiência                                                |
| -------------------------- | ------------------ | ---------------- | --------------------------------------------------------- |
| `TreeSet<Integer>`         | ❌ Não              | ✅ Sim            | **O(log N)**                                              |
| `PriorityQueue<Integer>`   | ✅ Sim              | ✅ Sim            | **O(log N)** (mas precisa `poll()` para acessar ordenado) |
| `ArrayList + sort()`       | ✅ Sim              | ✅ Sim            | **O(N log N)** (ineficiente)                              |
| `ArrayList + binarySearch` | ✅ Sim              | ✅ Sim            | **O(N)** (mais eficiente)                                 |

Se precisar de **ordenação automática**, escolha **`TreeSet`** (sem duplicatas) ou **`PriorityQueue`** (com duplicatas).\
Se precisar de um **array ordenado dinamicamente**, use **`ArrayList` com `binarySearch`**.

Qualquer dúvida, só perguntar! 🚀


#### You:
TreeSet predefined size

#### ChatGPT:
O `TreeSet` em Java não tem um tamanho **pré-definido** porque ele é baseado em uma **árvore balanceada** (`TreeMap` internamente). Ele cresce dinamicamente conforme novos elementos são adicionados. No entanto, existem algumas estratégias para **limitar o tamanho máximo** do `TreeSet`. Aqui estão algumas abordagens:

---

## 🔹 **1. Usar `TreeSet` com Remoção Manual**

Se quiser um `TreeSet` com tamanho fixo, pode
