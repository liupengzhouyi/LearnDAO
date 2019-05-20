# LearnDAO

#### 介绍
#
DAO 是什么？
**今日得宝图一张，了解DAO在项目中的作用**

## DAO层大抵是一种持久层

### 承上启下

**对下**

* 对下可以连接数据库
* 获取对数据库的操作
* 获取数据库中的数据
* 对数据库中的数据增删改查

**对上**

* 提供封装好的数据
* 提供对数据操作的接口

### 这就是DAO层！

## DAO 层包含什么？

* DatabaseConnection

> 负责数据库的打开
> 负责数据库的关闭

* ValueObject

> JavaBean 对数据库的对象进行封装

* DAO interface

> 定义数据库操作的接口

* Implement DAO

> 实现对数据库操作的接口类

* Proxy

> 代理实现类，主要完成对数据库的打开与关闭。
> 调用真实实现类对线的操作

* Factory

> 工厂类，通过工厂类获取一个DAO的实例化对象

## 命名规则


**数据库连接**：xxx.dbc.DatabaseConnection

**DAO接口**： xxx.dao.XxxDAOInterface

**DAO接口真实实现类**：xxx.dao.implement.XxxDAOImplement

**DAO接口代理实现类**：xxx.dao.proxy.XxxDAOProxy

**ValueObject类**： xxx.valueObject.Xxx, ValueObject命名要与表的命名一致

**工厂类**：xxx.factory.DAOFactory.

## [提交记录](note/note.md)

## [说明](DAO/note.md)

### [工厂说明](DAO/factory/note.md)

### [数据库连接说明](DAO/link/node.md)

### [DAO实现说明](DAO/lpImplements/note.md)

### [DAO接口说明](DAO/lpInterface/note.md)

### [测试说明](DAO/test/note.md)

### [ValueObject说明](DAO/valueObject/note.md)