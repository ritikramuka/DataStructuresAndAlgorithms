# Write your MySQL query statement below
SELECT employee_id, salary * (employee_id % 2 != 0 AND name NOT LIKE "M%") AS bonus FROM Employees ORDER BY employee_id;