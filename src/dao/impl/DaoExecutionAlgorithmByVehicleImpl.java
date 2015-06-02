/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.ExecutionAlgorithmByVehicle;
import dao.DaoExecutionAlgorithmByVehicle;
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
public class DaoExecutionAlgorithmByVehicleImpl implements DaoExecutionAlgorithmByVehicle {

    private final ConectaDb db;

    public DaoExecutionAlgorithmByVehicleImpl() {
        db = new ConectaDb();
    }
    
    @Override
    public String executionAlgorithmByVehicleIns(ExecutionAlgorithmByVehicle execution) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String result = null;
        String sql = "INSERT INTO execution_algorithm_by_vehicle("
                +"route,Execute_Algorithm_idExecutionAlgorithm,Vehicle_idVehicle,"
                + "Vehicle_Vehicle_State_idVehicle_State,Vehicle_Driver_idDriver"
                + ") VALUES(?,?,?,?,?)";
         
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
              
                ps.setString(1,execution.getRoute());
                ps.setInt(2, execution.getExecution_Algorithm_idExecutionAlgorithm());
                ps.setInt(3,execution.getVehicle_idVehicle());
                ps.setInt(4, execution.getVehicle_Vehicle_State_idVehicleState());
                ps.setInt(5, execution.getVehicle_Driver_idDriver());
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
    public List<ExecutionAlgorithmByVehicle> executionAlgorithmVehicleQry(Integer idExecutionAlgorithm) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<ExecutionAlgorithmByVehicle> list = null;
        String sql =  "select idExecutionAlgorithmByVehicle,route,Execution_Algorithm_idExecutionAlgorithm,Vehicle_idVehicle,Vehicle_Vehicle_State_idVehicle_State,"
                + "Vehicle_Driver_idDriver "
                +"From  execution_algorithm_by_vehicle WHERE Execution_Algorithm_idExecutionAlgorithm=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    ExecutionAlgorithmByVehicle executeVec = new ExecutionAlgorithmByVehicle();
                    executeVec.setIdExecutionAlgorithmByVehicle(rs.getInt(1));
                    executeVec.setRoute(rs.getString(2));
                    executeVec.setExecution_Algorithm_idExecutionAlgorithm(rs.getInt(3));
                    executeVec.setVehicle_idVehicle(rs.getInt(4));
                    executeVec.setVehicle_Vehicle_State_idVehicleState(rs.getInt(5));
                    executeVec.setVehicle_Driver_idDriver(rs.getInt(6));
                    list.add(executeVec);
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
    public List<ExecutionAlgorithmByVehicle> executionAlgorithmVehicleGet(Integer idExecutionAlgorithm,Integer idVehicle ) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<ExecutionAlgorithmByVehicle> list =null;
        Integer id=0;
        String sql =  "select idExecutionAlgorithmByVehicle,route,Execution_Algorithm_idExecutionAlgorithm,Vehicle_idVehicle,Vehicle_Vehicle_State_idVehicle_State,"
                + "Vehicle_Driver_idDriver "
                +"From  execution_algorithm_by_vehicle WHERE Execution_Algorithm_idExecutionAlgorithm=? "
                + "AND Vehicle_idVehicle=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,idExecutionAlgorithm);
                ps.setInt(2,idVehicle);
                
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    ExecutionAlgorithmByVehicle executeVec = new ExecutionAlgorithmByVehicle();
                    executeVec.setIdExecutionAlgorithmByVehicle(rs.getInt(1));
                    executeVec.setRoute(rs.getString(2));
                    executeVec.setExecution_Algorithm_idExecutionAlgorithm(rs.getInt(3));
                    executeVec.setVehicle_idVehicle(rs.getInt(4));
                    executeVec.setVehicle_Vehicle_State_idVehicleState(rs.getInt(5));
                    executeVec.setVehicle_Driver_idDriver(rs.getInt(6));
                    list.add(executeVec);
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
