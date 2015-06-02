/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.PalletIni;
import Model.PalletProduct;
import Model.Product;
import Model.Trademark;
import dao.DaoPalletIni;
import dao.DaoPalletProduct;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gzavala
 */
public class DaoPalletProductImpl implements DaoPalletProduct{

    private ConectaDb db;

    public DaoPalletProductImpl() {
        db = new ConectaDb();
    }    

    @Override
    public Trademark GetTrademarkname(String namemark) {
        Trademark objmodel = null;
        String sql = "SELECT "
                + "id_Trademark, "
                + "name "
                + "FROM trademark where name='" + namemark +"' ";

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
                + "FROM trademark where id_Trademark=" + idmark +" ";

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
                + "FROM product where Trademark_id_Trademark=" +idmark+" ";
        Connection cn = db.getConnection();
        
        System.out.println("Query ejecutado " + sql); 
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
    public Product GetProduct(String nameproduct) {
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
                + "Trademark_id_Trademark "                                                                                
               // + "user_created, "                                                                                
               // + "user_updated "                                                                                
                + "FROM product where name='" +nameproduct+"' ";

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
                + "Product_Trademark_id_Trademark, "
                + "Product_idProduct, "
                + "status, "
                + "created_at, "
                + "updated_at, "
                + "user_created, "
                + "user_updated "
                + "FROM pallet_by_product  " +CadenaWhere+" ";
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
                    objmodel.setIdtrademark(rs.getInt(2));
                    objmodel.setIdproduct(rs.getInt(3));
                    objmodel.setStatus(rs.getInt(4));
                    objmodel.setCreated_at(rs.getTimestamp(5));
                    objmodel.setUpdated_at(rs.getTimestamp(6));
                    objmodel.setUser_created(rs.getInt(7));
                    objmodel.setUser_updated(rs.getInt(8));
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
    public String PalletProductDelMasive(List<Integer> listidpallet, List<Integer> listidmark, List<Integer> listidproduct,List<Integer> lististatus) {

        int sizelist= listidpallet.size();
        String result = null;
        String sql = "UPDATE  pallet_by_product SET "
                + "status=? "
                + "WHERE Pallet_idPallet=? "
                + " and Product_Trademark_id_Trademark=? "
                + " and Product_idProduct=? " ;
        Connection cn = db.getConnection();
        PalletIni objmodelpalletini=new PalletIni();
        DaoPalletIni objdaopalletini= new DaoPalletIniImpl();
        int idpallet; 
        int idmarca; 
        int idproduct; 
        int idstatus; 
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (int x = 0 ; x<sizelist ;x ++) {
                    idpallet= listidpallet.get(x);
                    idmarca=listidmark.get(x);
                    idproduct=listidproduct.get(x);
                    idstatus=lististatus.get(x);
                    ps.setInt(1,1-idstatus);
                    ps.setInt(2,idpallet);
                    ps.setInt(3,idmarca);
                    ps.setInt(4,idproduct);
                    objmodelpalletini=objdaopalletini.PalletIniGet(idpallet);
                    objmodelpalletini.setStatuspallet(idstatus+1);
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
    public String PalletProductInsMasive(List<Integer> listidpallet, Integer idmarca, Integer idproduct) {
        int sizelist= listidpallet.size();
        String result = null;
        String sql = "insert into pallet_by_product(Pallet_idPallet,Product_Trademark_id_Trademark,Product_idProduct,status) "
                + " values(?,?,?,1) ";
        Connection cn = db.getConnection();
        PalletIni objmodelpalletini=new PalletIni();
        DaoPalletIni objdaopalletini= new DaoPalletIniImpl();
        int idpallet; 
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (int x = 0 ; x<sizelist ;x ++) {
                    idpallet= listidpallet.get(x);
                    ps.setInt(1,idpallet);
                    ps.setInt(2,idmarca);
                    ps.setInt(3,idproduct);
                    //Se actualiza el pallet como no disponible
                    objmodelpalletini=objdaopalletini.PalletIniGet(idpallet);
                    objmodelpalletini.setStatuspallet(1);
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
                    cantPal +=1;
                    if(cantPal == cantPallets) break;
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
    public List<Integer> GetPalletsByIntOrder(Integer idIntOrder) {
        List<Integer> palletList = null;
        String sql = "SELECT "
                + "Pallet_idPallet "
                + "FROM Pallet_By_Product "
                + "WHERE Internment_Order_idInternment_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idIntOrder);
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
    
    
}
