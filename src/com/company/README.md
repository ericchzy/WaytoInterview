# Android选择题
从牛客网的答案解析中收集

- 安卓的六大布局管理器是LinearLayout、FrameLayout、TableLayout、RelativeLayout、AbsoluteLayout、GridLayout

- Intent主要用于同一个app中不同组件之间传递信息。不同app之间主要使用AIDL进行通信

- 获取屏幕属性

获取屏幕密度  getScreen

获取设备屏幕大小 getDisplay

获得屏幕的属性，从而取得屏幕的高度和宽度 getMetrics

获得window对象 getWindows

- 重要性依次是：前台进程，可见进程，服务进程，后台进程和空进程；所以销毁的顺序是逆方向。

![](http://uploadfiles.nowcoder.net/images/20150302/742522_1425292551666_1.png)

- Handler与MessageQueue数量关系

1.Handler 必须在 Looper.prepare() 之后才能创建使用 
2.Looper 与当前线程关联，并且管理着一个 MessageQueue 
3.Message 是实现 Parcelable 接口的类 
4.以一个线程为基准，他们的数量级关系是： Handler(N) : Looper(1) : MessageQueue(1) : Thread(1)

- RemoteView会用在两个地方： 一个是在AppWidget , 另外一个是在Notification.  

- 使用SimpleAdapter作为适配器时，支持三种类型的 View，而且是按照如下顺序进行匹配：

1. 继承Checkable接口
2. TextView
3. ImageView

- android常用的跨进程通信四种方式：
1.访问其他应用程序的Activity
2.Content Provider 
3.广播（Broadcast） 
4.AIDL服务

- AlertDialog的构造方法被声明为protected, 而ProgressDialog构造方法为public

- 对于Listiew来说，getViewTypeCount 和getItemViewType主要用于为不同的列表项目提供不同的视图view

- Android选框操作

1. 单选框操作：单选框在Android里面随处可见，它是由两部分组成的，一部分是RadioGroup，一部分是RadioButton。一个RadioGroup里面是有多个RadioButton。每个RadioButton就是一个单选项，而控制的时候是控制RadioGroup。
2. 复选框(checkBox)：复选框就没有单选框那样有组的概念了，所以复选框的操作和单选框比起来就会比较复杂一点点，因为你要对每个复选框都进行一个事件响应。 

- 自定 style 的方式： 标签嵌套是resources>style>item

- Android动画

AlphaAnimation
渐变透明度动画效果

ScaleAnimation
渐变尺寸伸缩动画效果

TranslateAnimation
画面转换位置移动动画效果

RotateAnimation
画面转移旋转动画效果

- Android Service生命周期

![](https://uploadfiles.nowcoder.net/images/20170303/6524741_1488555669592_52F9B454F356F85C2361F789A44194F2)

- ContentProvider

1. ContentResolver和 ContentProvider是一对。一个运行在提供数据端(provider),一个运行在调用端(resolver)。使用的时候利用resolver来调用provider的方法(query,insert,update等)，然后provider再进行数据查询 
2. Cursor是游标，返回结果集的。provider的query可以返回这中类型的结果。
3. SQliteHelper这个应该是干扰项，我记得是SQLiteOpenHelper啊。管理数据库的，一般继承它，然后重写onCreate、onUpGrade

- 160sp=160dip=1in=72pt

- NDK是一系列工具的集合， NDK 提供了一系列的工具，帮助开发者迅速的开发 C/C++ 的动态库，并能自动将 so 和 java  应用打成 apk 包。 NDK集成了交叉编译器，并提供了相应的 mk 文件和隔离 cpu 、平台等的差异，开发人员只需简单的修改 mk 文件就可以创建出 so。

- Intent可以传递哪些类型的数据

1. 8种基本数据类型及其数组 
2. String（String实现了 Serializable ）/CharSequence实例类型的数据及其数组 
3. 实现了Parcelable的对象及其数组 
4. 实现了 Serializable 的对象及其数组 

- GLSurfaceView提供了下列特性：

1. 管理一个surface，这个surface就是一块特殊的内存，能直接排版到android的视图view上。
2. 管理一个EGL display，它能让opengl把内容渲染到上述的surface上。
3. 用户自定义渲染器(render)。
4. 让渲染器在独立的线程里运作，和UI线程分离。
5. 支持按需渲染(on-demand)和连续渲染(continuous)。
6. 一些可选工具，如调试。

## 小迈科技问答题

- Intent的主要概念和用处，显式Intent和隐式Intent区别
- 线程控制函数 wait, notify, notifyall, join, yield, sleep, synchronized的作用
- ANR以及引起的原因
- View绘制过程onMeasure, onLayout, onDraw三个方法的作用
- Android的动画有哪些，分别有什么区别
- 找出一串数列中最长的一串顺序的数字， 并输出最长的长度

