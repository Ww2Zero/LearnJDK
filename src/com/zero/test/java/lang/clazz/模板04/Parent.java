package com.zero.test.java.lang.clazz.模板04;

// @可重复注解的容器_不可继承(value = {@可重复注解_不可继承(str = "父类-1"), @可重复注解_不可继承(str = "父类-2")})

@可重复注解_不可继承(str = "父类-1")
@可重复注解_不可继承(str = "父类-2")

@可重复注解_可继承(str = "父类-3")
@可重复注解_可继承(str = "父类-4")
public class Parent {
}
