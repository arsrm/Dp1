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
                + "description "
                + "created_at "
                + "deleted_at "
                + "update_at " 
                + "Type_Condition_WareHouse_idType_Condition_WareHouse "
                + "Type_Product_idType_Product "
                + "Distribution_Center_idDistribution_Center "
                + "Warehousecol "
                
                + "FROM Warehouse";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    Warehouse c = new Warehouse();
                    
                    c.setIdWH(rs.getInt(1));
                    c.setDescription(rs.getString(2));
                    c.setCreated_at(rs.getTimestamp(3));
                    c.setDeleted_at(rs.getTimestamp(4));
                    c.setUpdate_at(rs.getTimestamp(5));
                    c.setType_Condition_WareHouse_idType_Condition_WareHouse(rs.getInt(6));
                    c.setType_Product_idType_Product(rs.getInt(7));
                    c.setDistribution_Center_idDistribution_Center(rs.getInt(8));
                    c.setWarehousecol(rs.getString(9));
                   
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
    public String whIns(Warehouse whs) {
    
        String result = null;
        String sql = "INSERT INTO Warehouse("
                + "description"
                + "created_at"
                + "deleted_at"
                + "update_at" 
                + "Type_Condition_WareHouse_idType_Condition_WareHouse"
                + "Type_Product_idType_Product"
                + "Distribution_Center_idDistribution_Center"
                + "Warehousecol"
                + ") VALUES(?,?,?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, whs.getDescription());
                ps.setTimestamp(2, whs.getCreated_at());
                ps.setTimestamp(3, whs.getDeleted_at());
                ps.setTimestamp(4, whs.getUpdate_at());
                ps.setInt(5, whs.getType_Condition_WareHouse_idType_Condition_WareHouse());
                ps.setInt(6,whs.getType_Product_idType_Product());
                ps.setInt(7, whs.getDistribution_Center_idDistribution_Center());
                ps.setString(8, whs.getWarehousecol());
               

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
    public String whDel(List<Integer> ids) {
        String result = null;
        String sql = "DELETE FROM User WHERE idWerehause=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (Integer x : ids) {
                    ps.setInt(1, x);

                    int ctos = ps.executeUpdate();
                    if (ctos == 0) {
                        throw new SQLException("ID: " + x + " no existe");
                    }
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
    public Warehouse whGet(Integer idwh) {
        Warehouse whs = null;
        String sql = "SELECT "
                + "description"
                + "created_at"
                + "deleted_at"
                + "update_at" 
                + "Type_Condition_WareHouse_idType_Condition_WareHouse"
                + "Type_Product_idType_Product"
                + "Distribution_Center_idDistribution_Center"
                + "Warehousecol"
                + "FROM Warehouse WHERE idWarehouse=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idwh);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    whs = new Warehouse();

                    whs.setIdWH(rs.getInt(1));
                    whs.setDescription(rs.getString(2));
                    whs.setCreated_at(rs.getTimestamp(3));
                    whs.setDeleted_at(rs.getTimestamp(4));
                    whs.setUpdate_at(rs.getTimestamp(5));
                    whs.setType_Condition_WareHouse_idType_Condition_WareHouse(rs.getInt(6));
                    whs.setType_Product_idType_Product(rs.getInt(7));
                    whs.setDistribution_Center_idDistribution_Center(rs.getInt(8));
                    whs.setWarehousecol(rs.getString(9));
                    

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
                + "created_at=? "
                + "deleted_at=? "
                + "update_at=? "
                + "Type_Condition_WareHouse_idType_Condition_WareHouse=? "
                + "Type_Product_idType_Product=? " 
                + "Distribution_Center_idDistribution_Center=? "
                + "Warehousecol=? "
                + "WHERE idWarehouse=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, whs.getDescription());
                ps.setTimestamp(2, whs.getCreated_at());
                ps.setTimestamp(3, whs.getDeleted_at());
                ps.setTimestamp(4, whs.getUpdate_at());
                ps.setInt(5, whs.getType_Condition_WareHouse_idType_Condition_WareHouse());
                ps.setInt(6, whs.getType_Product_idType_Product()); 
                ps.setInt(7, whs.getDistribution_Center_idDistribution_Center());
                ps.setString(8, whs.getWarehousecol());
                

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
