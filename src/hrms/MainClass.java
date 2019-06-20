package hrms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bush.ui.*;
import org.bush.utilities.*;
/**
 *@author Timothy Segolame Monyake
 *@version 1.00    
 */
public class MainClass extends JFrame{
Container pane;
CardLayout layout;
AllEmpsPanel allempsPanel;
OverViewPanel ovvPanel;
AllFemaleEmpsPanel allfemalePanel;
EmpsByCityPanel empsByCityPanel;
AllEmpsNetSalsPanel allNetSalsPanel;
AllGrossSalsPanel allGrossSalsPanel;
AboutPanel aboutPanel;
List<Employee> emplist;
    
    public MainClass() throws IOException
    {
        emplist = new ArrayList<>();
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
        allempsPanel = new AllEmpsPanel();
        allfemalePanel = new AllFemaleEmpsPanel();
        empsByCityPanel =new EmpsByCityPanel();
        allNetSalsPanel = new AllEmpsNetSalsPanel();
        allGrossSalsPanel = new AllGrossSalsPanel();
        aboutPanel =new AboutPanel();

            
        //displays the first component(and or window) added to it
        pane.add("overview",ovvPanel); //main card (opens when the app starts)
        pane.add("all_female",allfemalePanel);
        pane.add("by_city",empsByCityPanel);
        pane.add("net_salaries",allNetSalsPanel);
        pane.add("gross_salaries",allGrossSalsPanel);
      
        
        /* no view menuitem should be enabled util file loaded */
           if(emplist.isEmpty())
        {
            jm2.setEnabled(false);           
        }
        
        /*action listeners*/
        
        
      
        
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
             }    
        });
           
       
        
        jmi3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(pane, "gross_salaries");
            }
        
        });
        
        jmi5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(pane,"all_female");
             }
        });
        
        jmi6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(pane, "by_city");
            }
        });
        
        jmi7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(pane, "net_salaries");
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
    
   public void openFile(ActionEvent e) throws IOException
   {
       Utilities ut = new Utilities();
       emplist =  ut.getList(); //getList returns an arraylist of type Employee
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
       //fr.remove(JFrame.);
       
   }
}
