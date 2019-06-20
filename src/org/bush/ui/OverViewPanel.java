/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bush.ui;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import org.bush.utilities.*;
/**
 *@author Timothy Segolame Monyake
 *@version 1.00    
 */
public class OverViewPanel extends JPanel
{
    JTextArea jta;
    ArrayList<String> readme;
    JPanel pn1,pn2,pn3,pn4;
    JScrollPane sp;
    public OverViewPanel() throws IOException
    {
        setLayout(new BorderLayout(5,10));
        jta = new JTextArea();
        readme = getReadMe();
  
        JLabel jl = new JLabel("APPLICATION OVERVIEW");
        Font f1 = new Font(Font.DIALOG_INPUT,Font.BOLD,30);
        jl.setFont(f1);
        pn1 = new JPanel();
        pn2 = new JPanel();
        pn3 = new JPanel();
        pn4 = new JPanel();
        
        pn1.add(jl);
        add(pn1,BorderLayout.NORTH);
        add(pn2,BorderLayout.EAST);
        add(pn3,BorderLayout.WEST);
        add(pn4,BorderLayout.SOUTH);
        
         
         JTextArea jt = new JTextArea();
         String tex = "";
         
      
         for(int i = 0;i<readme.size();i++)
         {
            tex = tex.concat(readme.get(i))+"\n";           
         }
          jt.setText(tex);
         
         
         jt.setEditable(false);
         jt.setBackground(new Color(238,238,238)); //rgb
       
         sp = new JScrollPane(jt);
                           
     
         add(sp,BorderLayout.CENTER);
    }
    
    
    public ArrayList<String> getReadMe() throws IOException
    {
        ArrayList<String> rm = new ArrayList<>();
        rm = Utilities.sysOverview();
        return rm;
    }
}

