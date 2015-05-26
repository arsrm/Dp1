/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.MotiveReturn;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoMotiveReturn {
    
    public List<MotiveReturn> motiveReturnQry();
    
    public List<MotiveReturn> motiveReturnQry_search();
    
    public String motiveReturnIns(MotiveReturn motiveReturn);
    
    public String motiveReturnDel(List<String> ids);
    
    public MotiveReturn motiveReturnGet(String idmotiveReturn);
    
    public String motiveReturnUpd(MotiveReturn motiveReturn);
}
