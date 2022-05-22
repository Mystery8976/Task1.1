package json_model;

import java.util.Objects;

public class Address {
    private String zipcode;
    private String suite;
    private String city;
    private String street;


    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(zipcode, address.zipcode) && Objects.equals(suite, address.suite)
                && Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipcode,suite, city, street);
    }
}
