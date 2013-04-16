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
import zgpdistribution.util.oops.Warehouse;

/**
 *
 * @author HWT
 */
public class WarehouseDAO {
    private Connection conn;

    public WarehouseDAO() {
        try {
            conn = DataSourceConnection.initDB();
        }catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }
    
    public boolean save(Warehouse data) {
        String sql = "insert into warehouseinfo (name, address, township, city, state, phone, whsvr) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, data.getName());
            pstat.setString(2, data.getAddress());
            pstat.setString(3, data.getTownship());
            pstat.setString(4, data.getCity());
            pstat.setString(5, data.getState());
            pstat.setString(6, data.getPhone());
            pstat.setString(7, data.getWhsvr());
            pstat.executeUpdate();
        }catch (Exception exc) {
            System.err.println(exc.getMessage());
            return false;
        }        
        return true;
    }
    
    public ArrayList<Warehouse> queryAllData() {
        String sql = "select * from warehouseinfo";
        ArrayList<Warehouse> whlist = null;
        try {
            whlist = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                whlist.add(new Warehouse(rs.getString("name"),rs.getString("address"),rs.getString("township"), 
                        rs.getString("city"), rs.getString("state"),rs.getString("country"), rs.getString("phone"), 
                        rs.getString("whsvr")));
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return whlist; 
    }
}
