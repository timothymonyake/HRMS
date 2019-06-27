package hrms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import org.bush.ui.*;
import org.bush.utilities.*;

/**
 *@author Timothy Segolame Monyake
 *@version 1.00    
 */
public class MainClass extends JFrame{
Container pane;
Utilities ut;
CardLayout layout;
AllEmpsPanel allempsPanel;
AllGrossSalsPanel allGrossSalsPanel;
AllEmpsNetSalsPanel allEmpsNetSalsPanel;
AllFemaleEmpsPanel allFemaleEmpsSalsPanel;
OverViewPanel ovvPanel;
EmpsByCityPanel empsByCityPanel;
AboutPanel aboutPanel;
List<Employee> emplist;
JRadioButton jrb1,jrb2,jrb3;
ButtonGroup bg;
String linuxUI = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
String JavaUI = "javax.swing.plaf.metal.MetalLookAndFeel";
String WindowsUI = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    
    public MainClass() throws IOException
    {   emplist = new ArrayList<>();        
        //menus
        JMenuBar jmb = new JMenuBar();
        //create and add menus to menu bar
        JMenu jm1 = new JMenu("File");
        JMenu jm2 = new JMenu("View");
        JMenu jm4 = new JMenu("Help");
        jm4.setToolTipText("app version, authors, contacts..");//when cursor moves
        //over help menu the text displayes
        jmb.add(jm1);
        jmb.add(jm2);
        jmb.add(jm4);
        JMenuItem jmi9 = new JMenuItem("About");
        //setTheme();
        jrb1 = new JRadioButton("linux");
        jrb2 = new JRadioButton("windows");
        jrb3 = new JRadioButton("java",true);
        bg =new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
  
        jm4.add(jrb1);
        jm4.add(jrb2);
        jm4.add(jrb3);
        
        
        jm4.add(jmi9);
        ///create and add menu items to menus
        JMenuItem jmi1 = new JMenuItem("Open file");
        JMenuItem jmi8 = new JMenuItem("Exit");
        jm1.add(jmi1);
        jm1.add(jmi8);
        //inner menu and its menu items
        JMenuItem jmi10 = new JMenuItem("All records");
        jm2.add(jmi10);
        JMenu jm3 = new JMenu("employees and gross salaries");
        JMenuItem jmi3 = new JMenuItem("All employees");
        //JMenuItem jmi4 = new JMenuItem("Search employee");
        jm3.add(jmi3);
        //jm3.add(jmi4);
        jm2.add(jm3); //ad it to another menu
        JMenuItem jmi5 = new JMenuItem("All female employees");
        JMenuItem jmi6 = new JMenuItem("Employee number per city");
        JMenuItem jmi7 = new JMenuItem("All employees and net salaries");
        jm2.add(jmi5);
        jm2.add(jmi6);
        jm2.add(jmi7);    
        
        setJMenuBar(jmb); //u dont add() you use the method setJMenuBar()     
        
        /*layout and panels*/
        pane = this.getContentPane();
        layout = new CardLayout(); 
        setLayout(layout);
        /*init external panels and add them to content pane*/
   
        ovvPanel= new OverViewPanel();
        aboutPanel =new AboutPanel();
       //displays the first component(and or window) added to it
        pane.add("overview",ovvPanel); //main card (opens when the app starts)
  
        /* no menuitem should be enabled util file loaded */
           if(emplist.isEmpty())
        {
            jm2.setEnabled(false);           
        }
        
        /*action listeners*/
        jrb1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { 
                setLinuxUI(e);
             }
        });        
        jrb2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { 
                setWindowsUI(e);
             }
        });        
        jrb3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { 
                setJavaUI(e);
             }
        });
        
        jmi1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    openFile(e);                  
                    jm2.setEnabled(true); 
                } catch (IOException ex) {
                   JOptionPane.showMessageDialog(null,ex,"Error opening file",JOptionPane.ERROR_MESSAGE);
                   jm2.setEnabled(false); 
                }   
                try {  
                    initAddPanels();
                } catch (IOException ex) {
                     JOptionPane.showMessageDialog(null,ex,"Error opening file",JOptionPane.ERROR_MESSAGE);
                }
             }    
        });
           
    
         jmi8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);//int arg - 0 means app exited without an err!
            }        
        });
        
         jmi9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAbout(aboutPanel); 
             }
         });
         
          jmi3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(pane,"gross_panel"); 
             }
         });
          
           jmi7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(pane,"net_panel"); 
             }
         });
           
           jmi5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               layout.show(pane,"female_panel");
             }
         });
         
            jmi6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(pane,"city_panel");
             }
         });
         
         
        jmi10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllRecords(allempsPanel);                        
             }        
        });
        
    }
  
    public static void main(String[] args) throws IOException 
    {
      MainClass frm = new MainClass();//create an initilise an instance of jframe
      frm.setSize(800,450);
      frm.setTitle("Human Resource Management System");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frm.setLocationRelativeTo(null);
      frm.setVisible(true);
      
    }
    
    public void  initAddPanels() throws IOException
    {
        emplist = ut.getList();   
        //all non-def constructors will be passed a list of type employee so that the tables are drawn in respective classes!
        allEmpsNetSalsPanel = new AllEmpsNetSalsPanel(emplist);
        allGrossSalsPanel = new AllGrossSalsPanel(emplist);
        empsByCityPanel = new EmpsByCityPanel(emplist);
        allFemaleEmpsSalsPanel = new AllFemaleEmpsPanel(emplist);
        allempsPanel = new AllEmpsPanel(emplist);
        //add panels to the Container pane
        pane.add("city_panel",empsByCityPanel); 
        pane.add("gross_panel",allGrossSalsPanel);
        pane.add("net_panel",allEmpsNetSalsPanel);
        pane.add("female_panel",allFemaleEmpsSalsPanel);
    }
    
   public void openFile(ActionEvent e) throws IOException
   {
       ut = new Utilities();       
   } 
    
   public void showAllRecords(JPanel jp)
   {      
       JFrame fr = new JFrame("all records in database");
       fr.setSize(1000,500);
       fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       fr.setLocationRelativeTo(null);
       fr.setVisible(true);
       fr.add(jp);
    }
   
   public void displayAbout(JPanel jp)           
   {
      JFrame fr = new JFrame("About HRMS");
       fr.setSize(300,150);
       fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       fr.setLocationRelativeTo(null);
       fr.setVisible(true);
       fr.add(jp); 
   }
   /*set themes - action events for radio buttons*/
   public void setLinuxUI(ActionEvent e)
   {
       try{UIManager.setLookAndFeel(linuxUI);}
                catch(Exception ex)
                {      
                    JOptionPane.showMessageDialog(null,"error setting linux theme","Error",JOptionPane.ERROR_MESSAGE);
                }
                SwingUtilities.updateComponentTreeUI(this);
   }
   
   public void setWindowsUI(ActionEvent e)
   {
       try{UIManager.setLookAndFeel(WindowsUI);}
                catch(Exception ex)
                {      
                    JOptionPane.showMessageDialog(null,"error setting windows theme","Error",JOptionPane.ERROR_MESSAGE);
                }
                SwingUtilities.updateComponentTreeUI(this);       
   }
       
   
    public void setJavaUI(ActionEvent e)
   {
       try{UIManager.setLookAndFeel(JavaUI);}
                catch(Exception ex)
                {      
                    JOptionPane.showMessageDialog(null,"error setting theme","Error",JOptionPane.ERROR_MESSAGE);
                }
                SwingUtilities.updateComponentTreeUI(this);       
   }

}
