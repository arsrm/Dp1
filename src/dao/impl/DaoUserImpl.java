package dao.impl;

import dao.DaoUsers;
import Model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import enlaceBD.ConectaDb;
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
                + "Names "
                + "password "
                + "created_at "
                + "update_at "
                + "deleted_at "
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
                    c.setNames(rs.getString(2));
                    c.setPassword(rs.getString(3));
                    c.setCreated_at(rs.getTimestamp(4));
                    c.setUpdate_at(rs.getTimestamp(5));
                    c.setDeleted_at(rs.getTimestamp(6));
                    c.setIdUser(rs.getInt(7));
                    c.setDistribution_Center_idDistribution_Center(rs.getInt(8));
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
                + "Names"
                + "password"
                + "created_at"
                + "update_at"
                + "deleted_at"
                + "Profile_idProfile"
                + "Distribution_Center_idDistribution_Center"
                + ") VALUES(?,?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, users.getNames());
                ps.setString(2, users.getPassword());
                ps.setTimestamp(3, users.getCreated_at());
                ps.setTimestamp(4, users.getUpdate_at());
                ps.setTimestamp(5, users.getDeleted_at());
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
        Users users = null;
        String sql = "SELECT "
                + "Names "
                + "password "
                + "created_at "
                + "update_at "
                + "deleted_at "
                + "Profile_idProfile "
                + "FROM User WHERE idUser=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, iduser);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    users = new Users();

                    users.setIdUser(rs.getInt(1));
                    users.setNames(rs.getString(2));
                    users.setPassword(rs.getString(3));
                    users.setCreated_at(rs.getTimestamp(4));
                    users.setUpdate_at(rs.getTimestamp(5));
                    users.setDeleted_at(rs.getTimestamp(6));
                    users.setProfile_idProfile(rs.getInt(7));
                    users.setDistribution_Center_idDistribution_Center(rs.getInt(8));

                }

            } catch (SQLException e) {
                users = null;
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
                + "Names=? "
                + "password=? "
                + "created_at=? "
                + "update_at=? "
                + "deleted_at=? "
                + "Profile_idProfile=? "
                + "Distribution_Center_idDistribution_Center=? "
                + "WHERE idUser=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, users.getNames());
                ps.setString(2, users.getPassword());
                ps.setTimestamp(3, users.getCreated_at());
                ps.setTimestamp(4, users.getUpdate_at());
                ps.setTimestamp(5, users.getDeleted_at());
                ps.setInt(6, users.getProfile_idProfile());
                ps.setInt(7, users.getDistribution_Center_idDistribution_Center());
                ps.setInt(8, users.getIdUser());

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
    public Integer acceder(String usuario, String clave) {

        Integer cap=0;
        
        String sql = "SELECT "
               + "idUser,"
                + "Names, "
                + "password, "
                + "created_at, "
                + "update_at, "
                + "deleted_at, "
                + "Profile_idProfile, "
                + "Distribution_Center_idDistribution_Center "
                + "FROM User where idUser='" + usuario + "' and password= '" + clave + "' ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                     cap = rs.getInt(7);
       
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
                + "Names "
                + "password "
                + "created_at "
                + "update_at "
                + "deleted_at "
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
                    c[3] = rs.getTimestamp(4);
                    c[4] = rs.getTimestamp(5);
                    c[5] = rs.getTimestamp(6);
                    c[6] = rs.getInt(7);
                    c[7] = rs.getInt(8);
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

}
