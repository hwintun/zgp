/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.util.oops;

/**
 *
 * @author John
 */
public class Employee {

    private String name, nrc, wphone, mphone, jobPosition, dept, deptMgr, address,
            tsp, city, state, country, email, team;

    public Employee() {
    }

    public Employee(String name, String nrc, String wphone, String mphone,
            String jobPosition, String dept, String deptMgr, String address,
            String tsp, String city, String state, String country, String email, String team) {
        this.name = name;
        this.nrc = nrc;
        this.wphone = wphone;
        this.mphone = mphone;
        this.jobPosition = jobPosition;
        this.dept = dept;
        this.deptMgr = deptMgr;
        this.address = address;
        this.tsp = tsp;
        this.city = city;
        this.state = state;
        this.country = country;
        this.email = email;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getWphone() {
        return wphone;
    }

    public void setWphone(String wphone) {
        this.wphone = wphone;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptMgr() {
        return deptMgr;
    }

    public void setDeptMgr(String deptMgr) {
        this.deptMgr = deptMgr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTsp() {
        return tsp;
    }

    public void setTsp(String tsp) {
        this.tsp = tsp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
