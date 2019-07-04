# 原理说明

## Junit原理讲解

Java在我们的认知中只有 pasvm,main方法可以执行，为什么加上@Test注解的方法就可以执行了?我们一起debug深入了解Junit原理吧。


## 环境说明

1.junit 4.12

2.Idea 2019.1

## 原理讲解

1.在IDEA中搜索 idea-junit.jar
![step1](https://raw.githubusercontent.com/BoomManPro/unit-test/master/docs/images/junit-2.png)
2.在当前项目中通过如图引入
![step2](https://raw.githubusercontent.com/BoomManPro/unit-test/master/docs/images/junit-3.png)
3.双击debug中main最后一栏 从源头看起

![step3](https://raw.githubusercontent.com/BoomManPro/unit-test/master/docs/images/junit-4.png)

## 简单阐述

我们会发现 IDEA实际上先执行了一个main方法，然后将带有@Test的方法进行执行，具体执行过程就不分析啦。
如果我们的IDEA有一天不能执行@Test，你首先先查看是否有Junit依赖，其次查询IDEA的Plugs是否有Junit插件

具体插件详情:
![plugins](https://raw.githubusercontent.com/BoomManPro/unit-test/master/docs/images/juit-plugins-for-idea.png)

## 写在末尾

学习和熟悉IDEA的Debug快捷键是成为一个大牛的必备吧！下面存储以备忘

`Shift`+`F7`                     Smart Step Into （选中方法智能步入）

`F9`                                   resume programe 恢复程序

`Alt`+ `F10`                      show execution point 显示执行断点

`F8`                                   Step Over 相当于eclipse的f6      跳到下一步

`F7`                                   Step Into 相当于eclipse的f5就是  进入到代码

`Alt`+`shift` + `F7`         Force Step Into 这个是强制进入代码

`Shift` + `F8`                   Step Out  相当于eclipse的f8跳到下一个断点，也相当于eclipse的f7跳出函数

`Atl`+`F9`                         Run To Cursor 运行到光标处

`ctrl`+`shift`+`F9`        debug运行java类

`ctrl`+`shift`+`F10`      正常运行java类

`Alt` + `F8`                      debug时选中查看值