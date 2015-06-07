package dao.impl;

import Model.LocationCell;
import Model.LocationCellDetail;
import dao.DaoLocationCellDetail;
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
public class DaoLocationCellDetailImpl implements DaoLocationCellDetail {

    private final ConectaDb db;

    public DaoLocationCellDetailImpl() {
        db = new ConectaDb();
    }

    @Override
    public LocationCellDetail locationCellDetailGet(Integer id) {
        LocationCellDetail locCell = null;
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
                ps.setInt(1, id);

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
    public String locationCellDetailDel(List<Integer> ids){
       int sizelist= ids.size();
        String result = null;
        String sql = "UPDATE  Location_Cell_Detail SET "
                + "availability= '1' "
                + "WHERE idLocation_Cell_Detail=?";
/*"DELETE FROM User WHERE idUser=?";*/
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (int x = 0 ; x<sizelist ;x ++) {
                    int z= ids.get(x);
                    ps.setInt(1,z);

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
    public String locationCellDetailUpd(LocationCellDetail users){
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
    public String locationCellDetailIns(LocationCellDetail users){
    
        String result = null;
        String sql = "INSERT INTO User("
                +"description,availability,Location_Cell_idLocation_Cell,Location_Cell_Rack_idRack,"
                + "Location_Cell_Rack_Warehouse_idWarehouse,idDistribution_Center"
                + ") VALUES(?,?,?,?,?,?)";
         
        
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                
                ps.setString(1, users.getDescription());
                ps.setInt(2, users.getAvailability());
                ps.setInt(3,users.getLocation_Cell_idLocation_Cell() );
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
                ps.setInt(2,idLocationCell);

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
}
