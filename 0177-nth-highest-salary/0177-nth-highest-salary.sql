CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M int DEFAULT 0;
set M = N - 1;
  RETURN (
      # Write your MySQL query statement below.
        SELECT DISTINCT salary 
        FROM Employee
        ORDER BY salary DESC 
        LIMIT 1 OFFSET M
    );
END