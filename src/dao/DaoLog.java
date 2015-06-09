package dao;

import Model.LogSystem;
import java.util.List;

public interface DaoLog {
    
    public String clientIns(String mensaje, String clase,Integer iduser);
    public List<LogSystem> clientQry();
      
}
