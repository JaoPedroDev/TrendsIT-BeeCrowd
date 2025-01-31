# Java ArrayDeque Exemplos

#### You:
Java ArrayDeque

#### ChatGPT:
`ArrayDeque` é uma classe da Java Collections Framework que implementa a interface `Deque` e fornece uma fila de deque (double-ended queue). Isso significa que você pode adicionar e remover elementos tanto no início quanto no final da fila de forma eficiente.

## 📌 Características principais do `ArrayDeque`:

- **Sem capacidade fixa**: Ele cresce conforme necessário.
- **Mais rápido que `Stack` e `LinkedList`**: Para operações de pilha (`push/pop`) e fila (`offer/poll`).
- **Não permite elementos `null`**.
- **Não é sincronizado**: Se precisar de sincronização, use `Collections.synchronizedDeque(new ArrayDeque<>())`.

---

## 📌 Principais Métodos:

### ✅ Adicionando elementos:

```java
ArrayDeque<Integer> deque = new ArrayDeque<>();
deque.add(10);        // Adiciona no final
deque.addFirst(5);    // Adiciona no início
deque.addLast(15);    // Adiciona no final (igual ao add)
deque.offer(20);      // Adiciona no final sem exceção
deque.offerFirst(2);  // Adiciona no início sem exceção
deque.offerLast(25);  // Adiciona no final sem exceção
```

### ✅ Removendo elementos:

```java
deque.remove();       // Remove do início (lança exceção se estiver vazio)
deque.removeFirst();  // Remove do início
deque.removeLast();   // Remove do final
deque.poll();         // Remove do início (retorna `null` se vazio)
deque.pollFirst();    // Remove do início (retorna `null` se vazio)
deque.pollLast();     // Remove do final (retorna `null` se vazio)
```

### ✅ Acessando elementos:

```java
System.out.println(deque.getFirst()); // Obtém o primeiro (exceção se vazio)
System.out.println(deque.getLast());  // Obtém o último (exceção se vazio)
System.out.println(deque.peek());     // Obtém o primeiro (null se vazio)
System.out.println(deque.peekFirst()); // Obtém o primeiro (null se vazio)
System.out.println(deque.peekLast());  // Obtém o último (null se vazio)
```

### ✅ Usando como **Pilha (Stack)**:

```java
ArrayDeque<Integer> stack = new ArrayDeque<>();
stack.push(1); // Adiciona no topo (equivalente a addFirst)
stack.push(2);
stack.push(3);
System.out.println(stack.pop()); // Remove do topo (equivalente a removeFirst)
```

### ✅ Iterando:

```java
for (Integer num : deque) {
    System.out.println(num);
}
```

---

## 📌 Exemplo Completo:

```java
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.add("A");
        deque.add("B");
        deque.add("C");
        deque.addFirst("X");
        deque.addLast("Z");

        System.out.println("Deque: " + deque);
        
        System.out.println("Primeiro elemento: " + deque.getFirst());
        System.out.println("Último elemento: " + deque.getLast());

        deque.removeFirst();
        deque.removeLast();

        System.out.println("Deque após remoções: " + deque);
    }
}
```

🔹 **Saída esperada:**

```
Deque: [X, A, B, C, Z]
Primeiro elemento: X
Último elemento: Z
Deque após remoções: [A, B, C]
```

---

## 📌 Quando usar `ArrayDeque`?

- Se precisar de uma **fila dupla** eficiente.
- Para substituir `Stack` ou `LinkedList` para operações de pilha/fila.
- Quando precisar de desempenho melhor que `LinkedList` para inserções e remoções.

Precisa de mais alguma coisa sobre `ArrayDeque`? 🚀


#### You:
Create ArrayDeque of 1 to N

#### ChatGPT:
You can create an `ArrayDeque` from `1` to `N` using a simple loop in Java. Aqui está um exemplo:

```java
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int N = scanner.nextInt();
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
            deque.add(i); // Add elements from 1 to N
        }

        System.out.println("ArrayDeque: " + deque);
        scanner.close();
    }
}
```

### 🔹 Exemplo de Entrada e Saída:

```
Enter value of N: 5
ArrayDeque: [1, 2, 3, 4, 5]
```

Se precisar de outra abordagem, como adicionar os números ao início em vez do final, basta substituir `deque.add(i);` por `deque.addFirst(i);`.

Precisa de mais alguma coisa? 🚀


#### You:
Can I use IntStream.range?

#### ChatGPT:
Yes! You can use `IntStream.rangeClosed(1, N)` to create an `ArrayDeque` in a more concise way. Here’s how:

```java
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int N = 10; // Change this value as needed
        
        Deque<Integer> deque = new ArrayDeque<>();
        IntStream.rangeClosed(1, N).forEach(deque::add);
        
        System.out.println("ArrayDeque: " + deque);
    }
}
```

### 🔹 Explanation:

- `IntStream.rangeClosed(1, N)`: Generates numbers from `1` to `N` (inclusive).
- `.forEach(deque::add)`: Adds each number to the `ArrayDeque`.

### 🔹 Output (for `N = 10`):

```
ArrayDeque: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
```

This method is clean and functional! 🚀 Let me know if you need modifications.


#### You:
Iterate ArrayDeque While modyfing it


#### ChatGPT:
If you need to iterate over an `ArrayDeque` while modifying it, you have to be careful because modifying a collection while iterating over it using a standard `for-each` loop or an iterator can cause a **`ConcurrentModificationException`**.

---

## ✅ **Safe Ways to Modify an `ArrayDeque` While Iterating**

Here are a few approaches that work safely:

### 1️⃣ **Using `Iterator` with `remove()`**

You can use an **explicit `Iterator`** to safely remove elements during iteration.

```java
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);

        System.out.println("Before modification: " + deque);

        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num % 2 == 0) { // Remove even numbers
                iterator.remove();
            }
        }

        System.out.println("After modification: " + deque);
    }
}
```

🔹 **Output:**

```
Before modification: [1, 2, 3, 4, 5]
After modification: [1, 3, 5]
```

✅ **Why use `Iterator`?**

- The `remove()` method of `Iterator` ensures safe removal without exceptions.

---

### 2️⃣ **Using `while (!deque.isEmpty())`**

You can also modify the `ArrayDeque` while iterating by using a **`while` loop**:

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);

        System.out.println("Before modification: " + deque);

        while (!deque.isEmpty()) {
            int num = deque.poll(); // Removes elements one by one
            System.out.println("Processing: " + num);
        }

        System.out.println("After modification: " + deque);
    }
}
```

🔹 **Output:**

```
Before modification: [1, 2, 3, 4, 5]
Processing: 1
Processing: 2
Processing: 3
Processing: 4
Processing: 5
After modification: []
```

✅ **Why use `poll()`?**

- It safely removes elements **from the front** without throwing exceptions.

---

### 3️⃣ **Using `removeIf()` (Java 8+)**

If you just want to filter elements, you can use **`removeIf()`**, which is the cleanest method:

```java
deque.removeIf(num -> num % 2 == 0); // Removes even numbers
```

This is **efficient and safe** since it doesn’t use an explicit loop.

---

### 🚨 **What You Should NOT Do**

#### ❌ **Using a `for-each` Loop (`ConcurrentModificationException`)**

```java
for (Integer num : deque) {
    if (num % 2 == 0) {
        deque.remove(num); // ❌ This will throw an exception
    }
}
```

✅ **Fix:** Use an `Iterator` instead.

---

## 🏆 **Best Approach?**

- **Use `Iterator` if you want controlled removal while iterating.**
- **Use `while (!deque.isEmpty())` if processing elements one by one.**
- **Use `removeIf()` for simple filtering.**

Which method works best for your case? 🚀


#### You:
Why this code gives error:
        ArrayDeque<Integer> pilha = new ArrayDeque<>();
        IntStream.rangeClosed(1, num).forEach(pilha::add);

        StringBuilder saida = new StringBuilder();
        while (!pilha.isEmpty()) {
            saida.append(pilha.pop());
            pilha.pop();
        }

        System.out.println(saida);

#### ChatGPT:
Your code likely throws a **`NoSuchElementException`** at `pilha.pop();` inside the `while` loop. Here's why:

---

### 🔎 **Understanding the Issue**

1. You are **adding numbers from `1` to `num`** into the `ArrayDeque`:
   ```java
   IntStream.rangeClosed(1, num).forEach(pilha::add);
   ```

2. Inside the `while` loop:
   ```java
   while (!pilha.isEmpty()) {
       saida.append(pilha.pop()); // Removes and appends an element
       pilha.pop();               // ❌ Removes another element without storing it
   }
   ```
   - The first `pilha.pop()` removes and appends an element.
   - The second `pilha.pop()` removes another element **without checking if the deque is empty**.
   - If `pilha` has an odd number of elements, the **last `pop()` call will execute when the deque is already empty**, causing a `NoSuchElementException`.

---

### 🛠 **How to Fix It**

To prevent this, check if `pilha` is empty before calling `pop()` a second time:

#### ✅ **Solution 1: Check if Not Empty Before Second `pop()`**

```java
while (!pilha.isEmpty()) {
    saida.append(pilha.pop());
    if (!pilha.isEmpty()) { // Ensure there's another element before popping again
        pilha.pop();
    }
}
```

This ensures that `pilha.pop()` is never called on an empty deque.

---

#### ✅ **Solution 2: Use a `while` Loop That Removes Two Elements at a Time**

```java
while (pilha.size() > 1) { // Ensures at least two elements exist before removing
    saida.append(pilha.pop());
    pilha.pop();
}

// If there's one element left, append it
if (!pilha.isEmpty()) {
    saida.append(pilha.pop());
}
```

This ensures you only remove pairs and properly handle the last remaining element.

---

### 🏆 **Final Notes**

- **Error Cause:** Calling `pop()` on an empty `ArrayDeque` throws `NoSuchElementException`.
- **Fix:** Always check `isEmpty()` before calling `pop()` a second time in the loop.
- **Alternative:** Instead of calling `pop()` twice, you could modify the logic to store and process elements differently.

Would you like help modifying the logic further? 🚀
