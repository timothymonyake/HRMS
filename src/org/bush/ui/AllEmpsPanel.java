package org.bush.ui;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bush.utilities.Employee;
import org.bush.utilities.Utilities;

/**
 *@author Timothy Segolame Monyake
 *@version 1.00    
 */
public class AllEmpsPanel extends JPanel
{
    JLabel jl;
    JTable jt;
    JScrollPane jsp;
  
    public AllEmpsPanel(List<Employee> emplist) throws IOException
    {
        setLayout(new BorderLayout(3,10));
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        
        add(jp1,BorderLayout.NORTH);
        add(jp2,BorderLayout.SOUTH);
        add(jp3,BorderLayout.EAST);
        add(jp4,BorderLayout.WEST);
        //use frame title rather
        //jl = new JLabel("All records in the database");
        //jp.add(jl);
        //add(jp,BorderLayout.NORTH);   
        
        displayTable(emplist);
        add(jsp,BorderLayout.CENTER);
       
    }    
    
    
    public void displayTable(List<Employee> emplist) throws IOException
    {
        jt = new JTable();
        DefaultTableModel md = (DefaultTableModel) jt.getModel();
        jt.setModel(md);
        jsp = new JScrollPane(jt);
                   
        md.addColumn("id");md.addColumn("firstname");md.addColumn("lastname");md.addColumn("gender");md.addColumn("city");md.addColumn("date hired");
        md.addColumn("department");md.addColumn("hours worked p/w");md.addColumn("pay rate");md.addColumn("leave");md.addColumn("car allwnce");md.addColumn("monthly gratuity");
        md.addColumn("tax");
       
        Object[] rowData = new Object[emplist.size()];
        for(int i=0;i<emplist.size();i++)
        {
            rowData[0] = emplist.get(i).geteID();
            rowData[1] = emplist.get(i).getFname();
            rowData[2] = emplist.get(i).getLname();
            rowData[3] = emplist.get(i).getSex();
            rowData[4] = emplist.get(i).getCity();
            rowData[5] = emplist.get(i).getDateHired();
            rowData[6] = emplist.get(i).getDept();
            rowData[7] = emplist.get(i).getHrsPerWeek();
            rowData[8] = emplist.get(i).getPayRate();
            rowData[9] = emplist.get(i).getLeaveDays();
            rowData[10] = emplist.get(i).getCarAllowance();
            rowData[11] = emplist.get(i).getmGratuity();
            rowData[12] = emplist.get(i).getTax();
            md.addRow(rowData);
        }
        
        
        
    }
}
