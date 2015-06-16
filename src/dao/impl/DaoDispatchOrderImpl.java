/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.DispatchOrder;
import Model.Driver;
import Model.Vehicle;
import Model.VehicleState;
import dao.DaoDispatchOrder;
import dao.DaoDriver;
import dao.DaoVehicle;
import dao.DaoVehicleState;
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
public class DaoDispatchOrderImpl implements DaoDispatchOrder{
    DaoVehicle daoVehicle = new DaoVehicleImpl();
    
    private final ConectaDb db;
    
    public DaoDispatchOrderImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<DispatchOrder> dispatchOrderQry() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         List<DispatchOrder> list = null;
        String sql =  "SELECT idDispatch_Order,"
                + "idClient,"
                + "departure_date,"
                + "arrival_date,"
                + "status,"
                + "Picking_Order_idPicking_Order, "
                + "idVehicle "
                +"FROM  dispatch_order";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<>();
                while (rs.next()) {
                    DispatchOrder dor = new DispatchOrder();
                    dor.setIdDispatch_Order(rs.getInt(1));
                    dor.setIdClient(rs.getInt(2));
                    dor.setDepartureDate(rs.getDate(3));
                    dor.setArrivalDate(rs.getDate(4));
                    dor.setStatus(rs.getInt(5));
                    dor.setIdPickingOrder(rs.getInt(6));
                    if(rs.getObject(7)!=null){
                        Vehicle veh = daoVehicle.vehicleGet(rs.getInt(7));
                        dor.setIdVehicle(veh);
                    }else
                        dor.setIdVehicle(null);
                    list.add(dor);
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
    public List<DispatchOrder> dispatchOrderQry_search(Integer id, Date fi, Date ff, Integer index_status) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = null;
        int idStatus;
        List<DispatchOrder> dispatchList = null;
        int flag = 0;
        if (fi != null && ff !=null ){
            sql = "SELECT idDispatch_Order,"
                + "idClient,"
                + "departure_date,"
                + "arrival_date,"
                + "status,"
                + "Picking_Order_idPicking_Order, "
                + "idVehicle " 
                + "FROM dispatch_order "
                + "WHERE arrival_date BETWEEN ? AND ? ";
                if(id!=-1)
                    sql+= " AND idClient = ? ";
                if(index_status == 0){ //es cualquiera de los dos tipos
                    sql+="";
                }else
                    sql+= " AND status="+index_status;
            flag = 1;
        }else if(fi != null && ff == null){
             sql = "SELECT idDispatch_Order,"
                + "idClient,"
                + "departure_date,"
                + "arrival_date,"
                + "status,"
                + "Picking_Order_idPicking_Order, "
                + "idVehicle " 
                + "FROM dispatch_order "
                + "WHERE arrival_date >= ? ";
                if(id!=-1)
                    sql+= " AND idClient = ? ";
                if(index_status == 0){ //es cualquiera de los dos tipos
                    sql+="";
                }else
                    sql+= " AND status="+index_status;
             flag = 2;
        }else if (fi == null && ff != null){
           sql = "SELECT idDispatch_Order,"
                + "idClient,"
                + "departure_date,"
                + "arrival_date,"
                + "status,"
                + "Picking_Order_idPicking_Order, "
                + "idVehicle " 
                + "FROM dispatch_order "
                + "WHERE arrival_date <= ? ";
                if(id!=-1)
                    sql+= " AND idClient = ? ";
                if(index_status == 0){ //es cualquiera de los dos tipos
                    sql+="";
                }else
                    sql+= " AND status="+index_status;
            flag = 3;
        }else if (fi == null && ff == null){
            sql = "SELECT idDispatch_Order,"
                + "idClient,"
                + "departure_date,"
                + "arrival_date,"
                + "status,"
                + "Picking_Order_idPicking_Order, "
                + "idVehicle " 
                + "FROM dispatch_order ";
                if(id!=-1){
                    sql+= " WHERE idClient = ? ";
                    if(index_status == 0){ //es cualquiera de los dos tipos
                        sql+="";
                    }else
                        sql+= " AND status="+index_status;
                    }
                    else{
                        if(index_status == 0){ //es cualquiera de los dos tipos
                            sql+="";
                        }else
                            sql+= " WHERE status="+index_status;
                    }
        }
        
        
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

                dispatchList = new LinkedList<>();
                while (rs.next()) {
                    DispatchOrder dor = new DispatchOrder();
                    dor.setIdDispatch_Order(rs.getInt(1));
                    dor.setIdClient(rs.getInt(2));
                    dor.setDepartureDate(rs.getDate(3));
                    dor.setArrivalDate(rs.getDate(4));
                    dor.setStatus(rs.getInt(5));
                    dor.setIdPickingOrder(rs.getInt(6));
                    if(rs.getObject(7)!=null){
                        Vehicle veh = daoVehicle.vehicleGet(rs.getInt(7));
                        dor.setIdVehicle(veh);
                    }else
                        dor.setIdVehicle(null);
                   
                    dispatchList.add(dor);
                }

            } catch (SQLException e) {
                dispatchList = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return dispatchList;
    }
    
    @Override
    public List<DispatchOrder> dispatchOrderQry_search(Integer numDispatchOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = null;
        List<DispatchOrder> dispatchList = null;
        
        if(numDispatchOrder!=-1){
            sql = "SELECT idDispatch_Order,"
                + "idClient,"
                + "departure_date,"
                + "arrival_date,"
                + "status,"
                + "Picking_Order_idPicking_Order, "
                + "idVehicle " 
                + "FROM dispatch_order "
                + "WHERE idDispatch_Order = ? ";
        }else{
            sql = "SELECT idDispatch_Order,"
                + "idClient,"
                + "departure_date,"
                + "arrival_date,"
                + "status,"
                + "Picking_Order_idPicking_Order, "
                + "idVehicle " 
                + "FROM dispatch_order ";
        }
        
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                if(numDispatchOrder!=-1)
                    ps.setInt(1, numDispatchOrder);
                

                ResultSet rs = ps.executeQuery();

                dispatchList = new LinkedList<>();
                while (rs.next()) {
                    DispatchOrder dor = new DispatchOrder();
                    dor.setIdDispatch_Order(rs.getInt(1));
                    dor.setIdClient(rs.getInt(2));
                    dor.setDepartureDate(rs.getDate(3));
                    dor.setArrivalDate(rs.getDate(4));
                    dor.setStatus(rs.getInt(5));
                    dor.setIdPickingOrder(rs.getInt(6));
                    if(rs.getObject(7)!=null){
                        Vehicle veh = daoVehicle.vehicleGet(rs.getInt(7));
                        dor.setIdVehicle(veh);
                    }else
                        dor.setIdVehicle(null);
                    
                    dispatchList.add(dor);
                }

            } catch (SQLException e) {
                dispatchList = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return dispatchList;
    }

    @Override
    public String dispatchOrderIns(DispatchOrder dispatchOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        String result = null;
        String sql = "INSERT INTO dispatch_order("
                + "idClient,"
                + "departure_date,"
                + "arrival_date,"
                + "status,"
                + "Picking_Order_idPicking_Order"
                + ") VALUES(?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,dispatchOrder.getIdClient());
                ps.setDate(2,  new java.sql.Date(dispatchOrder.getDepartureDate().getTime()));
                ps.setDate(3, new java.sql.Date(dispatchOrder.getArrivalDate().getTime()));
                ps.setInt(4, dispatchOrder.getStatus());                
                ps.setInt(5, dispatchOrder.getIdPickingOrder());

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
    public String dispatchOrdersDel(List<Integer> ids) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         String result = null;
        for (Integer id : ids) {
            result = dispatchOrderDel(id);
        }
        return result;
    }

    @Override
    public String dispatchOrderDel(Integer idDispatchOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Integer status;
        String result = null;
        String sql = "UPDATE dispatch_order SET "                
                + "status = ? "
                + "WHERE idDispatch_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                
                DispatchOrder dor = dispatchOrderGet(idDispatchOrder);
                
                if (dor.getStatus()==2 || dor.getStatus()==1 || dor.getStatus()==3) {//pendiente
                    status = 4;//cancelada
                } else {//cancelada
                   status = 2; 
                }
                
                ps.setInt(1, status);
                ps.setInt(2, idDispatchOrder);
            
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
    public DispatchOrder dispatchOrderGet(Integer idDispatchOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         DispatchOrder dispatchOrder = null;
          String sql =  "SELECT idDispatch_Order,"
                + "idClient,"
                + "departure_date,"
                + "arrival_date,"
                + "status,"
                + "Picking_Order_idPicking_Order, "
                + "idVehicle " 
                + "FROM dispatch_order WHERE idDispatch_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idDispatchOrder);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    dispatchOrder = new DispatchOrder();
                    dispatchOrder.setIdDispatch_Order(idDispatchOrder);
                    dispatchOrder.setIdClient(rs.getInt(2));
                    dispatchOrder.setDepartureDate(rs.getDate(3));
                    dispatchOrder.setArrivalDate(rs.getDate(4));
                    dispatchOrder.setStatus(rs.getInt(5));
                    dispatchOrder.setIdPickingOrder(rs.getInt(6));
                    if(rs.getObject(7)!=null){
                        Vehicle veh = daoVehicle.vehicleGet(rs.getInt(7));
                        dispatchOrder.setIdVehicle(veh);
                    }else
                        dispatchOrder.setIdVehicle(null);
                }

            } catch (SQLException e) {
                dispatchOrder = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return dispatchOrder;
    }

    @Override
    public String dispatchOrderUpd(DispatchOrder dispatchOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       String result = null;
        String sql = "UPDATE  dispatch_order SET "
                +" status = ?  "
                + "WHERE  idDispatch_Order=?";
        
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,dispatchOrder.getStatus());
                ps.setInt(2,dispatchOrder.getIdDispatch_Order());
                
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
    public List<DispatchOrder> dispatchOrderQry_search(Date departureDate) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = null;
        int idStatus;
        List<DispatchOrder> dispatchList = null;
        
            sql = "SELECT idDispatch_Order,"
                + "idClient,"
                + "departure_date,"
                + "arrival_date,"
                + "status,"
                + "Picking_Order_idPicking_Order, "
                + "idVehicle "
                + "FROM dispatch_order "
                + "WHERE departure_date = ? ";

        
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
//                java.sql.Date dateIniSql = new java.sql.Date(dateIni.getTime());
                ps.setDate(1, new java.sql.Date(departureDate.getTime()));
                
                ResultSet rs = ps.executeQuery();

                dispatchList = new LinkedList<>();
                while (rs.next()) {
                    DispatchOrder dor = new DispatchOrder();
                    dor.setIdDispatch_Order(rs.getInt(1));
                    dor.setIdClient(rs.getInt(2));
                    dor.setDepartureDate(rs.getDate(3));
                    dor.setArrivalDate(rs.getDate(4));
                    dor.setStatus(rs.getInt(5));
                    dor.setIdPickingOrder(rs.getInt(6));
                    if(rs.getObject(7)!=null){
                        Vehicle veh = daoVehicle.vehicleGet(rs.getInt(7));
                        dor.setIdVehicle(veh);
                    }else
                        dor.setIdVehicle(null);
                   
                    dispatchList.add(dor);
                }

            } catch (SQLException e) {
                dispatchList = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return dispatchList;
    }

    @Override
    public String dispatchOrderAssignVehicle(DispatchOrder dispatchOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String result = null;
        String sql = "UPDATE  dispatch_order SET "
                +" idVehicle = ? "
                + "WHERE  idDispatch_Order=?";
        
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                
                if(dispatchOrder.getIdVehicle()==null)
                    ps.setString(1,null);
                else
                    ps.setInt(1,dispatchOrder.getIdVehicle().getIdVehicle());
                
                ps.setInt(2,dispatchOrder.getIdDispatch_Order());
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
    
    
   
    
}
