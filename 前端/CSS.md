# Selector

##  [Simple selector](https://www.w3schools.com/css/css_selectors.asp)
### 1.类型
|类型| 符号 | 例子 |
|-- | -- | -- |
| item | p | ```p {color: red }``` |
| id | # | ```#idName { color: red}``` |
| class |. | ```.className {color: red}``` |
| inline | 在html文件中使用style关键字  | ```<p style="color: red">...</p>```  |

### 2.优先级
Inline > id > class > item

## Pseudoselector([class](https://www.w3schools.com/css/css_pseudo_classes.asp),[element](https://www.w3schools.com/css/css_pseudo_elements.asp))
### 1.类型

<table >
	<tr>
			<th>类型</th><th>表达式</th><th>例子</th><th>操作对象</th><th>含义</th>
	</tr>
	<tr>
			<td rowspan="4">选择子项</td><td>first-child</td><td td rowspan="3"><ul><li>a</li><li>b</li><li>b</li></ul></td><td>li:frist-child{ color: red}</td><td>选择a</td>
	</tr>
	<tr>
			<td>last-child</td><td>li:last-child{ color: red}</td><td>选择c</td>
	</tr>
	<tr>
			<td>nth-child</td><td>li:nth-child(2){ color: red}</td><td>选择b</td>
	</tr>
	<tr>
			<td>only-child</td><td><ul><li>a</li></td><td>li:only-child{ color: red}</td><td>当ul只有一个li的时候才会生效</td>
	</tr>
	<tr>
			<td>选中</td><td>honver</td><td><p>text</p></td><td>p:hover{ color: red}</td><td>当鼠标放在text时，颜色变红</td>
	</tr>
	<tr>
			<td rowspan="2">超链接</td><td>link</td><td rowspan="2"><a href=".....">这是超链接</a></td><td>a:link{ color: red}</td><td>该连接以红色显示</td>
	</tr>
	<tr>
			<td>visited</td><td>a:visited{ color: blue}</td><td>点击后显示成白色</td>
	</tr>
</table>

##  [combinators selector](https://www.w3schools.com/css/css_combinators.asp)

|表达式| 含义 |
| -- | -- |
|h2 +a {color:red}| h2 和 a 都显示红色 |
|textarea ~ button { color: purple} | 在相同的层级中紧接这textarea 的button显示紫色|
|ul > li { color: red}| ul 下直系 子 li 变为红色 |
|ul li { color: red}| ul 下 所有的 li变为红色 |

## [attribute selector](https://www.w3schools.com/css/css_attribute_selectors.asp)
| 符号|  表达式 |  含义  |
|  -- |  -- |  -- |
|=||
| &#8727= | | |
| ^= | | |
| ~= | | |
| &#124=| | |

## selector 之间可以组合使用
```css
ul[class="tt"] li {
	color: red;
}
```

