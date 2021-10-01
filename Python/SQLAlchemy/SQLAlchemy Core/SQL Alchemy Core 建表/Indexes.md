索引

# 普通索引

![[SQLAlchemy Core 使用#网店的饼干库存表。]]
方式1. 直接在建表语句中指定

```py
Column('cookie_name', String(50), index=True),  
```

方式2. 建表语句后指定

```py
from sqlalchemy import Index
Index('ix_cookies_cookie_name', 'cookie_name')
```

# 复合索引

```py
Index('ix_test', mytable.c.cookie_sku, mytable.c.cookie_name)
```