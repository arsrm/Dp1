/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.Driver;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoDriver {
     public List<Driver> driverQry();
    
    public List<Driver> driverQry_search();
    
    public String driverIns(Driver driver);
    
    public String driverDel(List<String> ids);
    
    public Driver driverGet(Integer idDriver);
    
    public String driverUpd(Driver driver);
    
    
}
