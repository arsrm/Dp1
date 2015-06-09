package dao.impl;

import Model.Pallet_Product_Location;
import dao.DaoPallet_Product_Location;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoPallet_Producto_LocationImpl implements DaoPallet_Product_Location {
   private final ConectaDb db;

    public DaoPallet_Producto_LocationImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<Pallet_Product_Location> daoPallet_Product_LocationQry() {
       List<Pallet_Product_Location> list = null;
        String sql =  "select idPallet_By_Product_By_Location_Cell_Detail,"
                + "Pallet_By_Product_Pallet_idPallet,"
                + "Pallet_By_Product_Product_Trademark_id_Trademark,"
                + "Pallet_By_Product_Product_idProduct,"
                + "Location_Cell_Detail_idLocation_Cell_Detail,"
                + " Location_Cell_Detail_Location_Cell_idLocation_Cell,"
                + "Location_Cell_Detail_Location_Cell_Rack_idRack,"
                + "Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse,"
                + "Location_Cell_Detail_idDistribution_Center,status "
                +"From Pallet_By_Product_By_Location_Cell_Detail ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    Pallet_Product_Location c = new Pallet_Product_Location();
                    c.setIdPallet_By_Product_By_Location_Cell_Detail(rs.getInt(1));
                    c.setPallet_By_Product_Pallet_idPallet(rs.getInt(2));
                    c.setPallet_By_Product_Product_Trademark_id_Trademark(rs.getInt(3));
                    c.setPallet_By_Product_Product_idProduct(rs.getInt(4));
                    c.setLocation_Cell_Detail_idLocation_Cell_Detail(rs.getInt(5));
                    c.setLocation_Cell_Detail_Location_Cell_idLocation_Cell(rs.getInt(6));
                    c.setLocation_Cell_Detail_Location_Cell_Rack_idRack(rs.getInt(7));
                    c.setLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse(rs.getInt(8));
                    c.setLocation_Cell_Detail_idDistribution_Center(rs.getInt(9));
                    c.setStatus(rs.getInt(10));
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
    public String daoPallet_Product_LocationIns(Pallet_Product_Location client) {
         String result = null;
        String sql = "INSERT INTO Pallet_By_Product_By_Location_Cell_Detail("
                +"Pallet_By_Product_Pallet_idPallet,"
                + "Pallet_By_Product_Product_Trademark_id_Trademark,"
                + "Pallet_By_Product_Product_idProduct,"
                + "Location_Cell_Detail_idLocation_Cell_Detail,"
                + "Location_Cell_Detail_Location_Cell_idLocation_Cell,"
                + "Location_Cell_Detail_Location_Cell_Rack_idRack,"
                + "Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse,"
                + "Location_Cell_Detail_idDistribution_Center,"
                + "status "
                + ") VALUES(?,?,?,?,?,?,?,?,?)";
         
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                
                ps.setInt(1, client.getPallet_By_Product_Pallet_idPallet());
                ps.setInt(2,client.getPallet_By_Product_Product_Trademark_id_Trademark());
                ps.setInt(3, client.getPallet_By_Product_Product_idProduct());
                ps.setInt(4, client.getLocation_Cell_Detail_idLocation_Cell_Detail());
                ps.setInt(5, client.getLocation_Cell_Detail_Location_Cell_idLocation_Cell());
                ps.setInt(6, client.getLocation_Cell_Detail_Location_Cell_Rack_idRack());
                ps.setInt(7, client.getLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse());
                ps.setInt(8, client.getLocation_Cell_Detail_idDistribution_Center());
                ps.setInt(9, client.getStatus());
                
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
    public String daoPallet_Product_LocationDel(List<String> ids) {
        
        int sizelist= ids.size();
        String result = null;
        String sql = "UPDATE Pallet_By_Product_By_Location_Cell_Detail  SET "
                + "status= 0 "
                + "WHERE idPallet_By_Product_By_Location_Cell_Detail=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (int x = 0 ; x<sizelist ;x ++) {
                    String z= ids.get(x);
                    ps.setString(1,z);

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
    public Pallet_Product_Location daoPallet_Product_LocationGet(Integer ids) {
 
        Pallet_Product_Location c =null;
        Integer id=0;
        
        String sql =  "select idPallet_By_Product_By_Location_Cell_Detail,"
                + "Pallet_By_Product_Pallet_idPallet,"
                + "Pallet_By_Product_Product_Trademark_id_Trademark,"
                + "Pallet_By_Product_Product_idProduct,"
                + "Location_Cell_Detail_idLocation_Cell_Detail,"
                + " Location_Cell_Detail_Location_Cell_idLocation_Cell,"
                + "Location_Cell_Detail_Location_Cell_Rack_idRack,"
                + "Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse,"
                + "Location_Cell_Detail_idDistribution_Center,"
                + "status "
                +"From Pallet_By_Product_By_Location_Cell_Detail "
                + " where idPallet_By_Product_By_Location_Cell_Detail = ?";
               


        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, ids);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                     
                    c = new Pallet_Product_Location();
                    c.setIdPallet_By_Product_By_Location_Cell_Detail(rs.getInt(1));
                    c.setPallet_By_Product_Pallet_idPallet(rs.getInt(2));
                    c.setPallet_By_Product_Product_Trademark_id_Trademark(rs.getInt(3));
                    c.setPallet_By_Product_Product_idProduct(rs.getInt(4));
                    c.setLocation_Cell_Detail_idLocation_Cell_Detail(rs.getInt(5));
                    c.setLocation_Cell_Detail_Location_Cell_idLocation_Cell(rs.getInt(6));
                    c.setLocation_Cell_Detail_Location_Cell_Rack_idRack(rs.getInt(7));
                    c.setLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse(rs.getInt(8));
                    c.setLocation_Cell_Detail_idDistribution_Center(rs.getInt(9));
                    c.setStatus(rs.getInt(10));
                    
                }
            } catch (SQLException e) {
               c=null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return c;
    }

    @Override
    public String daoPallet_Product_LocationUpd(Pallet_Product_Location client) {
        
        String result = null;
        String sql = "UPDATE  Pallet_By_Product_By_Location_Cell_Detail SET "
               + "Pallet_By_Product_Pallet_idPallet=?,"
                + "Pallet_By_Product_Product_Trademark_id_Trademark=?,"
                + "Pallet_By_Product_Product_idProduct=?,"
                + "Location_Cell_Detail_idLocation_Cell_Detail=?,"
                + " Location_Cell_Detail_Location_Cell_idLocation_Cell=?,"
                + "Location_Cell_Detail_Location_Cell_Rack_idRack=?,"
                + "Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse=?,"
                + "Location_Cell_Detail_idDistribution_Center=?,"
                + "status=?  "
                + "WHERE idPallet_By_Product_By_Location_Cell_Detail=? ";
        
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
               
                ps.setInt(1, client.getPallet_By_Product_Pallet_idPallet());
                ps.setInt(2,client.getPallet_By_Product_Product_Trademark_id_Trademark());
                ps.setInt(3, client.getPallet_By_Product_Product_idProduct());
                ps.setInt(4, client.getLocation_Cell_Detail_idLocation_Cell_Detail());
                ps.setInt(5, client.getLocation_Cell_Detail_Location_Cell_idLocation_Cell());
                ps.setInt(6, client.getLocation_Cell_Detail_Location_Cell_Rack_idRack());
                ps.setInt(7, client.getLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse());
                ps.setInt(8, client.getLocation_Cell_Detail_idDistribution_Center());
                ps.setInt(9, client.getStatus());
                ps.setInt(10, client.getIdPallet_By_Product_By_Location_Cell_Detail());

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
    public List<Pallet_Product_Location> GetPallet_Product_LocationWhere(String Cadwhere) {
       List<Pallet_Product_Location> list = null;
        String sql =  "select idPallet_By_Product_By_Location_Cell_Detail,"
                + "Pallet_By_Product_Pallet_idPallet,"
                + "Pallet_By_Product_Product_Trademark_id_Trademark,"
                + "Pallet_By_Product_Product_idProduct,"
                + "Location_Cell_Detail_idLocation_Cell_Detail,"
                + " Location_Cell_Detail_Location_Cell_idLocation_Cell,"
                + "Location_Cell_Detail_Location_Cell_Rack_idRack,"
                + "Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse,"
                + "Location_Cell_Detail_idDistribution_Center,status "
                +"From Pallet_By_Product_By_Location_Cell_Detail  where " + Cadwhere ;

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                System.out.println("Cadena Ejecutada: " + sql);
                list = new LinkedList<>();
                while (rs.next()) {
                    Pallet_Product_Location c = new Pallet_Product_Location();
                    c.setIdPallet_By_Product_By_Location_Cell_Detail(rs.getInt(1));
                    c.setPallet_By_Product_Pallet_idPallet(rs.getInt(2));
                    c.setPallet_By_Product_Product_Trademark_id_Trademark(rs.getInt(3));
                    c.setPallet_By_Product_Product_idProduct(rs.getInt(4));
                    c.setLocation_Cell_Detail_idLocation_Cell_Detail(rs.getInt(5));
                    c.setLocation_Cell_Detail_Location_Cell_idLocation_Cell(rs.getInt(6));
                    c.setLocation_Cell_Detail_Location_Cell_Rack_idRack(rs.getInt(7));
                    c.setLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse(rs.getInt(8));
                    c.setLocation_Cell_Detail_idDistribution_Center(rs.getInt(9));
                    c.setStatus(rs.getInt(10));
                    list.add(c);
                }

            } catch (SQLException e) {
                list = null;
                System.out.println("Error: "+ e.getMessage());
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
    public String daoPallet_Product_LocationDel(Integer idPallet_Product_Location, Integer idPallet) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        String result = null;
        String sql = "UPDATE Pallet_By_Product_By_Location_Cell_Detail  SET "
                + "status= 0 "
                + "WHERE idPallet_By_Product_By_Location_Cell_Detail=? AND Pallet_By_Product_Pallet_idPallet=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,idPallet_Product_Location);
                ps.setInt(2,idPallet);
                
                
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
    public String daoPallet_Product_LocationActivate(Integer idPallet_Product_Location, Integer idPallet) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        String result = null;
        String sql = "UPDATE Pallet_By_Product_By_Location_Cell_Detail  SET "
                + "status= 1 "
                + "WHERE idPallet_By_Product_By_Location_Cell_Detail=? AND Pallet_By_Product_Pallet_idPallet=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,idPallet_Product_Location);
                ps.setInt(2,idPallet);
                
                
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
