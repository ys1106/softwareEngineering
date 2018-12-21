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
public class DTO_Time {
    private String Time_id;
    private String Time_stime;
    private String Time_etime;
    
    public void setId(String a){
    this.Time_id = a;}
    
    public String getId(){
    return this.Time_id;}
    
    public void setStime(String a){
    this.Time_stime = a;
    }
    public String getStime(){
    return this.Time_stime;}
    
    public void setEtime(String a){
    this.Time_etime = a;
    }
    public String getEtime(){
    return this.Time_etime;
    }
}
