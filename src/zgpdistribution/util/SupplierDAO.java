/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import zgpdistribution.util.oops.Supplier;

/**
 *
 * @author John
 */
public class SupplierDAO {
    private Connection conn;

    public SupplierDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public boolean save(Supplier data){
        String sql = "insert into supplier (name) value (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public ArrayList<Supplier> queryAll(){
        String sql = "select * from supplier";
        ArrayList<Supplier> supplierList = null;
        try {
            supplierList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                supplierList.add(new Supplier(rs.getString("name")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return supplierList;
    }
    
}
