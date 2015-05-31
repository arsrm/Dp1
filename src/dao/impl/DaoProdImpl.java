/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Model.Product;
import Model.Trademark;
import Model.Users;
import dao.DaoProducts;
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
public class DaoProdImpl implements DaoProducts {

    private final ConectaDb db;

    public DaoProdImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<Product> ProductsQry() {
        List<Product> products = null;
        String sql = "SELECT "
                + "idProduct,"
                + "name,"
                + "quantity_per_box,"
                + "weight_per_box,"
                + "quantity_boxes_per_pallet,"
                + "physical_stock,"
                + "free_stock,"
                + "status,"
                + "cod_ean13,"
                + "Trademark_id_Trademark,"
                + "Type_Condition_idType_Condition "
                + "FROM Product";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                products = new LinkedList<>();
                while (rs.next()) {
                    Product p = new Product();

                    p.setIdProduct(rs.getInt(1));
                    p.setName(rs.getString(2));
                    p.setQuantityPerBox(rs.getInt(3));
                    p.setWeightPerBox(rs.getInt(4));
                    p.setQuantityBoxesPerPallet(rs.getInt(5));
                    p.setPhysicalStock(rs.getInt(6));
                    p.setFreeStock(rs.getInt(7));
                    p.setStatus(rs.getInt(8));
                    p.setCodeEAN13(rs.getString(9));
                    p.setTrademark(rs.getInt(10));
                    p.setTypeConditionWH(rs.getInt(11));

                    products.add(p);
                }

            } catch (SQLException e) {
                products = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return products;
    }

    @Override
    public String ProductsIns(Product p) {
        String result = null;
        String sql = "INSERT INTO Product("
                + "name,"
                + "quantity_per_box,"
                + "weight_per_box,"
                + "quantity_boxes_per_pallet,"
                + "physical_stock,"
                + "free_stock,"
                + "status,"
                + "Type_Condition_idType_Condition,"
                + "cod_ean13,"
                + "Trademark_id_Trademark"
                + ") VALUES(?,?,?,?,?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, p.getName());
                ps.setInt(2, p.getQuantityPerBox());
                ps.setInt(3, p.getWeightPerBox());
                ps.setInt(4, p.getQuantityBoxesPerPallet());
                ps.setInt(5, p.getPhysicalStock());
                ps.setInt(6, p.getFreeStock());
                ps.setInt(7, p.getStatus());
                ps.setInt(8, p.getTypeConditionWH());
                ps.setString(9, p.getCodeEAN13());
                ps.setInt(10, p.getTrademark());

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
    public Product ProductsGet(Integer idProduct) {
        Product p = null;
        String sql = "SELECT "
                + "name,"
                + "quantity_per_box,"
                + "weight_per_box,"
                + "quantity_boxes_per_pallet,"
                + "physical_stock,"
                + "free_stock,"
                + "status,"
                + "cod_ean13,"
                + "Trademark_id_Trademark,"
                + "Type_Condition_idType_Condition "
                + "FROM Product WHERE idProduct = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idProduct);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    p = new Product();
                    p.setIdProduct(idProduct);
                    p.setName(rs.getString(1));
                    p.setQuantityPerBox(rs.getInt(2));
                    p.setWeightPerBox(rs.getInt(3));
                    p.setQuantityBoxesPerPallet(rs.getInt(4));
                    p.setPhysicalStock(rs.getInt(5));
                    p.setFreeStock(rs.getInt(6));
                    p.setStatus(rs.getInt(7));
                    p.setCodeEAN13(rs.getString(8));
                    p.setTrademark(rs.getInt(9));
                    p.setTypeConditionWH(rs.getInt(10));
                }

            } catch (SQLException e) {
                p = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return p;
    }

//    @Override
//    public Integer ProductsGetMaxID() {
//        Integer maxIdProduct = 0;
//        String sql = "SELECT MAX(p.idProduct) "
//                + "FROM Product p";
//
//        Connection cn = db.getConnection();
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//                if (rs.next()) {
//                    maxIdProduct = rs.getInt(1);
//                }
//            } catch (SQLException e) {
//                maxIdProduct = 0;
//            } finally {
//                try {
//                    cn.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//        return maxIdProduct;
//    }
    @Override
    public String ProductsDel(List<Integer> ids) {
        String result = null;

        for (Integer id : ids) {
            result = ProductDel(id);
        }

        return result;
    }

    public String ProductDel(Integer idProduct) {
        Integer status;
        String result = null;
        String sql = "UPDATE Product SET "
                + "status = ? "
                + "WHERE idProduct = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                if (ProductsGet(idProduct).getStatus() == 0) {
                    status = 1;
                } else {
                    status = 0;
                }

                ps.setInt(1, status);//se cambia el estado del producto
                ps.setInt(2, idProduct);

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
    public String ProductsUpd(Product p) {
        String result = null;
        String sql = "UPDATE Product SET "
                + "name = ?,"
                + "quantity_per_box = ?,"
                + "weight_per_box = ?,"
                + "quantity_boxes_per_pallet = ?,"
                + "Type_Condition_idType_Condition = ? "
                + "WHERE idProduct = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, p.getName());
                ps.setInt(2, p.getQuantityPerBox());
                ps.setInt(3, p.getWeightPerBox());
                ps.setInt(4, p.getQuantityBoxesPerPallet());
                ps.setInt(5, p.getTypeConditionWH());
                ps.setInt(6, p.getIdProduct());

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
    public List<Product> ProductsSearch(String EAN13, String name, Trademark trademark) {
        String sql = null;
        List<Product> products = null;
        if (trademark == null) {
            sql = "SELECT "
                    + "idProduct,"
                    + "name,"
                    + "quantity_per_box,"
                    + "weight_per_box,"
                    + "quantity_boxes_per_pallet,"
                    + "physical_stock,"
                    + "free_stock,"
                    + "status,"
                    + "cod_ean13,"
                    + "Trademark_id_Trademark,"
                    + "Type_Condition_idType_Condition "
                    + "FROM Product "
                    + "WHERE name LIKE ? AND "
                    + "cod_ean13 LIKE ?";
        } else {
            sql = "SELECT "
                    + "idProduct,"
                    + "name,"
                    + "quantity_per_box,"
                    + "weight_per_box,"
                    + "quantity_boxes_per_pallet,"
                    + "physical_stock,"
                    + "free_stock,"
                    + "status,"
                    + "cod_ean13,"
                    + "Trademark_id_Trademark,"
                    + "Type_Condition_idType_Condition "
                    + "FROM Product "
                    + "WHERE name LIKE ? AND "
                    + "cod_ean13 LIKE ? AND "
                    + "Trademark_id_Trademark = ?";
        }

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, "%" + name + "%");
                ps.setString(2, "%" + EAN13 + "%");
                if (trademark != null) {
                    ps.setInt(3, trademark.getId_Trademark());
                }

                ResultSet rs = ps.executeQuery();

                products = new LinkedList<>();
                while (rs.next()) {
                    Product p = new Product();

                    p.setIdProduct(rs.getInt(1));
                    p.setName(rs.getString(2));
                    p.setQuantityPerBox(rs.getInt(3));
                    p.setWeightPerBox(rs.getInt(4));
                    p.setQuantityBoxesPerPallet(rs.getInt(5));
                    p.setPhysicalStock(rs.getInt(6));
                    p.setFreeStock(rs.getInt(7));
                    p.setStatus(rs.getInt(8));
                    p.setCodeEAN13(rs.getString(9));
                    p.setTrademark(rs.getInt(10));
                    p.setTypeConditionWH(rs.getInt(11));

                    products.add(p);
                }

            } catch (SQLException e) {
                products = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return products;
    }

    @Override
    public List<Product> ProductsQryByTrademark(Integer idTrademark) {
        List<Product> products = null;
        String sql = "SELECT "
                + "idProduct,"
                + "name,"
                + "quantity_per_box,"
                + "weight_per_box,"
                + "quantity_boxes_per_pallet,"
                + "physical_stock,"
                + "free_stock,"
                + "status,"
                + "cod_ean13,"
                + "Trademark_id_Trademark,"
                + "Type_Condition_idType_Condition "
                + "FROM Product "
                + "WHERE Trademark_id_Trademark=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idTrademark);
                ResultSet rs = ps.executeQuery();

                products = new LinkedList<>();
                while (rs.next()) {
                    Product p = new Product();

                    p.setIdProduct(rs.getInt(1));
                    p.setName(rs.getString(2));
                    p.setQuantityPerBox(rs.getInt(3));
                    p.setWeightPerBox(rs.getInt(4));
                    p.setQuantityBoxesPerPallet(rs.getInt(5));
                    p.setPhysicalStock(rs.getInt(6));
                    p.setFreeStock(rs.getInt(7));
                    p.setStatus(rs.getInt(8));
                    p.setCodeEAN13(rs.getString(9));
                    p.setTrademark(rs.getInt(10));
                    p.setTypeConditionWH(rs.getInt(11));

                    products.add(p);
                }

            } catch (SQLException e) {
                products = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return products;
    }

}
