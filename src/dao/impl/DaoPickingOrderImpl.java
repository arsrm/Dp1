/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.PickingOrder;
import Model.PickingOrderDetail;
import dao.DaoPickingOrder;
import dao.DaoPickingOrderDetail;
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
public class DaoPickingOrderImpl implements DaoPickingOrder {
    DaoPickingOrderDetail daoPickingOrderDetail = new DaoPickingOrderDetailImpl();
    private final ConectaDb db;
    
    public DaoPickingOrderImpl() {
        db = new ConectaDb();
    }
    @Override
    public List<PickingOrder> pickingOrderQry() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<PickingOrder> list = null;
        String sql =  "SELECT idPicking_Order,"
                + "Date,"
                + "status,"
                + "user_created,"
                + "user_updated "
                +"FROM  picking_order";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<>();
                while (rs.next()) {
                    List<PickingOrderDetail> pickingDetail =  null;
                    PickingOrder po = new PickingOrder();
                    po.setIdPickingOrder(rs.getInt(1));
                    po.setDate(rs.getDate(2));
                    po.setStatus(rs.getInt(3));
                    po.setUserCreated(rs.getInt(4));
                    po.setUserUpdated(rs.getInt(5));
                    pickingDetail = daoPickingOrderDetail.pickingOrderDetailQry(rs.getInt(1));
                    po.setPickingOrderDetailList(pickingDetail);
                    list.add(po);                    
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
    public List<PickingOrder> pickingOrderQry_search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pickingOrderIns(PickingOrder pickingOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        String result = null;
        String sql = "INSERT INTO picking_order("
                + "idPicking_Order,"
                + "Date,"
                + "status,"
                + "userCreated,"
                + "userUpdated"
                + ") VALUES(?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, pickingOrder.getIdPickingOrder());
                ps.setDate(2,  new java.sql.Date(pickingOrder.getDate().getTime()));
                ps.setInt(3, pickingOrder.getStatus());
                ps.setInt(4, pickingOrder.getUserCreated());
                if(pickingOrder.getUserUpdated()==null){
                    ps.setNull(5, java.sql.Types.NULL);
                }else{
                    ps.setInt(8, pickingOrder.getUserUpdated());
                }
                int ctos = ps.executeUpdate();
                List<PickingOrderDetail> list = pickingOrder.getPickingOrderDetailList();
                int sizeRequest = list.size();
                
                for(int i=0;i<sizeRequest;i++){
                    daoPickingOrderDetail.pickingOrderDetailIns(list.get(i));
                }
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
    public String pickingOrderDel(Integer idPickingOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Integer status;
        String result = null;
        String sql = "UPDATE picking_order SET "                
                + "status = ? "
                + "WHERE idPicking_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
               
                PickingOrder po = pickingOrderGet(idPickingOrder);
                
                if (po.getStatus()==0) {//inactivo
                    status = 1;//activo
                } else {//activo
                   status = 0; 
                }
                
                ps.setInt(1, status);
                ps.setInt(2, idPickingOrder);
                
                List<PickingOrderDetail> list = po.getPickingOrderDetailList();
                int size = list.size();
                for(int i=0;i<size;i++){
                        daoPickingOrderDetail.pickingOrderDetailDel(list.get(i).getIdPicking_Order_Detail(),idPickingOrder,status);
                }
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
    public String pickingOrderUpd(PickingOrder pickingOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PickingOrder pickingOrderGet(Integer idpickingOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PickingOrder pickingOrder = null;
         String sql =  "SELECT idPicking_Order,"
                + "Date,"
                + "status,"
                + "user_created,"
                + "user_updated "
                + "FROM picking_order WHERE idPicking_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idpickingOrder);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                     List<PickingOrderDetail> pickingDetail =  null;
                    PickingOrder po = new PickingOrder();
                    po.setIdPickingOrder(rs.getInt(1));
                    po.setDate(rs.getDate(2));
                    po.setStatus(rs.getInt(3));
                    po.setUserCreated(rs.getInt(4));
                    po.setUserUpdated(rs.getInt(5));
                    pickingDetail = daoPickingOrderDetail.pickingOrderDetailQry(rs.getInt(1));
                    po.setPickingOrderDetailList(pickingDetail);
                }

            } catch (SQLException e) {
                pickingOrder = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return pickingOrder;
    }
    
}
