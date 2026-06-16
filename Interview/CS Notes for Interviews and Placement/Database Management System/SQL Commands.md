# **Basic SQL Commands**

1. **SELECT**: Retrieve data from a database.

   ```sql
   SELECT column1, column2 FROM table_name;
   ```
2. **WHERE**: Filter records based on a condition.

   ```sql
   SELECT column1, column2 FROM table_name WHERE condition;
   ```
3. **AND/OR**: Combine multiple conditions.

   ```sql
   SELECT column1 FROM table_name WHERE condition1 AND condition2;
   SELECT column1 FROM table_name WHERE condition1 OR condition2;
   ```
4. **ORDER BY**: Sort the result set in ascending or descending order.

   ```sql
   SELECT column1, column2 FROM table_name ORDER BY column1 ASC;
   ```
5. **INSERT INTO**: Insert new data into a table.

   ```sql
   INSERT INTO table_name (column1, column2) VALUES (value1, value2);
   ```
6. **UPDATE**: Modify existing data in a table.

   ```sql
   UPDATE table_name SET column1 = value1 WHERE condition;
   ```
7. **DELETE**: Delete data from a table.

   ```sql
   DELETE FROM table_name WHERE condition;
   ```
8. **JOIN**: Combine rows from two or more tables based on a related column.

   - **INNER JOIN**: Returns records that have matching values in both tables.
     ```sql
     SELECT columns FROM table1 INNER JOIN table2 ON table1.column = table2.column;
     ```
   - **LEFT JOIN**: Returns all records from the left table, and the matched records from the right table.
     ```sql
     SELECT columns FROM table1 LEFT JOIN table2 ON table1.column = table2.column;
     ```
   - **RIGHT JOIN**: Returns all records from the right table, and the matched records from the left table.
     ```sql
     SELECT columns FROM table1 RIGHT JOIN table2 ON table1.column = table2.column;
     ```
   - **FULL JOIN**: Returns all records when there is a match in either left or right table.
     ```sql
     SELECT columns FROM table1 FULL JOIN table2 ON table1.column = table2.column;
     ```
9. **GROUP BY**: Group rows that have the same values in specified columns.

   ```sql
   SELECT COUNT(*), column1 FROM table_name GROUP BY column1;
   ```
10. **HAVING**: Filter records after grouping.

    ```sql
    SELECT COUNT(*), column1 FROM table_name GROUP BY column1 HAVING COUNT(*) > 1;
    ```
11. **DISTINCT**: Select distinct (unique) values.

    ```sql
    SELECT DISTINCT column1 FROM table_name;
    ```
12. **LIMIT**: Specify the number of records to return.

    ```sql
    SELECT column1 FROM table_name LIMIT 10;
    ```
13. **ALTER TABLE**: Modify an existing table structure.

    - Add a new column:
      ```sql
      ALTER TABLE table_name ADD column_name datatype;
      ```
    - Drop a column:
      ```sql
      ALTER TABLE table_name DROP COLUMN column_name;
      ```
    - Modify a column:
      ```sql
      ALTER TABLE table_name MODIFY column_name datatype;
      ```
14. **CREATE TABLE**: Create a new table in the database.

    ```sql
    CREATE TABLE table_name (
      column1 datatype,
      column2 datatype,
      ...
    );
    ```
15. **DROP TABLE**: Delete a table and all of its data.

    ```sql
    DROP TABLE table_name;
    ```
16. **TRUNCATE TABLE**: Delete all rows in a table without removing the table structure.

    ```sql
    TRUNCATE TABLE table_name;
    ```

### **Advanced SQL Commands**

1. **SUBQUERIES**: A query within another query.

   - **Single Row Subquery**:
     ```sql
     SELECT column1 FROM table_name WHERE column2 = (SELECT column2 FROM table_name2 WHERE condition);
     ```
   - **Multiple Row Subquery**:
     ```sql
     SELECT column1 FROM table_name WHERE column2 IN (SELECT column2 FROM table_name2 WHERE condition);
     ```
2. **INDEXES**: Improve the speed of data retrieval.

   - **Create Index**:
     ```sql
     CREATE INDEX index_name ON table_name (column1);
     ```
   - **Drop Index**:
     ```sql
     DROP INDEX index_name;
     ```
3. **VIEWS**: Create a virtual table based on the result set of a query.

   - **Create View**:
     ```sql
     CREATE VIEW view_name AS SELECT column1, column2 FROM table_name WHERE condition;
     ```
   - **Drop View**:
     ```sql
     DROP VIEW view_name;
     ```
4. **TRIGGERS**: Execute a block of SQL code in response to an event on a table.

   - **Create Trigger**:
     ```sql
     CREATE TRIGGER trigger_name
     BEFORE INSERT ON table_name
     FOR EACH ROW
     BEGIN
       -- SQL code
     END;
     ```
   - **Drop Trigger**:
     ```sql
     DROP TRIGGER trigger_name;
     ```
5. **TRANSACTIONS**: Ensure a sequence of SQL operations is executed as a single unit.

   - **Begin Transaction**:
     ```sql
     BEGIN TRANSACTION;
     ```
   - **Commit Transaction**:
     ```sql
     COMMIT;
     ```
   - **Rollback Transaction**:
     ```sql
     ROLLBACK;
     ```
6. **UNION**: Combine the result set of two or more SELECT statements.

   ```sql
   SELECT column1 FROM table_name1
   UNION
   SELECT column1 FROM table_name2;
   ```
7. **CASE**: Add conditional logic to queries.

   ```sql
   SELECT column1,
   CASE
     WHEN condition1 THEN result1
     WHEN condition2 THEN result2
     ELSE result3
   END
   FROM table_name;
   ```
8. **EXISTS**: Check if a subquery returns any results.

   ```sql
   SELECT column1 FROM table_name WHERE EXISTS (SELECT 1 FROM table_name2 WHERE condition);
   ```
9. **WITH**: Define a temporary result set that can be used within a SELECT, INSERT, UPDATE, or DELETE statement.

   ```sql
   WITH temp_table AS (
     SELECT column1, column2 FROM table_name WHERE condition
   )
   SELECT * FROM temp_table;
   ```
10. **PARTITION BY**: Divide the result set into partitions and perform an aggregate function on each partition.

    ```sql
    SELECT column1, COUNT(*) OVER (PARTITION BY column1) FROM table_name;
    ```

These commands cover a wide range of SQL functionality, from basic data retrieval and modification to advanced query techniques and database management. Each command can be customized to fit specific use cases, depending on the complexity and requirements of the database operations you need to perform.
