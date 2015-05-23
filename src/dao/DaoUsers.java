package dao;

import Model.Users;
import java.util.List;

public interface DaoUsers {

    public List<Users> usersQry();
    
    public String usersIns(Users users);
    
    public String usersDel(List<Integer> ids);
    
    public Users usersGet(Integer iduser);
    
    public String usersUpd(Users users);
    
    public List<Object[]> usersCbo();

    public Integer login(String user , String password);
    
    public String setpasword(Integer id , String password,Integer flag);
    
    public Integer getflagpwd(Integer id);
    
}

