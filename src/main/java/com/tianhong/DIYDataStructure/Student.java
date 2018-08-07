package com.tianhong.DIYDataStructure;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Student one = new Student("xiaowang", 56);
        Student two = new Student("ben", 100);
        Array<Student> test = new Array();
        test.addLast(one);
        test.addLast(two);
        System.out.println(test);
    }
}
