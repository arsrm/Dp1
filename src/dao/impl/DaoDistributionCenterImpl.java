/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;


import Model.Distribution_Center;
import dao.DaoDistributionCenter;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Luigi
 */
public class DaoDistributionCenterImpl implements DaoDistributionCenter{
    
   private final ConectaDb db;
   
   public DaoDistributionCenterImpl() {
        db = new ConectaDb();
   }

   @Override
    public ArrayList<Distribution_Center> distribution_centerGetQry() {        
        ArrayList<Distribution_Center> list = new ArrayList<>();
        String sql = "SELECT "
                + "idDistribution_Center, "
                + "name, "
                + "address, "
                + "pos_x, "    
                + "pos_y, "
                + "status "
                + "FROM Distribution_Center";
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Distribution_Center c = new Distribution_Center();
                    c.setIdDistribution_Center(rs.getInt(1));
                    c.setName(rs.getString(2));
                    c.setAddress(rs.getString(3));
                    c.setPos_x(rs.getInt(4));
                    c.setPos_y(rs.getInt(5));
                    c.setStatus(rs.getInt(6));                    
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
    public Distribution_Center distribution_centerGet(Integer idDistribution_Center) {
       Distribution_Center c = null;
       Integer id=0;
        String sql = "select idDistribution_Center,name,address,pos_x,pos_y,status "
                +" From  Distribution_Center where idDistribution_Center = ?";


        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idDistribution_Center);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    c = new Distribution_Center();
                    c.setIdDistribution_Center(rs.getInt(1));
                    c.setName(rs.getString(2));
                    c.setAddress(rs.getString(3));
                    c.setPos_x(rs.getInt(4));
                    c.setPos_y(rs.getInt(5));
                    c.setStatus(rs.getInt(6));                    
                  
                    
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
               
       return c ;  
    }
    
    @Override
    public Distribution_Center distribution_centerGet(String name) {
       Distribution_Center c = null;
       Integer id=0;
        String sql = "select idDistribution_Center,name,address,pos_x,pos_y,status "
                +" From  Distribution_Center where  name= ?";


        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, name);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    c = new Distribution_Center();
                    c.setIdDistribution_Center(rs.getInt(1));
                    c.setName(rs.getString(2));
                    c.setAddress(rs.getString(3));
                    c.setPos_x(rs.getInt(4));
                    c.setPos_y(rs.getInt(5));
                    c.setStatus(rs.getInt(6));                    
                  
                    
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
               
       return c ;  
    }
    
    @Override
    public void distribution_centerUpd(Distribution_Center distribution_center) {
        String sql = "UPDATE Distribution_Center SET "
                + "name=?, "
                + "address=?, "
                + "pos_x=?, "
                + "pos_y=? "
                + "WHERE idDistribution_Center = ?; ";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);                

                ps.setString(1, distribution_center.getName());
                ps.setString(2, distribution_center.getAddress());
                ps.setInt(3, distribution_center.getPos_x());
                ps.setInt(4, distribution_center.getPos_y());
                ps.setInt(5, distribution_center.getIdDistribution_Center());
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
    public List<Object[]> distribution_centerCbo() {
        List<Object[]> list = null;
        String sql = "SELECT "
                + "idDistribution_Center, "
                + "name, "
                + "address, "
                + "pos_x, "    
                + "pos_y, "
                + "status, "
                + "created_at, "
                + "updated_at, "
                + "user_created, "
                + "user_updated "
                + "FROM Distribution_Center";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    Object[] c = new Object[10];

                    c[0] = rs.getInt(1);
                    c[1] = rs.getString(2);
                    c[2] = rs.getString(3);
                    c[3] = rs.getInt(4);
                    c[4] = rs.getInt(5);
                    c[5] = rs.getInt(6);
                    c[6] = rs.getTimestamp(7);
                    c[7] = rs.getTimestamp(8);
                    c[8] = rs.getInt(9);
                    c[9] = rs.getInt(10);                    
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
