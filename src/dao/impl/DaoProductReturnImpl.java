/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.DispatchOrder;
import Model.ProductReturn;
import dao.DaoProductReturn;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public class DaoProductReturnImpl implements DaoProductReturn{
    
    private final ConectaDb db;
    
    public DaoProductReturnImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<ProductReturn> productReturnQry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductReturn> productReturnQry_search(String dni, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String productReturnIns(ProductReturn productReturn) {                
        
        
        String result = null;
        String sql = "INSERT INTO Product_Return("
                + "quantity,"
                + "status,"
                + "idDispatch_Order,"
                + "Motive_Return_idMotive_Return,"
                + "Picking_Order_Detail_idPicking_Order_Detail,"
                + "Picking_Order_Detail_Picking_Order_idPicking_Order,"
                + "Picking_Order_Detail_Product_idProduct,"
                + "idClient,"
                + "return_date "
                + ") VALUES(?,?,?,?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, productReturn.getQuantity());
                ps.setInt(2,  productReturn.getStatus());
                ps.setInt(3, productReturn.getIdDispatch_Order());
                ps.setInt(4, productReturn.getMotive_Return_idMotive_Return()); 
                ps.setInt(5, productReturn.getPicking_Order_Detail_idPicking_Order_Detail());
                ps.setInt(6, productReturn.getPicking_Order_Detail_Picking_Order_idPicking_Order());
                ps.setInt(7, productReturn.getPicking_Order_Detail_Product_idProduct());
                ps.setInt(8,productReturn.getIdClient());
                java.sql.Date return_date = new java.sql.Date(productReturn.getReturn_date().getTime());
                ps.setDate(9, return_date);
                int ctos = ps.executeUpdate();

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
    public String productReturnDel(List<String> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductReturn productReturnGet(String idproductReturn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String productReturnUpd(ProductReturn productReturn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<DispatchOrder> dispatchOrderInDevolution(Integer idClient, Date dateFrom, Date dateTo, Integer status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
    }

    @Override
    public List<ProductReturn> productReturnQry(Integer idClient, Date dateFrom, Date dateTo, Integer status) {
        String sql = null;
        int idStatus;
        List<ProductReturn> ProductReturnList = null;
        if(dateFrom==null){
            dateFrom = new Date();
            dateFrom.setTime(0);
        }
        if(dateTo==null){
            dateTo = new Date();
            dateTo.setTime(0);
        }
        
        if(idClient!=-1){
            sql = "SELECT idProduct_Return,"
                + "quantity,"
                + "status,"
                + "idDispatch_Order,"
                + "idClient,"
                + "return_date,"
                + "Motive_Return_idMotive_Return,"
                + "Picking_Order_Detail_idPicking_Order_Detail,"
                + "Picking_Order_Detail_Picking_Order_idPicking_Order,"
                + "Picking_Order_Detail_Product_idProduct"
                + "FROM Product_Return "
                + "WHERE return_date >= ? "
                + "AND return_date <= ? "
                + "AND idClient = ? ";
        }else{
            sql = "SELECT idProduct_Return,"
                + "quantity,"
                + "status,"
                + "idDispatch_Order,"
                + "idClient,"
                + "return_date,"
                + "Motive_Return_idMotive_Return,"
                + "Picking_Order_Detail_idPicking_Order_Detail,"
                + "Picking_Order_Detail_Picking_Order_idPicking_Order,"
                + "Picking_Order_Detail_Product_idProduct"
                + "FROM Product_Return "
                + "WHERE return_date >= ? "
                + "AND return_date <= ? ";
        }

        if(status == 0){ //es cualquiera de los dos tipos
            sql+="";
        }else if(status == 1){ //atendido
            sql+= "AND status=1";
        }else if(status==2){//pendiente
            sql+= "AND status=2";
        }else if(status==3){//cancelado
            sql+= "AND status=3";
        }
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setDate(1, new java.sql.Date(dateFrom.getTime()));
                ps.setDate(2, new java.sql.Date(dateTo.getTime()));
                if(idClient!=-1)
                    ps.setInt(3,idClient);

                ResultSet rs = ps.executeQuery();

                ProductReturnList = new LinkedList<>();
                while (rs.next()) {
                    ProductReturn pR = new ProductReturn();
                    pR.setIdProduct_Return(rs.getInt(1));
                    pR.setQuantity(rs.getInt(2));
                    pR.setStatus(rs.getInt(3));
                    pR.setIdDispatch_Order(rs.getInt(4));
                    pR.setIdClient(rs.getInt(5));
                    pR.setReturn_date(rs.getDate(6));
                    pR.setMotive_Return_idMotive_Return(rs.getInt(7));
                    pR.setPicking_Order_Detail_idPicking_Order_Detail(rs.getInt(8));
                    pR.setPicking_Order_Detail_Picking_Order_idPicking_Order(rs.getInt(9));
                    pR.setPicking_Order_Detail_Product_idProduct(rs.getInt(10));
                    ProductReturnList.add(pR);
                }

            } catch (SQLException e) {
                ProductReturnList = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return ProductReturnList;
    }
    
}
