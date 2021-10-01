# 元数据
元数据 用于把数据库结构集成在一起方便SQLAlchemy快速对接。可以把元数据看成是一种表目录，再加一些引擎和链接的信息。这些信息可以通过MetaData.tables 查看。

- 读 线程安全
- 写 非线程安全

创建元数据
```py
from sqlalchemy import MetaData
metadata = MetaData()
```