/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bush.utilities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Employee extends Person {
    
    private int eID;private String title;private String dateHired;private String dept;private int hrsPerWeek;
    private double payRate;private int leaveDays;private double carAllowance;private double mGratuity;private double tax;
    
    
    
     //will be used to initialise our object
     public Employee(String name,String sname,String dob,String city,String sex){//int eID, String title, String dateHired, String dept, int hrsPerWeek, double payRate, int leaveDays, double carAllowance, double mGratuity, double tax) {
      
        super(name,sname,dob,city,sex);
         /* this.eID = eID;
        this.title = title;
        this.dateHired = dateHired;
        this.dept = dept;
        this.hrsPerWeek = hrsPerWeek;
        this.payRate = payRate;
        this.leaveDays = leaveDays;
        this.carAllowance = carAllowance;
        this.mGratuity = mGratuity;
        this.tax = tax;*/
    }

  
    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateHired() {
        return dateHired;
    }

    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getHrsPerWeek() {
        return hrsPerWeek;
    }

    public void setHrsPerWeek(int hrsPerWeek) {
        this.hrsPerWeek = hrsPerWeek;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public double getCarAllowance() {
        return carAllowance;
    }

    public void setCarAllowance(double carAllowance) {
        this.carAllowance = carAllowance;
    }

    public double getmGratuity() {
        return mGratuity;
    }

    public void setmGratuity(double mGratuity) {
        this.mGratuity = mGratuity;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
     
     
    @Override
    public String getFname()
    {
        String str;
        str = super.getFname();
        return str;
    }
    
    
    @Override
    public String getLname()
    {
        String str;
        str = super.getLname();
        return str;
    }
    
    @Override
    public String getDob()
    {
        String str;
        str = super.getDob();
        return str;
    }
    
    @Override
    public String getSex()
    {
        String str;
        str = super.getSex();
        return str;
    }
    
    @Override
    public String getCity()
    {
        String str;
        str = super.getCity();
        return str;
    }
    
    @Override
    public String toString()
    {
   
        return ""/*+geteID()*/+" "+getFname().toUpperCase()+" | "+getLname().toUpperCase()+" | "+this.taxPaid()+" | "+this.getgSalary();
                ///*+getDob()+" "+getSex()+" "+getCity()+" */getTitle()/*" "+getDateHired()+" "+getDept()*/ ;                
    }
    
    
    //gross salary
    public double getgSalary()  //show all employee salaries
    {
        double salary; //
        int msalary = (this.getHrsPerWeek())*4;  //is leave paid or unpaid.
        salary=(double)msalary * this.getPayRate();  //converting an int(msalary) to a double (cast operator)
        double grossSalary = salary+(salary*this.getCarAllowance())+(salary*this.getmGratuity());//(salary*getTax()));         
        
        DecimalFormat df = new DecimalFormat("####.00");
        String stf = df.format(grossSalary); //because this is double we need to format our values after the decimal point, some are just ugly! ie 34455.737434636 to 34455.73
        double dv = Double.parseDouble(stf);   
        
        return dv; //better we round our Thebes    ??                   
    }
    
    public double taxPaid()
    {
        double txpaid = (this.getgSalary()*this.getTax()); //formula
        
        DecimalFormat df = new DecimalFormat("####.00");
        String stf = df.format(txpaid);
        double dv = Double.parseDouble(stf); 
        
        return dv;  //we could use the Math.round to round off to the nearest decimal
    }
    
    public double getnetSalary()
    {
        double calcSal;
        calcSal = this.getgSalary() - (this.getgSalary()*this.getTax()); //formula
        
        DecimalFormat df = new DecimalFormat("####.00");
        String stf = df.format(calcSal);
        double netsalary = Double.parseDouble(stf); 
        
        return netsalary;
    }
    
    
    
 /*   public void showEmpsSalaries(ArrayList<Employee> s)
    {
        while(s.isEmpty()==false)
        {
             Scanner sc = new Scanner(System.in);
             System.out.println("please enter the name of the employee");
             String name = "> "+sc.nextLine();    
             
            for(Employee a : s)
            {
                if(s.getFname().equalsIgnoreCase(name) || e.getLname().equalsIgnoreCase(name))
                                        {

                                        }
            }
             
             
        }
    }*/
  
    
    
  
    
} //end of class

   
