package com.record.hodgepodge;

public class HashTest {

    public static void main(String[] args) {
        System.out.println("A".hashCode());
        System.out.println("B".hashCode());
        //字母的哈希值顺序与其本身排序一致，故测试HashSet与TreeSet时，两者放入同样顺序后内部顺序也一样
    }
}
