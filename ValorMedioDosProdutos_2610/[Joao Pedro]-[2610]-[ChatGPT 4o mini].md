# SQL SUM Function

#### You:
PostgreSQL, average values of column

#### ChatGPT:
To get the **average value** of a column in PostgreSQL, you can use the `AVG()` function. Here's the basic syntax:

```sql
SELECT AVG(column_name) FROM table_name;
```

### Example:

Suppose you have a table called `sales` with the following data:

| id | product | price |
| -- | ------- | ----- |
| 1  | A       | 10.0  |
| 2  | B       | 15.0  |
| 3  | C       | 20.0  |
| 4  | D       | 25.0  |

To get the average price, you would run:

```sql
SELECT AVG(price) FROM sales;
```

### Output:

```
17.5
```

### Additional Use Cases:

- **Grouping by a category** (e.g., average price per product type):
  ```sql
  SELECT product, AVG(price) 
  FROM sales 
  GROUP BY product;
  ```

- **Rounding the result**:
  ```sql
  SELECT ROUND(AVG(price), 2) FROM sales;
  ```

- **Filtering results** (e.g., only products above 10):
  ```sql
  SELECT AVG(price) FROM sales WHERE price > 10;
  ```

Precisa de algo mais específico?
