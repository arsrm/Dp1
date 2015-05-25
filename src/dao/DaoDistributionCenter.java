/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.Distribution_Center;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luigi
 */
public interface DaoDistributionCenter {
    
    public ArrayList<Distribution_Center> distribution_centerGetQry();
    
    public Distribution_Center distribution_centerGet(Integer idDistribution_Center);
    
    public Distribution_Center distribution_centerGet(String name);
    
    public void distribution_centerUpd(Distribution_Center distribution_center);
    
    public List<Object[]> distribution_centerCbo();
    
    
}
