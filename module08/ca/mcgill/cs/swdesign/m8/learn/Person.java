package ca.mcgill.cs.swdesign.m8.learn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

abstract class Person implements Visitable {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    String getName() { return this.name; }

    void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
    int getAge() { return this.age; }

    String greet() {
        return "I am " + this.name + " and I am " +
                ((age == 1) ? "year" : "years") + " old";
    }
}


class Child extends Person {
    private String food;
    Child(String name, int age) {
        super(name, age);
        this.food = "nothing";
    }
    Child(String name, int age, String food) {
        super(name, age);
        this.food = food;
    }
    @Override
    String greet() {
        return super.greet() + " and I eat " + food;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitChild(this);
    }
}

class Parent extends Person {
    private int salary;
    private Set<Child> children = new HashSet<>();
    Parent(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    Parent(String name, int age, int salary, Set<Child> children) {
        super(name, age);
        this.salary = salary;
        this.children = children;
    }

    int getSalary() { return this.salary; }

    void setSalary(int salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    Set<Child> getChildren() { return new HashSet<>(this.children); }

    void addChild(Child child) {
        this.children.add(child);
    }



    @Override
    String greet() {
        return super.greet() + " I earn " + salary + " and kids, I have " + children.size();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParent(this);
    }
}