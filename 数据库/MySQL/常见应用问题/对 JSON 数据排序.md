# 描述
Mysql 中 是无法通过 order by filed 对 json字段直接排序，需通过order by [[CAST]] 取出josn字段排序按

```sql
-- local为json字段 {"name": {"en_US": "QQQ"}, "comment": {"en_US": "QQQ"}}
order by cast(JSON_EXTRACT(locale,'$.name.en_US') as char )
```