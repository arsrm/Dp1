/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.Client;
import Model.RequestOrder;
import dao.DaoRequestOrder;
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
public class DaoRequestOrderImpl implements DaoRequestOrder{

    private final ConectaDb db;

    public DaoRequestOrderImpl() {
        db = new ConectaDb();
    }
    
    @Override
    public List<RequestOrder> requestOrderQry() {
         List<RequestOrder> list = null;
        String sql =  "SELECT idRequest_Order,dateArrive,dateline,Picking_Order_idPicking_Order,idClient,status,State_Request_Order_idStateRequest_Order,user_created,user_updated "
                +"FROM  request_order";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    
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
    public List<RequestOrder> requestOrderQry_search(String ruc, String dateFrom, String dateTo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String requestOrderIns(RequestOrder requestOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String requestOrderDel(List<String> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RequestOrder requestOrderGet(String idRequestOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String requestOrderUpd(RequestOrder requestOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
