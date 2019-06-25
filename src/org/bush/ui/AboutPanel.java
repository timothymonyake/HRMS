/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bush.ui;
import java.awt.*;
import javax.swing.*;


/**
 *@author Timothy Segolame Monyake
 *@version 1.00    
 */
public class AboutPanel extends JPanel
{
    JPanel jp1,jp2,jp3;
    JLabel jl1,jl2,jl3;
    public AboutPanel()
    {
        setLayout(new BorderLayout());
        jp1 = new JPanel();
            jl1 = new JLabel("HRMS");
            jl1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));            
        jp1.add(jl1);
        add(jp1,BorderLayout.NORTH); 
        jp2 = new JPanel();
            jl2 = new JLabel("For educational purposes");
            jl2.setFont(new Font(Font.SERIF,Font.PLAIN,15));
        jp2.add(jl2);
        add(jp2,BorderLayout.CENTER);
        
        jp3 = new JPanel();
            jl3 = new JLabel("Copyright 2019 Ver 1.00");
            jl3.setFont(new Font(Font.SERIF,Font.PLAIN,13));
        jp3.add(jl3);
        add(jp3,BorderLayout.SOUTH);       
    }

}
