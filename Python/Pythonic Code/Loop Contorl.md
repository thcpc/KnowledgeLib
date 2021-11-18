1. for, 在循环中查找，如果条件满足则跳出，如果没有查找的值则执行没有找到

```python
needle = 'd'
haystack = ['a','b','c']
# Bad Way
found = False
for letter in haystack:
	if needle == letter:
		print("FOund!")
		found = True
		break
if not found:
	print("Not Found")
# Good Way
for letter in haystack:
	if needle == letter:
		print("FOund!")
		break
else:
	print("Not Found")
```