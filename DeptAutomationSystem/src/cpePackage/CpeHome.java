package cpePackage;

import guiPackage.MyConnection;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import reportsPackage.CpeReportMain;

@SuppressWarnings("serial")
public class CpeHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public CpeHome(final JFrame F) {
		new CpeMenu(F);
		
		setLayout(null);
		
		JLabel lblCpeManagement = new JLabel("CPE MANAGEMENT");
		lblCpeManagement.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblCpeManagement.setBounds(181, 31, 194, 28);
		add(lblCpeManagement);
		
		JPanel panel = new JPanel();
		panel.setBounds(80, 92, 364, 247);
		add(panel);
		panel.setLayout(new GridLayout(5, 1, 1, 6));
		
		JButton btnOrganizing = new JButton("ORGANIZING");
		btnOrganizing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection con=new MyConnection();
				long sn=1;
				try
				{
					PreparedStatement stmt=con.getConnection().prepareStatement("select sno from organize order by sno desc");
					ResultSet rs=stmt.executeQuery();
					if(rs.next())
						sn=Long.parseLong(rs.getString(1))+1;
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new Organizing(F,sn));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnOrganizing);
		
		JButton btnAttending = new JButton("ATTENDING");
		btnAttending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection con=new MyConnection();
				long sn=1;
				try
				{
					PreparedStatement stmt=con.getConnection().prepareStatement("select sno from attending order by sno desc");
					ResultSet rs=stmt.executeQuery();
					if(rs.next())
						sn=Long.parseLong(rs.getString(1))+1;
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new Attending(F,sn));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnAttending);
		
		JButton btnGuestLectures = new JButton("GUEST LECTURES");
		btnGuestLectures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection con=new MyConnection();
				long sn=1;
				try
				{
					PreparedStatement stmt=con.getConnection().prepareStatement("select sno from lecture order by sno desc");
					ResultSet rs=stmt.executeQuery();
					if(rs.next())
						sn=Long.parseLong(rs.getString(1))+1;
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new GuestLecture(F,sn));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnGuestLectures);
		
		JButton btnReports = new JButton("REPORTS");
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeReportMain(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnReports);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.dispose();
			}
		});
		panel.add(btnLogout);

	}

	public static void main(String args[])
	{
		JFrame F=new JFrame();
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.setSize(550, 500);
		F.setResizable(false);
		Container pane=F.getContentPane();
		pane.add(new CpeHome(F));
	}
}
