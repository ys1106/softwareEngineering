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
import java.sql.*;
import java.util.Vector;

public class DAO_Payment {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:Orcl";
    private static final String username = "Hong";
    private static final String password = "4856";

    public DAO_Payment() {
    }

    public Connection getConn() {
        Connection con = null;

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }

        return con;
    }

    public boolean insertPayment(DTO_Payment dto) {
        boolean ok = false;

        Connection con;
        PreparedStatement ps;

        try {
            con = getConn();
            String sql = "insert into PAYMENTLIST values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, dto.getPnum());
            ps.setString(2, dto.getId());
            ps.setString(3, dto.getDate());
            ps.setInt(4, dto.getPtotal());
            int r = ps.executeUpdate();

            if (r > 0) {
                ok = true;
                System.out.println("성공적으로 입력되었습니다.");
            } else {
                System.out.println("입력에 실패하였습니다.");
            }
        } catch (SQLException e) {
            System.out.println(e + "->오류가 발생했습니다.");
        }
        return ok;
    }

    public Vector getPaymentList() { 
        Vector data = new Vector();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from Payment";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int num = rs.getInt("PAYMENT_NUM");
                String u_id = rs.getString("USER_ID");
                String p_date = rs.getString("PAYMENT_DATE");
                int p_total = rs.getInt("PAYMENT_TOTAL");

                Vector row = new Vector();
                row.add(num);
                row.add(u_id);
                row.add(p_date);
                row.add(p_total);

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return data;
    }

    public Vector getPaymentList(String a) {
        Vector data = new Vector();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from PAYMENTLIST where USER_ID=" + a;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int num = rs.getInt("PAYMENT_NUM");
                String id = rs.getString("USER_ID").trim();
                String p_date = rs.getString("PAYMENT_DATE").trim();
                int p_total = rs.getInt("PAYMENT_TOTAL");

                Vector row = new Vector();
                row.add(num);
                row.add(id);
                row.add(p_date);
                row.add(p_total);

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return data;
    }

    public int getPaymentNum() {
        int count = 0;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            con = getConn();
            String sql = "select * from PAYMENTLIST";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return count;
    }
       public DTO_Payment getPaymentDTO(String userId) {

        DTO_Payment dto = new DTO_Payment();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from PAYMENTLIST where USER_ID=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);

            rs = ps.executeQuery();

            if (rs.next()) {
                dto.setPnum(rs.getInt("PAYMENT_NUM"));
                dto.setId(rs.getString("ITEM_NAME"));
                dto.setDate(rs.getString("PAYMENT_DATE"));
                dto.setPtotal(rs.getInt("PAYMENT_TOTAL"));
            }

        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return dto;
    }
}
