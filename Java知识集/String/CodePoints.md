以前 String 使用两个字节来表示一个字符( char[] )。但是bai随着时代的发展，现在的 Unicode 已经有 17 个代码平面，每个平面有 65536 个字符，加起来就是 1114112 个字符，2个字节已经无法表示这么多字符了，所以 String 目前使用 char[] 存储 utf-16 编码，再将 utf-16 编码转成 Unicode。

utf-16 是基于 Unicode 的不定长度的字符编码(不定长度是指，有些字符使用 2 个字节表示，有些字符使用 4 个字节表示)。utf-16 的基本单位是 2 个字节，英文名叫 code unit，而真正能表示一个 Unicode 字符的数据(在 utf-16 中可能是 2 个字节也可能是 4 个字节)叫代码点，英文名叫 code point。

例如，

"𝕆"这个字符的 Unicode 码(或者叫代码点)是 U+1D546(超过了 65535)，转换成 utf-16 有两个代码单元，分别为 U+D835 和 U+DD46，而如果使用 s1.codePointCount(0, s1.length()); ，那么结果就为 1 。String s1 = "𝕆";

System.out.println(s1.length());

System.out.println(s1.codePointCount(0, s1.length()));

例如：

返回在字符串中找到的代码点的数目：String myStr = "Hello";

int result = myStr.codePointCount(0, 5);

System.out.println(result);

1、定义和用法

codePointCount()方法返回在字符串中找到的代码点的数量。

使用startIndex和endIndex参数指定在哪里开始和结束搜索。

第一个字符的索引为0，第二个字符的索引为1，依此类推。

2、调用语法public int codePointCount(int startIndex, int endIndex)

3、参数说明参数描述

startIndexint值，表示字符串中第一个字符的索引

endIndexint值，表示字符串中最后一个字符之后的索引

4、方法说明返回值:int值，表示在字符串中找到的代码点的数量

Throws:IndexOutOfBoundsException：如果startIndex为负，

或者endindex大于字符串的长度，

或者startIndex大于endIndex，则引发此异常
