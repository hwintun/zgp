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
import zgpdistribution.util.oops.Position;

/**
 *
 * @author John
 */
public class PositionDAO {

    private Connection conn;

    public PositionDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(Position data) {
        String sql = "insert into position (position) value (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getPosition());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PositionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList<Position> queryAll() {
        String sql = "select * from position";
        ArrayList<Position> positionList = null;
        try {
            positionList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                positionList.add(new Position(rs.getString("position")));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PositionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return positionList;
    }
}
