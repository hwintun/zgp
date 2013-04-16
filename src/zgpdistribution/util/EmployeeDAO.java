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
import zgpdistribution.util.oops.Employee;

/**
 *
 * @author John
 */
public class EmployeeDAO {

    private Connection conn;

    public EmployeeDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(Employee data) {
        String sql = "insert into employeeinfo (name, NRC, wPhone, mPhone, "
                + "jobPosition, dept, deptMgr, address, tsp, city, state, country,email,team) "
                + "vlaue (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getName());
            ps.setString(2, data.getNrc());
            ps.setString(3, data.getWphone());
            ps.setString(4, data.getMphone());
            ps.setString(5, data.getJobPosition());
            ps.setString(6, data.getDept());
            ps.setString(7, data.getDeptMgr());
            ps.setString(8, data.getAddress());
            ps.setString(9, data.getTsp());
            ps.setString(10, data.getCity());
            ps.setString(11, data.getState());
            ps.setString(12, data.getCountry());
            ps.setString(13, data.getEmail());
            ps.setString(14, data.getTeam());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    public ArrayList<Employee> queryAll() {
        String sql = "select * from employeeinfo";
        ArrayList<Employee> employeeList = null;
        try {
            employeeList = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from employeeinfo");
            while (rs.next()) {
                employeeList.add(new Employee(rs.getString("name"), rs.getString("NRC"),
                        rs.getString("wPhone"), rs.getString("mPhone"), rs.getString("jobPosition"),
                        rs.getString("dept"), rs.getString("deptMgr"), rs.getString("address"), rs.getString("tsp"),
                        rs.getString("city"), rs.getString("state"), rs.getString("country"), rs.getString("email"),
                        rs.getString("team")));
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return employeeList;
    }
}
