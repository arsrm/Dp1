/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;
import Model.Pallet;
import Model.Distribution_Center;
import Model.LocationCell;
import Model.LocationCellDetail;
import Model.PalletIni;
import Model.Product;
import Model.Rack;
import Model.Warehouse;
import dao.DaoPallet;
import java.util.*;
import java.sql.*;
import enlaceBD.ConectaDb;


/**
 *
 * @author gzavala
 */
public class DaoPalletImpl implements DaoPallet{

   private final ConectaDb db;
   
   public DaoPalletImpl() {
        db = new ConectaDb();
   }

    @Override
    public List<Pallet> PalletQry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String PalletIns(Pallet pallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String PalletDel(Pallet pallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String PalletUpd(Pallet pallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pallet PalletGet(Integer idpallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> PalletCbo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Distribution_Center> CDQry() {
        List<Distribution_Center> list = null;
        Distribution_Center modelCd= new Distribution_Center();
        String sql = "select idDistribution_Center,name , address,pos_x, \n" +
                      " pos_y,status,created_at,updated_at,user_created,user_updated \n" +
                      "from  distribution_center \n" +
                      "where idDistribution_Center in \n" +
                      "(select distinct(idDistribution_Center) from location_cell_detail)" ;
        Connection cn = db.getConnection();
        
        System.out.println("Query ejecutado " + sql); 
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                list = new LinkedList<>();
                while (rs.next()) {
                    modelCd.setIdDistribution_Center(rs.getInt(1));
                    modelCd.setName(rs.getString(2));
                    modelCd.setAddress(rs.getString(3));
                    modelCd.setPos_x(rs.getInt(4));
                    modelCd.setPos_y(rs.getInt(5));
                    modelCd.setStatus(rs.getInt(6));
                    modelCd.setCreated_at(rs.getTimestamp(7));
                    modelCd.setUpdated_at(rs.getTimestamp(8));
                    modelCd.setUser_created(rs.getInt(9));
                    modelCd.setUser_updated(rs.getInt(10));
                    list.add(modelCd);
                }

            } catch (SQLException e) {
                list = null;
                System.out.println("Error" + e.getMessage());
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
    public List<Warehouse> WarehoseQry(String CentroCD) {
        List<Warehouse> list = null;
        Warehouse model= new Warehouse();
        String sql = "select idWarehouse,description, status,created_at,updated_at,\n" +
                    "Type_Condition_idType_Condition,Distribution_Center_idDistribution_Center,\n" +
                    "user_created,user_updated\n" +
                    " from warehouse \n" +
                    "where idWarehouse in (\n" +
                    "select distinct(Location_Cell_Rack_Warehouse_idWarehouse) from location_cell_detail \n" +
                    "where  " +CentroCD+ " )" ;
        Connection cn = db.getConnection();
        
        System.out.println("Query ejecutado " + sql); 
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                list = new LinkedList<>();
                while (rs.next()) {
                    model.setIdWH(rs.getInt(1));
                    model.setDescription(rs.getString(2));
                    model.setStatus(rs.getInt(3));
                    model.setCreated_at(rs.getTimestamp(4));
                    model.setUpdate_at(rs.getTimestamp(5));
                    model.setType_Condition_WareHouse_idType_Condition_WareHouse(rs.getInt(6));
                    model.setDistribution_Center_idDistribution_Center(rs.getInt(7));
                    list.add(model);
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
    public Warehouse Warehousename(String nameWR) {
        Warehouse objmodel = null;
        String sql = "SELECT "
                + "idWarehouse, "
                + "description, "
                + "status, "
                + "created_at, "
                + "updated_at, "
                + "Type_Condition_idType_Condition, "
                + "Distribution_Center_idDistribution_Center "
                + "FROM warehouse where description='" + nameWR +"' ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    objmodel = new Warehouse();
                    objmodel.setIdWH(rs.getInt(1));
                    objmodel.setDescription(rs.getString(2));
                    objmodel.setStatus(rs.getInt(3));
                    objmodel.setCreated_at(rs.getTimestamp(4));
                    objmodel.setUpdate_at(rs.getTimestamp(5));
                    objmodel.setType_Condition_WareHouse_idType_Condition_WareHouse(rs.getInt(6));
                    objmodel.setDistribution_Center_idDistribution_Center(rs.getInt(7));
                }

            } catch (SQLException e) {
                objmodel = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return objmodel;
    }

    @Override
    public List<Rack> RackQry(String cadena) {
        List<Rack> list = null;
        Rack model= new Rack();
        String sql = "select idRack,identifier,description,length,width,floor_numbers,height_per_floor,\n" +
                      "resistance_weigth_per_floor,column_number,status,created_at,updated_at,Warehouse_idWarehouse,\n" +
                      "Warehouse_Distribution_Center_idDistribution_Center,user_created,user_updated from rack \n" +
                      "where idRack in \n" +
                      "(select distinct(Location_Cell_Rack_idRack) from location_cell_detail where " + cadena +")" ;
        Connection cn = db.getConnection();
        System.out.println("Query ejecutado " + sql); 
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<>();
                while (rs.next()) {
                    model.setIdRack(rs.getInt(1));
                    model.setIdentifier(rs.getString(2));
                    model.setDescription(rs.getString(3));
                    model.setLength(rs.getDouble(4));
                    model.setWidth(rs.getDouble(5));
                    model.setFloor_numbers(rs.getInt(6));
                    model.setHeight_per_floor(rs.getInt(7));
                    model.setResistance_weigth_per_floor(rs.getInt(8));
                    model.setColumn_number(rs.getInt(9));
                    model.setStatus(rs.getInt(10));
                    model.setCreated_at(rs.getTimestamp(11));
                    model.setUpdated_at(rs.getTimestamp(12));
                    model.setWarehouse_idWarehouse(rs.getInt(13));
                    model.setWarehouse_Distribution_Center_idDistribution_Center(rs.getInt(14));
                    model.setUser_created(rs.getInt(15));
                    model.setUser_updated(rs.getInt(16));
                    list.add(model);
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
    public Rack Rackid(String identifier) {
        Rack objmodel = null;
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
                + "FROM rack where identifier='" + identifier +"' ";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    objmodel = new Rack();
                    objmodel.setIdRack(rs.getInt(1));
                    objmodel.setIdentifier(rs.getString(2));
                    objmodel.setDescription(rs.getString(3));
                    objmodel.setLength(rs.getDouble(4));
                    objmodel.setWidth(rs.getDouble(5));
                    objmodel.setFloor_numbers(rs.getInt(6));
                    objmodel.setHeight_per_floor(rs.getInt(7));
                    objmodel.setResistance_weigth_per_floor(rs.getInt(8));
                    objmodel.setColumn_number(rs.getInt(9));
                    objmodel.setStatus(rs.getInt(10));
                    objmodel.setCreated_at(rs.getTimestamp(11));
                    objmodel.setUpdated_at(rs.getTimestamp(12));
                    objmodel.setWarehouse_idWarehouse(rs.getInt(13));
                    objmodel.setWarehouse_Distribution_Center_idDistribution_Center(rs.getInt(14));
                    objmodel.setUser_created(rs.getInt(15));
                    objmodel.setUser_updated(rs.getInt(16));
                }

            } catch (SQLException e) {
                objmodel = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return objmodel;
    }

    @Override
    public List<String> CeldaQry(String cadrack) {
        List<String> list = null;
        String model= "";
        String sql = "select description" +
                    " from location_cell \n" +
                    "where idLocation_Cell in (\n" +
                    "select distinct(Location_Cell_idLocation_Cell) from location_cell_detail \n" +
                    "where  " +cadrack+ " )" ;
        Connection cn = db.getConnection();
        
        System.out.println("Query ejecutado " + sql); 
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                list = new LinkedList<>();
                while (rs.next()) {
                    model=rs.getString(1);
                    list.add(model);
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
    public Pallet GetPallet(LocationCellDetail obj) {
        Pallet objmodel = null;
        String sql = "select Pallet_By_Product_Pallet_idPallet, Pallet_By_Product_Product_Trademark_id_Trademark,\n" +
                    "Pallet_By_Product_Product_idProduct,Location_Cell_Detail_idLocation_Cell_Detail,\n" +
                    "Location_Cell_Detail_Location_Cell_idLocation_Cell,Location_Cell_Detail_Location_Cell_Rack_idRack,\n" +
                    "Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse,Location_Cell_Detail_idDistribution_Center,\n" +
                    "status,created_at,updated_at,user_created,user_updated \n" +
                    "from pallet_by_product_by_location_cell_detail\n" +
                    "where  Location_Cell_Detail_idLocation_Cell_Detail ="+obj.getIdLocation_Cell_Detail()+" ";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    objmodel = new Pallet();
                    objmodel.setIdPallet(rs.getInt(1));
                    objmodel.setProduct_Trademark_id_Trademark(rs.getInt(2));
                    objmodel.setProduct_idProduct(rs.getInt(3));
                    objmodel.setLocation_Cell_Detail_idLocation_Cell_Detail(rs.getInt(4));
                    objmodel.setLocation_Cell_Detail_Location_Cell_idLocation_Cell(rs.getInt(5));
                    objmodel.setLocation_Cell_Detail_Location_Cell_Rack_idRack(rs.getInt(6));
                    objmodel.setLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse(rs.getInt(7));
                    objmodel.setIdDistribution_Center(rs.getInt(8));
                    objmodel.setStatus(rs.getInt(9));
                    objmodel.setCreated_at(rs.getTimestamp(10));
                    objmodel.setUpdated_at(rs.getTimestamp(11));
                    objmodel.setUser_created(rs.getInt(12));
                    objmodel.setUser_updated(rs.getInt(13));
                }
            } catch (SQLException e) {
                objmodel = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return objmodel;
    }

    @Override
    public LocationCell LocationCellid(String description) {
        LocationCell objmodel = null;
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
                + "FROM location_cell where description='" + description +"' ";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    objmodel = new LocationCell();
                    objmodel.setIdLocation_Cell(rs.getInt(1));
                    objmodel.setDescription(rs.getString(2));
                    objmodel.setWidth(rs.getDouble(3));
                    objmodel.setLength(rs.getDouble(4));
                    objmodel.setHeight(rs.getInt(5));
                    objmodel.setRow_Cell(rs.getInt(6));
                    objmodel.setColumn_Cell(rs.getInt(7));
                    objmodel.setStatus(rs.getInt(8));
                    objmodel.setLocation_State_idLocation_State(rs.getInt(9));
                    objmodel.setRack_idRack(rs.getInt(10));
                    objmodel.setRack_Warehouse_idWarehouse(rs.getInt(11));
                    objmodel.setRack_Warehouse_Distribution_Center_idDistribution_Center(rs.getInt(12));
                }

            } catch (SQLException e) {
                objmodel = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return objmodel;
    }

    @Override
    public List<String> DetalleCeldaQry(String Cadenacelda) {
        List<String> list = null;
        String model= "";
        String sql = "select description" +
                    " from location_cell_detail \n" +
                    "where " +Cadenacelda+ " " ;
        Connection cn = db.getConnection();
        
        System.out.println("Query para Detalle Celda : " + sql);   
        System.out.println("Query ejecutado " + sql); 
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                list = new LinkedList<>();
                while (rs.next()) {
                    model=rs.getString(1);
                    list.add(model);
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
