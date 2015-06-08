/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.ExecutionAlgorithm;
import dao.DaoExecutionAlgorithm;
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
public class DaoExecutionAlgorithmImpl implements DaoExecutionAlgorithm{

    private final ConectaDb db;

    public DaoExecutionAlgorithmImpl() {
        db = new ConectaDb();
    }

    
    @Override
    public String executionAlgorithmIns(ExecutionAlgorithm execution) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String result = null;
        String sql = "INSERT INTO execution_algorithm("
                +"date,status,function_value,vehicles_number"
                + ") VALUES(?,?,?,?)";
         
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
              
                ps.setDate(1, new java.sql.Date(execution.getDate().getTime()));
                ps.setInt(2,execution.getStatus() );
                ps.setDouble(3, execution.getFunction_value());
                ps.setInt(4, execution.getVehicles_number());
                
                
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
    public List<ExecutionAlgorithm> executionAlgorithmQry() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<ExecutionAlgorithm> list = null;
        String sql =  "select idExecutionAlgorithm,date,status,function_value,vehicles_number "
                +"From  execution_algorithm";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    ExecutionAlgorithm execute = new ExecutionAlgorithm();
                    execute.setIdExecutionAlgorithm(rs.getInt(1));
                    execute.setDate(rs.getDate(2));
                    execute.setStatus(rs.getInt(3));
                    execute.setFunction_value(rs.getDouble(4));
                    execute.setVehicles_number(rs.getInt(5));
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
    public ExecutionAlgorithm executionAlgorithmGet(Integer idExecutionAlgorithm) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ExecutionAlgorithm execute =null;
        Integer id=0;
        String sql ="select idExecutionAlgorithm,date,status,function_value,vehicles_number "
                +" From  execute_algorithm where idExecutionAlgorithm = ?";


        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idExecutionAlgorithm);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    execute = new ExecutionAlgorithm();
                    execute.setIdExecutionAlgorithm(idExecutionAlgorithm);
                    execute.setDate(rs.getDate(2));
                    execute.setStatus(rs.getInt(3));
                    execute.setFunction_value(rs.getDouble(4));
                    execute.setVehicles_number(rs.getInt(5));
                }
            } catch (SQLException e) {
               execute=null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return execute;
    
    }

    @Override
    public List<ExecutionAlgorithm> executionAlgorithmQry(Date date) {
        
        List<ExecutionAlgorithm> list = null;
        String sql =  "SELECT "
                + "idExecutionAlgorithm, "
                + "date, "
                + "status, "
                + "function_value, "
                + "vehicles_number "
                + "FROM Execution_Algorithm "
                + "WHERE date = ?; ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setDate(1, (java.sql.Date) date);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    ExecutionAlgorithm execute = new ExecutionAlgorithm();
                    execute.setIdExecutionAlgorithm(rs.getInt(1));
                    execute.setDate(rs.getDate(2));
                    execute.setStatus(rs.getInt(3));
                    execute.setFunction_value(rs.getDouble(4));
                    execute.setVehicles_number(rs.getInt(5));
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
    
    
    
}
