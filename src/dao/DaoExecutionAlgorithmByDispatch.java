/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.ExecutionAlgorithmByDispatch;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoExecutionAlgorithmByDispatch {
    
    public String executionAlgorithmByDispatchIns(ExecutionAlgorithmByDispatch execution);
    
    public List<ExecutionAlgorithmByDispatch> executionAlgorithmDispatchQry(Integer idExecutionAlgorithm);
    
    //devuelve toda las rutas de un vehiculo en una corrida
    public List<ExecutionAlgorithmByDispatch> executionAlgorithmVehicleGet(Integer idExecutionAlgorithm, Integer idDispatch);
    
    
}
