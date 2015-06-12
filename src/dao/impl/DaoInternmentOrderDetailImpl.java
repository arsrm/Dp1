/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Model.InternmentOrderDetail;
import Model.Product;
import dao.DaoInternmentOrderDetail;
import dao.DaoProducts;
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
public class DaoInternmentOrderDetailImpl implements DaoInternmentOrderDetail {

    DaoProducts daoProducts = new DaoProdImpl();
    private final ConectaDb db;

    public DaoInternmentOrderDetailImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<InternmentOrderDetail> IntOrderDetailQry(Integer idIntOrder) {
        List<InternmentOrderDetail> intOrdDetailList = null;
        String sql = "SELECT "
                + "idInternment_Order_Detail,"
                + "quantity,"
                + "Product_idProduct, "
                + "status "
                + "FROM Internment_Order_Detail "
                + "WHERE Internment_Order_idInternment_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idIntOrder);
                ResultSet rs = ps.executeQuery();

                intOrdDetailList = new LinkedList<>();
                while (rs.next()) {
                    InternmentOrderDetail intOrdersDetail = new InternmentOrderDetail();
                    Product product = daoProducts.ProductsGet(rs.getInt(3));

                    intOrdersDetail.setIdInternmentOrderDetail(rs.getInt(1));
                    intOrdersDetail.setQuantityPallets(rs.getInt(2));
                    intOrdersDetail.setProduct(product);
                    intOrdersDetail.setStatus(rs.getInt(4));

                    intOrdDetailList.add(intOrdersDetail);
                }

            } catch (SQLException e) {
                intOrdDetailList = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return intOrdDetailList;
    }

    @Override
    public String IntOrderDetailIns(Integer idIntOrder, InternmentOrderDetail intOrderDetail) {
        String result = null;
        String sql = "INSERT INTO Internment_Order_Detail("
                + "idInternment_Order_Detail,"
                + "quantity,"
                + "status,"
                + "Product_idProduct,"
                + "Internment_Order_idInternment_Order"
                + ") VALUES(?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, intOrderDetail.getIdInternmentOrderDetail());
                ps.setInt(2, intOrderDetail.getQuantityPallets());
                ps.setInt(3, intOrderDetail.getStatus());
                ps.setInt(4, intOrderDetail.getProduct().getIdProduct());
                ps.setInt(5, idIntOrder);

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
    public String IntOrderDetailsDel(Integer idIntOrder, List<Integer> idsIntOrdDetail) {
        String result = null;

        for (Integer id : idsIntOrdDetail) {
            result = IntOrderDetailDel(idIntOrder, id);
        }

        return result;
    }

    public String IntOrderDetailDel(Integer idIntOrder, Integer idIntOrdDetail) {
        String result = null;
        String sql = "UPDATE Internment_Order_Detail SET "
                + "status = ? "
                + "WHERE idInternment_Order_Detail = ? "
                + "AND Internment_Order_idInternment_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, 0);//se cambia a cero el campo status
                ps.setInt(2, idIntOrdDetail);
                ps.setInt(3, idIntOrder);

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
    public Integer IntOrderDetailMaxId(Integer idProduct, Integer idIntOrd) {
        Integer maxId = 0;
        String sql = "SELECT MAX(idInternment_Order_Detail) "
                + "FROM internment_order_detail "
                + "WHERE Product_idProduct = ? "
                + "AND Internment_Order_idInternment_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idProduct);
                ps.setInt(2, idIntOrd);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    maxId = rs.getInt(1);
                }

            } catch (SQLException e) {
                maxId = 0;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return maxId;
    }

}
