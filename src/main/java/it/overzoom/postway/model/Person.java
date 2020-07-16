package it.overzoom.postway.model;

public class Person {
    private String name;
    private String surname;
    private String businessName;
    private String postalOffice;
    private String postalBox;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPostalOffice() {
        return postalOffice;
    }

    public void setPostalOffice(String postalOffice) {
        this.postalOffice = postalOffice;
    }

    public String getPostalBox() {
        return postalBox;
    }

    public void setPostalBox(String postalBox) {
        this.postalBox = postalBox;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address {
    private AddressKind king;
    private String street;
    private String city;
    private String fraction;
    private String zip;
    private String province;
    private String country;

    public AddressKind getKing() {
        return king;
    }

    public void setKing(AddressKind king) {
        this.king = king;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
