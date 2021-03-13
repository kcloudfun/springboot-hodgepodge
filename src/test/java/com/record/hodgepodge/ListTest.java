package com.record.hodgepodge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("ooo");
        list1.add("ppp");
        System.out.println(list1.get(0));

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("ooo");
        list2.add("ppp");
        System.out.println(list2.get(0));
        //两者虽然都有get(index)方法，获取元素看起来是一样的，但是看源码就可知道两者get(index)的实现方式不一样。
        //LinkedList是循环，故查询比ArrayList效率低。
        //添加元素也是同理，两者add方法实现不一样，LinkedList插入效率比ArrayList高
    }
}
