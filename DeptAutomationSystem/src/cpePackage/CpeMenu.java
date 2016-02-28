package cpePackage;

import guiPackage.MyConnection;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import reportsPackage.CpeReportMain;
import reportsPackage.CpeReports;
import reportsPackage.CpeStaffReports;

public class CpeMenu {
	JMenuBar M;
	JMenu home,rep,quit;
	JMenuItem h1,h2,h3,h4,h5;
	JMenuItem r1,r2,r3,r4,r5;
	JMenuItem q1;
	
	public CpeMenu(final JFrame F)
	{
		M=new JMenuBar();
		home=new JMenu("HOME");
		rep=new JMenu("REPORTS");
		quit=new JMenu("QUIT");
		h1=new JMenuItem("Event Organizing");
		h1.setIcon(new ImageIcon("images/OrganizingIcon.png"));
		h2=new JMenuItem("Event Attending");
		h2.setIcon(new ImageIcon("images/AttendingIcon.jpg"));
		h3=new JMenuItem("Guest Lectures");
		h3.setIcon(new ImageIcon("images/LectureIcon.jpg"));
		h4=new JMenuItem("Reports Home");
		h4.setIcon(new ImageIcon("images/ReportIcon.png"));
		h5=new JMenuItem("CPE Home");
		h5.setIcon(new ImageIcon("images/HomeIcon.png"));
		r1=new JMenuItem("Event Organizing - Students");
		r2=new JMenuItem("Event Organizing - Staff");
		r3=new JMenuItem("Event Organizing - Both");
		r4=new JMenuItem("Event Attending - Staff");
		r5=new JMenuItem("Guest Lectures - Staff");
		r1.setIcon(new ImageIcon("images/IconPad.png"));
		r2.setIcon(new ImageIcon("images/IconPad.png"));
		r3.setIcon(new ImageIcon("images/IconPad.png"));
		r4.setIcon(new ImageIcon("images/IconPad.png"));
		r5.setIcon(new ImageIcon("images/IconPad.png"));
		q1=new JMenuItem("Logout");
		q1.setIcon(new ImageIcon("images/LogoutIcon.jpg"));
		
		home.add(h1);
		home.add(h2);
		home.add(h3);
		home.add(h4);
		home.add(h5);
		
		rep.add(r1);
		rep.add(r2);
		rep.add(r3);
		rep.add(r4);
		rep.add(r5);
		
		quit.add(q1);
		
		M.add(home);
		M.add(rep);
		M.add(quit);
		
		F.setJMenuBar(M);
		
		h1.addActionListener(new ActionListener() {
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

		h2.addActionListener(new ActionListener() {
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
		
		h3.addActionListener(new ActionListener() {
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
		
		h4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeReportMain(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		h5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeHome(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeReports(F,2));
				p.revalidate();
				p.repaint();
			}
		});
		
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeReports(F,1));
				p.revalidate();
				p.repaint();
			}
		});
		
		r3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeReports(F,3));
				p.revalidate();
				p.repaint();
			}
		});
		
		r4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeStaffReports(F,1));
				p.revalidate();
				p.repaint();
			}
		});
		
		r5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeStaffReports(F,2));
				p.revalidate();
				p.repaint();
			}
		});
		
		q1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.dispose();
			}
		});
	}
}
