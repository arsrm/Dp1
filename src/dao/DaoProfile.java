package dao;

import Model.Profile;
import Model.ProfileWindow;
import java.util.ArrayList;
import java.util.List;

public interface DaoProfile {
  
    public List<Profile>  profileCbo();
    public Profile usersGet(Integer idprofile);
    public Profile usersGet(String name);
    public List<ProfileWindow> windowsGet(Integer idProfile);
    public void profileIns(Profile profile);
    public int profileDel(Integer idProfile, Integer statusToChange);
    public Profile profileGet(Integer idProfile);
    public int profileHasWindows(Integer idProfile);
    public List<ProfileWindow> windowsGetById(Integer idProfile);
    public void profileWindowIns(ProfileWindow profileWindow);
    public void profileWindowUpd(Integer idProfile, String idWindow, Integer status);
    public boolean existsProfileName(String profileName);
    public void profileWindowsDel(Integer idProfile);
    //evalua si hay usuarios activos cn el perfil buscado
    public boolean existsUserWithProfile(Integer idProfile);
    public void profileUpd(Profile profile);
    //obtiene el maximo id de tabla Profile
    public int profileMaxIdGet();
}
