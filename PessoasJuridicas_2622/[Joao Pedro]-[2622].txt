SELECT c.name
FROM customers c
JOIN legal_person lp
ON c.id = lp.id_customers;
