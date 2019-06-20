/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bush.utilities;

/**
 *
 * @author root
 */
public abstract class Person 
{
    private String fname;
    private String lname;
    private String dob;
    private String city;
    private String gender;

    public Person(String fname, String lname, String dob, String city,String sex) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.city = city;
        this.gender = sex;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
      public String getSex() {
        return gender;
    }

    public void setSex(String sex) {
        this.gender = sex;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
  
    
}
