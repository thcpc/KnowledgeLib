# 作用及定义
Column 对象表示数据表的每个字段，都是用包含名称、数据类型和一些SQL结构与约束特征

列定义了数据表中的字段，它们通过我们对其关键词参数的设置来表达具体的含义。不同类型的主要参数不同。例如，字符串类型的基本参数是长度，而带小数的数值类型基本参数是精度和长度。其他类型大都没有基本参数。

有时你也会看到字符串类型没有设置长度。并非所有的数据库都支持这种特性，包括MySQL也不支持。

# 定义内部结构和约束的关键字参数
- primary_key 主键

```py
Column('user_id', Integer(), primary_key=True)
```

- nullable 非空

```py
Column('username', String(length=15), table=<users>, nullable=False),
```
- unique 唯一约束

```py
Column('username', String(length=15), table=<users>, unique=False),
```
- default 默认值
 - 可传递函数，每条记录生成的时候都会生成一个新的时间
```py
Column('username', String(length=15), table=<users>, default=datetime.now),
```
	
   - 可传递具体值，表生成的时间，以后每条记录就是固定值
```py
Column('username', String(length=15), table=<users>, default=datetime.now()),
```
	

  
  
