/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import zgpdistribution.util.oops.Customer;

/**
 *
 * @author John
 */
public class CustomerDAO {
    private Connection conn;

    public CustomerDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public boolean save(Customer data){
        String sql = "insert into customerinfo (outletName, customerName, address,"
                + "township, city, country, email, phone, coustomerType) value (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getOutletName());
            ps.setString(2, data.getCustomerName());
            ps.setString(3, data.getAddress());
            ps.setString(4, data.getTownship());
            ps.setString(5, data.getCity());
            ps.setString(6, data.getState());
            ps.setString(7, data.getCountry());
            ps.setString(8, data.getEmail());
            ps.setString(9, data.getPhone());
            ps.setString(10, data.getCustomerType());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public ArrayList<Customer> queryAll(){
        String sql = "select * from customerinfo";
        ArrayList<Customer> customerList = null;
        try {
            customerList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                customerList.add(new Customer(rs.getString("outletName"), rs.getString("customerName"), rs.getString("address"), rs.getString("twonship"), rs.getString("city"), rs.getString("state"), rs.getString("country"), rs.getString("email"), rs.getString("phone"), rs.getString("customerType")));
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return customerList;
    }
    
}
