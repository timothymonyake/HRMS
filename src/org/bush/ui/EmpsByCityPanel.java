/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bush.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bush.utilities.Employee;
import org.bush.utilities.Utilities;

/**
 *@author Timothy Segolame Monyake
 *@version 1.00    
 */
public class EmpsByCityPanel extends JPanel
{
    JTable jt;
    JLabel jl;
    JScrollPane jsp;
    JPanel jp1,jp2,jp3,jp4;
 
    public EmpsByCityPanel(List<Employee> emplist) throws IOException
    {
        setLayout(new BorderLayout(3,10));
        JPanel jp1 = new JPanel(new FlowLayout());
        jl = new JLabel("Number of employees in cities");
        jl.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        jp1.add(jl);
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        
        add(jp1,BorderLayout.NORTH);
        add(jp2,BorderLayout.SOUTH);
        add(jp3,BorderLayout.EAST);
        add(jp4,BorderLayout.WEST);
  
        displayEmpsbyCity(emplist);
        add(jsp,BorderLayout.CENTER);         
    }
    
    public void displayEmpsbyCity(List<Employee> emplist) throws IOException
    {
            jt = new JTable();
            jsp = new JScrollPane(jt);
            DefaultTableModel md = (DefaultTableModel) jt.getModel();
            jt.setModel(md);          
            //emplist = Utilities.getList();        
            md.addColumn("City");
            md.addColumn("Number of Employees");
                     
               String [] city = {"mochudi","orapa","lobatse","jwaneng","kasane","Francistown","Palapye","Serowe","jwaneng","Selibe Phikwe","gaborone"};
               Object[] rowData = new Object[emplist.size()];
        
            
                for(int c = 0;c<city.length;c++)
                {
                    rowData[0] = city[c];
                    int count = 0;
                    for(int i = 0;i<emplist.size();i++)
                    {
                        if(city[c].equalsIgnoreCase(emplist.get(i).getCity()))
                        {
                            count++;
                            rowData[1] = count;
                        }

                    }
                   md.addRow(rowData);
                }
    }

}
