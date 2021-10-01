DELETE FROM 表名 WHERE 条件

```sql
DELETE FROM `student` WHERE id = 1
```

TRUNCATE 清空一张表

```sql
truncate TABLE `student`
```

区别
- truncate 重新设置自增列，重新归0
- truncate 不会影响事务

Delete 删除问题，重启数据库
- InnoDB 自增列会重1开始
- MyISAM 继续从上一个自增量开始