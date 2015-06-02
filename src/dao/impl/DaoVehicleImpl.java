/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.Driver;
import Model.Vehicle;
import Model.VehicleState;
import dao.DaoDriver;
import dao.DaoVehicle;
import dao.DaoVehicleState;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public class DaoVehicleImpl implements DaoVehicle {
    private final ConectaDb db;
    private DaoVehicleState daoVehicleState = new DaoVehicleStateImpl();
    private DaoDriver daoDriver = new DaoDriverImpl();
    
    public DaoVehicleImpl() {
        db = new ConectaDb();
    }
    
    @Override
    public List<Vehicle> vehicleQry() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Vehicle> list = null;
        String sql =  "SELECT idVehicle,"
                + "capacity,"
                + "dispatch_number,"
                + "status,"
                + "Vehicle_State_idVehicle_State,"
                + "Driver_idDriver,"
                + "user_created,"
                + "user_updated "
                +"FROM  vehicle";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<>();
                while (rs.next()) {
                    Vehicle ve = new Vehicle();
                    ve.setIdVehicle(rs.getInt(1));
                    ve.setCapacity(rs.getDouble(2));
                    ve.setDispatchNumber(rs.getInt(3));
                    ve.setStatus(rs.getInt(4));
                    VehicleState veState = daoVehicleState.vehicleStateGet(rs.getInt(5));
                    ve.setVehicleState(veState);
                    Driver driver = daoDriver.driverGet(rs.getInt(6));
                    ve.setUserCreated(rs.getInt(7));
                    ve.setUserUpdated(rs.getInt(8));
                    list.add(ve);
                }

            } catch (SQLException e) {
                list = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return list;
    }

    

    @Override
    public Vehicle vehicleGet(Integer idvehicle) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Vehicle vehicle = null;
        //List<RequestOrder> requestOrderDetailList = null;
          String sql =  "SELECT idVehicle,"
                + "capacity,"
                + "dispatch_number,"
                + "status,"
                + "State_Request_Order_idStateRequest_Order,"
                + "Driver_idDriver,"
                + "user_created,"
                + "user_updated "
                + "FROM vehicle WHERE idVehicle = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idvehicle);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    vehicle = new Vehicle();
                    vehicle.setIdVehicle(idvehicle);
                    vehicle.setCapacity(rs.getDouble(2));
                    vehicle.setDispatchNumber(rs.getInt(3));
                    vehicle.setStatus(rs.getInt(4));
                    VehicleState veState = daoVehicleState.vehicleStateGet(rs.getInt(5));
                    vehicle.setVehicleState(veState);
                    Driver driver = daoDriver.driverGet(rs.getInt(6));
                    vehicle.setUserCreated(rs.getInt(7));
                    vehicle.setUserUpdated(rs.getInt(8));
                    
                }

            } catch (SQLException e) {
                vehicle = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return vehicle;
    }

    @Override
    public String vehicleUpd(Vehicle vehicle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
