SELECT e.id, e.name, e.department
FROM employees e
LEFT JOIN assignments a
    ON e.id = a.employee_id
WHERE a.project_id IS NULL;