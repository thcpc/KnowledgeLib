```sql
update mysql.user set authentication_string=password('123456') WHERE user = 'root' AND host = 'localhost'
```