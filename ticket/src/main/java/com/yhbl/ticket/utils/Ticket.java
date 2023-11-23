package com.yhbl.ticket.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: Ticket
 * @Description:
 * @Author: savn
 * @Date: 2023/11/24 01:24
 */
public class Ticket {
    public static void main(String[] args) {
        Map<Object, Object> multiple = multiple(2, 1);
        Iterator var2 = multiple.keySet().iterator();

        while(var2.hasNext()) {
            Object o = var2.next();
            System.out.println(o + "" + multiple.get(o));
        }

    }

    public static Map<Object, Object> multiple(int lottoTimes, int twoBallTime) {
        Map<Object, Object> map = new LinkedHashMap();
        String currentData = getCurrentData();
        map.put("【时间】", currentData + "\n");

        int i;
        ArrayList integers;
        for(i = 1; i <= lottoTimes; ++i) {
            integers = Lotto();
            map.put("大乐透，第【" + i + "】组：", integers);
        }

        map.put("", "");

        for(i = 1; i <= twoBallTime; ++i) {
            integers = TwoBall();
            map.put("双色球，第【" + i + "】组：", integers);
        }

        return map;
    }

    public static Map<Object, Object> multiple() {
        Map<Object, Object> map = new LinkedHashMap();
        String currentData = getCurrentData();
        map.put("【时间】", currentData + "\n");
        ArrayList<Integer> lotto = Lotto();
        ArrayList<Integer> integers = TwoBall();
        map.put("【大乐透】", lotto);
        map.put("【双色球】", integers);
        return map;
    }

    public static ArrayList<Integer> Lotto() {
        ArrayList<Integer> ints = new ArrayList();
        initList(ints, 35, 5);
        Collections.sort(ints);
        initList(ints, 12, 2);
        return ints;
    }

    public static ArrayList<Integer> TwoBall() {
        ArrayList<Integer> ints = new ArrayList();
        initList(ints, 33, 6);
        Collections.sort(ints);
        initList(ints, 16, 1);
        return ints;
    }

    public static void initList(ArrayList array, int maxNum, int times) {
        for(int i = 0; i < times; ++i) {
            int ii;
            for(ii = (new Random()).nextInt(maxNum) + 1; array.contains(ii); ii = (new Random()).nextInt(maxNum) + 1) {
            }

            array.add(ii);
        }

    }

    public static String getCurrentData() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}
