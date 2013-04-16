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
import zgpdistribution.util.oops.Country;

/**
 *
 * @author John
 */
public class CountryDAO {

    private Connection conn;

    public CountryDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public boolean save(Country data){
        String sql = "insert into country (name, code) value(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getName());
            ps.setString(2, data.getCode());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public ArrayList<Country> queryAll(){
      String sql = "select * from country";
      ArrayList<Country> countryList = null;
        try {
            countryList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                countryList.add(new Country(rs.getString("name"), rs.getString("code")));
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return countryList;
    }
}
