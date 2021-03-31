INSERT INTO 表名(字段1，字段2，字段3) VALUES(值1,值2,值3)

1. 指定字段插入
```sql
INSERT INTO `grade`(`name`) VALUES('大四')
```

2. 默认插入
字段省略，但必须一一对应
```sql
INSERT INTO `grade` VALUES(1,'大四')
```

3. 插入多行
```sql
INSERT INTO `grade`(`name`) VALUES('大四'),('大一')
```