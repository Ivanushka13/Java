package davydoff.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model-class with some fields for testing program.
 */
public final class Person {
    @JsonProperty
    private final String name;

    @JsonProperty
    public final String sureName;

    @JsonProperty
    public final int age;

    public Person(String name, String sureName, int age) {
        this.name = name;
        this.sureName = sureName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public int getAge() {
        return age;
    }
}
