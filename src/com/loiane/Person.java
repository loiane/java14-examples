package com.loiane;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof Person person) {
            return age == person.age &&
                   Objects.equals(name, person.name);
        }
        return false;
    }
}
