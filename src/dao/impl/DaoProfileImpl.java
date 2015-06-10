package dao.impl;

import Model.Profile;
import Model.ProfileWindow;
import dao.DaoProfile;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DaoProfileImpl implements DaoProfile {

    private final ConectaDb db;

    public DaoProfileImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<Profile>  profileCbo() {
        
        List<Profile> list = null;
        String sql = "SELECT "
                + "idProfile,"
                + "name, "
                + "description, "
                + "status "
                + "FROM Profile";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    Profile c = new Profile();
                    c.setIdprofile(rs.getInt(1));
                    c.setName(rs.getString(2));
                    c.setDescription(rs.getString(3));
                    c.setStatus(rs.getInt(4));
                    list.add(c);
                }

            } catch (SQLException e) {
                list = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return list;

    }
    
    @Override
    public Profile usersGet(Integer idprofile){
    
    Profile profile = null;
        Integer id=0;
        String sql = "select idProfile,name,description,status "
                +" From  Profile where idProfile = ?";


        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idprofile);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    profile = new Profile();
                    profile.setIdprofile(rs.getInt(1));
                    profile.setName(rs.getString(2));
                    profile.setDescription(rs.getString(3));
                    profile.setStatus(rs.getInt(4));
                }
            } catch (SQLException e) {
               profile=null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    return profile;

    }
    
    @Override
    public Profile usersGet(String name){
    
    Profile profile = null;
        Integer id=0;
        String sql = "select idProfile,name,description,status "
                +" From  Profile where  name= ?";


        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, name);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    profile = new Profile();
                    profile.setIdprofile(rs.getInt(1));
                    profile.setName(rs.getString(2));
                    profile.setDescription(rs.getString(3));
                    profile.setStatus(rs.getInt(4));
                }
            } catch (SQLException e) {
               profile=null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    return profile;

    }

    @Override
    public List<ProfileWindow> windowsGet(Integer idProfile) {
        List<ProfileWindow> list = null;
        String sql = "SELECT "
                + "id_windows, "
                + "description, "
                + "id_menu "
                + "FROM Windows; ";
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);                
                ResultSet rs = ps.executeQuery();
                  
                list = new LinkedList<>();
                while (rs.next()) {
                    ProfileWindow profileWindow = new ProfileWindow();
                    
                    profileWindow.setId_windows(rs.getString(1));
                    profileWindow.setDescription(rs.getString(2));
                    profileWindow.setId_menu(rs.getInt(3));
                    profileWindow.setIdProfile(idProfile);
                    profileWindow.setStatus(0);
                    list.add(profileWindow);
                }

            } catch (SQLException e) {
                list = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }        
        return list;
    }

    @Override
    public void profileIns(Profile profile) {
        String sql = "INSERT INTO Profile ("
                + "name, "
                + "description, \n"
                + "status) "
                + "VALUES (?,?,?);";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);

                ps.setString(1, profile.getName());
                ps.setString(2, profile.getDescription());
                ps.setInt(3, 1);
                // status en 0 para que luego al asignarsele los permisos recien pase a 1
                ps.executeUpdate();
                
            } catch (SQLException e) {
                //
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public int profileDel(Integer idProfile, Integer statusToChange) {
        String sql = "UPDATE Profile SET "                
                + "status=? "
                + "WHERE idProfile=?; ";                
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                
                PreparedStatement ps = cn.prepareStatement(sql);                   
                ps.setInt(1, statusToChange);
                ps.setInt(2, idProfile);
                ps.executeUpdate();
                
            } catch (SQLException e) {
                e.getMessage();
                return 0;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return 1;
    }

    @Override
    public Profile profileGet(Integer idProfile) {
        Profile profile = null;
        String sql = "SELECT "
                + "idProfile, "
                + "name, "
                + "description, "
                + "status "                
                + "FROM Profile WHERE idProfile = ?;";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idProfile);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    profile = new Profile();
                    profile.setIdprofile(rs.getInt(1));
                    profile.setName(rs.getString(2));
                    profile.setDescription(rs.getString(3));                    
                }
            } catch (SQLException e) {
                profile = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return profile;
    }

    @Override
    public int profileHasWindows(Integer idProfile) {
        String sql = "SELECT "
                + "count(*) "                
                + "FROM Profile_Windows WHERE idProfile = ?;";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idProfile);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    if (rs.getInt(1)>0) return 1;
                }
            } catch (SQLException e) {
                
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return 0;
    }

    @Override
    public List<ProfileWindow> windowsGetById(Integer idProfile) {
        List<ProfileWindow> list = null;
        String sql = "SELECT "
                + "PW.idProfile, "
                + "PW.id_windows, "
                + "PW.status, "
                + "W.description, "
                + "W.id_menu "
                + "FROM Profile_Windows PW "
                + "JOIN Windows W ON (PW.id_windows=W.id_windows) "
                + "WHERE idProfile=? "
                + "ORDER BY id_menu; ";
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idProfile);
                ResultSet rs = ps.executeQuery();
                  
                list = new LinkedList<>();
                while (rs.next()) {
                    ProfileWindow profileWindow = new ProfileWindow();
                    
                    profileWindow.setIdProfile(rs.getInt(1));
                    profileWindow.setId_windows(rs.getString(2));
                    profileWindow.setStatus(rs.getInt(3));
                    profileWindow.setDescription(rs.getString(4));
                    profileWindow.setId_menu(rs.getInt(5));
                    list.add(profileWindow);
                }

            } catch (SQLException e) {
                list = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }        
        return list;
    }

    @Override
    public void profileWindowIns(ProfileWindow profileWindow) {
        String sql = "INSERT INTO Profile_Windows ("
                + "idProfile, "
                + "id_windows, "
                + "status) "
                + "VALUES (?,?,?); ";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);

                ps.setInt(1, profileWindow.getIdProfile());
                ps.setString(2, profileWindow.getId_windows());
                ps.setInt(3, profileWindow.getStatus());                
                ps.executeUpdate();
                
            } catch (SQLException e) {
                //
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void profileWindowUpd(Integer idProfile, String idWindow, Integer status) {
        String sql = "UPDATE Profile_Windows SET "
                + "status=? "
                + "WHERE idProfile=? AND id_windows=? ;";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);                

                ps.setInt(1, status);
                ps.setInt(2, idProfile);
                ps.setString(3, idWindow);                
                ps.executeUpdate();
                
            } catch (SQLException e) {
                //
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public boolean existsProfileName(String profileName) {
        String sql = "SELECT "
                + "count(*) "
                + "FROM Profile WHERE name = ?;";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, profileName);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    if (rs.getInt(1)>0) return true;
                }
            } catch (SQLException e) {
                
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return false;
    }

    @Override
    public void profileWindowsDel(Integer idProfile) {
        String sql = "UPDATE Profile_Windows SET "                
                + "status=? "
                + "WHERE idProfile=?; ";                
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                
                PreparedStatement ps = cn.prepareStatement(sql);                   
                ps.setInt(1, 0);
                ps.setInt(2, idProfile);
                ps.executeUpdate();
                
            } catch (SQLException e) {
                e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public boolean existsUserWithProfile(Integer idProfile) {
        String sql = "SELECT "
                + "count(*) "
                + "FROM User WHERE Profile_idProfile = ? "
                + "AND status = 1; ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idProfile);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    if (rs.getInt(1)>0) return true;
                }
            } catch (SQLException e) {
                
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return false;
    }

    @Override
    public void profileUpd(Profile profile) {
        String sql = "UPDATE Profile SET "
                + "description=?, "
                + "status=? "
                + "WHERE idProfile=?;";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);

                ps.setString(1, profile.getDescription());                
                ps.setInt(2, profile.getStatus());
                ps.setInt(3, profile.getIdprofile());                
                ps.executeUpdate();
                
            } catch (SQLException e) {
                //
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public int profileMaxIdGet() {
        int maxId=0;
        String sql = "SELECT "
                + "MAX(idProfile) "
                + "FROM Profile;";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    maxId = rs.getInt(1);
                    return maxId;
                }
            } catch (SQLException e) {
                
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return -1;
    }
}

