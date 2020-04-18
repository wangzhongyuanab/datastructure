package com.interview;

import java.io.*;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/7 21:57
 */
public class SerialDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("object.out"));
        Student student = new Student("aha","123456","1");
        oos.writeObject(student);
        oos.close();
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("object.out"));
        Student student1 = (Student) ois.readObject();
        System.out.println(student1.getUserName()+student1.getPassword()+student1.getSex());
        ois.close();
    }
}

class Student implements Serializable{
    private String userName;
    private String password;
    private String sex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(String userName, String password, String sex) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
    }
}
