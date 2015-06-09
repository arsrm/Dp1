/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.ProductReturn;
import dao.DaoProductReturn;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                + "Picking_Order_Detail_Product_idProduct"
                + ") VALUES(?,?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, productReturn.getQuantity());
                ps.setInt(2,  productReturn.getStatus());
                ps.setInt(3, productReturn.getIdDispatch_Order());
                ps.setInt(4, productReturn.getMotive_Return_idMotive_Return()); 
                ps.setInt(5, productReturn.getPicking_Order_Detail_idPicking_Order_Detail());
                ps.setInt(5, productReturn.getPicking_Order_Detail_Picking_Order_idPicking_Order());
                ps.setInt(6, productReturn.getPicking_Order_Detail_Product_idProduct());
                
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
    
}
