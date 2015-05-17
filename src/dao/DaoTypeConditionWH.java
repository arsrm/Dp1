/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.Type_Condition_WareHouse;
import java.util.List;

/**
 *
 * @author CHACON
 */
public interface DaoTypeConditionWH {
    public List<Type_Condition_WareHouse> tcwhQry();
    
    public String tcwhIns(Type_Condition_WareHouse tcwh);
    
    public String tcwhDel(List<Integer> ids);
    
    public Type_Condition_WareHouse tcwhGet(Integer idtc);
    
    public String tcwhUpd(Type_Condition_WareHouse tc);
}
