/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.StateRequestOrder;
import dao.DaoStateRequestOrder;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public class DaoStateRequestOrderImpl implements DaoStateRequestOrder{
    
    private final ConectaDb db;

    public DaoStateRequestOrderImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<StateRequestOrder> stateRequestOrderQry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StateRequestOrder> stateRequestOrderQry_search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String stateRequestOrderIns(StateRequestOrder client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String stateRequestOrderDel(List<String> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StateRequestOrder stateRequestOrderGet(int idState) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        StateRequestOrder state = null;
         
          String sql =  "SELECT idStateRequest_Order,"
                + "description,"
                + "status "
                + "FROM state_request_order WHERE idStateRequest_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idState);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    state = new StateRequestOrder();
                    state.setIdStateRequestOrder(idState);
                    state.setDescription(rs.getString(2));
                    state.setStatus(rs.getInt(3));
                }

            } catch (SQLException e) {
                state = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return state;
    }

    @Override
    public String clientUpd(StateRequestOrder stateRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
