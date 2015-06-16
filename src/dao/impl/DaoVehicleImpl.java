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
                + "license_plate,"
                + "name,"
                + "capacity,"
                + "dispatch_number,"
                + "Vehicle_State_idVehicle_State,"
                + "Driver_idDriver "
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
                    ve.setLicense_plate(rs.getString(2));
                    ve.setName(rs.getString(3));
                    ve.setCapacity(rs.getDouble(4));
                    ve.setDispatchNumber(rs.getInt(5));
                    VehicleState veState = daoVehicleState.vehicleStateGet(rs.getInt(6));
                    ve.setVehicleState(veState);
                    Driver driver = daoDriver.driverGet(rs.getInt(7));
                    ve.setDriver(driver);
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
                    + "license_plate,"
                + "name,"
                + "capacity,"
                  +"dispatch_number,"
                + "Vehicle_State_idVehicle_State,"
                + "Driver_idDriver "
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
                    vehicle.setLicense_plate(rs.getString(2));
                    vehicle.setName(rs.getString(3));
                    vehicle.setCapacity(rs.getDouble(4));
                    vehicle.setDispatchNumber(rs.getInt(5));
                    VehicleState veState = daoVehicleState.vehicleStateGet(rs.getInt(6));
                    vehicle.setVehicleState(veState);
                    Driver driver = daoDriver.driverGet(rs.getInt(7));
                    vehicle.setDriver(driver);
                    
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String result = null;
        String sql = "UPDATE Vehicle SET "
                + "dispatch_number = ? "
                + "WHERE idVehicle = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,vehicle.getDispatchNumber());
                ps.setInt(2,vehicle.getIdVehicle());
                ps.executeUpdate();
            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }
        return result;
    }

    @Override
    public List<Vehicle> vehicleQry(Integer limit) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Vehicle> list = null;
        String sql =  "SELECT idVehicle,"
                + "license_plate,"
                + "name,"
                + "capacity,"
                + "dispatch_number,"
                + "Vehicle_State_idVehicle_State,"
                + "Driver_idDriver "
                +"FROM  vehicle "
                +"limit ?;";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,limit);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<>();
                while (rs.next()) {
                    Vehicle ve = new Vehicle();
                    ve.setIdVehicle(rs.getInt(1));
                    ve.setLicense_plate(rs.getString(2));
                    ve.setName(rs.getString(3));
                    ve.setCapacity(rs.getDouble(4));
                    ve.setDispatchNumber(rs.getInt(5));
                    VehicleState veState = daoVehicleState.vehicleStateGet(rs.getInt(6));
                    ve.setVehicleState(veState);
                    Driver driver = daoDriver.driverGet(rs.getInt(7));
                    ve.setDriver(driver);
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
    public String vehicleIns(Vehicle vehicle) {
        String result = null;
        String sql = "INSERT INTO Vehicle("
                + "license_plate,"
                + "name,"
                + "capacity,"
                + "dispatch_number,"
                + "status,"
                + "Vehicle_State_idVehicle_State,"
                + "Driver_idDriver"
                + ") VALUES(?,?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, vehicle.getLicense_plate());
                ps.setString(2, vehicle.getName());
                ps.setDouble(3, vehicle.getCapacity());
                ps.setInt(4, vehicle.getDispatchNumber());
                ps.setInt(5, 1);
                ps.setInt(6, vehicle.getVehicleState().getIdVehicleState());
                ps.setInt(7, vehicle.getDriver().getIdDriver());

                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    throw new SQLException("0 filas afectadas");
                }

            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }

        return result;
    }
    
}
                    
