  
# ADD COLUMN
增加列
```sql
ALTER TABLE student ADD COLUMN `grade_id` INT(4);
```

# ADD CONSTRAINT
增加外键
```sql
ALTER TABLE student ADD CONSTRAINT GRADE_FK FOREIGN KEY(grade_id) REFERENCES grade(id);
```