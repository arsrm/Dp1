package dao.impl;


import Model.Client;
import dao.DaoClient;
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


public class DaoClientImpl implements DaoClient {

    private final ConectaDb db;

    public DaoClientImpl() {
        db = new ConectaDb();
    }

    @Override
     public List<Client> clientQry(){
        List<Client> list = null;
        String sql =  "select idClient,ruc,name,address,priority,pos_x,pos_y,status "
                +"From  Client";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    Client c = new Client();
                    c.setIdClient(rs.getInt(1));
                    c.setRuc(rs.getString(2));
                    c.setName(rs.getString(3));
                    c.setAddress(rs.getString(4));
                    c.setPriority(rs.getInt(5));
                    c.setPos_x(rs.getInt(6));
                    c.setPos_y(rs.getInt(7));
                    c.setStatus(rs.getInt(8));
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
    public List<Client> clientQry_search(String dni , String name){
        List<Client> list = null;
        if (dni==null)dni =""; 
        if (name==null)name="";
        
        String sql =  "select idClient,ruc,name,address,priority,pos_x,pos_y,status From  Client "
                + "where ruc LIKE ? AND name LIKE ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, "%"+dni+"%");
                ps.setString(2,"%"+name+"%");
                ResultSet rs = ps.executeQuery();
                
                list = new LinkedList<>();
                while (rs.next()) {
                    Client c = new Client();
                    c.setIdClient(rs.getInt(1));
                    c.setRuc(rs.getString(2));
                    c.setName(rs.getString(3));
                    c.setAddress(rs.getString(4));
                    c.setPriority(rs.getInt(5));
                    c.setPos_x(rs.getInt(6));
                    c.setPos_y(rs.getInt(7));
                    c.setStatus(rs.getInt(8));
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
    public String clientIns(Client client){
        String result = null;
        String sql = "INSERT INTO Client("
                +"ruc,name,address,priority,pos_x,pos_y,status"
                + ") VALUES(?,?,?,?,?,?,?)";
         
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                
                ps.setString(1, client.getRuc());
                ps.setString(2,client.getName() );
                ps.setString(3, client.getAddress());
                ps.setInt(4, client.getPriority());
                ps.setInt(5, client.getPos_x());
                ps.setInt(6, client.getPos_y());
                ps.setInt(7, client.getStatus());
                
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
    public String clientDel(List<String> ids) {
        int sizelist= ids.size();
        String result = null;
        String sql = "UPDATE  Client SET "
                + "status= '0' "
                + "WHERE ruc=?";
/*"DELETE FROM Client WHERE idClient=?";*/
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                for (int x = 0 ; x<sizelist ;x ++) {
                    String z= ids.get(x);
                    ps.setString(1,z);

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
    public Client clientGet(String idclient) {
        Client c =null;
        Integer id=0;
        String sql = "select  idClient,ruc,name,address,priority,pos_x,pos_y,status"
                +" From  Client where ruc = ?";


        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, idclient);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                     
                    c = new Client();
                    c.setIdClient(rs.getInt(1));
                    c.setRuc(rs.getString(2));
                    c.setName(rs.getString(3));
                    c.setAddress(rs.getString(4));
                    c.setPriority(rs.getInt(5));
                    c.setPos_x(rs.getInt(6));
                    c.setPos_y(rs.getInt(7));
                    c.setStatus(rs.getInt(8));
                    
                }
            } catch (SQLException e) {
               c=null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return c;
    }

     @Override 
     public Client clientGet(Integer id){
        Client c =null;
        //Integer id=0;
        String sql = "select  idClient,ruc,name,address,priority,pos_x,pos_y,status"
                +" From  Client where idClient = ?";


        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                     
                    c = new Client();
                    c.setIdClient(rs.getInt(1));
                    c.setRuc(rs.getString(2));
                    c.setName(rs.getString(3));
                    c.setAddress(rs.getString(4));
                    c.setPriority(rs.getInt(5));
                    c.setPos_x(rs.getInt(6));
                    c.setPos_y(rs.getInt(7));
                    c.setStatus(rs.getInt(8));
                    
                }
            } catch (SQLException e) {
               c=null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return c;
    
         
     }
     
    @Override
    public String clientUpd(Client client) {
        String result = null;
        String sql = "UPDATE  Client SET "
                +"ruc=?, name= ?,address= ?,priority= ?,pos_x= ?,pos_y= ?,status= ?  "
                + "WHERE ruc=? ";
        
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
               
                ps.setString(1,client.getRuc());
                ps.setString(2,client.getName() );
                ps.setString(3, client.getAddress());
                ps.setInt(4, client.getPriority());
                ps.setInt(5, client.getPos_x());
                ps.setInt(6, client.getPos_y());
                ps.setInt(7, client.getStatus());
                 ps.setString(8, client.getRuc());

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

    
}
