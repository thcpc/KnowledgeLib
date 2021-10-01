# 用例表
##  网店的饼干库存表。

```py
from sqlalchemy import Table, Column, Integer, Numeric, String, ForeignKey

cookies = Table('cookies', metadata,  
Column('cookie_id', Integer(), primary_key=True),  
Column('cookie_name', String(50), index=True),  
Column('cookie_recipe_url', String(255)),  
Column('quantity', Integer()),  
Column('unit_cost', Numeric(12, 2))
)
```

## 用户表
```py
from datetime import datetime  
from sqlalchemy import DateTime

users = Table('users', metadata,  
Column('user_id', Integer(), primary_key=True),  
Column('username', String(15), nullable=False, unique=True),  
Column('email_address', String(255), nullable=False),  
Column('phone', String(20), nullable=False),  
Column('password', String(25), nullable=False),  
Column('created_on', DateTime(), default=datetime.now),  
Column('updated_on', DateTime(), default=datetime.now, onupdate=datetime.now)  )


```

##  orders
```py
from sqlalchemy import ForeignKey, Boolean  
orders = Table('orders', metadata,  
Column('order_id', Integer(), primary_key=True),  
Column('user_id', ForeignKey('users.user_id')),  
Column('shipped', Boolean(), default=False)  
)
```


## line_items
```py
line_items = Table('line_items', metadata,  
Column('line_items\_id', Integer(), primary_key=True),  
Column('order_id', ForeignKey('orders.order_id')),  
Column('cookie_id', ForeignKey('cookies.cookie_id')),  
Column('quantity', Integer()),  
Column('extended_cost', Numeric(12, 2))  
)

```

数据表对象初始化过程是通过构建 [[Table]] 和 [[Column]] 对象完成