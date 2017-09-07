package com.allen.learn.java8Learn.dataStructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class MapTest {


    public static void main(String[] args) {

        Map<String, String> resultMap = createMap();


        System.out.println(resultMap.keySet());

        System.out.println(resultMap.entrySet());

        Iterator<Map.Entry<String, String> >  keyValueParse =  resultMap.entrySet().iterator();

        long startTime = System.currentTimeMillis();
        //iterator(keyValueParse);
        array(resultMap);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

        int i=0;
        int hash = 3055;
        int n =16;
        System.out.println((0 & hash));

        System.out.println(0 << 1);



        String a = "a123.";
        System.out.println(a.hashCode());


    }


    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    public static void iterator (Iterator<Map.Entry<String, String> >  keyValueParse ){
        while ( keyValueParse.hasNext() ){
            Map.Entry<String, String> obj = keyValueParse.next();
            String key = obj.getKey();
            String value = obj.getValue();
            System.out.println(key+"---"+value);
        }
    }


    public static void array (Map<String, String> resultMap){
        Object[] keyValuePairs2 = resultMap.entrySet().toArray();
        int size = keyValuePairs2.length;
        for (int i = 0; i < size; i++) {
            Map.Entry entry = (Map.Entry) keyValuePairs2[i];
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"----"+value);
        }
    }

    public static Map<String, String> createMap(){
        Map<String, String> mapData = new HashMap<>(6);
        String key = "a";
        String value = "b";
        int r = 0 ;
        for ( int i=0;i<5; i++ ){
            System.out.println(hash(key+i));
            mapData.put(key+i, value+i);

            r += Objects.hashCode(key+i) ^ Objects.hashCode(value+i);

        }

        System.out.println("r="+r);
        System.out.println("mapData="+mapData.hashCode());

        return mapData;
    }















}

