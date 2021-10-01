4种数据类型

 - 通用数据类型(Generic)
 - SQL标准类型(SQL standard)
 - 数据库特有类型(Vendor Specific)
 - 用户自定义类型(User Defined)

# 通用数据类型(Generic)
| SQLAlchemy | Python | SQL |
| --- | --- | --- |
|BigInteger|int|BIGINT|
|Boolean|bool|BOOLEAN or SMALLINT|
|Date|datetime.date|Date (SQLite: String)|
|DateTime|datetime.datetime|DATETIME (SQLite: String)|
|Enum|str|ENUM or VARCHAR|
|Float|float or Decimal|FLOAT or REAL|
|Integer|int|Integer|
|Interval|datetime.timedelta|INTERVAL or DATE from epoch|
|LargeBinary|byte|BLOB or BYTEA|
|Numeric|decimal.Decimal|NUMERIC or DECIMAL|
|Unicode|unicode|UNICODE or VARCHAR|
|Text|str|CLOB or TEXT|
|Time|datetime.time|DATETIME|

# SQL 标准类型
如果通用类型无法满足，则会用到SQL标准类型
- CHAR
- NVARCHAR
模块路径 sqlalchemy.types, 为了和通用类型区分开，使用大写字母表示

# 数据库专有类型
只存在与特定的数据库，可通过
- SQLALchemy 网站
- 数据库方言 dialect查询
模块路径 sqlalchemy.dialects, 为了和通用类型区分开，使用大写字母表
例如 PostgreSQL中 from sqlalchemy.dialects.postgresql import JSON
