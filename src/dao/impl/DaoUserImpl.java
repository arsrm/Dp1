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
        String sql =  "select idUser,name,password,password_change,status,"
                +"Profile_idProfile,Distribution_Center_idDistribution_Center From  User";

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
                    c.setPassword_change(rs.getInt(4));
                    c.setStatus(rs.getInt(5));
                    c.setProfile_idProfile(rs.getInt(6));
                    c.setDistribution_Center_idDistribution_Center(rs.getInt(7));
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
    public List<Users> usersQry_search(Integer center, Integer perfil,Integer dni , String name) {
        List<Users> list = null;
        String num =null;
        if (dni==null){num =""; }else {num =dni.toString();}
        
        if (name==null)name="";
        String sql =  "select idUser,name,password,password_change,status,"
                +"Profile_idProfile,Distribution_Center_idDistribution_Center From  User "
                + "where Distribution_Center_idDistribution_Center='"
                +center
                +"' AND Profile_idProfile ='"+ perfil + "' AND idUser LIKE ? AND name LIKE ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, "%"+num+"%");
                ps.setString(2,"%"+name+"%");
                ResultSet rs = ps.executeQuery();
                
                list = new LinkedList<>();
                while (rs.next()) {
                    Users c = new Users();
                    c.setIdUser(rs.getInt(1));
                    c.setname(rs.getString(2));
                    c.setPassword(rs.getString(3));
                    c.setPassword_change(rs.getInt(4));
                    c.setStatus(rs.getInt(5));
                    c.setProfile_idProfile(rs.getInt(6));
                    c.setDistribution_Center_idDistribution_Center(rs.getInt(7));
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
                +"idUser,name,password,password_change,status,"
                +"Profile_idProfile,Distribution_Center_idDistribution_Center"
                + ") VALUES(?,?,?,?,?,?,?)";
         
        
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, users.getIdUser());
                ps.setString(2, users.getname());
                 String hashed = BCrypt.hashpw(users.getPassword(), BCrypt.gensalt(12));
                ps.setString(3,hashed );
                ps.setInt(4, users.getPassword_change());
                ps.setInt(5, users.getStatus());
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
        int sizelist= ids.size();
        String result = null;
        String sql = "UPDATE  User SET "
                + "status= '0' "
                + "WHERE idUser=?";
/*"DELETE FROM User WHERE idUser=?";*/
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (int x = 0 ; x<sizelist ;x ++) {
                    int z= ids.get(x);
                    ps.setInt(1,z);

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
                + "name=? ,"
                + "password=? ,"
                + "password_change=? ,"
                 + "status=? ,"
                + "Profile_idProfile=? ,"
                + "Distribution_Center_idDistribution_Center=? "
                + "WHERE idUser=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, users.getname());
                 String hashed = BCrypt.hashpw(users.getPassword(), BCrypt.gensalt(12));
                ps.setString(2, hashed);
                 ps.setInt(3, users.getPassword_change());
                 ps.setInt(4, users.getStatus());
                ps.setInt(5, users.getProfile_idProfile());
                ps.setInt(6, users.getDistribution_Center_idDistribution_Center());
                ps.setInt(7, users.getIdUser());

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
                       cap = 1;
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

    //gzavala-inicio 
    @Override
    public boolean accesswindow(Integer idrol, String idwindows) {

        boolean opcion=false;
        int  status ; 
        
        //gzavala-inicio 24/05 16:36
        /*
        String sql = "select coalesce(status,0)  from profile_windows  \n" +
                     "where id_profile="+ idrol +" \n" +
                     "and id_windows='"+idwindows+"';" ;
        */
        String sql = "select count(1) from profile_windows  \n" +
                    "where idProfile="+idrol+"  \n" +
                    "and status=1  \n" +
                    "and id_windows='"+idwindows+"';" ;
        //gzavala-fin 24/05 16:36
        
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    status = rs.getInt(1);
                     if (status==1 ){
                       opcion=true;
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
       
        return opcion;
        
        
    }
    //gzavala-fin    
    
    
}
