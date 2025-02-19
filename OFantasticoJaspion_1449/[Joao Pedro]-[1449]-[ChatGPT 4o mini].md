# Diferença entre Map e HashMap

#### You:
Java, diference between:
HashMap<String, String> dicionario = new HashMap<>();
Map<String, String> dicionario = new HashMap<>();

#### ChatGPT:
The difference between `HashMap<String, String> dicionario = new HashMap<>();` and `Map<String, String> dicionario = new HashMap<>();` lies in **polymorphism and type declaration**:

### 1. **Declaration Type:**

- `HashMap<String, String> dicionario = new HashMap<>();`
  - This is a concrete type declaration. You are explicitly declaring the variable as a `HashMap`, which is a specific implementation of the `Map` interface.
- `Map<String, String> dicionario = new HashMap<>();`
  - This uses the interface `Map` as the type for the variable. It can hold any `Map` implementation (e.g., `HashMap`, `TreeMap`, `LinkedHashMap`, etc.).

### 2. **Flexibility:**

- Using `Map` as the type (`Map<String, String>`) allows for **greater flexibility**. You can easily change the implementation later without modifying your code logic. For example, you can switch to a `TreeMap`:
  ```java
  Map<String, String> dicionario = new TreeMap<>();
  ```

- Using `HashMap` directly (`HashMap<String, String>`) ties the code specifically to the `HashMap` implementation, making it less flexible for future changes.

### 3. **Polymorphism:**

- Declaring the variable as `Map` allows you to take full advantage of **polymorphism**. You can write code that is more generic and works with any `Map` implementation without worrying about the underlying structure.

### Conclusion:

- **Use `Map` as the type** when you want flexibility and polymorphism.
- **Use `HashMap` as the type** when you are sure that you need to use a `HashMap` specifically and are not planning to change the implementation.
