package dao;

import Model.Users;
import java.util.List;

public interface DaoUsers {

    public List<Users> usersQry();
    public List<Users> usersQry_search(Integer center, Integer perfil,Integer dni , String name);
    
    public String usersIns(Users users);
    
    public String usersDel(List<Integer> ids);
    
    public Users usersGet(Integer iduser);
    
    public String usersUpd(Users users);
    
    public List<Object[]> usersCbo();

    public Integer login(String user , String password);
    
    public String setpasword(Integer id , String password,Integer flag);
    
    public Integer getflagpwd(Integer id);

    //gzavala-inicio 24/05 15:45
    public boolean accesswindow(Integer idrol, String idwindows);
    //gzavala-fin   24/05 15:45 
    
    
}

