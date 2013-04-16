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
import zgpdistribution.util.oops.City;

/**
 *
 * @author John
 */
public class CityDAO {

    private Connection conn;

    public CityDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(City data) {
        String sql = "insert into city (name, code) value (?,?)";
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
    
    public ArrayList<City> queryAll(){
        String sql = "select * from city";
        ArrayList<City> clist = null;
        try {
            clist = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                clist.add(new City(rs.getString("name"), rs.getString("code")));
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return clist;
    }
}
