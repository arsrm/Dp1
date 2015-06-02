/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.Distribution_Center;
import Model.Warehouse;
import dao.DaoWH;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mibisaoficina
 */
public class DaoWHImpl implements DaoWH{

    private final ConectaDb db;
    public DaoWHImpl() {
        db = new ConectaDb();
    }
    @Override
    public ArrayList<Warehouse> whQry() {
        ArrayList<Warehouse> list = new ArrayList<>();
        String sql = "SELECT "
                + "idWarehouse,"
                + "description, "
                + "status, "
                + "Type_Condition_idType_Condition, "
                + "Distribution_Center_idDistribution_Center "
                + "FROM Warehouse";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
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
              
        String sql = "INSERT INTO Warehouse ("
//                + "idWarehouse, "
                + "description, "
                + "status, "
                + "Type_Condition_idType_Condition, "
                + "Distribution_Center_idDistribution_Center "
                + ") VALUES(?,?,?,?)";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
//                ps.setInt(1, 1);
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
            result = WhsDel(id);
        }
        return result;
    }

    @Override
    public Warehouse whGet(Integer idwh) {
         Warehouse whs = null;
        String sql = "SELECT "
                + "description," 
                + "status," 
                + "Type_Condition_idType_Condition,"
                + "Distribution_Center_idDistribution_Center "
                + "FROM Warehouse WHERE idWarehouse=?";
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
                + "description=? "
                + "WHERE idWarehouse=?";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, whs.getDescription());
                ps.setInt(2, whs.getIdWarehouse());
                
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
    

    private String WhsDel(Integer idWarehouse) {
         String result = null;
        String sql = "UPDATE Warehouse SET "
                + "status = ? "
                + "WHERE idWarehouse = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, 0);//se cambia a cero el campo status
                ps.setInt(2, idWarehouse);
                
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
    public ArrayList<Warehouse> whSearchByID(Distribution_Center distribution_center) {
         ArrayList<Warehouse> list = new ArrayList<>();
        String sql = "SELECT "
                + "Distribution_Center_idDistribution_Center, "
                + "idWarehouse, "
                + "description, "
                + "status "
                + "FROM Warehouse "
                + "WHERE Distribution_Center_idDistribution_Center = ?; ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, distribution_center.getIdDistribution_Center());
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Warehouse c = new Warehouse();
                    
                    c.setDistribution_Center_idDistribution_Center(rs.getInt(1));
                    c.setIdWH(rs.getInt(2));
                    c.setDescription(rs.getString(3));
                    c.setStatus(rs.getInt(4));
                    list.add(c);
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
    public List<Warehouse> whSearch(Integer idWh, Integer idTypeCondition) {
       String sql=  null; 
       ArrayList<Warehouse> list = new ArrayList<>();
       if(idWh!=0){
        sql = "SELECT "
                + "idWarehouse,"
                + "description, "
                + "status, "
                + "Type_Condition_idType_Condition, "
                + "Distribution_Center_idDistribution_Center "
                + "FROM Warehouse "
                + "WHERE  Type_Condition_idType_Condition=? "
                + "AND idWarehouse=?";
       }
       else {
           sql = "SELECT "
                + "idWarehouse,"
                + "description, "
                + "status, "
                + "Type_Condition_idType_Condition, "
                + "Distribution_Center_idDistribution_Center "
                + "FROM Warehouse "
                + "WHERE  Type_Condition_idType_Condition=? ";
       }
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idTypeCondition);
                if(idWh!=0) ps.setInt(2, idWh);
                ResultSet rs = ps.executeQuery();
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

  
    
}
