package dao.impl;

import Model.Log;
import dao.DaoLog;
import enlaceBD.ConectaDb;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class DaoLogImpl implements DaoLog {

    private final ConectaDb db;

    public DaoLogImpl() {
        db = new ConectaDb();
    }

    @Override
    public String clientIns(String mensaje, String clase, Integer iduser) {

        String result = null;
        String sql = "INSERT INTO Log_Security("
                + "date,action ,class, User_idUser,ip,mac_address"
                + ") VALUES(?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                Calendar Cal = Calendar.getInstance();
                String fec = Cal.get(Cal.YEAR) + "/" + (Cal.get(Cal.MONTH) + 1) + "/" + Cal.get(Cal.DATE)
                        + " " + Cal.get(Cal.HOUR_OF_DAY) + ":" + Cal.get(Cal.MINUTE) + ":" + Cal.get(Cal.SECOND);;

                ps.setString(1, fec);
                ps.setString(2, mensaje);
                ps.setString(3, clase);
                ps.setInt(4, iduser);

                InetAddress ip;
                try {

                    ip = InetAddress.getLocalHost();
                    //System.out.println("Current IP address : " + ip.getHostAddress());
                    ps.setString(5, "Current IP address : " + ip.getHostAddress());

                    NetworkInterface network = NetworkInterface.getByInetAddress(ip);

                    byte[] mac = network.getHardwareAddress();

		//System.out.print("Current MAC address : ");
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    //System.out.println(sb.toString());
                    ps.setString(6, "Current MAC address : " + sb.toString());
                } catch (UnknownHostException e) {

                    e.printStackTrace();

                } catch (SocketException e) {

                    e.printStackTrace();

                }

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
