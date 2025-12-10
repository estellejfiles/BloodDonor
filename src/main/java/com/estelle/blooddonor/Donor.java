package com.estelle.blooddonor;

public class Donor {
    // define characteristics for fields the donor has
    private String firstName;
    int age;
    int weight;

    // constructor w/o arguments; Spring will create donor object w/ getters & setters
    public Donor () {}

    // getters & setters that get data when called & set it as the associated variable's value
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
