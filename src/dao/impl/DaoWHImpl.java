/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.Warehouse;
import dao.DaoWH;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author CHACON
 */
public class DaoWHImpl implements DaoWH{

    private final ConectaDb db;

    public DaoWHImpl() {
        db = new ConectaDb();
    }
    
    @Override
    public List<Warehouse> whQry() {
        List<Warehouse> list = null;
        String sql = "SELECT "
                + "idWarehouse,"
                + "description, "
                + "status, "
                + "Type_Condition_WareHouse_idType_Condition_WareHouse, "
                + "Distribution_Center_idDistribution_Center "
                + "FROM Warehouse";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    Warehouse w = new Warehouse();
                    
                    w.setIdWH(rs.getInt(1));
                    w.setDescription(rs.getString(2));
                    w.setStatus(rs.getInt(3));
                    w.setType_Condition_WareHouse_idType_Condition_WareHouse(rs.getInt(4));
                    w.setDistribution_Center_idDistribution_Center(rs.getInt(5));
                   
                    list.add(w);
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
    public String whIns(Warehouse wh) {
    
        String result = null;
              
        String sql = "INSERT INTO Warehouse("
                + "description, "
                + "status, "
                + "Type_Condition_WareHouse_idType_Condition_WareHouse, "
                + "Distribution_Center_idDistribution_Center, "
                + ") VALUES(?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, wh.getDescription());
                ps.setInt(2, wh.getStatus());
                ps.setInt(3, wh.getType_Condition_WareHouse_idType_Condition_WareHouse());
                ps.setInt(4, wh.getDistribution_Center_idDistribution_Center());
               
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

    @Override
    public String whsDel(List<Integer> ids) {
         String result = null;

        for (Integer id : ids) {
            result = WhDel(id);
        }

        return result;
    }
    
    public String WhDel(Integer idWarehouse) {
        String result = null;
        String sql = "DELETE "
                + "FROM Warehouse "
                + "WHERE idWarehouse = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idWarehouse);
                ResultSet rs = ps.executeQuery();

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
    public Warehouse whGet(Integer idwh) {
        Warehouse whs = null;
        String sql = "SELECT "
                + "description," 
                + "status," 
                + "Type_Condition_WareHouse_idType_Condition_WareHouse,"
                + "Distribution_Center_idDistribution_Center "
                + "FROM Warehouse whs WHERE whs.idWarehouse=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idwh);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    whs = new Warehouse();

                    whs.setIdWH(idwh);
                    whs.setDescription(rs.getString(1));
                    whs.setStatus(rs.getInt(2));
                    whs.setType_Condition_WareHouse_idType_Condition_WareHouse(rs.getInt(3));
                    whs.setDistribution_Center_idDistribution_Center(rs.getInt(4));
                    

                }

            } catch (SQLException e) {
                whs = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return whs;
    }
    
    @Override
    public String whUpd(Warehouse whs) {
        String result = null;
        String sql = "UPDATE  Warehouse SET "
                + "description=?, "
                + "status=?, "
                + "Type_Condition_WareHouse_idType_Condition_WareHouse=?, "
                + "Distribution_Center_idDistribution_Center=? "
                + "WHERE idWarehouse=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, whs.getDescription());
                ps.setInt(2, whs.getStatus());
                ps.setInt(5, whs.getType_Condition_WareHouse_idType_Condition_WareHouse()); 
                ps.setInt(7, whs.getDistribution_Center_idDistribution_Center());
                
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
    
}
