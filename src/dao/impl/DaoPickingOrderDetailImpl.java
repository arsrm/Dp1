/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Model.PickingOrderDetail;
import dao.DaoPickingOrderDetail;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class DaoPickingOrderDetailImpl implements DaoPickingOrderDetail{

    
     private final ConectaDb db;
    
    public DaoPickingOrderDetailImpl() {
        db = new ConectaDb();
    }
    @Override
    public List<PickingOrderDetail> pickingOrderDetailQry(Integer idPickingOrder) {
        List<PickingOrderDetail> list = null;
        String sql =  "SELECT idPicking_Order_Detail,"
                + "status,"
                + "Picking_Order_idPicking_Order,"
                + "idPallet_By_Product_By_Location_Cell_Detail "
                +"FROM Picking_Order_Detail "
                + "where  Picking_Order_idPicking_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<>();
                while (rs.next()) {
                    PickingOrderDetail po = new PickingOrderDetail();
                    po.setIdPicking_Order_Detail(rs.getInt(1));
                    po.setStatus(rs.getInt(2));
                    po.setPicking_Order_idPicking_Order(rs.getInt(3));
                    po.setIdPallet_By_Product_By_Location_Cell_Detail(rs.getInt(4));
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
    public String pickingOrderDetailIns(PickingOrderDetail pickingOrderDetail){
       
        String result = null;
        String sql = "INSERT INTO Picking_Order_Detail("
                + "status,"
                + "Picking_Order_idPicking_Order,"
                + "idPallet_By_Product_By_Location_Cell_Detail"
                + ") VALUES(?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, pickingOrderDetail.getStatus() );
                ps.setInt(3, pickingOrderDetail.getPicking_Order_idPicking_Order());
                ps.setInt(4, pickingOrderDetail.getIdPallet_By_Product_By_Location_Cell_Detail());
                
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
    public String pickingOrderDetailDel(Integer idPickingOrderDetail,Integer idPickingOrder,Integer status){
        String result = null;
        String sql = "UPDATE Picking_Order_Detail SET "                
                + "status = ? "
                + "WHERE  idPicking_Order_Detail= ? AND Picking_Order_idPicking_Order = ? ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, status);
                ps.setInt(2, idPickingOrderDetail);
                ps.setInt(3, idPickingOrder);
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
    public PickingOrderDetail pickingOrderDetailGet(Integer idpickingOrderDetail){
       
           PickingOrderDetail pickingOrder = null;
         String sql =  "SELECT idPicking_Order_Detail,"
                + "status,"
                + " Picking_Order_idPicking_Order,"
                 + "idPallet_By_Product_By_Location_Cell_Detail"
                + "FROM Picking_Order_Detail WHERE idPicking_Order_Detail = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idpickingOrderDetail);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    PickingOrderDetail po = new PickingOrderDetail();
                    po.setIdPicking_Order_Detail(rs.getInt(1));
                    po.setStatus(rs.getInt(2));
                    po.setPicking_Order_idPicking_Order(rs.getInt(3));
                    po.setIdPallet_By_Product_By_Location_Cell_Detail(rs.getInt(4));
                    
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
    
     @Override
    public List<PickingOrderDetail> pickingOrderDetailFind(Integer pickingOrder , Integer numpallet , Integer codProd){
        
        List<PickingOrderDetail> list = null;
        String sql = null;
                sql=    "select  Pallet_By_Product.status 'Estado',"
                        + "expiration_date,idPallet_By_Product_By_Location_Cell_Detail,"
                        + "Pallet_By_Product_Product_idProduct "
                        + "from Pallet_By_Product_By_Location_Cell_Detail"
                        +"Left Join Pallet_By_Product on "
                        +"(Pallet_By_Product.Product_idProduct="
                        + "Pallet_By_Product_By_Location_Cell_Detail.Pallet_By_Product_Product_idProduct)"
                        +"where Pallet_By_Product_Product_idProduct = ? "
                        + "and  Pallet_By_Product_By_Location_Cell_Detail.status='1'" //codigo estatus
                        +"order by expiration_date asc "
                        +"limit ?";
                        
                        
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                 
                  ps.setInt(1,codProd);
                  ps.setInt(1,numpallet);
                ResultSet rs = ps.executeQuery();
                
                list = new LinkedList<>();
                while (rs.next()) {
                   PickingOrderDetail order = new PickingOrderDetail();
                   order.setIdPallet_By_Product_By_Location_Cell_Detail(rs.getInt(3));
                   order.setPicking_Order_idPicking_Order(pickingOrder);
                   order.setStatus(2);
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
    
}
