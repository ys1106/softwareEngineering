/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineering;

/**
 *
 * @author Hong
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DAO_Time {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:Orcl";
    private static final String username = "Hong";
    private static final String password = "4856";

    public void DAO_TIME() {
    }

    public Connection getConn() {
        Connection con = null;

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "-> 오류 발생");
        }

        return con;
    }

    public boolean insertTime(DTO_Time dto) { //insert 하는 부분 순서 맞춰서 해야함
        boolean ok = false;

        Connection con;
        PreparedStatement ps;

        try {
            con = getConn();
            String sql = "insert into TIME values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getStime());
            ps.setString(3, dto.getEtime());

            int r = ps.executeUpdate();

            if (r > 0) {
                ok = true;
                System.out.println("입력되었습니다.");
            } else {
                System.out.println("입력에 실패하였습니다.");
            }
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return ok;
    }

    public Vector getTimeList() {
        Vector data = new Vector();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from TIME";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("USER_ID");
                String s_time = rs.getString("S_TIME");
                String e_time = rs.getString("E_TIME");

                Vector row = new Vector();
                row.add(id);
                row.add(s_time);
                row.add(e_time);

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e + "->오류가 발생했습니다.");
        }
        return data;
    }

    public Vector getTimeList(String a) {
        Vector data = new Vector();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from TIME where USER_ID=" + a;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("USER_ID").trim();
                String sTime = rs.getString("S_TIME").trim();
                String eTime = rs.getString("E_TIME").trim();

                Vector row = new Vector();
                row.add(id);
                row.add(sTime);
                row.add(eTime);

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return data;
    }

    public DTO_Time getTimeDTO(String userId) {  //얘 어디다 쓰냐?

        DTO_Time dto = new DTO_Time();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from TIME where USER_ID=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);

            rs = ps.executeQuery();

            if (rs.next()) {
                dto.setId(rs.getString("USER_ID"));
                dto.setStime(rs.getString("S_TIME"));
                dto.setEtime(rs.getString("E_TIME"));
            }

        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return dto;
    }

}
