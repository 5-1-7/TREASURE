package com.cy.api;

import java.util.Objects;

/**
练习 Object API，on 2021/3/7 15:33
Object是每个类的父类

String  toString()：
重写前展示对象的地址值；@Override重写后展示对象的属性值。

int     hashCode()

boolean equals(Object o)：
重写前比较两个对象的地址值；@Override重写后比的是对象的属性值。

== 比基本类型的数据，是比值的本身
== 比引用类型的数据，比的是地址值
*/
public class ObjectTest {
    public static void main(String[] args) {
        // 1、创建对象，触发无参构造 Object()
        Object o = new Object();
        // 1.1、调用方法（方法使用：名字、参数、返回值）
        String s = o.toString();
        // toString() 获取o对象在内存中的地址值，java.lang.Object@95be4dd9
        System.out.println(s);

        // 1.2、hashCode();获取o对象在内存中的哈希码值
        int i = o.hashCode();
        System.out.println(i);

        // equals(Object o); Object体现了多态：通用性/扩展性
        // 1.3、比较o对象和"abc"对象是否相等，相等返回true，不等返回false
        boolean b = o.equals("abc");
        // false
        System.out.println(b);

       /* 2.1、触发无参构造
         students s1 = new students();*/
        // 2.2、触发含参构造
        students ss = new students("王一博", 24);
        /* 重写toString()前展示地址值：com.cy.api.students@1ab98e7a
          原因：底层自动调用ss对象的toString()，默认调用了父类Object的toString()
          2.3、重写toString()后展示对象属性值，students{name='王一博', age=24}*/
        System.out.println(ss);

        students ss1 = new students("王一博",24);
        boolean b1 =ss.equals(ss1);
        System.out.println(b1);
    }

}

class students {
    private String name;
    private int age;

    // 类里如仅有含参构造，默认隐藏的无参构造就没了，所以一定要写上无参构造（方便new）
    public students() {
    }

    // 工具生成：alt+insert > Constructor
    public students(String name, int age) {
        // super();找Object的无参构造，默认隐藏不写。
        super();
        this.name = name;
        this.age = age;
    }

    // TODO 重写Object的toString()展示属性值 (默认是展示地址值)
    /* 重写toString()前展示地址值：com.cy.api.students@1ab98e7a
       原因：底层自动调用ss对象的toString()，默认调用了父类Object的toString()
       重写toString()后展示对象属性值，students{name='王一博', age=24}
       工具自动生成：alt+insert > toString */
    @Override
    public String toString() {
        return "students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /* 重写equals(Object o)前默认使用Object，就是比两个对象的地址值)
       重写equals(Object o)后，比的是对象的属性值 */
    // TODO 重写Object的equals(Object o)展示属性值 (默认是展示地址值)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        students students = (students) o;
        return age == students.age && name.equals(students.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

