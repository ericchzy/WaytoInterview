# 如何正确使用Volatile变量

文章来源：
[IBM JAVA技术专区文章 - 正确使用 Volatile 变量](https://www.ibm.com/developerworks/cn/java/j-jtp06197.html)

锁提供了两种主要特性：互斥（mutual exclusion）
和可见性（visibility）。互斥即一次只允许一个线程持有某个特定的锁，因此可使用该特性实现对共享数据的协调访问协议，这样，一次就只有一个线程能够使用该共享数据。可见性要更加复杂一些，它必须确保释放锁之前对共享数据做出的更改对于随后获得该锁的另一个线程是可见的
——
如果没有同步机制提供的这种可见性保证，线程看到的共享变量可能是修改前的值或不一致的值，这将引发许多严重问题。

## 正确使用 volatile 变量的条件
您只能在有限的一些情形下使volatile变量替代锁。要使 volatile
变量提供理想的线程安全，必须同时满足下面两个条件：

- 对变量的写操作不依赖于当前值。
- 该变量没有包含在具有其他变量的不变式中。

## 正确使用 volatile 的模式

- 模式 #1：状态标志
- 模式 #2：一次性安全发布（one-time safe publication）
- 模式 #3：独立观察（independent observation）
- 模式 #4：“volatile bean” 模式
- 模式 #5：开销较低的读－写锁策略
