# 2018 秋招刷题汇总

## JVM Explore

简单的Java虚拟机探索之旅以及OOM问题探究

![Java虚拟机运行时数据区](https://ws1.sinaimg.cn/mw690/0061W3qMgy1fugaeyygdlj30d70b2dhf.jpg)

- 堆内存溢出（不断新建静态对象而不释放其唯一引用）
- 线程栈溢出（不断新建线程调用死循环方法）
- 方法栈溢出（调用无返回条件的递归方法）
- 运行时常量池内存溢出（在 JDK8
  中，永久代已完全被元空间(Meatspace)所取代，故此处抛出错误和堆内存溢出一样）

## Design Pattern
各种经典的设计模式以及简单例子

- 工厂模式
- 适配器模式
- 过滤器模式
- 代理模式
- MVC模式
- 策略模式

## Algorithm

剑指Offer上的算法题目的Java实现


## Netease

2018 - 2019 年度网易Android、Java岗算法题目汇总

- 最大兴趣值(MaxInterest)
- 数塔问题(BalancedTower)
- 丰收(Harvest)
- 牛牛找工作（FindJob）
- 数对(PairedNum)
- 独立的小易(Independency)
- 交错01串(MixedZerosAndOnes)
- 彩色砖块排列（ColorBrick）
- 等差数列(ArithmeticProgression)
- 小易喜欢的数列(FavouriteSequence)

## 触宝
2019秋季校招Android工程师

- 优先级计算表达式(Expression)
- 上帝洪水(GodProblem)

## B站策略/算法岗

- 最短路径逃脱问题(MouseEscape)
- 版本号比较问题(VersionCompare)
- 附带提前结束条件的顺时针打印数字矩阵(ClockwiselyPrintMatrix)