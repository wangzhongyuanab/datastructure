package com.interview.juc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class User{
    private Integer id;
    private String userName;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(Integer id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }
}

//找出同时满足以下条件的用户,也即以下条件全部满足偶数id且年龄大于24且用户名转为大写且用户名字母倒排序
//只输出一个用户名字
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11,"a",23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1,u2, u3, u4, u5);

        list.stream().filter(u->{return u.getId()%2==0;})
                .filter(t->{return t.getAge()>24;})
                .map(m->{return  m.getUserName().toUpperCase();})
                .sorted((o1,o2)->{ return o2.compareTo(o1);})
                .limit(1)
                .forEach(System.out::println);

    }
}
