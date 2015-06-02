/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.Driver;
import dao.DaoDriver;
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
public class DaoDriverImpl implements DaoDriver{
     private final ConectaDb db;
     public DaoDriverImpl() {
        db = new ConectaDb();
    }
     
    @Override
    public List<Driver> driverQry() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         List<Driver> list = null;
        String sql =  "SELECT idDriver,"
                + "name,"
                + "status,"
                + "user_created,"
                + "user_updated "
                +"FROM  driver";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<>();
                while (rs.next()) {
                    
                    Driver dr = new Driver();
                    dr.setIdDriver(rs.getInt(1));
                    dr.setName(rs.getString(2));
                    dr.setStatus(rs.getInt(3));
                    dr.setUserCreated(rs.getInt(4));
                    dr.setUserUpdated(rs.getInt(5));
                    list.add(dr);
                    
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
    public List<Driver> driverQry_search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String driverIns(Driver driver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String driverDel(List<String> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Driver driverGet(Integer idDriver) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Driver driver = null;
        //List<RequestOrder> requestOrderDetailList = null;
          String sql =  "SELECT idDriver,"
                + "name,"
                + "status,"
                + "user_created,"
                + "user_updated "
                + "FROM driver WHERE idDriver = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idDriver);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    driver = new Driver();
                    driver.setIdDriver(idDriver);
                    driver.setName(rs.getString(2));
                    driver.setStatus(rs.getInt(3));
                    driver.setUserCreated(rs.getInt(4));
                    driver.setUserUpdated(rs.getInt(5));
                }

            } catch (SQLException e) {
                driver = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return driver;
    }

    @Override
    public String driverUpd(Driver driver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
