# Junit

## 什么是Junit

JUnit is a simple framework to write repeatable tests. It is an instance of the xUnit architecture for unit testing frameworks.
>>Junit是一个能够简单的编写重复测试的框架，他是XUnit的一个实例。from:[Junit](https://junit.org/junit4/)

## Junit4.12引入

因为Spring默认集成的Junit为4.12，遂下面的教程皆以4.12为主，并且以maven的方式引入依赖

```html
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.12</version>
  <scope>test</scope>
</dependency> 
```

## Junit使用

Junit中以注解为主，学会大部分注解你就可以使用Junit的功能了

