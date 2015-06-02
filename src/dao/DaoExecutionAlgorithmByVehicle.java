/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.ExecutionAlgorithmByVehicle;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoExecutionAlgorithmByVehicle {
    
    public String executionAlgorithmByVehicleIns(ExecutionAlgorithmByVehicle execution);
    
    public List<ExecutionAlgorithmByVehicle> executionAlgorithmVehicleQry(Integer idExecutionAlgorithm);
    
    //devuelve toda las rutas de un vehiculo en una corrida
    public List<ExecutionAlgorithmByVehicle> executionAlgorithmVehicleGet(Integer idExecutionAlgorithm, Integer idVehicle);

}
