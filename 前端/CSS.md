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

# background
## [background-attachment](https://www.w3schools.com/cssref/pr_background-attachment.asp)

Sets whether a background image is fixed or scrolls with the rest of the page

## [background-clip](https://www.w3schools.com/cssref/css3_pr_background-clip.asp)

Specifies the painting area of the background

## [background-color](https://www.w3schools.com/cssref/pr_background-color.asp)

Sets the background color of an element

## [background-image](https://www.w3schools.com/cssref/pr_background-image.asp)

Sets the background image for an element

## [background-origin](https://www.w3schools.com/cssref/css3_pr_background-origin.asp)

Specifies where the background image(s) is/are positioned

## [background-position](https://www.w3schools.com/cssref/pr_background-position.asp)

Sets the starting position of a background image

## [background-repeat](https://www.w3schools.com/cssref/pr_background-repeat.asp)

Sets how a background image will be repeated

## [background-size](https://www.w3schools.com/cssref/css3_pr_background-size.asp)

Specifies the size of the background image(s)
1. 把图片完全覆盖，即使图片会失真
```css
body{
	backgroud-image: url("1.jpg");
	backgroud-size: cover
}
```
2. 把图片尽量保持不失真的情况下，覆盖背景层
 ```css
body{
	backgroud-image: url("1.jpg");
	backgroud-size: contain
}
```
## Gradinets
渐变色
```css
body{
	background: linear-gradient(to bottom, rgb(200,105,30),rgb(200,105,31,0.4))
}
```

# Units
绝对单位
 - px
 - pt
 - pc
 - cm
 - mm
 相对单位
 - em
 - vw
 - %
# FlexBox
针对容器的控制
```css
.container{
	dispaly: flex; # 表明该容器使用FlexBox布局
	flex-direction: colum; # 控制容器中元素的排列方式，colum是垂直排列， row 是横向排列
	flex-wrap: wrap; # 控制如果屏幕满了后是否换行，wrap 换行，nowrap不换行
    justify-content: center; # 控制元素水平的位置，center 居中，flex-end 居后 ，flex-start 居前，space-between 元素间等分间隔, space-around 前，后，元素间等分间隔
	align-items:center; # 控制元素垂直方向的位置 center 居中, flex-end 底部, flex-start 顶格, baseline 如果元素高度不一致的，按高度剧中对齐
	
}
```
针对组件的控制

```css
.container-item{
	order: 1; # 调整顺序
    flex-grow:2; # 当拉伸屏幕时，假如其余组件为1，则在拉伸程度时，该组件是其余组件的2倍
	flex-shrink:2; # 当屏幕压缩时，假如其余组件为1，则在压缩程度，该组件是其余组件的2倍
	flex-basis: 100px; # 定义组件基准长度

	flex: 1 2 100px; # flex-grow flex-shrink flex-basis 的简写形式
	align-self: center # 内容同align只是这个控制单个元素align控制容器中所有的
}
```
