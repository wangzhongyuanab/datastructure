package com.testTransferValue;


public class Person {
    private Integer id;
    private String personName;

    public Person(String personName){
        this.personName=personName;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
