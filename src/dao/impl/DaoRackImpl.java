/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;


import Model.LocationCell;
import Model.LocationCellDetail;
import Model.Rack;
import Model.Warehouse;
import dao.DaoRack;
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
                + "identifier, "
                + "description, "
                + "length, "    
                + "width, "
                + "floor_numbers, "
                + "height_per_floor, "
                + "resistance_weigth_per_floor, "
                + "column_number, "
                + "status, "
                + "Warehouse_idWarehouse, "
                + "Warehouse_Distribution_Center_idDistribution_Center) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);

                ps.setString(1, rack.getIdentifier());
                ps.setString(2, rack.getDescription());
                ps.setDouble(3, rack.getLength());
                ps.setDouble(4, rack.getWidth());
                ps.setInt(5, rack.getFloor_numbers());
                ps.setInt(6, rack.getHeight_per_floor());
                ps.setInt(7, rack.getResistance_weigth_per_floor());
                ps.setInt(8, rack.getColumn_number());
                ps.setInt(9, 1);
                ps.setInt(10, rack.getWarehouse_idWarehouse());
                ps.setInt(11, rack.getWarehouse_Distribution_Center_idDistribution_Center());
                ps.executeUpdate();
                
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
    public int rackDel(Integer idRack, Integer statusToChange) {
        String sql = "UPDATE Rack SET "                
                + "status=? "
                + "WHERE idRack=?;";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                
                PreparedStatement ps = cn.prepareStatement(sql);                   
                ps.setInt(1, statusToChange);
                ps.setInt(2, idRack);
                ps.executeUpdate();
                
            } catch (SQLException e) {
                e.getMessage();
                return 0;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return 1;
    }

    @Override
    public Rack rackGet(Integer idRack) {
        Rack rack = null;
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
                + "Warehouse_idWarehouse, "
                + "Warehouse_Distribution_Center_idDistribution_Center "
                + "FROM Rack WHERE idRack = ?;";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idRack);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    rack = new Rack();
                    rack.setIdRack(rs.getInt(1));
                    rack.setIdentifier(rs.getString(2));
                    rack.setDescription(rs.getString(3));
                    rack.setLength(rs.getDouble(4));
                    rack.setWidth(rs.getDouble(5));
                    rack.setFloor_numbers(rs.getInt(6));
                    rack.setHeight_per_floor(rs.getInt(7));
                    rack.setResistance_weigth_per_floor(rs.getInt(8));
                    rack.setColumn_number(rs.getInt(9));
                    rack.setStatus(rs.getInt(10));
                    rack.setWarehouse_idWarehouse(rs.getInt(11));
                    rack.setWarehouse_Distribution_Center_idDistribution_Center(rs.getInt(12));
                }
            } catch (SQLException e) {
                rack = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
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
                + "column_number=? "
                + "WHERE idRack=?;";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);                

                ps.setString(1, rack.getIdentifier());
                ps.setString(2, rack.getDescription());
                ps.setDouble(3, rack.getLength());
                ps.setDouble(4, rack.getWidth());
                ps.setInt(5, rack.getFloor_numbers());
                ps.setInt(6, rack.getHeight_per_floor());
                ps.setInt(7, rack.getResistance_weigth_per_floor());
                ps.setInt(8, rack.getColumn_number());
                ps.setInt(9, rack.getIdRack());
                ps.executeUpdate();
                
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

    @Override
    public boolean existsRackName(String rackName) {
        String sql = "SELECT "
                + "count(*) "
                + "FROM Rack WHERE identifier = ?;";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, rackName);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    if (rs.getInt(1)>0) return true;
                }
            } catch (SQLException e) {
                
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return false;
    }

    @Override
    public boolean rackInUse(Rack rack) {
        String sql = "SELECT "
                + "count(*) "
                + "FROM Pallet_By_Product_By_Location_Cell_Detail "
                + "WHERE Location_Cell_Detail_idDistribution_Center = ? AND "
                + "Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse = ? AND "
                + "Location_Cell_Detail_Location_Cell_Rack_idRack = ? AND "
                + "status = 1; ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, rack.getWarehouse_Distribution_Center_idDistribution_Center());
                ps.setInt(2, rack.getWarehouse_idWarehouse());
                ps.setInt(3, rack.getIdRack());

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    if (rs.getInt(1)>0) return true;
                }
            } catch (SQLException e) {
                
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return false;
    }

    @Override
    public int rackMaxIdGet() {
        int maxId=0;
        String sql = "SELECT "
                + "MAX(idRack) "
                + "FROM Rack;";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    maxId = rs.getInt(1);
                    return maxId;
                }
            } catch (SQLException e) {
                
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return -1;
    }

    @Override
    public void rackLocationCellsIns(LocationCell locationCell) {        
        String sql = "INSERT INTO Location_Cell ("
                + "idLocation_Cell, "
                + "description, "
                + "width, "    
                + "length, "
                + "height, "
                + "row_cell, "
                + "column_cell, "
                + "status, "
                + "Location_State_idLocation_State, "
                + "Rack_idRack, "
                + "Rack_Warehouse_idWarehouse, "
                + "Rack_Warehouse_Distribution_Center_idDistribution_Center) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, locationCell.getIdLocation_Cell());
                ps.setString(2, locationCell.getDescription());
                ps.setDouble(3, locationCell.getWidth());
                ps.setDouble(4, locationCell.getLength());
                ps.setInt(5, locationCell.getHeight());                
                ps.setInt(6, locationCell.getRow_Cell());
                ps.setInt(7, locationCell.getColumn_Cell());
                ps.setInt(8, locationCell.getStatus());
                ps.setInt(9, locationCell.getLocation_State_idLocation_State());
                ps.setInt(10, locationCell.getRack_idRack());
                ps.setInt(11, locationCell.getRack_Warehouse_idWarehouse());
                ps.setInt(12, locationCell.getRack_Warehouse_Distribution_Center_idDistribution_Center());
                ps.executeUpdate();
                
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
    public void rackLocationCellDetailIns(LocationCellDetail locationCellDetail) {
        String sql = "INSERT INTO Location_Cell_Detail ("
                + "idLocation_Cell_Detail, "
                + "description, "
                + "availability, "    
                + "Location_Cell_idLocation_Cell, "
                + "Location_Cell_Rack_idRack, "
                + "Location_Cell_Rack_Warehouse_idWarehouse, "
                + "idDistribution_Center) "
                + "VALUES (?,?,?,?,?,?,?);";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);

                ps.setInt(1, locationCellDetail.getIdLocation_Cell_Detail());
                ps.setString(2, locationCellDetail.getDescription());
                ps.setInt(3, locationCellDetail.getAvailability());
                ps.setInt(4, locationCellDetail.getLocation_Cell_idLocation_Cell());
                ps.setInt(5, locationCellDetail.getLocation_Cell_Rack_idRack());
                ps.setInt(6, locationCellDetail.getLocation_Cell_Rack_Warehouse_idWarehouse());
                ps.setInt(7, locationCellDetail.getIdDistribution_Center());
                ps.executeUpdate();
                
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
    public List<Rack> rackQueryByWarehouse(Warehouse warehouse) {
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
                + "Warehouse_idWarehouse, "
                + "Warehouse_Distribution_Center_idDistribution_Center "
                + "FROM Rack "
                + "WHERE "
                + "Warehouse_Distribution_Center_idDistribution_Center = ? AND "
                + "Warehouse_idWarehouse = ? ";
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                
                PreparedStatement ps = cn.prepareStatement(sql);                                
                ps.setInt(1, warehouse.getDistribution_Center_idDistribution_Center());
                ps.setInt(2, warehouse.getIdWarehouse());                
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
                    c.setWarehouse_idWarehouse(rs.getInt(11));
                    c.setWarehouse_Distribution_Center_idDistribution_Center(rs.getInt(12));
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
    
}
