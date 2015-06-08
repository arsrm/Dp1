/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.ExecutionAlgorithmDetail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoExecutionAlgorithmDetail {    
    
    public List<ExecutionAlgorithmDetail> executionAlgorithmQry();
    
    public ExecutionAlgorithmDetail executionAlgorithmGet(Integer idExecutionAlgorithm, Integer idDispatchOrder, Integer idPickingOrder);
    
}
