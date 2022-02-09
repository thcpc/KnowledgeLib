# 定义
以一个线程运行，限制同时只让一个线程运行， 别称"Crtical Section"(临界区)

# 参与者
在该模式中，有 SharedResource(共享资源)角色的类存在，范例中 Gate

# 适用场景
- 1. SharedResource 被多个线程访问的时候
- 2. SharedResource 状态可能变化的时候
- 3. 数据安全性比运行速度更重要的时候 

# 相关的模式
Guarded Suspension Pattern
Read-Write Lock Pattern
[[Immutable | Immutable Pattern]]
Thread-Specific Storage Pattern

# 实现
===关键在与确认被保护的对象，在该范例中，因为check是不会被其它对象调用到的，所以不用加锁,但是pass或toString 会被其它调用，所以需要加锁===
## Java
###  使用synchronized 关键字
Gate 实现
```java
public class Gate {  
 private int counter = 0;  
 private String name = "Nobody";  
 private String address = "NoWhere";  
  
 public synchronized void pass(String name,String address){  
    this.counter ++;  
 	this.name = name;  
 	this.address = address;  
 	check();  
 }  
  
 @Override  
 public synchronized String toString() {  
    return "NO{" +  
                "counter=" + counter +  
                ", name='" + name + '\'' +  
                ", address='" + address + '\'' +  
                '}';  
 }  
  
 private void check(){  
    if(name.charAt(0)!=address.charAt(0)){  
            System.out.println("***BROKEN****" + toString());  
 	}  
}
}
```
UserThread 实现
```java
public class UserThread extends Thread {  
 private final Gate gate;  
 private final String myName;  
 private final String myAddress;  
  
 public UserThread(Gate gate, String myName, String myAddress) {  
    this.gate = gate;  
 	this.myName = myName;  
 	this.myAddress = myAddress;  
 }  
  
    public void run(){  
        System.out.println(myName + " BEGIN");  
 		while (true){  
            gate.pass(myName,myAddress);  
 		}  
    }  
}
```
Main实现
```java
public class Main {  
    public static void main(String[] args) {  
        System.out.println("Testing Gate");  
 		Gate gate = new Gate();  
  
 		new UserThread(gate,"Alice","Alaska").start(); 
 		new UserThread(gate,"Bobby","Brazil").start(); 
 		new UserThread(gate,"Chris","Canada").start(); 
 }  
}
```

2. 实现Mutex类
Mutex
```java
public class Mutex {  
    private long count;  
 	private Thread owner;  
  
 	public void lock() {  
        synchronized (this){  
            while ( count>0 && owner != 		Thread.currentThread() ){  
                try {  
                    this.wait();  
 				}catch (InterruptedException e){}  
  
            }  
            owner = Thread.currentThread();  
 			count ++;  
 			}  
    }  
  
    public void unLock(){  
        synchronized (this){  
            if(count>0 && owner == 	Thread.currentThread()){  
                count -=1;  
 				if(count == 0){  
              		owner = null;  
 			  		this.notifyAll();  
 				}  
            }  
        }  
    }  
}
```
Gate
```java
public class Gate {  
    private int counter = 0;  
 	private String name = "Nobody";  
 	private String address = "NoWhere";  
 	private final Mutex mutex = new Mutex();  
  
 	public void pass(String name,String address){  
        try {  
            mutex.lock();  
 			this.counter ++;  
 			this.name = name;  
 			this.address = address;  
 			check();  
 		} finally {  
            mutex.unLock();  
 		}  
    }  
  
    @Override  
 	public String toString() {  
        return "NO{" +  
                "counter=" + counter +  
                ", name='" + name + '\'' +  
                ", address='" + address + '\'' +  
                '}';  
 	}  
  
    private void check(){  
        if(name.charAt(0)!=address.charAt(0)){  
            System.out.println("***BROKEN****" + toString());  
 		}  
    }  
}
```


## Python
使用thread.Lock
```python
from threading import Lock  
  
  
class Gate(object):  
    def __init__(self):  
        self.count = 0  
 		self.name = "NoBody"  
 		self.address = "NoWhere"  
 		self.lock = Lock()  
  
    def pass_gate(self, name, address):  
        try:  
            self.lock.acquire()  
            self.count += 1  
 			self.name = name  
            self.address = address  
            self.check()  
        finally:  
            self.lock.release()  
  
    def __str__(self):  
        try:  
            self.lock.acquire()  
            return f"counter = {self.count}, name = {self.name}, address = {self.address}"  
 		finally:  
            self.lock.release()  
              
    def check(self):  
        if self.name[0] != self.address[0]:  
            print(f"****BOKEN****{str(self)}")
```
UserThread
```python
import threading  
  
from single_thread_execution_pattern.gate import Gate  
class UserThread(threading.Thread):  
    def __init__(self, gate: Gate, my_name: str, 		my_address: str):  
        super().__init__()  
        self.my_name = my_name  
        self.gate = gate  
        self.my_address = my_address  
  
    def run(self):  
        print(f"{self.my_name} BEGIN")  
        while True:  
            self.gate.pass_gate(self.my_name, self.my_address)
```
Main
```python
if __name__ == '__main__':  
    gate = Gate()  
    UserThread(gate, "Alice", "Alaska").start()  
    UserThread(gate, "Bobby", "Brazil").start()  
    UserThread(gate, "Chris", "Canada").start()
```

