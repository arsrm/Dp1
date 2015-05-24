package dao.impl;

import Model.Profile;
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
                + "description "
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
        String sql = "select idProfile,name,description "
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
        String sql = "select idProfile,name,description "
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


}

