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
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DaoPickingOrderImpl implements DaoPickingOrder {
    DaoPickingOrderDetail daoPickingOrderDetail = new DaoPickingOrderDetailImpl();
    private final ConectaDb db;
    
    public DaoPickingOrderImpl() {
        db = new ConectaDb();
    }
    @Override
    public List<PickingOrder> pickingOrderQry() {
        List<PickingOrder> list = null;
        String sql =  "SELECT idPicking_Order,"
                + "Date,"
                + "status,"
                + "Request_Order_idRequest_Order "
                +"FROM  Picking_Order";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<>();
                while (rs.next()) {
                    PickingOrder po = new PickingOrder();
                    po.setIdPickingOrder(rs.getInt(1));
                    po.setDate(rs.getDate(2));
                    po.setStatus(rs.getInt(3));
                    po.setIdRequest_Order(rs.getInt(4));
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
    public List<PickingOrder> pickingOrderQry_search(Date fi , Date ff){
     
        List<PickingOrder> list = null;
        String sql =null;
        Integer flag = 0; 
       if (fi != null && ff !=null ){
         sql =  "select idPicking_Order ,"
                + "Date,"
                + "status,"
                + "Request_Order_idRequest_Order "
                + "from Picking_Order "
                 + "where Date BETWEEEN ? AND ? ";
         flag = 1; 
       }
       else if (fi != null && ff == null){
         sql =  "select idPicking_Order ,"
                + "Date,"
                + "status,"
                + "Request_Order_idRequest_Order "
                 + "from Picking_Order "
                + "where Date >=  ? ";
         flag = 2; 
       }
       else if (fi == null && ff != null){
       
         sql =  "select idPicking_Order ,"
                + "Date,"
                + "status,"
                + "Request_Order_idRequest_Order "
                 + "from Picking_Order "
                + "where Date <=  ? ";
         flag = 3; 
       }
       else if (fi == null && ff == null){
       sql =  "select idPicking_Order ,"
                + "Date,"
                + "status,"
                + "Request_Order_idRequest_Order "
                + " from Picking_Order";
        
       }
       
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                if (flag == 1 ){
                ps.setDate(1,  new java.sql.Date(fi.getTime()));
                ps.setDate(2,  new java.sql.Date(ff.getTime()));
                }
                else if (flag ==2 ){
                ps.setDate(1,  new java.sql.Date(fi.getTime()));
                }
                else if (flag ==3 ){
                ps.setDate(1,  new java.sql.Date(ff.getTime()));
                }
                
                ResultSet rs = ps.executeQuery();
                
                list = new LinkedList<>();
                while (rs.next()) {
                   PickingOrder order = new PickingOrder();
                   order.setIdPickingOrder(rs.getInt(1));
                   order.setDate(rs.getDate(2));
                   order.setStatus(rs.getInt(3));
                   order.setIdRequest_Order(rs.getInt(4));
                   list.add(order);
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
     public List<PickingOrder> pickingOrderQry_search(Integer numOrden ){
        
        List<PickingOrder> list = null;
        Integer flag =0 ;
        String sql = null;
              if (numOrden !=null ){
                sql=   "select idPicking_Order ,"
                + "Date,"
                + "status,"
                + "Request_Order_idRequest_Order "
                 + "from Picking_Order "
                + "where Request_Order_idRequest_Order =  ? ";
                flag =1 ;
              }
              else if (numOrden ==null ){
                sql=   "select idPicking_Order ,"
                + "Date,"
                + "status,"
                + "Request_Order_idRequest_Order "
                 + "from Picking_Order ";
                flag = 2 ; 
                
              }
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                  if (flag ==1) 
                  ps.setInt(1,numOrden);
                 
                ResultSet rs = ps.executeQuery();
                
                list = new LinkedList<>();
                while (rs.next()) {
                   PickingOrder order = new PickingOrder();
                   order.setIdPickingOrder(rs.getInt(1));
                   order.setDate(rs.getDate(2));
                   order.setStatus(rs.getInt(3));
                   order.setIdRequest_Order(rs.getInt(4));
                   list.add(order);
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
    public Integer pickingOrderIns(PickingOrder pickingOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Integer idGenerated = -1;
        String sql = "INSERT INTO picking_order("
                + "Date,"
                + "status,"
                + "Request_Order_idRequest_Order"
                + ") VALUES(?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setDate(1,  new java.sql.Date(pickingOrder.getDate().getTime()));
                ps.setInt(2, pickingOrder.getStatus());
                ps.setInt(3, pickingOrder.getIdRequest_Order());
                
               
                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    throw new SQLException("0 filas afectadas");
                }
                
                //this is an error since the above is an error
                System.out.println("HOLI 0");
                ResultSet rs = ps.getGeneratedKeys();
                System.out.println("HOLI");
                rs.next();
                System.out.println("HOLI 2");
                idGenerated = rs.getInt(1);
                System.out.println("HOLI 3");
                
               

            } catch (SQLException e) {
                System.out.println("JEJE");
              idGenerated=-1;  
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return idGenerated;
    }

    @Override
    public String pickingOrderDel(Integer idPickingOrder, Integer status) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        String result = null;
        String sql = "UPDATE Picking_Order SET "                
                + "status = ? "
                + "WHERE idPicking_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, status);
                ps.setInt(2, idPickingOrder);
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
        
        String result = null;
        String sql = "UPDATE Picking_Order SET "                
                + "status = ? "
                + "WHERE idPicking_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, pickingOrder.getStatus());
                ps.setInt(2, pickingOrder.getIdPickingOrder());
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
    public PickingOrder pickingOrderGet(Integer idpickingOrder) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PickingOrder pickingOrder = null;
         String sql =  "SELECT idPicking_Order,"
                + "Date,"
                + "status,"
                + "Request_Order_idRequest_Order "
                + "FROM Picking_Order WHERE idPicking_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idpickingOrder);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    pickingOrder = new PickingOrder();
                    pickingOrder.setIdPickingOrder(rs.getInt(1));
                    pickingOrder.setDate(rs.getDate(2));
                    pickingOrder.setStatus(rs.getInt(3));
                    pickingOrder.setIdRequest_Order(rs.getInt(4));
                    
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
