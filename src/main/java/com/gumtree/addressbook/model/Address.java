package com.gumtree.addressbook.model;

import java.time.LocalDate;

/**
 * Created by SMumbaraddi on 28/07/2015.
 */
public class Address {

    private final String name;
    private final String gender;
    private final LocalDate dob;

    public Address(String name, String gender, LocalDate dob){
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!name.equals(address.name)) return false;
        if (!gender.equals(address.gender)) return false;
        return dob.equals(address.dob);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + dob.hashCode();
        return result;
    }
}
