/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.ExecutionAlgorithm;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoExecutionAlgorithm {
    
    public String executionAlgorithmIns(ExecutionAlgorithm execution);
    
    public List<ExecutionAlgorithm> executionAlgorithmQry();
    
    public ExecutionAlgorithm executionAlgorithmGet(Integer idExecutionExecution);
    
    public List<ExecutionAlgorithm> executionAlgorithmQry(Date date);
}
