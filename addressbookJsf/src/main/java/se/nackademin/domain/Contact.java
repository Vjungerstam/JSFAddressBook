package se.nackademin.domain;

public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String street;
    private String phone;

    public Contact(){

    }

    public Contact(String firstName, String lastName, String street, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}