# Game4399
2019 Android开发工程师笔试题目

## 问答题

- 请描述Android Service用不同方式启动时对应的生命周期。

1. startService() -> onCreate() -> onStartCommand() -> Service Running -> onDestroy()
2. bindService() -> onCreate() -> onBind() -> Clients are bound to service -> onUnbind() -> onDestroy()

- 用手机在应用市场下载App，总是下载不了，目前已知是网络问题。请问在网络通信过程中，有哪些环节、链路、节点可能出问题？如何定位具体的问题？
  
- 请回答：
  
1、写出堆排序、归并排序和快速三种排序算法的平均、最好、最坏时间复杂度，和空间复杂度。
  
2、什么是算法稳定性？以上三种排序中哪些是稳定的？他们的算法实现用了什么策略思想？
  
3、在大规模数据排序的实际应用中，哪种排序最快，为什么？

## 编程题

- 随机生成一注双色球（编程语言不限）
  
  要求：
     从 1 ~ 33 随机抽取6个数打印出来（即6个红球），不能重复
     从 1 ~ 16 随机抽取1个数打印出来（即1个蓝球）
  
  已知随机函数为：
     int rand(int bound); // 输入bound，随机返回一个范围为 [0, bound) 的整数
     
- （Matching）分析一个字符串里的大括号和小括号是否配对
  
  如：
     输入 "123(a+a=3){xxx}" 或 "e{(bb)cc}dd" 时打印true
     输入 "({abc)}" 或 "e{(b)c{c}dd" 或 "}aa(c)bb{" 时打印false
     
- （BinarySearch）请使用熟悉的编程语言实现函数，计算指定数字在排好序的数组中出现了多少次
  要求时间复杂度为 O(logn)
  如输入有序数组 [1,2,3,4,4,4,4,4,5] 和数字 4，输出 5