package com.estelle.blooddonor;

import jakarta.validation.constraints.*;

public class Donor {
    // define characteristics for fields the donor has

    // use NotNull annotation validates user enters a name; display message if null
    // NotBlank annotation validates user enters a name; display message if blank
    // Size annotation validates name is min 2 & max 50 characters; display message if not
    @NotNull(message="Name is required")
    @NotBlank(message="Name is required")
    @Size(min=2, max=50, message="Name must be at least 2 characters")
    private String firstName;

    // Min validates age is a positive number
    @Min(value=0, message="Age must be a positive number")
    // Max validates age is less than 130
    @Max(value=130, message="Age must be 130 or less")
    private int age;

    // Min validates weight is more than 5
    @Min(value=5, message="Weight must be at least 5")
    // Max validates weight is less than 600
    @Max(value=600, message="Weight must be 600lbs or less")
    private int weight;

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
