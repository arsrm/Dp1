/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.ExecutionDetail;
import dao.DaoExecutionDetail;
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
public class DaoExecutionDetailImpl implements DaoExecutionDetail{

    private final ConectaDb db;
    
    public DaoExecutionDetailImpl() {
        db = new ConectaDb();
    }
    
    @Override
    public String executionDetailIns(ExecutionDetail execution) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         String result = null;
        String sql = "INSERT INTO execution_detail("
                + "Execution_Algorithm_idExecutionAlgorithm,Dispatch_Order_idDispatch_Order,"
                + "Dispatch_Order_Picking_Order_idPicking_Order,Vehicle_idVehicle,"
                + "Vehicle_Vehicle_State_idVehicle_State,Vehicle_Driver_idDriver, route_order "
                + ") VALUES(?,?,?,?,?,?,?)";
         
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, execution.getIdExecutionAlgorithm());
                ps.setInt(2, execution.getIdDispatch_Order());
                ps.setInt(3, execution.getIdPicking_Order());
                ps.setInt(4, execution.getIdVehicle());
                ps.setInt(5, execution.getIdVehicle_State());
                ps.setInt(6, execution.getIdDriver());
                ps.setInt(7,execution.getOrder_route());
                
                
                
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
    public List<ExecutionDetail> executionDetailQry(Integer idExecutionAlgorithm) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<ExecutionDetail> list = null;
        String sql =  "select "
                +"Execution_Algorithm_idExecutionAlgorithm,Dispatch_Order_idDispatch_Order,"
                + "Dispatch_Order_Picking_Order_idPicking_Order,Vehicle_idVehicle,"
                + "Vehicle_Vehicle_State_idVehicle_State,Vehicle_Driver_idDriver,route_order "
                +"From  execution_detail where Execution_Algorithm_idExecutionAlgorithm=? "
                + "order by Vehicle_idVehicle,route_order";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                
                ps.setInt(1,idExecutionAlgorithm);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    ExecutionDetail execute = new ExecutionDetail();
                    execute.setIdExecutionAlgorithm(rs.getInt(1));
                    execute.setIdDispatch_Order(rs.getInt(2));
                    execute.setIdPicking_Order(rs.getInt(3));
                    execute.setIdVehicle(rs.getInt(4));
                    execute.setIdVehicle_State(rs.getInt(5));
                    execute.setIdDriver(rs.getInt(6));
                    execute.setOrder_route(rs.getInt(7));
                    list.add(execute);
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
    public ExecutionDetail executionDetailGet(Integer idExecutionAlgorithm, Integer idDispatch, Integer idPicking) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ExecutionDetail executionDetail = null;
        String sql =  "select "
                +"Execution_Algorithm_idExecutionAlgorithm,Dispatch_Order_idDispatch_Order,"
                + "Dispatch_Order_Picking_Order_idPicking_Order,Vehicle_idVehicle,"
                + "Vehicle_Vehicle_State_idVehicle_State,Vehicle_Driver_idDriver, route_order "
                +"From  execution_detail where Execution_Algorithm_idExecutionAlgorithm=?"
                +" AND Dispatch_Order_idDispatch_Order=? AND "
                +" Dispatch_Order_Picking_Order_idPicking_Order=?;";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idExecutionAlgorithm);
                ps.setInt(2,idDispatch);
                ps.setInt(3,idPicking);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    executionDetail = new ExecutionDetail();
                    executionDetail.setIdExecutionAlgorithm(rs.getInt(1));
                    executionDetail.setIdDispatch_Order(rs.getInt(2));
                    executionDetail.setIdPicking_Order(rs.getInt(3));
                    executionDetail.setIdVehicle(rs.getInt(4));
                    executionDetail.setIdVehicle_State(rs.getInt(5));
                    executionDetail.setIdDriver(rs.getInt(6));
                    executionDetail.setOrder_route(rs.getInt(7));
                    
                }

            } catch (SQLException e) {
                executionDetail = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return executionDetail;
    }
    
    @Override
    public List<ExecutionDetail> executionDetailGetByVehicleOrdered(Integer idExecutionAlgorithm, Integer idVehicle) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<ExecutionDetail> list = null;
        String sql =  "select "
                +"Execution_Algorithm_idExecutionAlgorithm,Dispatch_Order_idDispatch_Order,"
                + "Dispatch_Order_Picking_Order_idPicking_Order,Vehicle_idVehicle,"
                + "Vehicle_Vehicle_State_idVehicle_State,Vehicle_Driver_idDriver,route_order "
                +"From  execution_detail where Execution_Algorithm_idExecutionAlgorithm=? "
                +" and Vehicle_idVehicle = ? "
                + "order by Vehicle_idVehicle,route_order";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                
                ps.setInt(1,idExecutionAlgorithm);
                ps.setInt(2,idVehicle);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    ExecutionDetail execute = new ExecutionDetail();
                    execute.setIdExecutionAlgorithm(rs.getInt(1));
                    execute.setIdDispatch_Order(rs.getInt(2));
                    execute.setIdPicking_Order(rs.getInt(3));
                    execute.setIdVehicle(rs.getInt(4));
                    execute.setIdVehicle_State(rs.getInt(5));
                    execute.setIdDriver(rs.getInt(6));
                    execute.setOrder_route(rs.getInt(7));
                    list.add(execute);
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
    public Integer countVehiclesInExecution(Integer idExecutionAlgorithm) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Integer count = 0;
        ExecutionDetail executionDetail = null;
        String sql =  "select COUNT(DISTINCT Vehicle_idVehicle) as count from execution_detail where Execution_Algorithm_idExecutionAlgorithm = ? "
                + "order by Vehicle_idVehicle;";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idExecutionAlgorithm);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
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
    public List<Integer> getClientsFromRoute(Integer idExecutionAlgorithm, Integer idVehicle) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Integer> list = null;
        String sql =  "select  DISTINCT d.idClient from execution_detail e, dispatch_order d"
                + " where Execution_Algorithm_idExecutionAlgorithm = ? and Vehicle_idVehicle = ? "
                + "and d.idDispatch_Order = e.Dispatch_Order_idDispatch_Order order by route_order ;";


        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                
                ps.setInt(1,idExecutionAlgorithm);
                ps.setInt(2,idVehicle);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    list.add(id);
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
