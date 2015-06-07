/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.Product;
import Model.RequestOrder;
import Model.RequestOrderDetail;
import dao.DaoProducts;
import dao.DaoRequestOrder;
import dao.DaoRequestOrderDetail;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public class DaoRequestOrderDetailImpl implements DaoRequestOrderDetail {

    DaoProducts daoProducts =  new DaoProdImpl();
    private final ConectaDb db;

    public DaoRequestOrderDetailImpl() {
        db = new ConectaDb();
    }
    
    @Override
    public String requestOrderIns(RequestOrderDetail requestOrderDetail) {
        String result = null;
        String sql = "INSERT INTO request_order_detail("
                + "idRequest_Order_Detail,"
                + "Product_idProduct,"
                + "quantity,"
                + "status,"
                + "Request_Order_idRequest_Order,"
                + "delivered,"
                + "remaining "
                + ") VALUES(?,?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, requestOrderDetail.getIdRequest_Order_Detail());
                ps.setInt(2, requestOrderDetail.getProduct().getIdProduct());
                ps.setInt(3, requestOrderDetail.getQuantity());
                ps.setInt(4, requestOrderDetail.getStatus());
                ps.setInt(5, requestOrderDetail.getRequestOrder());
                ps.setInt(6, requestOrderDetail.getDelivered());
                ps.setInt(7, requestOrderDetail.getRemaining());
                

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
    public String requestOrderDetailDel(Integer idRequestOrderDetail, Integer idRequestOrder, Integer status) {
        String result = null;
        String sql = "UPDATE request_order_detail SET "
                + "status = ? "
                + "WHERE idRequest_Order_Detail = ? "
                + "AND Request_Order_idRequest_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                RequestOrderDetail roD = requestOrderDetailGet(idRequestOrder,idRequestOrderDetail);
                
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, status);//se cambia a cero el campo status
                ps.setInt(2, idRequestOrderDetail);
                ps.setInt(3, idRequestOrder);

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
    public RequestOrderDetail requestOrderDetailGet(Integer idRequestOrder, Integer idRequestOrderDetail) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
        RequestOrderDetail requestOrderDetail = null;
        String sql = "SELECT "
                + "idRequest_Order_Detail,"
                + "Product_idProduct, "
                + "quantity,"
                + "status, "
                + "Request_Order_idRequest_Order, "
                + "delivered,"
                + "remaining,"
                + "user_created, "
                + "user_updated "
                + "FROM request_order_detail "
                + "WHERE Request_Order_idRequest_Order = ?"
                + " AND idRequest_Order_Detail = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idRequestOrder);
                ps.setInt(2, idRequestOrderDetail);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    requestOrderDetail = new RequestOrderDetail();
                    Product product = daoProducts.ProductsGet(rs.getInt(2));
                    requestOrderDetail.setIdRequest_Order_Detail(rs.getInt(1));
                    requestOrderDetail.setProduct(product);
                    requestOrderDetail.setQuantity(rs.getInt(3));
                    requestOrderDetail.setStatus(rs.getInt(4));
                    requestOrderDetail.setDelivered(rs.getInt(6));
                    requestOrderDetail.setRemaining(rs.getInt(7));
                    
                    
                }

            } catch (SQLException e) {
                requestOrderDetail = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return requestOrderDetail;
                
    }

    @Override
    public String requestOrderDetailUpd(RequestOrderDetail requestOrderDetail) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String result = null;
        String sql = "UPDATE  request_order_detail SET "
                +" quantity=?, status = ? , delivered=?, remaining=? "
                + "WHERE Request_Order_idRequest_Order=? AND idRequest_Order_Detail = ? ";
        
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,requestOrderDetail.getQuantity());
                ps.setInt(2,requestOrderDetail.getStatus());
                ps.setInt(3,requestOrderDetail.getDelivered());
                ps.setInt(4,requestOrderDetail.getRemaining());
                ps.setInt(5,requestOrderDetail.getRequestOrder());
                ps.setInt(6,requestOrderDetail.getIdRequest_Order_Detail());
                
                
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
    public List<RequestOrderDetail> requestOrderDetailQry(Integer idOrder) {
        List<RequestOrderDetail> requestOrderDetail = null;
        String sql = "SELECT "
                + "idRequest_Order_Detail,"
                + "Product_idProduct,"
                + "quantity,"
                + "status, "
                + "Request_Order_idRequest_Order, "
                + "delivered,"
                + "remaining,"
                + "user_created,"
                + "user_updated "
                + "FROM request_order_detail "
                + "WHERE Request_Order_idRequest_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idOrder);
                ResultSet rs = ps.executeQuery();

                requestOrderDetail = new LinkedList<>();
                while (rs.next()) {
                    RequestOrderDetail requestOrderDet = new RequestOrderDetail();
                    Product product = daoProducts.ProductsGet(rs.getInt(2));
                    requestOrderDet.setIdRequest_Order_Detail(rs.getInt(1));
                    requestOrderDet.setProduct(product);
                    requestOrderDet.setQuantity(rs.getInt(3));
                    requestOrderDet.setStatus(rs.getInt(4));
                    requestOrderDet.setRequestOrder(idOrder);
                    requestOrderDet.setDelivered(rs.getInt(6));
                    requestOrderDet.setRemaining(rs.getInt(7));
                    requestOrderDetail.add(requestOrderDet);
                }

            } catch (SQLException e) {
                requestOrderDetail = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return requestOrderDetail;
    }

    @Override
    public String requestOrderDetailsDel(List<Integer> idOrderDetailList, Integer idRequestOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String result = null;
        int status = -1;
        for (Integer id : idOrderDetailList) {
            RequestOrderDetail roD = requestOrderDetailGet(idRequestOrder, id);
            if(roD.getStatus()==0){
                status=1;
            }else if(roD.getStatus()==1 || roD.getStatus()==2)
                status=0;
            result = requestOrderDetailDel(id,idRequestOrder,status);
        }
        return result;
    }
    
}
