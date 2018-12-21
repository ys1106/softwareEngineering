/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineering;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
/**
 *
 * @author Hong
 */
public class DAO_User {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:Orcl";
    private static final String username = "Hong";
    private static final String password = "4856";
    public DAO_User(){
    }
    public Connection getConn(){
       Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "오류가 발생했습니다");
        }

        return con;
    }
 public boolean insertUser(DTO_User dto) {
        boolean ok = false;

        Connection con;
        PreparedStatement ps;

        try {
            con = getConn();
            String sql = "insert into USERLIST values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getName());
            ps.setInt(3, dto.getPhone());
            int r = ps.executeUpdate();

            if (r > 0) {
                ok = true;
                System.out.println("성공적으로 입력을 했습니다.");
            } else {
                System.out.println("입력에 실패하였습니다.");
            }
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return ok;
    }   
  public Vector getUserList() {
        Vector data = new Vector();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from USERLIST;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("USER_ID");
                String name = rs.getString("USER_NAME");
                int phone_number = rs.getInt("USER_PHONE");
                
                Vector row = new Vector();
                row.add(name);
                row.add(name);
                row.add(phone_number);

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return data;
    }
   public Vector getUserList(String a) {
        Vector data = new Vector();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from USERLIST where USER_ID=" + a;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("USER_ID").trim();
                String name = rs.getString("USER_NAME").trim();
                int phone_number = rs.getInt("USER_PHONE");
                
                Vector row = new Vector();
                row.add(id);
                row.add(name);
                row.add(phone_number);

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return data;
    }
   public DTO_User getUserDTO(String userId) {  //얘 어디다 쓰냐?

        DTO_User dto = new DTO_User();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from USERLIST where USER_ID=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);

            rs = ps.executeQuery();

            if (rs.next()) {
                dto.setId(rs.getInt("USER_ID"));
                dto.setName(rs.getString("USER_NAME"));
                dto.setPhone(rs.getInt("USER_PHONE"));
            }

        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return dto;
    }
}
