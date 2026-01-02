SELECT 
    e.name AS employee_name,
    m.name AS manager_name
FROM employees as e
LEFT JOIN employees as m
    ON e.manager_id = m.id;
