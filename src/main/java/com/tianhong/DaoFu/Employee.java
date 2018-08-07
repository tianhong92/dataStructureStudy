package com.tianhong.DaoFu;

public class Employee {
    private String name;
    private int employId;
    private int age;
    private int bossId;

    public Employee() {
    }

    public Employee(String name, int employId, int age) {
        this.name = name;
        this.employId = employId;
        this.age = age;
    }

    public Employee(String name, int employId, int age, int bossId) {
        this.name = name;
        this.employId = employId;
        this.age = age;
        this.bossId = bossId;
    }

    public String getName() {
        return name;
    }

    public int getEmployId() {
        return employId;
    }

    public int getAge() {
        return age;
    }

    public int getBossId() {
        return bossId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployId(int employId) {
        this.employId = employId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBossId(int bossId) {
        this.bossId = bossId;
    }

    @Override
    public String toString(){
        return name + ", " + employId +
                ", " + age + ", " + bossId;
    }

    public boolean isTopBoss() {
        return bossId == 0;
    }
}
