SELECT
    UPPER(SUBSTRING_INDEX(name, ' ', -1)) || ', ' || 
        CONCAT(SUBSTRING_INDEX(name, ' ', 1)) AS formatted_name,
    LOWER(CONCAT(
        SUBSTRING_INDEX(name, ' ', 1), '.', 
        SUBSTRING_INDEX(name, ' ', -1), '@company.com'
    )) AS email,
    CONCAT(
        UPPER(SUBSTRING(name, 1, 1)),
        UPPER(SUBSTRING(SUBSTRING_INDEX(name, ' ', -1), 1, 1))
    ) AS initials
FROM employees;
