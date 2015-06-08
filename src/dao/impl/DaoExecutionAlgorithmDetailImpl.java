/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.ExecutionAlgorithmDetail;
import dao.DaoExecutionAlgorithmDetail;
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
public class DaoExecutionAlgorithmDetailImpl implements DaoExecutionAlgorithmDetail{

    private final ConectaDb db;

    public DaoExecutionAlgorithmDetailImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<ExecutionAlgorithmDetail> executionAlgorithmQry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExecutionAlgorithmDetail executionAlgorithmGet(Integer idExecutionAlgorithm, Integer idDispatchOrder, Integer idPickingOrder) {
        ExecutionAlgorithmDetail executionAlgorithmDetail =null;
        Integer id=0;
        String sql ="SELECT "
                + "Execution_Algorithm_idExecutionAlgorithm, "
                + "Dispatch_Order_idDispatch_Order, "
                + "Dispatch_Order_Picking_Order_idPicking_Order, "
                + "Vehicle_idVehicle, "
                + "Vehicle_Vehicle_State_idVehicle_State"
                + "Vehicle_Driver_idDriver "
                + "FROM Execution_Detail "
                + "WHERE Execution_Algorithm_idExecutionAlgorithm = ? AND "
                + "Dispatch_Order_idDispatch_Order = ? AND "
                + "Dispatch_Order_Picking_Order_idPicking_Order = ?; ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idExecutionAlgorithm);
                ps.setInt(2, idDispatchOrder);
                ps.setInt(3, idPickingOrder);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    executionAlgorithmDetail = new ExecutionAlgorithmDetail();
                    executionAlgorithmDetail.setExecution_Algorithm_idExecutionAlgorithm(rs.getInt(1));
                    executionAlgorithmDetail.setDispatch_Order_idDispatch_Order(rs.getInt(2));
                    executionAlgorithmDetail.setDispatch_Order_Picking_Order_idPicking_Order(rs.getInt(3));
                    executionAlgorithmDetail.setVehicle_idVehicle(rs.getInt(4));
                    executionAlgorithmDetail.setVehicle_Vehicle_State_idVehicle_State(rs.getInt(5));
                    executionAlgorithmDetail.setVehicle_Driver_idDriver(rs.getInt(6));
                }
            } catch (SQLException e) {
               executionAlgorithmDetail=null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return executionAlgorithmDetail;
    }

    
    
}
