# MySql

## 1. 判断数是否为奇偶的时候，最快的方法是按位与

```sql
SELECT ID FROM Table WHERE id&1
```

因为奇数的二进制表示法的最低位是1，偶数的最低位是0。那么用这个数去和1按位与，如果是奇数，那么结果就是1；偶数结果则是0。

Leecode : 620,有趣的电影

## 2.什么时候用Union，什么时候用OR

当单列的时候时OR 和 Union差不多，但是多列条件的时候，建议用Union ,并且Union会去重，这个和索引有关

```sql
SELECT name,population,area WHERE area> 1 UNION SELECT name,population,area WHERE population > 2
```

 Leecode: 595, 大的国家

