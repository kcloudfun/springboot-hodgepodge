package com.record.hodgepodge;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {


    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null, null);

        LinkedHashMap<Object,Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(null, null);

//        TreeMap<Object,Object> treeMap = new TreeMap<>();
//        treeMap.put(null, null);

//        Hashtable<Object, Object> hashtable = new Hashtable<>();
//        hashtable.put("null", null);
//        //Hashtable不允许键为null，此处会报空指针
//
//        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put(null, null);
    }

}
