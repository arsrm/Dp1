/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.VehicleState;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoVehicleState {
    
    public List<VehicleState> vehicleStateQry();
    
    public List<VehicleState> vehicleStateQry_search();
    
    public String vehicleStateIns(VehicleState vehicleState);
    
    public String vehicleStateDel(List<String> ids);
    
    public VehicleState vehicleStateGet(String idvehicleState);
    
    public String vehicleStateUpd(VehicleState vehicleState);
}
