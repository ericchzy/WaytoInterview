# 快速阅览

## 如何保证程安全的两种方式区别


- Lock使用起来比较灵活，但需要手动释放和开启；采用synchronized不需要用户去手动释放锁，当synchronized方法或者synchronized代码块执行完之后，系统会自动让线程释放对锁的占用；

- Lock不是Java语言内置的，synchronized是Java语言的关键字，因此是内置特性。Lock是一个类，通过这个类可以实现同步访问；

- 在并发量比较小的情况下，使用synchronized是个不错的选择，但是在并发量比较高的情况下，其性能下降很严重，此时Lock是个不错的方案。

- 使用Lock的时候，等待/通知 是使用的Condition对象的await()/signal()/signalAll()  ，而使用synchronized的时候，则是对象的wait()/notify()/notifyAll();由此可以看出，使用Lock的时候，粒度更细了，一个Lock可以对应多个Condition。

- 虽然Lock缺少了synchronized隐式获取释放锁的便捷性，但是却拥有了锁获取与是释放的可操作性、可中断的获取锁以及超时获取锁等多种synchronized所不具备的同步特性;


## OOM各种姿势

- 堆内存溢出（不断新建静态对象而不释放其唯一引用）
- 线程栈溢出（不断新建线程调用死循环方法）
- 方法栈溢出（调用无返回条件的递归方法）
- 运行时常量池内存溢出（在 JDK8
  中，永久代已完全被元空间(Meatspace)所取代，故此处抛出错误和堆内存溢出一样）


