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
public class DAO_Item {
   private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:Orcl";
    private static final String username = "Hong";
    private static final String password = "4856";
    
    public DAO_Item(){
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
     public boolean insertItem(DTO_Item dto) { //insert 하는 부분 순서 맞춰서 해야함
        boolean ok = false;

        Connection con;
        PreparedStatement ps;

        try {
            con = getConn();
            String sql = "insert into ITEMLIST values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setInt(2, dto.getPrice());
            ps.setInt(3, dto.getNum());
            ps.setString(4, dto.getCategory());
            ps.setString(5, dto.getInday());
            ps.setString(6, dto.getOutday());
            ps.setString(7, dto.getEvent());
            ps.setInt(8, dto.getAdult());
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
     public Vector getItemList() {
        Vector data = new Vector();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from ITEMLIST";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("ITEM_NAME");
                int price = rs.getInt("ITEM_PRICE");
                int num = rs.getInt("ITEM_NUM");
                String cate = rs.getString("ITEM_CAT");
                String inday = rs.getString("ITEM_INDAY");
                String outday = rs.getString("ITEM_OUTDAY");
                String event = rs.getString("ITEM_EVENT");
                int adult = rs.getInt("ITEM_ADULT");
                Vector row = new Vector();
                row.add(name);
                row.add(price);
                row.add(num);
                row.add(cate);
                row.add(inday);
                row.add(outday);
                row.add(event);
                row.add(adult);
        

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e + "->오류가 발생했습니다.");
        }
        return data;
    }
     public Vector getItemList(String itemName) {
        Vector data = new Vector();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from ITEMLIST WHERE ITEM_NAME = '" + itemName + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("ITEM_NAME").trim();
                int price = rs.getInt("ITEM_PRICE");
                int num = rs.getInt("ITEM_NUM");
                String cate = rs.getString("ITEM_CAT").trim();
                String inday = rs.getString("ITEM_INDAY").trim();
                String outday = rs.getString("ITEM_OUTDAY").trim();
                String event = rs.getString("ITEM_EVENT").trim();
                int adult = rs.getInt("ITEM_ADULT");
                Vector row = new Vector();
                row.add(name);
                row.add(price);
                row.add(num);
                row.add(cate);
                row.add(inday);
                row.add(outday);
                row.add(event);
                row.add(adult);
        

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e + "->오류가 발생했습니다.");
        }
        return data;
    }
     public DTO_Item getItemDTO(String itemName) {

        DTO_Item dto = new DTO_Item();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = getConn();
            String sql = "select * from ITEMLIST where ITEM_NAME=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, itemName);

            rs = ps.executeQuery();

            if (rs.next()) {
                dto.setName(rs.getString("ITEM_NAME"));
                dto.setPrice(rs.getInt("ITEM_PRICE"));
                dto.setNum(rs.getInt("ITEM_NUM"));
                dto.setCategory(rs.getString("ITEM_CAT"));
                dto.setInday(rs.getString("ITEM_INDAY"));
                dto.setOutday(rs.getString("ITEM_OUTDAY"));
                dto.setEvent(rs.getString("ITEM_EVENT"));
                dto.setAdult(rs.getInt("ITEM_ADULT"));
            }

        } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
        return dto;
    }
}
