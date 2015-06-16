package dao.impl;

import Model.LocationCell;
import Model.LocationCellDetail;
import Model.LocationCellDetailInventory;
import dao.DaoLocationCellDetail;
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
 * @author Gustavo
 */
public class DaoLocationCellDetailImpl implements DaoLocationCellDetail {

    private final ConectaDb db;

    public DaoLocationCellDetailImpl() {
        db = new ConectaDb();
    }

    @Override
    public LocationCellDetail locationCellDetailGet(Integer idWh, Integer idRack, Integer idLocCell, Integer idLocCellDetail) {
        LocationCellDetail locCell = null;
        String sql = "SELECT "
                + "idLocation_Cell_Detail, "
                + "description, "
                + "availability "
                +"FROM Location_Cell_Detail "
                + "WHERE "
                + "Location_Cell_Rack_Warehouse_idWarehouse = ? AND "
                + "Location_Cell_Rack_idRack = ? AND "
                + "Location_Cell_idLocation_Cell = ? AND "
                +"idLocation_Cell_Detail = ?";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idWh);
                ps.setInt(2, idRack);
                ps.setInt(3, idLocCell);
                ps.setInt(4, idLocCellDetail);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    locCell = new LocationCellDetail();

                    locCell.setIdLocation_Cell_Detail(rs.getInt(1));
                    locCell.setDescription(rs.getString(2));
                    locCell.setAvailability(rs.getInt(3));
                    locCell.setLocation_Cell_idLocation_Cell(idLocCell);
                    locCell.setLocation_Cell_Rack_idRack(idRack);
                    locCell.setLocation_Cell_Rack_Warehouse_idWarehouse(idWh);
                    locCell.setIdDistribution_Center(1);

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
    public String locationCellDetailDel(List<Integer> ids) {
        int sizelist = ids.size();
        String result = null;
        String sql = "UPDATE  Location_Cell_Detail SET "
                + "availability= '1' "
                + "WHERE idLocation_Cell_Detail=?";
        /*"DELETE FROM User WHERE idUser=?";*/
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (int x = 0; x < sizelist; x++) {
                    int z = ids.get(x);
                    ps.setInt(1, z);

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
    public String locationCellDetailUpd(LocationCellDetail users) {
        String result = null;
        String sql = "UPDATE  Location_Cell_Detail SET "
                + "description=? ,"
                + "availability=? ,"
                + "Location_Cell_idLocation_Cell=? ,"
                + "Location_Cell_Rack_idRack=? ,"
                + "Location_Cell_Rack_Warehouse_idWarehouse=? "
                + "idDistribution_Center=? "
                + "WHERE idLocation_Cell_Detail=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, users.getDescription());
                ps.setInt(2, users.getAvailability());
                ps.setInt(3, users.getLocation_Cell_idLocation_Cell());
                ps.setInt(4, users.getLocation_Cell_Rack_idRack());
                ps.setInt(5, users.getLocation_Cell_Rack_Warehouse_idWarehouse());
                ps.setInt(6, users.getIdDistribution_Center());
                ps.setInt(7, users.getIdLocation_Cell_Detail());

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
    public String locationCellDetailIns(LocationCellDetail users) {

        String result = null;
        String sql = "INSERT INTO location_cell_detail("
                + "description,availability,Location_Cell_idLocation_Cell,Location_Cell_Rack_idRack,"
                + "Location_Cell_Rack_Warehouse_idWarehouse,idDistribution_Center"
                + ") VALUES(?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);

                ps.setString(1, users.getDescription());
                ps.setInt(2, users.getAvailability());
                ps.setInt(3, users.getLocation_Cell_idLocation_Cell());
                ps.setInt(4, users.getLocation_Cell_Rack_idRack());
                ps.setInt(5, users.getLocation_Cell_Rack_Warehouse_idWarehouse());
                ps.setInt(6, users.getIdDistribution_Center());

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
    public LocationCellDetail locationCellDetailQry(Integer idLocationCellDetail, Integer idLocationCell) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        LocationCellDetail locCell = null;
        String sql = "SELECT "
                + "idLocation_Cell_Detail, "
                + "description, "
                + "availability, "
                + "Location_Cell_idLocation_Cell, "
                + "Location_Cell_Rack_idRack, "
                + "Location_Cell_Rack_Warehouse_idWarehouse, "
                + "idDistribution_Center "
                + "FROM Location_Cell_Detail "
                + "WHERE idLocation_Cell_Detail = ? AND "
                + "Location_Cell_idLocation_Cell = ?;";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idLocationCellDetail);
                ps.setInt(2, idLocationCell);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    locCell = new LocationCellDetail();

                    locCell.setIdLocation_Cell_Detail(rs.getInt(1));
                    locCell.setDescription(rs.getString(2));
                    locCell.setAvailability(rs.getInt(3));
                    locCell.setLocation_Cell_idLocation_Cell(rs.getInt(4));
                    locCell.setLocation_Cell_Rack_idRack(rs.getInt(5));
                    locCell.setLocation_Cell_Rack_Warehouse_idWarehouse(rs.getInt(6));
                    locCell.setIdDistribution_Center(rs.getInt(7));

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
    public String locationCellDetailUpdAvailability(Integer idRack, Integer status) {
        String result = null;

        String sql = "UPDATE  Location_Cell_Detail SET "
                + "availability= ? "
                + "WHERE Location_Cell_Rack_idRack=?;";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);

                ps.setInt(1, status);
                ps.setInt(2, idRack);

                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    throw new SQLException("No se pudo actualizar el estado de algunos detalles");
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
    public List<LocationCellDetailInventory> locationCellDetailInventory(Integer idWh) {
        List<LocationCellDetailInventory> listLocCellInvent = new ArrayList<>();
        LocationCellDetailInventory locCellInvent = null;
        String sql = "SELECT DISTINCT "
                + "d.Location_Cell_Rack_idRack, "
                + "d.Location_Cell_idLocation_Cell,"
                + "c.row_cell, "
                + "c.column_cell,"
                + "d.idLocation_Cell_Detail,"
                + "d.availability, "
                + "if(p.Pallet_By_Product_Pallet_idPallet is NULL,0,p.Pallet_By_Product_Pallet_idPallet),"
                + "if(p.Pallet_By_Product_Product_idProduct is NULL,0,p.Pallet_By_Product_Product_idProduct) "
                + "FROM Location_Cell_Detail d "
                + "LEFT JOIN wms.Pallet_By_Product_By_Location_Cell_Detail p "
                + "ON d.idLocation_Cell_Detail = p.Location_Cell_Detail_idLocation_Cell_Detail "
                + "AND d.Location_Cell_idLocation_Cell = p.Location_Cell_Detail_Location_Cell_idLocation_Cell "
                + "AND d.Location_Cell_Rack_idRack = p.Location_Cell_Detail_Location_Cell_Rack_idRack "
                + "AND d.Location_Cell_Rack_Warehouse_idWarehouse = p.Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse "
                + "JOIN wms.Location_Cell c "
                + "ON d.Location_Cell_idLocation_Cell = c.idLocation_Cell "
                + "WHERE d.Location_Cell_Rack_Warehouse_idWarehouse = ? "
                + "ORDER BY d.Location_Cell_Rack_idRack,c.row_cell,c.column_cell,d.idLocation_Cell_Detail";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idWh);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    locCellInvent = new LocationCellDetailInventory();

                    locCellInvent.setIdRack(rs.getInt(1));
                    locCellInvent.setIdLocationCell(rs.getInt(2));
                    locCellInvent.setIdRow(rs.getInt(3));
                    locCellInvent.setIdColumn(rs.getInt(4));
                    locCellInvent.setIdLocationCellDetail(rs.getInt(5));
                    locCellInvent.setAvailability(rs.getInt(6));
                    locCellInvent.setIdPallet(rs.getInt(7));
                    locCellInvent.setIdProduct(rs.getInt(8));
                    locCellInvent.setIdWh(idWh);
                    listLocCellInvent.add(locCellInvent);
                }

            } catch (SQLException e) {
                listLocCellInvent = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return listLocCellInvent;
    }

}
