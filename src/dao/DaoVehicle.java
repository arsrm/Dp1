/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.Vehicle;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoVehicle {
    
    public List<Vehicle> vehicleQry();
    
    public Vehicle vehicleGet(Integer idvehicle);
    
    public String vehicleUpd(Vehicle vehicle);
}
