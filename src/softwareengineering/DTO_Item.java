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
public class DTO_Item {
     private String Item_name;
    private int Item_price;
    private int Item_num;
    private String Item_cat;
    private String Item_outDay;
    private String Item_event;
    private int Item_adult;
    private String Item_inDay;
    
    public void setName(String a){
    Item_name = a;
    }
    
    public String getName(){
    return this.Item_name;}
    
    public void setPrice(int a){
    this.Item_price = a;}
    
    public int getPrice(){
    return this.Item_price;}
    
    public void setNum(int a){
    this.Item_num = a;}
    
    public int getNum(){
    return this.Item_num;}
    
    public void setCategory(String a){
    this.Item_cat = a;}
    
    public String getCategory(){
    return this.Item_cat;}
    
    public void setOutday(String a){
    this.Item_outDay = a;}
    
    public String getOutday(){
    return this.Item_outDay;}
    
    public void setEvent(String a){
     this.Item_event = a;}
    
    public String getEvent(){
    return this.Item_event;}
    
    public void setAdult(int a){
    this.Item_adult = a;}
    
    public int getAdult(){
    return this.Item_adult;}
    
    public void setInday(String a){
    this.Item_inDay = a;}
    
    public String getInday(){
    return this.Item_inDay;}
}
