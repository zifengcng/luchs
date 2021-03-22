package com.luchs.java.collect;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author cheng
 * @Date 2021/2/22
 */
public class TestSet {

    public void test() {
        Set<Object> set = new HashSet<>();

        User user = new User();
        user.name = "123";

        set.add(user);
        System.out.println(set.contains(user));
        user.name = "456";
        System.out.println(set.contains(user));
    }

    public static void main(String[] args) {
        new TestSet().test();
    }

    class User {
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
