package dao;

import Model.Profile;
import java.util.ArrayList;
import java.util.List;

public interface DaoProfile {
  
    public List<Profile>  profileCbo();
    public Profile usersGet(Integer idprofile);
    public Profile usersGet(String name);
}
