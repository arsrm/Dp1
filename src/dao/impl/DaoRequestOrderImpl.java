/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.Client;
import Model.PickingOrder;
import Model.RequestOrder;
import Model.RequestOrderDetail;
import dao.DaoClient;
import dao.DaoPickingOrder;
import dao.DaoRequestOrder;
import dao.DaoRequestOrderDetail;
import dao.DaoStateRequestOrder;
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
public class DaoRequestOrderImpl implements DaoRequestOrder{

    private final ConectaDb db;
    private DaoRequestOrderDetail daoRequestOrderDetail = new DaoRequestOrderDetailImpl();
    private DaoPickingOrder daoPickingOrder = new DaoPickingOrderImpl();

    public DaoRequestOrderImpl() {
        db = new ConectaDb();
    }
    
    @Override
    public List<RequestOrder> requestOrderQry() {
        List<RequestOrder> list = null;
        String sql =  "SELECT idRequest_Order,"
                + "dateArrive,"
                + "dateline,"
                + "Client_idClient,"
                + "status,"
                + "State_Request_Order_idStateRequest_Order,"
                + "user_created,"
                + "user_updated "
                +"FROM  request_order";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<>();
                while (rs.next()) {
                    List<RequestOrderDetail> requestDetail =  null;
                    RequestOrder ro = new RequestOrder();
                    ro.setIdRequestOrder(rs.getInt(1));
                    requestDetail = daoRequestOrderDetail.requestOrderDetailQry(rs.getInt(1));
                    ro.setDateArrive(rs.getDate(2));
                    ro.setDateline(rs.getDate(3));
                    DaoClient daoClient = new DaoClientImpl();
                   
                    Client client = daoClient.clientGet(rs.getInt(4));
                    ro.setClient(client);
                    ro.setStatus(rs.getInt(5));
                    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
                    ro.setStateRequestOrder(daoStateRequestOrder.stateRequestOrderGet(rs.getInt(6)));
                    ro.setUserCreated(rs.getInt(7));
                    ro.setUserUpdated(rs.getInt(8));
                    ro.setRequestOrderDetailList(requestDetail);
                    list.add(ro);
                    
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
    public List<RequestOrder> requestOrderQry_search(Integer id, Date dateFrom, Date dateTo,Integer index_status) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = null;
        
        int idStatus;
        List<RequestOrder> requestOrders = null;
        if(dateFrom==null){
            dateFrom = new Date();
            dateFrom.setTime(0);
        }
        if(dateTo == null){
            dateTo = new Date();
        }
        
        if(id!=-1){
            sql = "SELECT idRequest_Order,"
                + "dateArrive,"
                + "dateline,"
                + "Client_idClient,"
                + "status,"
                + "State_Request_Order_idStateRequest_Order,"
                + "user_created,"
                + "user_updated "
                + "FROM request_order "
                + "WHERE dateline >= ? "
                + "AND dateline <= ? "
                + "AND Client_idClient = ? ";
        }else{
            sql = "SELECT idRequest_Order,"
                + "dateArrive,"
                + "dateline,"
                + "Client_idClient,"
                + "status,"
                + "State_Request_Order_idStateRequest_Order,"
                + "user_created,"
                + "user_updated "
                + "FROM request_order "
                + "WHERE dateline >= ? "
                + "AND dateline <= ? ";
        }

        if(index_status == 0){ //es cualquiera de los dos tipos
            sql+="";
        }else if(index_status == 1){ //atendido
            sql+= "AND State_Request_Order_idStateRequest_Order=1";
        }else if(index_status==2){//pendiente
            sql+= "AND State_Request_Order_idStateRequest_Order=2";
        }else if(index_status==3){//cancelado
            sql+= "AND State_Request_Order_idStateRequest_Order=3";
        }
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
//                java.sql.Date dateIniSql = new java.sql.Date(dateIni.getTime());
                ps.setDate(1, new java.sql.Date(dateFrom.getTime()));
                ps.setDate(2, new java.sql.Date(dateTo.getTime()));
                if(id!=-1)
                    ps.setInt(3,id);

                ResultSet rs = ps.executeQuery();

                requestOrders = new LinkedList<>();
                while (rs.next()) {
                    List<RequestOrderDetail> requestDetail =  null;
                    RequestOrder ro = new RequestOrder();
                    ro.setIdRequestOrder(rs.getInt(1));
                    requestDetail = daoRequestOrderDetail.requestOrderDetailQry(rs.getInt(1));
                    ro.setDateArrive(rs.getDate(2));
                    ro.setDateline(rs.getDate(3));
                    DaoClient daoClient = new DaoClientImpl();
                   
                    Client client = daoClient.clientGet(rs.getInt(4));
                    ro.setClient(client);
                    ro.setStatus(rs.getInt(5));
                    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
                    ro.setStateRequestOrder(daoStateRequestOrder.stateRequestOrderGet(rs.getInt(6)));
                    ro.setUserCreated(rs.getInt(7));
                    ro.setUserUpdated(rs.getInt(8));
                    ro.setRequestOrderDetailList(requestDetail);
                    requestOrders.add(ro);
                }

            } catch (SQLException e) {
                requestOrders = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return requestOrders;
    }

    @Override
    public String requestOrderIns(RequestOrder requestOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DaoRequestOrderDetail daoRequestOrderDetail = new DaoRequestOrderDetailImpl();
        String result = null;
        String sql = "INSERT INTO request_order("
                + "idRequest_Order,"
                + "dateArrive,"
                + "dateline,"
                + "Client_idClient,"
                + "status,"
                + "State_Request_Order_idStateRequest_Order,"
                + "user_created,"
                + "user_updated"
                + ") VALUES(?,?,?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, requestOrder.getIdRequestOrder());
                ps.setDate(2,  new java.sql.Date(requestOrder.getDateArrive().getTime()));
                ps.setDate(3, new java.sql.Date(requestOrder.getDateline().getTime()));
                ps.setInt(5, requestOrder.getClient().getIdClient());                
                ps.setInt(4, requestOrder.getStatus());
                ps.setInt(6, requestOrder.getStateRequestOrder().getIdStateRequestOrder());
                ps.setInt(7, requestOrder.getUserCreated());
                if(requestOrder.getUserUpdated()==null){
                    ps.setNull(8, java.sql.Types.NULL);
                }else{
                    ps.setInt(8, requestOrder.getUserUpdated());
                }
                             

                int ctos = ps.executeUpdate();
                List<RequestOrderDetail> list = requestOrder.getRequestOrderDetailList();
                int sizeRequest = list.size();
                
                for(int i=0;i<sizeRequest;i++){
                    daoRequestOrderDetail.requestOrderIns(list.get(i));
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
    public String requestOrderDel(Integer idRequestOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Integer status;
        Integer status_detail;
        DaoRequestOrderDetail daoDetail = new DaoRequestOrderDetailImpl();
        String result = null;
        String sql = "UPDATE request_order SET "                
                + "State_Request_Order_idStateRequest_Order = ? "
                + "WHERE idRequest_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
               
                RequestOrder ro = requestOrderGet(idRequestOrder);
                
                if (ro.getStateRequestOrder().getIdStateRequestOrder()==2) {//pendiente
                    status = 3;//cancelada
                    status_detail = 0;
                } else {//cancelada
                   status = 2; 
                   status_detail = 1;
                }
                
                ps.setInt(1, status);
                ps.setInt(2, idRequestOrder);
                
                List<RequestOrderDetail> list = ro.getRequestOrderDetailList();
                int size = list.size();
                for(int i=0;i<size;i++){
                        daoDetail.requestOrderDetailDel(list.get(i).getIdRequest_Order_Detail(),idRequestOrder,status_detail);
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
    public RequestOrder requestOrderGet(Integer idRequestOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         RequestOrder requestOrder = null;
          String sql =  "SELECT idRequest_Order,"
                + "dateArrive,"
                + "dateline,"
                + "Client_idClient,"
                + "status,"
                + "State_Request_Order_idStateRequest_Order,"
                + "user_created,"
                + "user_updated "
                + "FROM request_order WHERE idRequest_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idRequestOrder);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    requestOrder = new RequestOrder();
                    requestOrder.setIdRequestOrder(idRequestOrder);
                    List<RequestOrderDetail> requestDetail =  null;
                    requestDetail = daoRequestOrderDetail.requestOrderDetailQry(rs.getInt(1));
                    requestOrder.setDateArrive(rs.getDate(2));
                    requestOrder.setDateline(rs.getDate(3));
                    DaoClient daoClient = new DaoClientImpl();
                    Client client = daoClient.clientGet(rs.getInt(4));
                    requestOrder.setClient(client);
                    requestOrder.setStatus(rs.getInt(5));
                    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
                    requestOrder.setStateRequestOrder(daoStateRequestOrder.stateRequestOrderGet(rs.getInt(6)));
                    requestOrder.setUserCreated(rs.getInt(7));
                    requestOrder.setUserUpdated(rs.getInt(8));
                    requestOrder.setRequestOrderDetailList(requestDetail);
                }

            } catch (SQLException e) {
                requestOrder = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return requestOrder;
    }

    @Override
    public String requestOrderUpd(RequestOrder requestOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String requestsDel(List<Integer> requestListToDelete) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String result = null;
        for (Integer id : requestListToDelete) {
            result = requestOrderDel(id);
        }
        return result;
    }

    @Override
    public String requestsDelInvalidate(Integer idRequest) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        DaoRequestOrderDetail daoDetail = new DaoRequestOrderDetailImpl();
        String result = null;
        String sql = "UPDATE request_order SET "
                + "status = ? ,"
                + "State_Request_Order_idStateRequest_Order = ? "
                + "WHERE idRequest_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
               
                RequestOrder ro = requestOrderGet(idRequest);
               
                
                ps.setInt(1, 0);//se cambia a cero el campo status
                ps.setInt(2,3);
                ps.setInt(3, idRequest);
                
                List<RequestOrderDetail> list = ro.getRequestOrderDetailList();
                int size = list.size();
                for(int i=0;i<size;i++){
                        daoDetail.requestOrderDetailDel(list.get(i).getIdRequest_Order_Detail(),idRequest,0);
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
    
}
