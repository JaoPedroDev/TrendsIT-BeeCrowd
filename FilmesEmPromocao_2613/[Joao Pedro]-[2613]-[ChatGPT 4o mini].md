# Seleção entre tabelas SQL

#### You:
PostgreSQL select from two tables

#### ChatGPT:
No PostgreSQL, para selecionar dados de duas tabelas, você pode usar **JOINs** ou **subqueries**, dependendo do que deseja fazer. Aqui estão algumas abordagens comuns:

### 🔹 1. **INNER JOIN (Relacionando tabelas)**

Se as duas tabelas possuem uma relação (por exemplo, `id` de uma tabela sendo chave estrangeira na outra), você pode usar `INNER JOIN`:

```sql
SELECT a.id, a.nome, b.descricao
FROM tabela_a a
INNER JOIN tabela_b b ON a.id = b.tabela_a_id;
```

➡️ Isso retorna apenas os registros que têm correspondência em ambas as tabelas.

---

### 🔹 2. **LEFT JOIN (Pegando todos da primeira tabela)**

Se quiser todos os registros da `tabela_a`, mesmo que não tenham correspondência na `tabela_b`, use `LEFT JOIN`:

```sql
SELECT a.id, a.nome, b.descricao
FROM tabela_a a
LEFT JOIN tabela_b b ON a.id = b.tabela_a_id;
```

➡️ Se não houver correspondência em `tabela_b`, os valores dela aparecerão como `NULL`.

---

### 🔹 3. **RIGHT JOIN (Pegando todos da segunda tabela)**

Caso precise de todos os registros da `tabela_b`, mesmo que não tenham correspondência em `tabela_a`, use `RIGHT JOIN`:

```sql
SELECT a.id, a.nome, b.descricao
FROM tabela_a a
RIGHT JOIN tabela_b b ON a.id = b.tabela_a_id;
```

---

### 🔹 4. **FULL JOIN (Pegando todos os registros de ambas)**

Se quiser todos os registros de ambas as tabelas, independentemente de haver correspondência, use `FULL JOIN`:

```sql
SELECT a.id, a.nome, b.descricao
FROM tabela_a a
FULL JOIN tabela_b b ON a.id = b.tabela_a_id;
```

---

### 🔹 5. **UNION (Juntando resultados sem relação)**

Se as tabelas não têm relação mas possuem colunas compatíveis, você pode usar `UNION`:

```sql
SELECT nome FROM tabela_a
UNION
SELECT descricao FROM tabela_b;
```

➡️ `UNION` remove duplicatas; se quiser manter, use `UNION ALL`.

---

Qual dessas opções você precisa?
