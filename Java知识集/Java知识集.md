# Java知识集

# 集合

## 1. Collection继承图

![collection tree](/Users/chenpengcheng/Documents/Java知识集/screenshot/collection tree.png)

## 2. 哪些是线程安全，哪些是不安全

### 线程安全

- Vector
- Stack 因为Stack是基础自Vector的 
- HashTable
- Properties

### 线程不安全

- Array
- ArrayList
- LinkedList
- HashSet
- TreeSet
- HashMap
- TreeMap

### 安全转安全的方法

```java
<T> Collection<T> synchronizedCollection(Collection<T> c); //返回指定collection 对应的线程安全的collection。
static <T> List<T> synchronizedList(List<T> list); //返回指定List对象对应的线程安全的List 对象。
static <K, V> Map<K, V> synchronizedMap(Map<K, V> m); //返回指定Map对象对应的线程安全的Map对象。
static <T> Set<T> synchronizedSet(Set<T> s); //返回指定Set对象对应的线程安全的Set对象。
static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> m); //返回指定SortedMap对象对应的线程安全的SortedMap对象。
```

### 验证方法

https://www.iteye.com/problems/69206

### JVM类加载
双亲委派机制

### JavaBean
JavaBean有特定的写法
   * 无参构造函数
   * 属性必须私有化
   * 必须有对应的get/set方法
  
一般用来和数据库的字段做映射