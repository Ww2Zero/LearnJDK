package com.zero.test.java.lang.system;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class Test {

    public static void main(String[] args) throws IOException {

//        test01();
//        test02();
//        test03();

    }

    private static void test03() {
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.println("entry.getKey() = " + entry.getKey());
            System.out.println("entry.getValue() = " + entry.getValue());
            System.out.println("---------");
        }


        String pwd = System.getenv("PWD");
        System.out.println("pwd = " + pwd);
    }

    private static void test02() {
        System.setProperty("name","zhangsan");
        System.setProperty("age","18");
        String name = System.getProperty("name");
        System.out.println("name = " + name);
        String work = System.getProperty("work");
        System.out.println("work = " + work);
        work = System.getProperty("work","teacher");
        System.out.println("默认的work = " + work);

        Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> objectObjectEntry : properties.entrySet()) {
            System.out.println("objectObjectEntry.getKey() = " + objectObjectEntry.getKey());
            System.out.println("objectObjectEntry.getValue() = " + objectObjectEntry.getValue());
            System.out.println("=====");
        }

        Properties zeroProperties = new Properties();   // 构造自定义属性集
        zeroProperties.setProperty("key1", "value1");
        zeroProperties.setProperty("key2", "value2");
        zeroProperties.setProperty("key3", "value3");

        System.setProperties(zeroProperties);       // 设置自定义属性集【该操作会替换掉原有的系统属性集】

        Properties pp = System.getProperties(); // 获取自定义属性集
        for(Map.Entry<Object, Object> entry : pp.entrySet()){       // 遍历自定义属性集
            System.out.println(entry.getKey()+" :  "+entry.getValue());
        }
    }

    /**
     *
     * -----------------从控制台输入/输出内容-----------------
     * hello world
     * hello world
     *
     * -----------------从文件输入/输出内容-----------------
     * // in.txt
     * do more. know more. be more.
     *
     * // out.txt
     * 0.7915698211584528
     * do more. know more. be more.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
     *
     * @throws IOException
     */
    private static void test01() throws IOException {
        byte[] bytes = new byte[1024];          // 创建缓冲区以接收数据

        System.out.println("-----------------从控制台输入/输出内容-----------------");
        System.in.read(bytes);                  // 从控制台读取输入
        System.out.println(new String(bytes));  // 输出读取到的内容到控制台


        System.out.println("-----------------从文件输入/输出内容-----------------");
        System.setIn(new FileInputStream(new File("src/com/zero/test/java/lang/system/in.txt")));                      // 改变输入流源头
        System.setOut(new PrintStream(new FileOutputStream(new File("src/com/zero/test/java/lang/system/out.txt"))));  // 改变输出流终点
        System.in.read(bytes);                  // 从in.txt读取输入
        System.out.println(Math.random());      // 先输出一个随机数，目的是验证每次都是新的输出
        System.out.println(new String(bytes));  // 输出读取到的内容到out.txt
    }
}
