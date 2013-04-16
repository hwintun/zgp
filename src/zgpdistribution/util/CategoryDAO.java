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
import zgpdistribution.util.oops.Category;

/**
 *
 * @author John
 */
public class CategoryDAO {
    private Connection conn;

    public CategoryDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public boolean save(Category data){
        String sql = "insert into category (name) value (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
        return true;
    }
    public ArrayList<Category> queryAll(){
        String sql = "select * from category";
        ArrayList<Category> categoryList = null;
        try {
            categoryList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                categoryList.add(new Category(rs.getString("name")));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return categoryList;
    }
    
    
}
