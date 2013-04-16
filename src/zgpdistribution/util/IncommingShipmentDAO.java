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
import zgpdistribution.util.oops.IncommingShipment;

/**
 *
 * @author John
 */
public class IncommingShipmentDAO {

    private Connection conn;

    public IncommingShipmentDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(IncommingShipment data) {
        String sql = "insert into incommingshipment (supplier, actualDate, transitionDate)"
                + " value (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getSupplier());
            ps.setString(2, data.getActualDate());
            ps.setString(3, data.getTransitionDate());
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList<IncommingShipment> queryAll() {
        String sql = "select * from incommingshipment";
        ArrayList<IncommingShipment> incommingShipmentList = null;
        try {
            incommingShipmentList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                incommingShipmentList.add(new IncommingShipment(rs.getString("supplier"),
                        rs.getString("actualDate"), rs.getString("transitionDate")));
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return incommingShipmentList;
    }
}
