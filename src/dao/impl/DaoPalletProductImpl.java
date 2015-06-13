/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Model.DispatchOrder;
import Model.LocationCell;
import Model.LocationCellDetail;
import Model.PalletIni;
import Model.PalletProduct;
import Model.Product;
import Model.Rack;
import Model.Trademark;
import dao.DaoPalletIni;
import dao.DaoPalletProduct;
import dao.DaoProducts;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gzavala
 */
public class DaoPalletProductImpl implements DaoPalletProduct {

    private ConectaDb db;
    DaoProducts daoProd = new DaoProdImpl();
    SimpleDateFormat formatDateEan = new SimpleDateFormat("yyMMdd");

    public DaoPalletProductImpl() {
        db = new ConectaDb();
    }

    @Override
    public Trademark GetTrademarkname(String namemark) {
        Trademark objmodel = null;
        String sql = "SELECT "
                + "id_Trademark, "
                + "name "
                + "FROM trademark where name='" + namemark + "' ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    objmodel = new Trademark();
                    objmodel.setId_Trademark(rs.getInt(1));
                    objmodel.setName(rs.getString(2));
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
    public Trademark GetTradamarkid(Integer idmark) {
        Trademark objmodel = null;
        String sql = "SELECT "
                + "id_Trademark, "
                + "name "
                + "FROM trademark where id_Trademark=" + idmark + " ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    objmodel = new Trademark();
                    objmodel.setId_Trademark(rs.getInt(1));
                    objmodel.setName(rs.getString(2));
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
    public List<Product> GetProductList(Integer idmark) {
        List<Product> list = null;
        String sql = "SELECT "
                + "idProduct, "
                + "name, "
                + "quantity_per_box, "
                + "weight_per_box, "
                + "quantity_boxes_per_pallet, "
                + "physical_stock, "
                + "free_stock, "
                + "status, "
                + "created_at, "
                + "updated_at, "
                + "Type_Condition_idType_Condition, "
                + "cod_ean13, "
                + "Trademark_id_Trademark "
                // + "user_created, "                                                                                
                // + "user_updated "                                                                                
                + "FROM product where Trademark_id_Trademark=" + idmark + " ";
        Connection cn = db.getConnection();

        //  System.out.println("Query ejecutado " + sql);
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                list = new LinkedList<>();
                while (rs.next()) {
                    Product objmodel = new Product();
                    objmodel.setIdProduct(rs.getInt(1));
                    objmodel.setName(rs.getString(2));
                    objmodel.setQuantityPerBox(rs.getInt(3));
                    objmodel.setWeightPerBox(rs.getInt(4));
                    objmodel.setQuantityBoxesPerPallet(rs.getInt(5));
                    objmodel.setPhysicalStock(rs.getInt(6));
                    objmodel.setFreeStock(rs.getInt(7));
                    objmodel.setStatus(rs.getInt(8));
                    objmodel.setCreated_at(rs.getTimestamp(9));
                    objmodel.setUpdate_at(rs.getTimestamp(10));
                    objmodel.setTypeConditionWH(rs.getInt(11));
                    objmodel.setCodeEAN13(rs.getString(12));
                    objmodel.setTrademark(rs.getInt(13));
                    list.add(objmodel);
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
    public Product GetProduct(Integer idmark, String nameproduct) {
        Product objmodel = null;
        String sql = "SELECT "
                + "idProduct, "
                + "name, "
                + "quantity_per_box, "
                + "weight_per_box, "
                + "quantity_boxes_per_pallet, "
                + "physical_stock, "
                + "free_stock, "
                + "status, "
                + "created_at, "
                + "updated_at, "
                + "Type_Condition_idType_Condition, "
                + "cod_ean13, "
                + "Trademark_id_Trademark,"
                + "time_expiration  "
                // + "user_created, "                                                                                
                // + "user_updated "                                                                                
                + "FROM product where name='" + nameproduct + "' "
                + " and Trademark_id_Trademark=" + idmark + " ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    objmodel = new Product();
                    objmodel.setIdProduct(rs.getInt(1));
                    objmodel.setName(rs.getString(2));
                    objmodel.setQuantityPerBox(rs.getInt(3));
                    objmodel.setWeightPerBox(rs.getInt(4));
                    objmodel.setQuantityBoxesPerPallet(rs.getInt(5));
                    objmodel.setPhysicalStock(rs.getInt(6));
                    objmodel.setFreeStock(rs.getInt(7));
                    objmodel.setStatus(rs.getInt(8));
                    objmodel.setCreated_at(rs.getTimestamp(9));
                    objmodel.setUpdate_at(rs.getTimestamp(10));
                    objmodel.setTypeConditionWH(rs.getInt(11));
                    objmodel.setCodeEAN13(rs.getString(12));
                    objmodel.setTrademark(rs.getInt(13));
                    objmodel.setTimeExpiration(rs.getInt(14));
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
    public List<PalletProduct> GetPalletProductList(String CadenaWhere) {
        List<PalletProduct> list = null;
        String sql = "SELECT "
                + "Pallet_idPallet, "
                + "cod_ean128, "
                + "Product_Trademark_id_Trademark, "
                + "Product_idProduct, "
                + "status, "
                + "created_at, "
                + "updated_at, "
                + "user_created, "
                + "user_updated, "
                + "expiration_date, "
                + "Internment_Order_idInternment_Order "
                + "FROM pallet_by_product  " + CadenaWhere + " "
                + " order by Internment_Order_idInternment_Order, Product_Trademark_id_Trademark,Product_idProduct  ";
        Connection cn = db.getConnection();

        System.out.println("Query ejecutado " + sql);
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                list = new LinkedList<>();
                while (rs.next()) {
                    PalletProduct objmodel = new PalletProduct();
                    objmodel.setIdpallet(rs.getInt(1));
                    objmodel.setCod_ean128(rs.getString(2));
                    objmodel.setIdtrademark(rs.getInt(3));
                    objmodel.setIdproduct(rs.getInt(4));
                    objmodel.setStatus(rs.getInt(5));
                    objmodel.setCreated_at(rs.getTimestamp(6));
                    objmodel.setUpdated_at(rs.getTimestamp(7));
                    objmodel.setUser_created(rs.getInt(8));
                    objmodel.setUser_updated(rs.getInt(9));
                    objmodel.setDateexpira(rs.getDate(10));
                    objmodel.setNuminterna(rs.getInt(11));
                    list.add(objmodel);
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
    public String PalletProductDelMasive(List<Integer> listidpallet, List<Integer> listidmark, List<Integer> listidproduct, List<Integer> lististatus) {

        int sizelist = listidpallet.size();
        String result = null;
        String sql = "UPDATE  pallet_by_product SET "
                + "status=? "
                + "WHERE Pallet_idPallet=? "
                + " and Product_Trademark_id_Trademark=? "
                + " and Product_idProduct=? ";
        Connection cn = db.getConnection();
        PalletIni objmodelpalletini = new PalletIni();
        DaoPalletIni objdaopalletini = new DaoPalletIniImpl();
        int idpallet;
        int idmarca;
        int idproduct;
        int idstatus;
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (int x = 0; x < sizelist; x++) {
                    idpallet = listidpallet.get(x);
                    idmarca = listidmark.get(x);
                    idproduct = listidproduct.get(x);
                    idstatus = lististatus.get(x);
                    ps.setInt(1, 1 - idstatus);
                    ps.setInt(2, idpallet);
                    ps.setInt(3, idmarca);
                    ps.setInt(4, idproduct);
                    objmodelpalletini = objdaopalletini.PalletIniGet(idpallet);
                    objmodelpalletini.setStatuspallet(idstatus + 1);
                    objdaopalletini.PalletIniUpd(objmodelpalletini);
                    int ctos = ps.executeUpdate();
                    if (ctos == 0) {
                        throw new SQLException("ID: no existe");
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
    public String PalletProductInsMasive(List<Integer> listidpallet, Integer idmarca, Integer idproduct, Date expirationDate, Integer idIntOrd) {
        int sizelist = listidpallet.size();
        String result = null;
        String ean128 = null;
        String pesoPallet = "";
        String day = "", month = "", year = "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(expirationDate);
        if (cal.get(Calendar.DAY_OF_MONTH) < 10) {
            day = "0" + cal.get(Calendar.DAY_OF_MONTH);
        } else {
            day = "" + cal.get(Calendar.DAY_OF_MONTH);
        }
        if (cal.get(Calendar.MONTH) < 10) {
            month = "0" + cal.get(Calendar.MONTH);
        } else {
            month = "" + cal.get(Calendar.MONTH);
        }
        year = "" + cal.get(Calendar.YEAR) % 100;
        String sql = "insert into pallet_by_product(Pallet_idPallet,Product_Trademark_id_Trademark,Product_idProduct,expiration_date,Internment_Order_idInternment_Order,status,cod_ean128) "
                + " values(?,?,?,?,?,1,?) ";
        Connection cn = db.getConnection();
        PalletIni objmodelpalletini = new PalletIni();
        DaoPalletIni objdaopalletini = new DaoPalletIniImpl();
        int idpallet;
        Product prod = daoProd.ProductsGet(idproduct);
        Integer cantProdPall = (prod.getQuantityBoxesPerPallet() * prod.getWeightPerBox());
        int longCant = cantProdPall.toString().length();
        for (int i = 0; i < 6 - longCant; i++) {
            pesoPallet += "0";
        }
        pesoPallet += cantProdPall.toString();
        ean128 = "(01)" + prod.getCodeEAN13() + "(12)" + year + month + day
                + "(3100)" + pesoPallet + "(37)" + prod.getQuantityBoxesPerPallet();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (int x = 0; x < sizelist; x++) {
                    idpallet = listidpallet.get(x);
                    ps.setInt(1, idpallet);
                    ps.setInt(2, idmarca);
                    ps.setInt(3, idproduct);
                    //ps.setDate(4, new java.sql.Date(expirationDate.getTime()));
                    ps.setDate(4, new java.sql.Date(expirationDate.getTime()));
                    ps.setInt(5, idIntOrd);
                    ps.setString(6, ean128);
                    //Se actualiza el pallet como no disponible
                    objmodelpalletini = objdaopalletini.PalletIniGet(idpallet);
                    objmodelpalletini.setStatuspallet(1);
                    objdaopalletini.PalletIniUpd(objmodelpalletini);
                    int ctos = ps.executeUpdate();
                    if (ctos == 0) {
                        throw new SQLException("ID: no existe");
                    }
                }
            } catch (SQLException e) {
                result = e.getMessage();
                System.out.println(result);
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
    public List<Integer> GetPalletByStatus(Integer status, Integer cantPallets) {
        Integer cantPal = 0;
        List<Integer> palletList = null;
        String sql = "SELECT "
                + "idPallet "
                + "FROM Pallet "
                + "WHERE Pallet_State_idPallet_Type = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, status);
                ResultSet rs = ps.executeQuery();

                palletList = new LinkedList<>();
                while (rs.next()) {
                    palletList.add(rs.getInt(1));
                    cantPal += 1;
                    if (cantPal == cantPallets) {
                        break;
                    }
                }

            } catch (SQLException e) {
                palletList = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return palletList;
    }

    @Override
    public List<Integer> GetPalletsByIntOrder(Integer idIntOrder, Integer idProd) {
        List<Integer> palletList = null;
        String sql = null;
        if (idIntOrder != 999999999) {//Cuando no es ajuste manual
            sql = "SELECT "
                    + "Pallet_idPallet "
                    + "FROM Pallet_By_Product "
                    + "WHERE Internment_Order_idInternment_Order = ? "
                    + "AND Product_idProduct = ?";
        } else {
            sql = "SELECT "
                    + "MAX(Pallet_idPallet) "
                    + "FROM Pallet_By_Product "
                    + "WHERE Internment_Order_idInternment_Order = ? "
                    + "AND Product_idProduct = ?";
        }
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idIntOrder);
                ps.setInt(2, idProd);
                ResultSet rs = ps.executeQuery();

                palletList = new LinkedList<>();
                while (rs.next()) {
                    palletList.add(rs.getInt(1));
                }

            } catch (SQLException e) {
                palletList = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return palletList;
    }

    @Override
    public Product GetProductId(Integer idmark, Integer idproduct) {
        Product objmodel = null;
        String sql = "SELECT "
                + "idProduct, "
                + "name, "
                + "quantity_per_box, "
                + "weight_per_box, "
                + "quantity_boxes_per_pallet, "
                + "physical_stock, "
                + "free_stock, "
                + "status, "
                + "created_at, "
                + "updated_at, "
                + "Type_Condition_idType_Condition, "
                + "cod_ean13, "
                + "Trademark_id_Trademark,"
                + "time_expiration  "
                // + "user_created, "                                                                                
                // + "user_updated "                                                                                
                + "FROM product where idProduct=" + idproduct + " "
                + " and Trademark_id_Trademark=" + idmark + " ";

        //    System.out.println("Cadena de ejecución"+ sql);
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    objmodel = new Product();
                    objmodel.setIdProduct(rs.getInt(1));
                    objmodel.setName(rs.getString(2));
                    objmodel.setQuantityPerBox(rs.getInt(3));
                    objmodel.setWeightPerBox(rs.getInt(4));
                    objmodel.setQuantityBoxesPerPallet(rs.getInt(5));
                    objmodel.setPhysicalStock(rs.getInt(6));
                    objmodel.setFreeStock(rs.getInt(7));
                    objmodel.setStatus(rs.getInt(8));
                    objmodel.setCreated_at(rs.getTimestamp(9));
                    objmodel.setUpdate_at(rs.getTimestamp(10));
                    objmodel.setTypeConditionWH(rs.getInt(11));
                    objmodel.setCodeEAN13(rs.getString(12));
                    objmodel.setTrademark(rs.getInt(13));
                    objmodel.setTimeExpiration(rs.getInt(14));
                }

            } catch (SQLException e) {
                System.out.println("Error es : " + e.getMessage());
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
    public List<PalletProduct> GetPalletProductList2(String CadenaWhere) {
        List<PalletProduct> list = null;
        String sql = "SELECT "
                + " Pallet_idPallet, "
                + " Product_Trademark_id_Trademark, "
                + " Product_idProduct, "
                + " status, "
                + " created_at, "
                + " updated_at, "
                + " user_created, "
                + " user_updated, "
                + " expiration_date, "
                + " Internment_Order_idInternment_Order "
                + " FROM pallet_by_product  " + CadenaWhere + " "
                + "  and not (Pallet_idPallet+''+Product_Trademark_id_Trademark+''+Product_idProduct)"
                + "  in ( select distinct(Pallet_By_Product_Pallet_idPallet+''+Pallet_By_Product_Product_Trademark_id_Trademark+''+Pallet_By_Product_Product_idProduct)"
                + "  from pallet_by_product_by_location_cell_detail   )";

        Connection cn = db.getConnection();

        //   System.out.println("Query ejecutado " + sql); 
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                list = new LinkedList<>();
                while (rs.next()) {
                    PalletProduct objmodel = new PalletProduct();
                    objmodel.setIdpallet(rs.getInt(1));
                    objmodel.setIdtrademark(rs.getInt(2));
                    objmodel.setIdproduct(rs.getInt(3));
                    objmodel.setStatus(rs.getInt(4));
                    objmodel.setCreated_at(rs.getTimestamp(5));
                    objmodel.setUpdated_at(rs.getTimestamp(6));
                    objmodel.setUser_created(rs.getInt(7));
                    objmodel.setUser_updated(rs.getInt(8));
                    objmodel.setDateexpira(rs.getDate(9));
                    objmodel.setNuminterna(rs.getInt(10));
                    list.add(objmodel);
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
    public Rack GetRackid(Integer idCD, Integer idware, Integer idrack) {
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
                + "FROM Rack WHERE idRack =" + idrack + " "
                + " and Warehouse_idWarehouse=" + idware + " "
                + " and Warehouse_Distribution_Center_idDistribution_Center=" + idCD + " ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);

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
                System.out.println("Error " + e.getMessage());
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
    public LocationCell GetLocationCellId(Integer idCD, Integer idware, Integer idrack, Integer idcelda) {
        LocationCell celda = null;
        String sql = "select idLocation_Cell, \n"
                + " description,\n"
                + " width,\n"
                + " length,\n"
                + " height,\n"
                + " row_cell,\n"
                + " column_cell,\n"
                + " status,\n"
                + " Location_State_idLocation_State,\n"
                + " Rack_idRack,\n"
                + " Rack_Warehouse_idWarehouse,\n"
                + " Rack_Warehouse_Distribution_Center_idDistribution_Center \n"
                + " from location_cell\n"
                + " where  Rack_Warehouse_Distribution_Center_idDistribution_Center=" + idCD + " \n"
                + " and Rack_Warehouse_idWarehouse=" + idware + " \n"
                + " and Rack_idRack=" + idrack + " \n"
                + " and idLocation_Cell=" + idcelda + " ";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    celda = new LocationCell();
                    celda.setIdLocation_Cell(rs.getInt(1));
                    celda.setDescription(rs.getString(2));
                    celda.setWidth(rs.getDouble(3));
                    celda.setLength(rs.getDouble(4));
                    celda.setHeight(rs.getInt(5));
                    celda.setRow_Cell(rs.getInt(6));
                    celda.setColumn_Cell(rs.getInt(7));
                    celda.setStatus(rs.getInt(8));
                    celda.setLocation_State_idLocation_State(rs.getInt(9));
                    celda.setRack_idRack(rs.getInt(10));
                    celda.setRack_Warehouse_idWarehouse(rs.getInt(11));
                    celda.setRack_Warehouse_Distribution_Center_idDistribution_Center(rs.getInt(12));
                }
            } catch (SQLException e) {
                celda = null;
                System.out.println("Error " + e.getMessage());
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return celda;
    }

    @Override
    public LocationCellDetail GetLocationCellDetailId(Integer idCD, Integer idware, Integer idrack, Integer idcelda, Integer idceldadet) {
        LocationCellDetail celda = null;
        String sql = "select idLocation_Cell_Detail,\n"
                + " description,\n"
                + " availability,\n"
                + " Location_Cell_idLocation_Cell,\n"
                + " Location_Cell_Rack_idRack,\n"
                + " Location_Cell_Rack_Warehouse_idWarehouse,\n"
                + " idDistribution_Center \n"
                + " from location_cell_detail\n"
                + " where idDistribution_Center=" + idCD + " \n"
                + " and Location_Cell_Rack_Warehouse_idWarehouse=" + idware + " \n"
                + " and Location_Cell_Rack_idRack=" + idrack + " \n"
                + " and Location_Cell_idLocation_Cell=" + idcelda + " \n"
                + " and idLocation_Cell_Detail=" + idceldadet + " ";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    celda = new LocationCellDetail();
                    celda.setIdLocation_Cell_Detail(rs.getInt(1));
                    celda.setDescription(rs.getString(2));
                    celda.setAvailability(rs.getInt(3));
                    celda.setLocation_Cell_idLocation_Cell(rs.getInt(4));
                    celda.setLocation_Cell_Rack_idRack(rs.getInt(5));
                    celda.setLocation_Cell_Rack_Warehouse_idWarehouse(rs.getInt(6));
                    celda.setIdDistribution_Center(rs.getInt(7));

                }
            } catch (SQLException e) {
                celda = null;
                System.out.println("Error " + e.getMessage());
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return celda;
    }

    @Override
    public String PalletProductLocationDelMasive(List<Integer> listidpallet, List<Integer> listidmarca, List<Integer> listidproduct, List<Integer> listidCD, List<Integer> listware, List<Integer> listrack, List<Integer> listcelda, List<Integer> listceldadet, List<Integer> listidstatus) {
        int sizelist = listidpallet.size();
        String result = null;
        String sql = "UPDATE  pallet_by_product_by_location_cell_detail SET "
                + " status=? "
                + " WHERE Pallet_By_Product_Pallet_idPallet=? "
                + " and Pallet_By_Product_Product_Trademark_id_Trademark=? "
                + " and Pallet_By_Product_Product_idProduct=? "
                + " and Location_Cell_Detail_idDistribution_Center=? "
                + " and Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse=? "
                + " and Location_Cell_Detail_Location_Cell_Rack_idRack=? "
                + " and Location_Cell_Detail_Location_Cell_idLocation_Cell=? "
                + " and Location_Cell_Detail_idLocation_Cell_Detail=? ";

        Connection cn = db.getConnection();
        Integer idpallet;
        Integer idmarca;
        Integer idproduct;
        Integer idCD;
        Integer idware;
        Integer idrack;
        Integer idcelda;
        Integer idceldadet;
        Integer idstatus = 0;
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (int x = 0; x < sizelist; x++) {
                    idpallet = listidpallet.get(x);
                    idmarca = listidmarca.get(x);
                    idproduct = listidproduct.get(x);
                    idCD = listidCD.get(x);
                    idware = listware.get(x);
                    idrack = listrack.get(x);
                    idcelda = listcelda.get(x);
                    idceldadet = listceldadet.get(x);
                    idstatus = listidstatus.get(x);
                    ps.setInt(1, 1 - idstatus);
                    ps.setInt(2, idpallet);
                    ps.setInt(3, idmarca);
                    ps.setInt(4, idproduct);
                    ps.setInt(5, idCD);
                    ps.setInt(6, idware);
                    ps.setInt(7, idrack);
                    ps.setInt(8, idcelda);
                    ps.setInt(9, idceldadet);
                    int ctos = ps.executeUpdate();
                    if (ctos == 0) {
                        throw new SQLException("ID: no existe");
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
    public Integer GetCantNumord(Integer numorden) {
        Integer objmodel = 0;
        String sql = " select count(1) from dispatch_order  "
                + " where idDispatch_Order=" + numorden + " "
                + " and status=1";

        //    System.out.println("Cadena de ejecución"+ sql);
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    objmodel = rs.getInt(1);
                }

            } catch (SQLException e) {
                System.out.println("Error es : " + e.getMessage());
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
    public Integer GetCantNumpicking(Integer numpicking) {
        Integer objmodel = 0;
        String sql = " select * from picking_order "
                + " where idPicking_Order=" + numpicking + " and status=1";

        //    System.out.println("Cadena de ejecución"+ sql);
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    objmodel = rs.getInt(1);
                }

            } catch (SQLException e) {
                System.out.println("Error es : " + e.getMessage());
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
    public List<DispatchOrder> GetDispatchOrderList(String CadenaWhere) {
        List<DispatchOrder> list = null;
        String sql = " select idDispatch_Order, idClient,departure_date,arrival_date,status,"
                + " Picking_Order_idPicking_Order  from dispatch_order  " + CadenaWhere + "  ";

        Connection cn = db.getConnection();
        System.out.println("Query ejecutado " + sql);
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                list = new LinkedList<>();
                while (rs.next()) {
                    DispatchOrder objmodel = new DispatchOrder();
                    objmodel.setIdDispatch_Order(rs.getInt(1));
                    objmodel.setIdClient(rs.getInt(2));
                    objmodel.setDepartureDate(rs.getDate(3));
                    objmodel.setArrivalDate(rs.getDate(4));
                    objmodel.setStatus(rs.getInt(5));
                    objmodel.setIdPickingOrder(rs.getInt(6));
                    list.add(objmodel);
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
    public PalletProduct getPalletProductById(Integer idPallet) {
        PalletProduct palletPro = new PalletProduct();
        String sql = " SELECT "
                + "Pallet_idPallet, "
                + "Product_Trademark_id_Trademark, "
                + "Product_idProduct, "
                + "cod_ean128, "
                + "status, "
                + "expiration_date, "
                + "Internment_Order_idInternment_Order "
                + "FROM Pallet_By_Product "
                + "WHERE Pallet_idPallet = ?";

        //    System.out.println("Cadena de ejecución"+ sql);
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idPallet);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    palletPro.setIdpallet(idPallet);
                    palletPro.setIdtrademark(rs.getInt(2));
                    palletPro.setIdproduct(rs.getInt(3));
                    palletPro.setCod_ean128(rs.getString(4));
                    palletPro.setStatus(rs.getInt(5));
                    palletPro.setDateexpira(rs.getDate(6));
                    palletPro.setNuminterna(rs.getInt(7));
                }

            } catch (SQLException e) {
                System.out.println("Error es : " + e.getMessage());
                palletPro = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return palletPro;
    }

    @Override
    public String palletProductByLocaCellUpdStatus(Integer status,Integer idPallet, Integer idTrade, Integer idProd, Integer idCell, Integer idCellDet, Integer idRack, Integer idWh) {
        String result = null;
        String sql = "UPDATE  pallet_by_product_by_location_cell_detail SET "
                + " status=? "
                + " WHERE Pallet_By_Product_Pallet_idPallet=? "
                + " and Pallet_By_Product_Product_Trademark_id_Trademark=? "
                + " and Pallet_By_Product_Product_idProduct=? "
                + " and Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse=? "
                + " and Location_Cell_Detail_Location_Cell_Rack_idRack=? "
                + " and Location_Cell_Detail_Location_Cell_idLocation_Cell=? "
                + " and Location_Cell_Detail_idLocation_Cell_Detail=? ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                    ps.setInt(1, status);
                    ps.setInt(2, idPallet);
                    ps.setInt(3, idTrade);
                    ps.setInt(4, idProd);
                    ps.setInt(5, idWh);
                    ps.setInt(6, idRack);
                    ps.setInt(7, idCell);
                    ps.setInt(8, idCellDet);
                    int ctos = ps.executeUpdate();
                    if (ctos == 0) {
                        throw new SQLException("ID: no existe");
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
