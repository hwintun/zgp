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
import zgpdistribution.util.oops.Items;

/**
 *
 * @author John
 */
public class ItemsDAO {

    private Connection conn;

    public ItemsDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(Items data) {
        String sql = "insert into items ( itemsName, itemsCode, category, Supplier,"
                + " unitPerGrams, stdPrices) value (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getItemsName());
            ps.setString(2, data.getItemsCode());
            ps.setString(3, data.getCategory());
            ps.setString(4, data.getSupplier());
            ps.setInt(5, data.getUnitPerGrams());
            ps.setInt(6, data.getStdPrices());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return true;
    }
    public ArrayList<Items> queryAll(){
        String sql = "select * from items";
        ArrayList<Items> itemsList = null;
        try {
            itemsList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                itemsList.add(new Items(rs.getString("itemsName"), rs.getString("itemsCode"), rs.getString("category"),
                        rs.getString("supplier"), rs.getInt("unitPerGrams"), rs.getInt("stdPrices")));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        
        return itemsList;
    }
}
