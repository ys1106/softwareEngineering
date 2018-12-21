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
public class DAO_Trade {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:Orcl";
    private static final String username = "Hong";
    private static final String password = "4856";

    public DAO_Trade() {
    }

    public Connection getConn() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "오류가 발생했습니다");
        }

        return con;
    }

    public boolean insertTrade(DTO_Trade dto) { //이거 INSERT 하는걸 바로 PAYMENT에다가 해야할 것 같은데여 님들
        boolean ok = false;

        Connection con;
        PreparedStatement ps;

        try {
            con = getConn();
            String sql = "insert into TRADE values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setInt(2, dto.getPrice());
            ps.setInt(3, dto.getNum());
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

    public Vector getTradeList() {
        Vector data = new Vector();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from TRADE";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("ITEM_NAME").trim();
                int price = rs.getInt("ITEM_PRICE");
                int num = rs.getInt("TRADE_NUM");
                Vector row = new Vector();
                row.add(name);
                row.add(price);
                row.add(num);

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return data;
    }

    public DTO_Trade getTradeDTO(String Itemname) {

        DTO_Trade dto = new DTO_Trade();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from ITEMLIST where ITEM_NAME=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Itemname);

            rs = ps.executeQuery();

            if (rs.next()) {
                dto.setName(rs.getString("ITEM_NAME"));
                dto.setPrice(rs.getInt("ITEM_PRICE"));
            }

        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return dto;
    }

    public int Sum() {
        Vector data = new Vector();
        int sum = 0;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from TRADE";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int price = rs.getInt("ITEM_PRICE");
                int num = rs.getInt("TRADE_NUM");
                sum += (price * num);
            }
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.(Sum)");
        }
        return sum;
    }

    public void clear() {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            con = getConn();
            String sql = "delete from TRADE";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
    }

    public boolean adultP() {
        DAO_Item dao = new DAO_Item();
        DTO_Item dto;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        boolean adult = false;
        try {
            con = getConn();
            String sql = "select * from TRADE";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("ITEM_NAME").trim();
                dto = dao.getItemDTO(name);
                int a = dto.getAdult();
                if (a == 2) {
                    adult = true;
                } else
                    ;

            }
        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.(adultp)");
        }
        return adult;
    }
}
