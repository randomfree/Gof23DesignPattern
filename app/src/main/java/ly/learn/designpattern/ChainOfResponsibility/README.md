# (GOF23设计模式)责任链模式

责任链模式属于行为模式的一种，定义为：**为了避免请求和多个处理者耦合在一起，将所有请求处理者以前一个处理者记住下一个处理者的方式连在一起，当有请求发生时，请求沿着这条处理链一直找到处理者为止。**

## 主要针对的场景

是一个请求或操作有多个对象可以处理，但是每个对象处理的条件或者权限不同。

## 实际应用的举例

在很多app中都有这样的需求：后端配置一条链接，这条链接根据参数不同可以打开原生页面，可以打开特定h5可以弹出弹窗等等，如果我们用if..else...去处理链接的参数来执行对应的动作就会使代码可读性非常差，并且因为一大堆if...else...的出现如果出现新的处理者就需要修改if..else...的部分，这违反了开闭原则,也会使代码难以维护。但是如果使用责任链模式就可以很好的解决这样的问题

## 模式的结构与实现

### 模式中的角色

1. 抽象处理者：有个抽象处理方法和一个包含下一个处理者的对象或者说链接。
2. 具体处理者：实现抽象处理者，判断自己是否能够处理，如果不能交给下一个处理者。
3. 客户类：完成责任链的拼接并发起请求

![uml](https://tva1.sinaimg.cn/large/007S8ZIlly1gf71uo1a35j30iq05xjrk.jpg)

### 顺便也实现了上面实际应用的举例

![real](https://tva1.sinaimg.cn/large/007S8ZIlly1gf767bbjuwj30sn07c3z2.jpg)