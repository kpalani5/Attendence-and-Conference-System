package guiPackage;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import attendancePackage.AttendanceHome;
import cpePackage.CpeHome; 
//import in.edu.ssn.cse.das.consumables.ConsumablesMainPanel;
//import in.edu.ssn.cse.das.library.LibraryMainPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame 
{
	public MainFrame() {
		setJMenuBar(null);
		revalidate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}  
	private JPanel cardHolder;
	private CardLayout cards;
	
	public static void main(String[] args) 
	{
        try 
        {
            SwingUtilities.invokeAndWait(new Runnable() 
            {
                @Override
                public void run() 
                {
                    new MainFrame().run();
                }
            });
        } 
        catch (Exception ex) { }
    }
	
	 private void run() 
	 {
		 
		 		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 		setJMenuBar(null);
		 		setBounds(0,0,550,500);
		 		setResizable(false);
		 		JPanel loginPanel = new LoginPanel(this);
				//JPanel libraryMainPanel = new LibraryMainPanel();
		        //JPanel consumablesMainPanel = new ConsumablesMainPanel();
		        JPanel attendanceMainPanel = new AttendanceHome(this);
		        JPanel conferenceMainPanel = new CpeHome(this);
		        setJMenuBar(null);
		        cardHolder = new JPanel();
		        cards = new CardLayout();
		        cardHolder.setLayout(cards);
		        cardHolder.add(loginPanel, "loginPanel");
		        //cardHolder.add(libraryMainPanel,"libraryMainPanel");
		        //cardHolder.add(consumablesMainPanel,"consumablesMainPanel");
		        cardHolder.add(attendanceMainPanel,"attendanceMainPanel");
		        cardHolder.add(conferenceMainPanel,"conferenceMainPanel");
		        
		        getContentPane().add(cardHolder);
		        //pack();
		        setVisible(true);
		        Switcher.cardHolder = cardHolder;
		        Switcher.cards = cards;
		        
		        
	 }
}
