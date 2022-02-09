# Selector
##  usually selecor
### 1.类型
|类型| 符号 | 例子 |
|-- | -- | -- |
| item | p | ```p {color: red }``` |
| id | # | ```#idName { color: red}``` |
| class |. | ```.className {color: red}``` |
| inline | 在html文件中使用style关键字  | ```<p style="color: red">...</p>```  |

### 2.优先级
Inline > id > class > item

## Pseudoselector
### 1.类型

|类型| 表达式 | 例子 | 含义 |
|-- | -- | -- |
| 选择子item | first-child | ```p {color: red }``` |
|  | last-child | ```p {color: red }``` |
|  | nth-child(n) | ```p {color: red }``` |
|  | only-child | ```p {color: red }``` |
| 选中 | hover | ```#idName { color: red}``` |
| 超连接 | link | ```.className {color: red}``` |
|  | visited  | ```<p style="color: red">...</p>```  |