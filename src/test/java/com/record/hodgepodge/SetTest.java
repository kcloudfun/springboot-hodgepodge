package com.record.hodgepodge;

import java.util.*;

/**
 * list、set有序无序测试
 */
public class SetTest {

    public static void main(String[] args) {
        //set无序，没法保证放入和输出顺序一致
        HashSet<String> set = new HashSet();
        set.add("A");
        set.add("C");
        set.add("B");
        System.out.println(set);
        for (String str : set) {
            System.out.println(str);
        }

        TreeSet<String> set1 = new TreeSet<>();
        set1.add("A");
        set1.add("C");
        set1.add("B");
        System.out.println(set1);
        for (String str : set1) {
            System.out.println(str);
        }

        //list有序，放入和输出顺序一致
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("C");
        list.add("B");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
