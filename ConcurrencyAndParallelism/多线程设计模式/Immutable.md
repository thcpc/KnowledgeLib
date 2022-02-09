# 定义
如果存在状态绝不会改变的类(Immutable 的类)，无论多少个线程访问该实例，都不需要考虑互斥，可提升效率。
## Immutable的理解
实际上是指线程对某个对象只读，不写。

## Java 标准库中的Immutable类
| 基本类型| 包装类|
| -- | -- |
|   | java.lang.String |
| boolean | java.lang.Boolean |
|byte | java.lang.Byte |
|char | java.lang.Character |
|double | java.lang.Double |
| float | java.lang.Float |
| int | java.lang.Integer |
|long | java.lang.Long|
| short | java.lang.Short |
|void | java.lang.Void |


# 参与者
一个Immutable 对象，它是一个字段值无法更改的类，也没有任何用来更改字段值的方法。

# 适用场景
- 1. 实例产生后，状态不再发生变化。
- 2. 实例需要共享，而且访问很频繁。

# 相关的模式
[[Signle Threaded Execution]]
Read-Write Lock Pattern
Flyweight Pattern

# 实现
实现一个Immutable 的类，主要是线程不能改变对象的状态或值
Person类的属性都为final, 且无Set方法
```java
public class Person {  
    private final String name;  
 	private final String address;  
  
 	public Person(String name, String address) {  
        this.name = name;  
 		this.address = address;  
 	}  
  
    public String getName() {  
        return name;  
 	}  
  
    public String getAddress() {  
        return address;  
 	}  
  
    @Override  
 	public String toString() {  
        return "Person{" +  
                "name='" + name + '\'' +  
                ", address='" + address + '\'' +  
                '}';  
 	}  
}
```
PrintPersonThread
```java
public class PrintPersonThread extends Thread {  
    private Person person;  
  
 	public PrintPersonThread(Person person) {  
        this.person = person;  
 	}  
  
    @Override  
 	public void run() {  
        while (true){  
            System.out.println(Thread.currentThread().getName() + "prints" + person );  
 	}  
   }  
}
```
Main
```java
public class Main {  
    public static void main(String[] args) {  
        Person alice = new Person("Alice", "Alaska");  
 		new PrintPersonThread(alice).start();  
 		new PrintPersonThread(alice).start();  
 		new PrintPersonThread(alice).start();  
 	}  
}
```

# 一个破坏 Immutable 的案例