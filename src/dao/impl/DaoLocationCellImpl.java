/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Model.LocationCell;
import Model.Rack;
import Model.Warehouse;
import dao.DaoLocationCell;
import dao.DaoRack;
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
 * @author Gustavo
 */
public class DaoLocationCellImpl implements DaoLocationCell {

    private final ConectaDb db;
    DaoRack daoRack = new DaoRackImpl();
    DaoWH daoWh = new DaoWHImpl();

    public DaoLocationCellImpl() {
        db = new ConectaDb();
    }

    @Override
    public LocationCell LocationCellGet(Integer idDistributionCenter, Integer idWarehouse, Integer idRack, Integer idLocCell) {
        LocationCell locCell = null;
        String sql = "SELECT "
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
                + "Rack_Warehouse_Distribution_Center_idDistribution_Center "
                + "FROM Location_Cell "
                + "WHERE Rack_Warehouse_Distribution_Center_idDistribution_Center = ? AND "
                + "Rack_Warehouse_idWarehouse = ? AND "
                + "Rack_idRack = ? AND "
                + "idLocation_Cell = ?;";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idDistributionCenter);
                ps.setInt(2, idWarehouse);
                ps.setInt(3, idRack);
                ps.setInt(4, idLocCell);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    locCell = new LocationCell();
                    
                    locCell.setIdLocation_Cell(rs.getInt(1));
                    locCell.setDescription(rs.getString(2));
                    locCell.setWidth(rs.getDouble(3));
                    locCell.setLength(rs.getDouble(4));
                    locCell.setHeight(rs.getInt(5));
                    locCell.setRow_Cell(rs.getInt(6));
                    locCell.setColumn_Cell(rs.getInt(7));
                    locCell.setStatus(rs.getInt(8));
                    locCell.setLocation_State_idLocation_State(rs.getInt(9));
                    locCell.setRack_idRack(rs.getInt(10));
                    locCell.setRack_Warehouse_idWarehouse(rs.getInt(11));
                    locCell.setRack_Warehouse_Distribution_Center_idDistribution_Center(rs.getInt(12));
                }

            } catch (SQLException e) {
                locCell = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return locCell;

    }

    @Override
    public String LocationCellAvailabilityUpd(Integer idDistCenter,Integer idWh, Integer idRack,Integer idLocCell,Integer idLocCellDetail,Integer status) {
        String result = null;
        String sql = "UPDATE Location_Cell_Detail SET "
                + "availability = ? "
                + "WHERE idLocation_Cell_Detail = ? "
                + "AND Location_Cell_Rack_Warehouse_idWarehouse = ? "
                + "AND Location_Cell_Rack_idRack = ? "
                +"AND Location_Cell_idLocation_Cell = ? "
                +"AND idDistribution_Center = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, status);
                ps.setInt(2, idLocCellDetail);
                ps.setInt(3, idWh);
                ps.setInt(4, idRack);
                ps.setInt(5, idLocCell);
                ps.setInt(6, idDistCenter);

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
    public List<LocationCell> locationCellByRack(Rack rack) {
        List<LocationCell> list = null;
        String sql = "SELECT "
                + "Rack_Warehouse_Distribution_Center_idDistribution_Center, "
                + "Rack_Warehouse_idWarehouse, "
                + "Rack_idRack, "
                + "idLocation_Cell, "    
                + "Location_State_idLocation_State, "
                + "description, "
                + "width, "
                + "length, "
                + "height, "
                + "row_cell, "
                + "column_cell, "
                + "status "
                + "FROM Location_Cell "
                + "WHERE "
                + "Rack_Warehouse_Distribution_Center_idDistribution_Center = ? AND "
                + "Rack_Warehouse_idWarehouse = ? AND "
                + "Rack_idRack = ?";
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                
                PreparedStatement ps = cn.prepareStatement(sql);                                
                ps.setInt(1, rack.getWarehouse_Distribution_Center_idDistribution_Center());
                ps.setInt(2, rack.getWarehouse_idWarehouse());
                ps.setInt(3, rack.getIdRack());
                ResultSet rs = ps.executeQuery();
                  
                list = new LinkedList<>();
                while (rs.next()) {
                    LocationCell locationCell = new LocationCell();
                    locationCell.setRack_Warehouse_Distribution_Center_idDistribution_Center(rs.getInt(1));
                    locationCell.setRack_Warehouse_idWarehouse(rs.getInt(2));
                    locationCell.setRack_idRack(rs.getInt(3));
                    locationCell.setIdLocation_Cell(rs.getInt(4));
                    locationCell.setLocation_State_idLocation_State(rs.getInt(5));
                    locationCell.setDescription(rs.getString(6));
                    locationCell.setWidth(rs.getDouble(7));
                    locationCell.setLength(rs.getDouble(8));
                    locationCell.setHeight(rs.getInt(9));
                    locationCell.setRow_Cell(rs.getInt(10));
                    locationCell.setColumn_Cell(rs.getInt(11));
                    locationCell.setStatus(rs.getInt(12));                    
                    list.add(locationCell);
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
    public void locationCellChangeState(LocationCell locationCell, Integer statusToChange) {
        String sql = "UPDATE Location_Cell SET "                
                + "status=? "
                + "WHERE Rack_Warehouse_Distribution_Center_idDistribution_Center = ? AND "
                + "Rack_Warehouse_idWarehouse = ? AND "
                + "Rack_idRack = ? AND "
                + "idLocation_Cell = ?;";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                
                PreparedStatement ps = cn.prepareStatement(sql);                   
                ps.setInt(1, statusToChange);
                ps.setInt(2, locationCell.getRack_Warehouse_Distribution_Center_idDistribution_Center());
                ps.setInt(3, locationCell.getRack_Warehouse_idWarehouse());
                ps.setInt(4, locationCell.getRack_idRack());
                ps.setInt(5, locationCell.getIdLocation_Cell());
                ps.executeUpdate();
                
            } catch (SQLException e) {
                e.getMessage();
                
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        
    }

    @Override
    public boolean locationCellInUse(LocationCell locationCell) {
        String sql = "SELECT "
                + "count(*) "
                + "FROM Pallet_By_Product_By_Location_Cell_Detail "
                + "WHERE Location_Cell_Detail_idDistribution_Center = ? AND "
                + "Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse = ? AND "
                + "Location_Cell_Detail_Location_Cell_Rack_idRack = ? AND "
                + "Location_Cell_Detail_Location_Cell_idLocation_Cell = ? AND "
                + "status = 1; ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, locationCell.getRack_Warehouse_Distribution_Center_idDistribution_Center());
                ps.setInt(2, locationCell.getRack_Warehouse_idWarehouse());
                ps.setInt(3, locationCell.getRack_idRack());
                ps.setInt(4, locationCell.getIdLocation_Cell());

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
    public void LocationCellAvailabilityUpd(LocationCell locationCell, Integer statusToChange) {
        String sql = "UPDATE Location_Cell_Detail SET "                
                + "availability=? "
                + "WHERE idDistribution_Center = ? AND "
                + "Location_Cell_Rack_Warehouse_idWarehouse = ? AND "
                + "Location_Cell_Rack_idRack = ? AND "
                + "Location_Cell_idLocation_Cell = ?;";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                
                PreparedStatement ps = cn.prepareStatement(sql);                   
                ps.setInt(1, statusToChange);
                ps.setInt(2, locationCell.getRack_Warehouse_Distribution_Center_idDistribution_Center());
                ps.setInt(3, locationCell.getRack_Warehouse_idWarehouse());
                ps.setInt(4, locationCell.getRack_idRack());
                ps.setInt(5, locationCell.getIdLocation_Cell());
                ps.executeUpdate();
                
            } catch (SQLException e) {
                e.getMessage();
                
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
