package com.maomao.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2019/7/2
 */
public class UserTest {
    public static void main(String[] args) {
        User p2 = new User(2, "wang", "qiang");
        User p3 = new User(3, "wang", "cheng");
        User p4 = new User(4, "wang", "qiang");
        User p5 = new User(5, "wang", "cheng");
        List<User> list = new ArrayList<>();
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);


        List<User> distinctList1 = list.stream().collect(Collectors
                .collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> {
                    // 根据firstName和secondName进行去重
                    return o.getFirstName() + "," + o.getSecondName();
                }))), ArrayList::new));

        distinctList1.stream().forEach(user -> {
            System.out.println(user.getFirstName() + " " + user.getSecondName());
        });
    }
}
