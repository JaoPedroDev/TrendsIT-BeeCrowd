# Money Representation in Java

#### You:
Java, what type to use to represent money? Float, Double?

#### ChatGPT:
In Java, **`float`** and **`double`** should **not** be used to represent money due to floating-point precision errors. Instead, the best options are:

### ✅ **Recommended Approaches**:

1. **`BigDecimal` (Best for Accuracy)**
   - Best choice when precision is critical (e.g., financial apps).
   - Avoids rounding issues.
   - Supports arbitrary-precision arithmetic.
   - Example:
     ```java
     import java.math.BigDecimal;

     public class MoneyExample {
         public static void main(String[] args) {
             BigDecimal price = new BigDecimal("19.99");
             BigDecimal quantity = new BigDecimal("2");
             BigDecimal total = price.multiply(quantity);
             
             System.out.println("Total: " + total); // 39.98
         }
     }
     ```
   - Use `BigDecimal(String)` instead of `new BigDecimal(double)`, as `double` can introduce precision errors.

2. **`long` (Best for Performance)**
   - Used to store money in **cents** (or smallest unit).
   - Example:
     ```java
     public class MoneyExample {
         public static void main(String[] args) {
             long priceInCents = 1999;  // $19.99
             long quantity = 2;
             long totalInCents = priceInCents * quantity;
             
             System.out.println("Total in cents: " + totalInCents); // 3998
         }
     }
     ```
   - Convert to decimal format when displaying (`totalInCents / 100.0`).

### ❌ **Avoid Using `float` or `double`**:

- Due to precision errors, they can lead to rounding mistakes.
- Example of precision issue:
  ```java
  public class PrecisionIssue {
      public static void main(String[] args) {
          double total = 0.1 + 0.2;
          System.out.println(total); // Outputs 0.30000000000000004
      }
  }
  ```

**TL;DR:**

- Use `BigDecimal` for high accuracy.
- Use `long` (cents-based) for performance and simpler calculations.
- Never use `float` or `double` for money.


#### You:
String to long

#### ChatGPT:
To convert a `String` to a `long` in Java, use `Long.parseLong()` or `Long.valueOf()`.

### ✅ **Using `Long.parseLong()` (Recommended)**

```java
public class StringToLongExample {
    public static void main(String[] args) {
        String numberStr = "123456";
        long number = Long.parseLong(numberStr);
        
        System.out.println(number); // 123456
    }
}
```

- Throws `NumberFormatException` if the string is not a valid number.

### ✅ **Using `Long.valueOf()`**

```java
public class StringToLongExample {
    public static void main(String[] args) {
        String numberStr = "123456";
        long number = Long.valueOf(numberStr); // Returns Long object, auto-unboxed to `long`
        
        System.out.println(number); // 123456
    }
}
```

- Returns a `Long` object but is usually auto-unboxed to `long`.

### ✅ **Handling Invalid Input with Try-Catch**

```java
public class SafeStringToLong {
    public static void main(String[] args) {
        String numberStr = "123abc"; // Invalid number
        
        try {
            long number = Long.parseLong(numberStr);
            System.out.println("Converted: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + numberStr);
        }
    }
}
```

**📌 TL;DR:**

- Use `Long.parseLong(str)` for primitive `long`.
- Use `Long.valueOf(str)` if you need a `Long` object.
- Always handle potential exceptions (`NumberFormatException`).


#### You:
HashMap String long

#### ChatGPT:
### **Using `HashMap<String, Long>` in Java**

A `HashMap<String, Long>` stores key-value pairs where:

- The **key** is a `String`
- The **value** is a `Long` (can be auto-unboxed to `long`)

---

### ✅ **Basic Example**

```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Long> map = new HashMap<>();

        // Adding values
        map.put("Alice", 1000L);
        map.put("Bob", 2500L);
        map.put("Charlie", 1500L);

        // Retrieving values
        System.out.println("Alice's balance: " + map.get("Alice")); // 1000

        // Checking if a key exists
        if (map.containsKey("Bob")) {
            System.out.println("Bob's balance: " + map.get("Bob"));
        }

        // Iterating over the map
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
```

---

### ✅ **Handling Default Values**

If a key does not exist, `map.get()` returns `null`. To avoid `NullPointerException`, use:

```java
long balance = map.getOrDefault("Daniel", 0L);
System.out.println("Daniel's balance: " + balance);
```

---

### ✅ **Updating Values**

```java
map.put("Alice", map.get("Alice") + 500L); // Increase Alice's balance by 500
```

Or using `computeIfPresent`:

```java
map.computeIfPresent("Alice", (key, val) -> val + 500L);
```

---

### ✅ **Removing an Entry**

```java
map.remove("Charlie");
```

---

### ✅ **Checking If a Value Exists**

```java
if (map.containsValue(2500L)) {
    System.out.println("Someone has 2500L in their account.");
}
```

---

### **📌 TL;DR**

- Use `put(key, value)` to add/update.
- Use `get(key)` to retrieve (returns `null` if key not found).
- Use `getOrDefault(key, defaultValue)` to avoid `null`.
- Use `computeIfPresent()` for modifying values safely.
- Use `containsKey()` / `containsValue()` for existence checks.
- Use `remove(key)` to delete an entry.


#### You:
Print Long as $ xx.xx

#### ChatGPT:
To print a `Long` as **money format (`$ xx.xx`)**, you should convert it to a decimal format. Typically, a `long` stores values in **cents** (e.g., `1999` represents `$19.99`).

---

### ✅ **Using `DecimalFormat` (Recommended)**

```java
import java.text.DecimalFormat;

public class MoneyFormatter {
    public static void main(String[] args) {
        long amountInCents = 1999; // $19.99

        DecimalFormat df = new DecimalFormat("$#.00");
        String formattedAmount = df.format(amountInCents / 100.0);

        System.out.println(formattedAmount); // $19.99
    }
}
```

- **Divides by `100.0`** to get dollars.
- **Formats with two decimal places** (`#.00` ensures `.xx` even if it's `.00`).

---

### ✅ **Using `String.format()`**

```java
public class MoneyFormatter {
    public static void main(String[] args) {
        long amountInCents = 1999;

        String formattedAmount = String.format("$%.2f", amountInCents / 100.0);
        System.out.println(formattedAmount); // $19.99
    }
}
```

- `%.2f` ensures **two decimal places**.
- Converts `long` to `double` before formatting.

---

### ✅ **Using `NumberFormat` for Locale-Specific Formatting**

```java
import java.text.NumberFormat;
import java.util.Locale;

public class MoneyFormatter {
    public static void main(String[] args) {
        long amountInCents = 1999;

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedAmount = currencyFormatter.format(amountInCents / 100.0);

        System.out.println(formattedAmount); // $19.99
    }
}
```

- **Handles currency symbols** automatically (`$`, `€`, `£`).
- Supports **different locales** (e.g., `Locale.UK`, `Locale.FRANCE`).

---

### **📌 TL;DR**

| Method                                        | Output   | Best For                |
| --------------------------------------------- | -------- | ----------------------- |
| `DecimalFormat("$#.00")`                      | `$19.99` | Simple formatting       |
| `String.format("$%.2f")`                      | `$19.99` | Quick inline formatting |
| `NumberFormat.getCurrencyInstance(Locale.US)` | `$19.99` | Locale-aware currency   |

For a **simple `$ xx.xx` format**, use **`DecimalFormat`** or **`String.format()`**. For international formatting, use **`NumberFormat`**. 🚀
