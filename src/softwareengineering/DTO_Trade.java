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
public class DTO_Trade {
    private String item_name;
    private int item_price;
    private int trade_num;
    
    public void setName(String a){
    this.item_name = a;}
    
    public void setPrice(int a){
    item_price = a;}
    
    public void setNum(int a){
    trade_num = a;}
    
    public String getName(){
    return this.item_name;}
    
    public int getPrice(){
    return this.item_price;}
    
    public int getNum(){
    return this.trade_num;}
}
