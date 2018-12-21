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
public class DTO_Payment {

    private int Payment_num;
    private String User_id;
    private String Payment_date;
    private String Item_name;
    private int Item_price;
    private int Item_num;
    private int Payment_total;
    private int Payment_method;
    private int Payment_access;
    private int Payment_cardNum;

    public void setId(String a) {
        this.User_id = a;
    }

    public String getId() {
        return this.User_id;
    }

    public void setPnum(int a) {
        this.Payment_num = a;
    }

    public int getPnum() {
        return this.Payment_num;
    }

    public void setDate(String a) {
        this.Payment_date = a;
    }

    public String getDate() {
        return this.Payment_date;
    }

    public void setName(String a) {
        this.Item_name = a;
    }

    public String getName() {
        return this.Item_name;
    }

    public void setPrice(int a) {
        this.Item_price = a;
    }

    public int getPrice() {
        return this.Item_price;
    }

    public void setNum(int a) {
        this.Item_num = a;
    }

    public int getNum() {
        return this.Item_num;
    }

    public void setPtotal(int a) {
        this.Payment_total = a;
    }

    public int getPtotal() {
        return this.Payment_total;
    }

    public void setPmethod(int a) {
        this.Payment_method = a;
    }

    public int getPmethod() {
        return this.Payment_method;
    }

    public void setPaccess(int a) {
        this.Payment_access = a;
    }

    public int getPaccess() {
        return this.Payment_access;
    }

    public void setCarNum(int a) {
        this.Payment_cardNum = a;
    }

    public int getCarNum() {
        return this.Payment_cardNum;
    }
}
