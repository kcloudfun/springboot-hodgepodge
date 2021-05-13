package com.record.hodgepodge.simpledemo;


import java.util.ArrayList;
import java.util.List;

public class Ttest {

    public static void main(String[] args) {
        Ttest ttest = new Ttest();
        ttest.compareTAndObject();

    }


    public List<Object> test1(Object obj) {
        List<Object> list1 = new ArrayList<>();
        list1.add(obj);
        return list1;
    }

    //泛型只存在编译阶段，运行阶段不存在泛型，也就是编译完成之后泛型就被具体化了。
    //泛型对比定义object的好处：1.自动检验，更规范2.隐式转化（若用object存在显式强转），代码更简洁

    public <T> List<T> test2(T t) {
        //泛型一定会指明一定范围，要么是某一个方法内，要么是某一个对象内。
        //指明范围后，那在范围内的所有T都只能是同一种对象
        List<T> list1 = new ArrayList<>();
        list1.add(t);
        return list1;
    }

    public void compareTAndObject() {
        Student student = new Student();
        student.setName("yahaha");
        student.setAge(1);
        List<Object> list1 = test1(student);//使用Object此处只能定义为Object
        Student student1 = (Student) list1.get(0);//只能显式强转，这一步可能运行时报错
        System.out.println(student1.getName());
        List<Student> list2 = test2(student);//使用泛型此处可直接定义为Student
        Student student2 = list2.get(0);//只可能过不了编译，不可能运行时报错
        System.out.println(student2.getName());
    }

    //?通配符的使用范围较小，通常用作接收对象的定义
    public List<?> test3(Object t) {
        List<Object> list1 = new ArrayList<>();
        list1.add(t);
        return list1;
    }

    private class Student {

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
