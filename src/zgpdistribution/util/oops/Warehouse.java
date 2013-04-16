/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.util.oops;

/**
 *
 * @author HWT
 */
public class Warehouse {
    private String name;
    private String address;
    private String township;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String whsvr;

    public Warehouse() {
    }

    public Warehouse(String name, String address, String township, String city, String state, String country, String phone, String whsvr) {
        this.name = name;
        this.address = address;
        this.township = township;
        this.city = city;
        this.state = state;
        this.country = country;
        this.phone = phone;
        this.whsvr = whsvr;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTownship() {
        return township;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getWhsvr() {
        return whsvr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWhsvr(String whsvr) {
        this.whsvr = whsvr;
    }    
}
