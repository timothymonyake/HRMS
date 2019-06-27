
package org.bush.utilities;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Utilities {
    static BufferedReader br = null;
    static FileReader fr = null;
    static File f = null;
    static String lineRead;
    static List<Employee> emplist ;
    static ArrayList<String> readme;
   
   
    public Utilities() throws IOException
    {
        loadFile();
    } 
    
   public void loadFile() throws IOException
   {
       
       try
       {
                
            //dynamic file reading using jfc 
            JFileChooser jfc = new JFileChooser();
            jfc.setDialogType(JFileChooser.OPEN_DIALOG);
            jfc.setDialogTitle("Open the employee database text file");            
           
                File lin_dir = new File("/root/Desktop/Year1Assign/");
                jfc.setCurrentDirectory(lin_dir);
             
            jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int status = jfc.showOpenDialog(jfc); //returns 0 if file selected , and 1 if cancel or exit button pressed!
            
            f  = jfc.getSelectedFile();
            fr = new FileReader(f);
            br = new BufferedReader(fr);
           //approve / cancel / error
           /* if(status==JFileChooser.APPROVE_OPTION)
            {
                JOptionPane.showMessageDialog(null,"Success","File read Successfully",JOptionPane.INFORMATION_MESSAGE);
            }*/          
            
           
       
       }
       catch(FileNotFoundException e)
       {
           System.out.println(e+" file not found at the specied location");
       }
    
   }//end of method
   
   public List<Employee> getList() throws IOException 
   {
       emplist = new ArrayList<>();
       while((lineRead = br.readLine())!=null)
       {
     //      1,michael,keane,01-01-1983,male,Gaborone,marketing executive,01-01-2015,marketing,40,45.37,3,0.00,0.01,0.12
           String [] empDetails = lineRead.split(",");
          
           if(empDetails.length>0)//if we managed to capture something
           {
                //need to be captured as string and converted 
                              String tempID = (empDetails[0]);
                              String temphpw = (empDetails[9]);
                              String tempprate = (empDetails[10]);
                              String templeav = (empDetails[11]);
                              String tempcall = empDetails[12]; 
                              String tempmgra = empDetails[13];
                              String temptax = empDetails[14];
                              
                               //15 attributes of employee
                              int eID = Integer.parseInt(tempID);
                              String fname = empDetails[1];
                              String lname = empDetails[2];
                              String dob = empDetails[3];
                              String sex = empDetails[4];
                              String city = empDetails[5];
                              String title = empDetails[6];
                              String dHired= empDetails[7];
                              String dept = empDetails[8];
                              int hoursWorked = Integer.parseInt(temphpw);
                              double payRate = Double.parseDouble(tempprate);
                              int ldays = Integer.parseInt(templeav);
                              double carAllowance = Double.parseDouble(tempcall);
                              double mGratuity = Double.parseDouble(tempmgra);
                              double tax = Double.parseDouble(temptax);
                              
                              Employee p = new Employee(fname,lname,dob,city,sex);
                              p.seteID(eID);p.setTitle(title);p.setDateHired(dHired);p.setDept(dept);p.setHrsPerWeek(hoursWorked);p.setPayRate(payRate);p.setLeaveDays(ldays);
                              p.setCarAllowance(carAllowance);p.setmGratuity(mGratuity);p.setTax(tax);
                              emplist.add(p);
           }          
       }//end of while   
       return emplist;
   }
   
   
   public static ArrayList<String>sysOverview() throws IOException
   {
       
       try
       {
            BufferedReader brz = new BufferedReader(new FileReader(new File("/root/Desktop/Year1Assign/readme.txt")));
            readme = new ArrayList<>();
            String line;
            while((line = brz.readLine())!=null)
            {
                readme.add(line);
            }
       }catch(FileNotFoundException ex)
       {
           System.out.println("File not found, this might help "+ex);
       }
       
      return readme;
   }
   
   
}
