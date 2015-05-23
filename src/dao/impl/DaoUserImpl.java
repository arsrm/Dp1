package dao.impl;

import Model.Users;
import dao.DaoUsers;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.mindrot.BCrypt;
import static org.mindrot.BCrypt.checkpw;
import static tool.Convierte.aInteger;


public class DaoUserImpl implements DaoUsers {

    private final ConectaDb db;

    public DaoUserImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<Users> usersQry() {
        List<Users> list = null;
        String sql = "SELECT "
                + "idUser,"
                + "name "
                + "password "
                + "Profile_idProfile "
                + "Distribution_Center_idDistribution_Center "
                + "FROM User";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    Users c = new Users();

                    c.setIdUser(rs.getInt(1));
                    c.setname(rs.getString(2));
                    c.setPassword(rs.getString(3));
                    c.setIdUser(rs.getInt(4));
                    c.setDistribution_Center_idDistribution_Center(rs.getInt(5));
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
    public String usersIns(Users users) {
        String result = null;
        String sql = "INSERT INTO User("
                + "name "
                + "password "
                + "Profile_idProfile "
                + "Distribution_Center_idDistribution_Center"
                + ") VALUES(?,?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, users.getname());
                ps.setString(2, users.getPassword());
                ps.setInt(6, users.getProfile_idProfile());
                ps.setInt(7, users.getDistribution_Center_idDistribution_Center());

                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    throw new SQLException("0 filas afectadas");
                }

            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }

        return result;
    }

    @Override
    public String usersDel(List<Integer> ids) {
        String result = null;
        String sql = "DELETE FROM User WHERE idUser=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (Integer x : ids) {
                    ps.setInt(1, x);

                    int ctos = ps.executeUpdate();
                    if (ctos == 0) {
                        throw new SQLException("ID: " + x + " no existe");
                    }
                }

            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }

        return result;
    }

    @Override
    public Users usersGet(Integer iduser) {
        Users users =null;
        Integer id=0;
        String sql = "select idUser,name,password,password_change,status,"
                +"Profile_idProfile,Distribution_Center_idDistribution_Center From  User where idUser = ?";


        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, iduser);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                     users = new Users();
                    users.setIdUser(rs.getInt(1));
                    users.setname(rs.getString(2));
                    users.setPassword(rs.getString(3));
                    users.setPassword_change(rs.getInt(4));
                    users.setStatus(rs.getInt(5));
                    users.setProfile_idProfile(rs.getInt(6));
                    users.setDistribution_Center_idDistribution_Center(rs.getInt(7));
                }
            } catch (SQLException e) {
               users=null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return users;
    }

    @Override
    public String usersUpd(Users users) {
        String result = null;
        String sql = "UPDATE  User SET "
                + "name=? "
                + "password=? "
                + "Profile_idProfile=? "
                + "Distribution_Center_idDistribution_Center=? "
                + "WHERE idUser=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, users.getname());
                ps.setString(2, users.getPassword());
                ps.setInt(3, users.getProfile_idProfile());
                ps.setInt(4, users.getDistribution_Center_idDistribution_Center());
                ps.setInt(5, users.getIdUser());

                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    throw new SQLException("0 filas afectadas");
                }

            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }

        return result;
    }

    
     @Override
    public String setpasword(Integer id , String password,Integer flag){
        String result = null;
         String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
         String sql = "UPDATE  User SET "
                + "password= '"+ hashed +"' ,"
                + "password_change= '"+flag+"' "
                + "WHERE idUser='"+id+"'";

            Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    throw new SQLException("0 filas afectadas");
                }

            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }
        return result;
    }
    @Override
    public Integer login(String usuario, String clave) {

        Integer cap=0;
        String pwd="" ; 
        String sql = "SELECT "
               + "idUser,"
                + "name, "
                + "password, "
                + "Profile_idProfile, "
                + "Distribution_Center_idDistribution_Center "
                + "FROM User where idUser='" + usuario + "' ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    pwd = rs.getString(3);
                     if (checkpw(clave, pwd)){
                       cap = rs.getInt(4);
                     }
                }
                
            } catch (SQLException e) {

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
          
        }
       
        return cap;
    }

    @Override
    public List<Object[]> usersCbo() {
        List<Object[]> list = null;
        String sql = "SELECT "
                + "idUser,"
                + "name "
                + "password "
                + "Profile_idProfile "
                + "Distribution_Center_idDistribution_Center "
                + "FROM User";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    Object[] c = new Object[8];

                    c[0] = rs.getInt(1);
                    c[1] = rs.getString(2);
                    c[2] = rs.getString(3);
                    c[4] = rs.getInt(7);
                    c[5] = rs.getInt(8);
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
    public Integer getflagpwd(Integer id){
     Integer cap=-1;
        String sql = "SELECT "
               + "idUser,"
                + "password_change "
                + "FROM User where idUser='" + id + "' ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    cap = rs.getInt(2);
                }
                
            } catch (SQLException e) {

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
          
        }
       
        return cap;
    }

}
