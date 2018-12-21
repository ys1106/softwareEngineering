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

/**
 *
 * @author Hong
 */
public class DAO_Card {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:Orcl";
    private static final String username = "Hong";
    private static final String password = "4856";
    
    public DAO_Card(){
       
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
    public boolean getAge(int a){
           boolean adult = false;
             Connection con;
    
           PreparedStatement ps;
           ResultSet rs;
           try {
            con = getConn();
            String sql = "select * from CARDLIST where USER_NUM =" + a;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int age = rs.getInt("USER_AGE");
               
                if( age >= 19)
                    adult = true;
                 else
                    adult = false;
                
            } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.");
        }
           return adult;
      }
    public void adjustMoney(int num, int sum, int cMoney){
             Connection con;
             PreparedStatement ps;
             ResultSet rs;
             try {
                con = getConn();
                String sql = "update CARDLIST set USER_MONEY ="+ (cMoney - sum) + "where USER_NUM =" + num; 
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();        
             } catch (SQLException e) {
             System.out.println(e + "-> 오류가 발생했습니다.");
            }
          
        }
    public boolean getMoney(int num, int sum){
            boolean money = false;
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
            int cMoney = 0;
             try {
            con = getConn();
            String sql = "select * from CARDLIST where USER_NUM =" + num;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
             cMoney = rs.getInt("USER_MONEY");
            }
                if( cMoney >= sum){
                    money = true ;
                    adjustMoney(num, sum, cMoney);
                }
                 else
                    money = false;
                
            } catch (SQLException e) {
            System.out.println(e + "-> 오류가 발생했습니다.(getMoney)");
        }
           return money;
    }
    
}

