键和约束是用来保证数据在存到数据库之前能够满足一些约束条件的方法。表示键和约束的对象在SQLAlchemy模块里面都有,常用的如下
- PrimaryKeyConstraint
- UniqueConstraint
- CheckConstraint

```py
from sqlalchemy import PrimaryKeyConstraint, UniqueConstraint, CheckConstraint
```

# PrimaryKeyConstraint
主键约束
![[SQLAlchemy Core 使用#用户表]]
## 方式1. 建表时指定
[[定义内部结构和约束的关键字参数| 使用内部参数]]
## 方式2. 建表后指定
```py
PrimaryKeyConstraint('user_id', name='user_pk')
```
# UniqueConstraint
![[SQLAlchemy Core 使用#用户表]]
## 方式1. 建表时指定
[[定义内部结构和约束的关键字参数| 使用内部参数]]
## 方式2. 建表后指定
唯一性约束
```py
UniqueConstraint('username', name='uix_username')
```
# CheckConstraint
检查约束类型
![[SQLAlchemy Core 使用#用户表]]

```py
CheckConstraint('unit_coust >= 0.00', name='unit_coust_positive')
```