/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;


import dao.DaoRack;
import Model.Rack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import enlaceBD.ConectaDb;
/**
 *
 * @author Luigi
 */
public class DaoRackImpl implements DaoRack{
    
   private final ConectaDb db;
   
   public DaoRackImpl() {
        db = new ConectaDb();
   }

    @Override
    public List<Rack> rackQry(Integer idDistributionCenter, Integer idWarehouse, String idIdentifier) {        
        List<Rack> list = null;
        String sql = "SELECT "
                + "idRack, "
                + "identifier, "
                + "description, "
                + "length, "    
                + "width, "
                + "floor_numbers, "
                + "height_per_floor, "
                + "resistance_weigth_per_floor, "
                + "column_number, "
                + "status, "
                + "created_at, "
                + "updated_at, "
                + "Warehouse_idWarehouse, "
                + "Warehouse_Distribution_Center_idDistribution_Center, "
                + "user_created, "
                + "user_updated "
                + "FROM Rack "
                + "WHERE "
                + "Warehouse_Distribution_Center_idDistribution_Center = ? AND "
                + "Warehouse_idWarehouse LIKE ? AND "
                + "identifier LIKE ?;";
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);                
                
                ps.setInt(1, idDistributionCenter);
                ps.setInt(2, idWarehouse);
                ps.setString(3, "%"+idIdentifier+"%");
                
                ResultSet rs = ps.executeQuery();
                  
                list = new LinkedList<>();
                while (rs.next()) {
                    Rack c = new Rack();
                    c.setIdRack(rs.getInt(1));
                    c.setIdentifier(rs.getString(2));
                    c.setDescription(rs.getString(3));
                    c.setLength(rs.getDouble(4));
                    c.setWidth(rs.getDouble(5));
                    c.setFloor_numbers(rs.getInt(6));
                    c.setHeight_per_floor(rs.getInt(7));
                    c.setResistance_weigth_per_floor(rs.getInt(8));
                    c.setColumn_number(rs.getInt(9));
                    c.setStatus(rs.getInt(10));
                    c.setWarehouse_idWarehouse(rs.getInt(13));
                    c.setWarehouse_Distribution_Center_idDistribution_Center(rs.getInt(14));
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
    public void rackIns(Rack rack) {
        String sql = "INSERT INTO Rack ("
                + "idRack, "
                + "identifier, "
                + "description, "
                + "length, "    
                + "width, "
                + "floor_numbers, "
                + "height_per_floor, "
                + "resistance_weigth_per_floor, "
                + "column_number, "
                + "status, "
                + "created_at, "
                + "updated_at, "
                + "Warehouse_idWarehouse, "
                + "Warehouse_Distribution_Center_idDistribution_Center, "
                + "user_created, "
                + "user_updated) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?;?,'',?,?,?,'');";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    ps.setInt(1, rack.getIdRack());
                    ps.setString(2, rack.getIdentifier());
                    ps.setString(3, rack.getDescription());
                    ps.setDouble(4, rack.getLength());
                    ps.setDouble(5, rack.getWidth());
                    ps.setInt(6, rack.getFloor_numbers());
                    ps.setInt(7, rack.getHeight_per_floor());
                    ps.setInt(8, rack.getResistance_weigth_per_floor());
                    ps.setInt(9, rack.getColumn_number());
                    ps.setInt(10, 1);
                    ps.setTimestamp(11, rack.getCreated_at());
                    ps.setInt(12, rack.getWarehouse_idWarehouse());
                    ps.setInt(13, rack.getWarehouse_Distribution_Center_idDistribution_Center());
                    ps.setInt(14, rack.getUser_created());
                    ps.executeUpdate();
                }

            } catch (SQLException e) {
                //
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        
    }

    @Override
    public void rackDel(Rack rack) {
        String sql = "UPDATE Rack SET "                
                + "status=?, "
                + "updated_at=?, "
                + "user_updated=?; ";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {                    
                    ps.setInt(1, 0);
                    ps.setTimestamp(2, rack.getUpdated_at());
                    ps.setInt(3, rack.getUser_updated());
                    ps.executeUpdate();
                }

            } catch (SQLException e) {
                //
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }        
    }

    @Override
    public Rack rackGet(String identifier_rack) {
        Rack rack = new Rack();
        
        return rack;
    }

    @Override
    public void rackUpd(Rack rack) {
        String sql = "UPDATE Rack SET "
                + "identifier=?, "
                + "description=?, "
                + "length=?, "    
                + "width=?, "
                + "floor_numbers=?, "
                + "height_per_floor=?, "
                + "resistance_weigth_per_floor=?, "
                + "column_number=?, "
                + "status=?, "
                + "updated_at=?, "
                + "user_updated=?; ";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    ps.setString(1, rack.getIdentifier());
                    ps.setString(2, rack.getDescription());
                    ps.setDouble(3, rack.getLength());
                    ps.setDouble(4, rack.getWidth());
                    ps.setInt(5, rack.getFloor_numbers());
                    ps.setInt(6, rack.getHeight_per_floor());
                    ps.setInt(7, rack.getResistance_weigth_per_floor());
                    ps.setInt(8, rack.getColumn_number());
                    ps.setInt(9, 1);
                    ps.setTimestamp(10, rack.getUpdated_at());
                    ps.setInt(11, rack.getUser_updated());
                    ps.executeUpdate();
                }

            } catch (SQLException e) {
                //
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<Object[]> rackCbo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
