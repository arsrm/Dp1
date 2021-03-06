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
                + "State_Request_Order_idStateRequest_Order "
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
                    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
                    ro.setStateRequestOrder(daoStateRequestOrder.stateRequestOrderGet(rs.getInt(5)));
                   
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
    public List<RequestOrder> requestOrderQry_search(Integer id, Date fi, Date ff,Integer index_status) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = null;
        int flag = 0;
        if (fi != null && ff !=null ){
            sql = "SELECT idRequest_Order,"
                + "dateArrive,"
                + "dateline,"
                + "Client_idClient,"
                + "State_Request_Order_idStateRequest_Order "
                + "FROM request_order "
                + "WHERE dateline BETWEEN ? AND ? ";
                if(id!=-1)
                    sql+= " AND Client_idClient = ? ";
                if(index_status == 0){ //es cualquiera de los dos tipos
                    sql+="";
                }else
                    sql+= " AND State_Request_Order_idStateRequest_Order="+index_status;
            flag = 1;
        }else if(fi != null && ff == null){
             sql = "SELECT idRequest_Order,"
                + "dateArrive,"
                + "dateline,"
                + "Client_idClient,"
                + "State_Request_Order_idStateRequest_Order "
                + "FROM request_order "
                + "WHERE dateline >= ? ";
                if(id!=-1)
                    sql+= " AND Client_idClient = ? ";
                if(index_status == 0){ //es cualquiera de los dos tipos
                    sql+="";
                }else
                    sql+= " AND State_Request_Order_idStateRequest_Order="+index_status;
             flag = 2;
        }else if (fi == null && ff != null){
            sql = "SELECT idRequest_Order,"
                + "dateArrive,"
                + "dateline,"
                + "Client_idClient,"
                + "State_Request_Order_idStateRequest_Order "
                + "FROM request_order "
                + "WHERE dateline <= ? ";
                if(id!=-1)
                    sql+= " AND Client_idClient = ? ";
                if(index_status == 0){ //es cualquiera de los dos tipos
                    sql+="";
                }else
                    sql+= " AND State_Request_Order_idStateRequest_Order="+index_status;
            flag = 3;
        }else if (fi == null && ff == null){
            sql = "SELECT idRequest_Order,"
                + "dateArrive,"
                + "dateline,"
                + "Client_idClient,"
                + "State_Request_Order_idStateRequest_Order "
                + "FROM request_order ";
                if(id!=-1){
                     sql+= " WHERE Client_idClient = ? ";
                        if(index_status == 0){ //es cualquiera de los dos tipos
                            sql+="";
                        }else
                            sql+= " AND State_Request_Order_idStateRequest_Order="+index_status;
                    }
                    else{
                        if(index_status == 0){ //es cualquiera de los dos tipos
                            sql+="";
                        }else
                            sql+= " WHERE State_Request_Order_idStateRequest_Order="+index_status;
                    }
        }
        
        
        
        
        
        int idStatus;
        List<RequestOrder> requestOrders = null;
        
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
//                java.sql.Date dateIniSql = new java.sql.Date(dateIni.getTime());
                if (flag == 1 ){
                    ps.setDate(1,  new java.sql.Date(fi.getTime()));
                    ps.setDate(2,  new java.sql.Date(ff.getTime()));
                    if(id!=-1)
                        ps.setInt(3,id);                    
                }
                else if (flag ==2 ){
                    ps.setDate(1,  new java.sql.Date(fi.getTime()));
                    if(id!=-1)
                        ps.setInt(2,id);
                }
                else if (flag ==3 ){
                    ps.setDate(1,  new java.sql.Date(ff.getTime()));
                    if(id!=-1)
                        ps.setInt(2,id);
                     
                }else{
                    if(id!=-1)
                        ps.setInt(1,id);     
                    
                }
                
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
                    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
                    ro.setStateRequestOrder(daoStateRequestOrder.stateRequestOrderGet(rs.getInt(5)));
                    
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
                + "dateline,"
                + "Client_idClient,"
                + "State_Request_Order_idStateRequest_Order"
                + ") VALUES(?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, requestOrder.getIdRequestOrder());
                ps.setDate(2, new java.sql.Date(requestOrder.getDateline().getTime()));
                ps.setInt(3, requestOrder.getClient().getIdClient()); 
                ps.setInt(4, requestOrder.getStateRequestOrder().getIdStateRequestOrder());
               
                             
                
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
                + "State_Request_Order_idStateRequest_Order "
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
                    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
                    requestOrder.setStateRequestOrder(daoStateRequestOrder.stateRequestOrderGet(rs.getInt(5)));
                    
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String result = null;
        String sql = "UPDATE  request_order SET "
                +"State_Request_Order_idStateRequest_Order = ?  "
                + "WHERE idRequest_Order=? ";
        
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,requestOrder.getStateRequestOrder().getIdStateRequestOrder());
                ps.setInt(2,requestOrder.getIdRequestOrder());
                
                int ctos = ps.executeUpdate();
                
                if (ctos == 0) {
                    throw new SQLException("0 filas afectadas");
                }
                
                List<RequestOrderDetail> list = requestOrder.getRequestOrderDetailList();
                int size = list.size();
                for(int i=0;i<size;i++){
                    daoRequestOrderDetail.requestOrderDetailUpd(list.get(i));
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
                + "State_Request_Order_idStateRequest_Order = ? "
                + "WHERE idRequest_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
               
                RequestOrder ro = requestOrderGet(idRequest);
               
                
                ps.setInt(1,3);
                ps.setInt(2, idRequest);
                
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
  
      @Override
    public RequestOrder requestOrderGetClient(Integer idclient) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         RequestOrder requestOrder = null;
          String sql =  "SELECT idRequest_Order,"
                + "dateArrive,"
                + "dateline,"
                + "Client_idClient,"
                + "State_Request_Order_idStateRequest_Order "
                + "FROM request_order WHERE Client_idClient = ?"
                + " AND State_Request_Order_idStateRequest_Order = 2  ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idclient);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    requestOrder = new RequestOrder();
                    requestOrder.setIdRequestOrder(rs.getInt(1));
                    List<RequestOrderDetail> requestDetail =  null;
                    requestDetail = daoRequestOrderDetail.requestOrderDetailQry(rs.getInt(1));
                    requestOrder.setDateArrive(rs.getDate(2));
                    requestOrder.setDateline(rs.getDate(3));
                    DaoClient daoClient = new DaoClientImpl();
                    Client client = daoClient.clientGet(rs.getInt(4));
                    requestOrder.setClient(client);
                    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
                    requestOrder.setStateRequestOrder(daoStateRequestOrder.stateRequestOrderGet(rs.getInt(5)));
                    
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
    public List<RequestOrder> requestOrderQryByStatus(Integer status) {
        List<RequestOrder> list = null;
        String sql =  "SELECT idRequest_Order,"
                + "dateArrive,"
                + "dateline,"
                + "Client_idClient,"
                + "State_Request_Order_idStateRequest_Order "
                +"FROM  request_order "
                + "WHERE State_Request_Order_idStateRequest_Order=? ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, status);
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
                    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
                    ro.setStateRequestOrder(daoStateRequestOrder.stateRequestOrderGet(rs.getInt(5)));
                   
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
    public Integer getQuantityDispatchesDeliveredCanceled(Integer idRequest) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Integer count = 0;
        String sql =  "select COUNT(d.`idDispatch_Order`) as count from request_order r,picking_order p,dispatch_order d"
                + " where r.`idRequest_Order` = p.`Request_Order_idRequest_Order` and d.`Picking_Order_idPicking_Order` = p.`idPicking_Order` and r.`idRequest_Order`=?"
                + " and (d.status=1 OR d.status=4)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,idRequest);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    count = rs.getInt("count");
                    
                }

            } catch (SQLException e) {
                count = 0;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return count;
    }

    @Override
    public String setDateArrivalToRequest(RequestOrder ro) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DaoRequestOrderDetail daoDetail = new DaoRequestOrderDetailImpl();
        String result = null;
        String sql = "UPDATE request_order SET "
                + "dateArrive = ? "
                + "WHERE idRequest_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
               
                
                ps.setDate(1,new java.sql.Date(ro.getDateArrive().getTime()));
                ps.setInt(2, ro.getIdRequestOrder());
               
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
