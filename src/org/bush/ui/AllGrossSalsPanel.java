/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bush.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.bush.utilities.Employee;
import org.bush.utilities.Utilities;

/**
 *@author Timothy Segolame Monyake
 *@version 1.00    
 */
public class AllGrossSalsPanel extends JPanel
{
    JTable jt;
    JLabel jl;
    JScrollPane jsp;
    JPanel jp1,jp2,jp3,jp4;
    List<Employee> emplist;
    JButton jb;
    JTextField jtf;
    TableRowSorter sorter;
    
    public AllGrossSalsPanel() throws IOException
    {
        setLayout(new BorderLayout(3,10));
        JPanel jp1 = new JPanel();
        jl = new JLabel("All employees gross salaries");
        jl.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        jp1.add(jl);
        JPanel jp1In = new JPanel(new FlowLayout());
        jtf = new JTextField();
        jtf.setColumns(20);
        jb = new JButton("Search record");
       
        
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        
        add(jp1,BorderLayout.NORTH);
        jp2.add(jtf);
        jp2.add(jb);
        add(jp2,BorderLayout.SOUTH);
        add(jp3,BorderLayout.EAST);
        add(jp4,BorderLayout.WEST);
  
        displayGrossSalaries();        
        add(jsp,BorderLayout.CENTER);  


        jb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String record = jtf.getText();
                sorter.setRowFilter(RowFilter.regexFilter(record));
            }        
        });
    }
    
    public void displayGrossSalaries() throws IOException
    {
        jt = new JTable();
        jsp  =new JScrollPane(jt);
        Utilities ut = new Utilities();
        emplist = ut.getList();
        DefaultTableModel md = (DefaultTableModel) jt.getModel();
        jt.setModel(md);
         md.addColumn("FIRSTNAME");md.addColumn("LASTNAME");md.addColumn("TAX TO BE PAID (BWP)");md.addColumn("GROSS SALARY (BWP)");
         Object[] rowData = new Object[emplist.size()]; 
         for(int ie = 0;ie<emplist.size();ie++)
         {
            rowData[0] = emplist.get(ie).getFname();
            rowData[1] = emplist.get(ie).getLname();
            rowData[2] = emplist.get(ie).taxPaid();
            rowData[3] = emplist.get(ie).getgSalary();
            md.addRow(rowData);
         }
         sorter= new TableRowSorter(md);
         jt.setRowSorter(sorter);
    }

}
