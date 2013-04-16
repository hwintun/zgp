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
import zgpdistribution.util.oops.Department;

/**
 *
 * @author John
 */
public class DepartmentDAO {

    private Connection conn;

    public DepartmentDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public boolean save(Department data){
        String sql = "insert into dept(name)value(?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public ArrayList<Department> queryAll(){
        String sql = "select * from dept";
        ArrayList<Department> departmentList = null;
        try {
            departmentList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                departmentList.add(new Department(rs.getString("name")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
        return departmentList;
    }
}
