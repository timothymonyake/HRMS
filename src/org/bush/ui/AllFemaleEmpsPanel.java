/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bush.ui;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bush.utilities.Employee;
import org.bush.utilities.Utilities;

/**
 *@author Timothy Segolame Monyake
 *@version 1.00    
 */
public class AllFemaleEmpsPanel extends JPanel
{
    JTable jt;
    JLabel jl;
    JScrollPane jsp;
    JPanel jp1,jp2,jp3,jp4;
    List<Employee> emplist;
    
    public AllFemaleEmpsPanel() throws IOException
    {
        setLayout(new BorderLayout(3,10));
        JPanel jp1 = new JPanel(new FlowLayout());
        jl = new JLabel("List of all female employees");
        jl.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,20));
        jp1.add(jl);
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        
        add(jp1,BorderLayout.NORTH);
        add(jp2,BorderLayout.SOUTH);
        add(jp3,BorderLayout.EAST);
        add(jp4,BorderLayout.WEST);
  
        displayAllFemEmps();
        add(jsp,BorderLayout.CENTER);       
    }
    
    public void displayAllFemEmps() throws IOException
    {
        jt = new JTable();
        jsp  =new JScrollPane(jt);
        Utilities ut = new Utilities();
        emplist = ut.getList();
        DefaultTableModel md = (DefaultTableModel) jt.getModel();
        jt.setModel(md);
        md.addColumn("ID"); 
        md.addColumn("FIRSTNAME"); md.addColumn("LASTNAME"); md.addColumn("CITY"); md.addColumn("DATE HIRED"); md.addColumn("DEPARTMENT");
        md.addColumn("GROSS SALARY");     

       //now that the column model has been taken care of, time to add rows.
       Object [] rowData = new Object[emplist.size()];     
      
       for(int i=0;i<emplist.size();i++)
            {
                if(emplist.get(i).getSex().equalsIgnoreCase("Female"))//filters female employees only from our arralist
                {
                    rowData[0] = emplist.get(i).geteID();
                    rowData[1] = emplist.get(i).getFname(); //first column cell data
                    rowData[2] = emplist.get(i).getLname();
                    rowData[3] = emplist.get(i).getCity();
                    rowData[4] = emplist.get(i).getDateHired();
                    rowData[5] = emplist.get(i).getDept();
                    rowData[6] = emplist.get(i).getgSalary();
                    md.addRow(rowData);
                }                
            } 
    }
}
