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
public class DTO_User {
    private int user_id;        
    private String user_name;          
    private int user_phone;       
    
    public void setId(int a){
    this.user_id = a;
    }
    public void setName(String a){
    this.user_name = a;
    }
    public void setPhone(int a){
    this.user_phone = a;
    }
    public int getId(){
    return this.user_id;
    }
    public String getName(){
    return this.user_name;
    }
    public int getPhone(){
    return this.user_phone;
    }
    public String toString(){
    return "DTO_User[id=" + user_id + ", name=" + user_name + ", Phone=" + user_phone;
    }
}
