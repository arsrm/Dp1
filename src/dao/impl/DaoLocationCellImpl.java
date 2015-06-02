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
    public LocationCell LocationCellGet(Integer idLocCell) {
        LocationCell locCell = null;
        String sql = "SELECT "
                + "description,"
                + "width,"
                + "length,"
                + "height,"
                + "row,"
                + "column,"
                + "status,"
                + "Location_State_idLocation_State,"
                + "Rack_idRack,"
                + "Rack_Warehouse_idWarehouse "
                + "FROM Location_Cell "
                + "WHERE idLocation_Cell = ?";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idLocCell);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    locCell = new LocationCell();

                    locCell.setIdLocation_Cell(idLocCell);
                    locCell.setDescription(rs.getString(1));
                    locCell.setWidth(rs.getDouble(2));
                    locCell.setLength(rs.getDouble(3));
                    locCell.setHeight(rs.getInt(4));
                    locCell.setRow_Cell(rs.getInt(5));
                    locCell.setColumn_Cell(rs.getInt(6));
                    locCell.setStatus(rs.getInt(7));
                    locCell.setLocation_State_idLocation_State(rs.getInt(8));
                    locCell.setRack_idRack(rs.getInt(9));
                    locCell.setRack_Warehouse_idWarehouse(rs.getInt(10));
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
    public String LocationCellAvailabilityUpd(Integer idLocCell,Integer idLocCellDetail,Integer status) {
        String result = null;
        String sql = "UPDATE Location_Cell_Detail SET "
                + "availability = ? "
                + "WHERE idLocation_Cell_Detail = ? "
                +"AND Location_Cell_idLocation_Cell = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, status);
                ps.setInt(2, idLocCellDetail);
                ps.setInt(3, idLocCell);

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
