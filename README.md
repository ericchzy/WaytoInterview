# 2018 秋招刷题汇总

💪 如果你觉得有帮助请点个 star，谢谢！欢迎 Follow 我 ☕️

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

## Leetcode

- IsomorphicStrings_lc205
- lowestCommonAncestor_lc235

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
- 橡皮泥斑马(EraserZebra)
- 翻转
- 字符串距离之Levenshtein Distance变种问题 (EditDistance)

## 触宝
2019秋季校招Android工程师

- 优先级计算表达式(Expression)
- 上帝洪水(GodProblem)

## B站策略/算法岗

- 最短路径逃脱问题(MouseEscape)
- 版本号比较问题(VersionCompare)
- 附带提前结束条件的顺时针打印数字矩阵(ClockwiselyPrintMatrix)

## 百度
2019机器学习工程师笔试

选择题
- 二次探测再散列
- 离散单信号源信息熵
- 静态重定位
- 贝叶斯定理
- Apriori算法
- 最小生成树 Prim算法

问答题
- 特征选择算法
- “标题党”度量的特征选择与标注数据获取

编程题
- 字符串计数2019年秋招37互娱笔试
- 寻寻觅觅

## BIGO
2019机器视觉线下笔试

问答题
- 导数、偏导数、方向导数、梯度概念
- Logistic Regression原理
- 卷积神经网络感受野概念

编程题
- 将单链表的数K个数移动到链表前面(MoveKthToFront)

## 京东

编程题
- 相似字符串(SimilarString)
- 完全多部图(CompleteMultiGraph)

## 37互娱
2019年秋招37互娱笔试

- 将数字0移动到最后(MoveZeros)
- 冒泡排序(BubbleSort)

## 欢聚时代YY

2019欢聚时代Android工程师笔试

问答题
- 观察者模式
- 横竖屏切换Activity生命过程

编程题
- 子字符串的最大长度(MaxLengthOfSubstring)
- 在给定范围内因子和为100的最小乘积

## 顺丰
2019顺丰人工智能与机器学习工程师笔试

编程题
- 文本改写(EditDistance)
- 排排坐吃果果(CandyProblem)