/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.ExecutionAlgorithmByDispatch;
import Model.ExecutionAlgorithmByVehicle;
import dao.DaoExecutionAlgorithmByDispatch;
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
public class DaoExecutionAlgorithmByDispatchImpl implements DaoExecutionAlgorithmByDispatch{

    private final ConectaDb db;

    public DaoExecutionAlgorithmByDispatchImpl() {
        db = new ConectaDb();
    }
    
    @Override
    public String executionAlgorithmByDispatchIns(ExecutionAlgorithmByDispatch execution) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String result = null;
        String sql = "INSERT INTO execution_algorithm_by_dispatch("
                +"Dispatch_Order_idDispatch_Order,Execution_Algorithm_idExecutionAlgorithm,"
                + "status"
                + ") VALUES(?,?,?)";
         
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
              
                ps.setInt(1,execution.getDispatch_Order_idDispatch_Order());
                ps.setInt(2, execution.getExecution_Algorithm_idExecutionAlgorithm());
                ps.setInt(3,execution.getStatus());
                
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
    public List<ExecutionAlgorithmByDispatch> executionAlgorithmDispatchQry(Integer idExecutionAlgorithm) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<ExecutionAlgorithmByDispatch> list = null;
        String sql =  "select idExecutionAlgorithmByDispatch,Dispatch_Order_idDispatch_Order,Execution_Algorithm_idExecutionAlgorithm,"
                + "status "
                +"From  execution_algorithm_by_dispatch WHERE Execution_Algorithm_idExecutionAlgorithm=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    ExecutionAlgorithmByDispatch executeDisp = new ExecutionAlgorithmByDispatch();
                    executeDisp.setIdExecutionAlgorithmByDispatch(rs.getInt(1));
                    executeDisp.setDispatch_Order_idDispatch_Order(rs.getInt(2));
                    executeDisp.setExecution_Algorithm_idExecutionAlgorithm(rs.getInt(3));
                    executeDisp.setStatus(rs.getInt(4));
                    list.add(executeDisp);
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
    public List<ExecutionAlgorithmByDispatch> executionAlgorithmVehicleGet(Integer idExecutionAlgorithm, Integer idDispatch) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<ExecutionAlgorithmByDispatch> list =null;
        Integer id=0;
        String sql =  "select idExecutionAlgorithmByVDispatch,Dispatch_Order_idDispatch_Order,Execution_Algorithm_idExecutionAlgorithm,"
                + "status "
                +"From  execution_algorithm_by_dispatch WHERE Execution_Algorithm_idExecutionAlgorithm=? "
                + "AND Dispatch_Order_idDispatch_Order=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,idExecutionAlgorithm);
                ps.setInt(2,idDispatch);
                
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    ExecutionAlgorithmByDispatch executeDisp = new ExecutionAlgorithmByDispatch();
                    executeDisp.setIdExecutionAlgorithmByDispatch(rs.getInt(1));
                    executeDisp.setDispatch_Order_idDispatch_Order(rs.getInt(2));
                    executeDisp.setExecution_Algorithm_idExecutionAlgorithm(rs.getInt(3));
                    executeDisp.setStatus(rs.getInt(4));
                    list.add(executeDisp);
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
