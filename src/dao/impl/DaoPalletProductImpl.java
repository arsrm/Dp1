/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.PalletIni;
import Model.Product;
import Model.Trademark;
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
}
