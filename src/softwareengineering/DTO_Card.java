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
public class DTO_Card {
    private int num;
    private String name;
    private int age;
    private int money;
    
    public void setNum(int a){
    this.num = a;}
    
    public void setAge(int a){
    this.age = a;}
    
    public void setMoney(int a){
    this.money = a;}
    
    public int getNum(){
    return this.num;}
    
    public String getName(){
    return this.name;}
    
    public int getAge(){
    return this.age;}
    
    public int getMoney(){
    return this.money;}
}
