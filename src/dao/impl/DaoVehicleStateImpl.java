/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.VehicleState;
import dao.DaoVehicleState;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public class DaoVehicleStateImpl implements DaoVehicleState {
    private final ConectaDb db;
    public DaoVehicleStateImpl() {
        db = new ConectaDb();
    }
    @Override
    public List<VehicleState> vehicleStateQry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VehicleState> vehicleStateQry_search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vehicleStateIns(VehicleState vehicleState) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vehicleStateDel(List<String> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VehicleState vehicleStateGet(Integer idvehicleState) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        VehicleState vehicleState = null;
         
          String sql =  "SELECT idVehicle_State,"
                + "description,"
                + "status,"
                + "user_created,"
                + "user_updated "
                + "FROM vehicle_state WHERE idVehicle_State = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idvehicleState);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    vehicleState = new VehicleState();
                    vehicleState.setIdVehicleState(idvehicleState);
                    vehicleState.setDescription(rs.getString(2));
                    vehicleState.setStatus(rs.getInt(3));
                    vehicleState.setUserCreated(rs.getInt(4));
                    vehicleState.setUserUpdated(rs.getInt(5));
                }

            } catch (SQLException e) {
                vehicleState = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return vehicleState;
    }

    @Override
    public String vehicleStateUpd(VehicleState vehicleState) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
