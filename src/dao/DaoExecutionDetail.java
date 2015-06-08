/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.ExecutionDetail;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoExecutionDetail {
    
   public String executionDetailIns(ExecutionDetail execution);
    
   public List<ExecutionDetail> executionDetailQry(Integer idExecutionAlgorithm);
    
   public ExecutionDetail executionDetailGet(Integer idExecutionAlgorith,Integer idDispatch,Integer idPicking);
    
}
