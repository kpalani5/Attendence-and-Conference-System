package attendancePackage;

import guiPackage.MyConnection;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

class subPanel
{
	JPanel p1;
	JLabel l1;
	JButton b1;
	
	JPanel create(final long reg,final int semester,final String subcd)
	{
		p1=new JPanel();
		p1.setLayout(new FlowLayout());
		l1=new JLabel(subcd);
		b1=new JButton("ADD ELECTIVE");
		p1.add(l1);
		p1.add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(false);
				MyConnection con=new MyConnection();
				try 
				{
					int k;
					for(k=1;k<=4;k++)
					{
					PreparedStatement stmt=con.getConnection().prepareStatement("insert into attended values(?,?,?,?,?)");
					stmt.setLong(1, reg);
					stmt.setString(2, l1.getText());
					stmt.setInt(3, 0);
					stmt.setInt(4, 0);
					stmt.setInt(5, k);
					stmt.execute();
					}
					
					for(k=1;k<=3;k++)
					{
					PreparedStatement stmt=con.getConnection().prepareStatement("insert into marks values(?,?,?,?)");
					stmt.setLong(1, reg);
					stmt.setString(2, l1.getText());
					stmt.setInt(3, 0);
					stmt.setInt(4, k);
					stmt.execute();
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Invalid Details!");
				}
			}
		});
		p1.setVisible(true);
		return p1;
	}
}

@SuppressWarnings("serial")
public class StudentSubjects extends JPanel {

	/**
	 * Create the panel.
	 * 
	 */
	
	JButton btnFinish;
	JButton btnNewButton;
	public StudentSubjects(final JFrame F,final long reg,final int semester,final String crse) {
		setLayout(null);
		
		JLabel lblRegistrationNumber = new JLabel("REGISTRATION NUMBER");
		lblRegistrationNumber.setBounds(123, 48, 152, 14);
		add(lblRegistrationNumber);
		
		JLabel lblChooseSubjects = new JLabel("CHOOSE SUBJECTS");
		lblChooseSubjects.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblChooseSubjects.setBounds(190, 11, 182, 26);
		add(lblChooseSubjects);
		
		JLabel label = new JLabel(new Long(reg).toString());
		label.setBounds(375, 48, 119, 14);
		add(label);
		
		final JPanel panel = new JPanel();
		panel.setBounds(74, 92, 408, 233);
		
		final JButton btnFinish_1 = new JButton("FINISH");
		btnFinish_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new AttendanceHome(F));
				p.revalidate();
				p.repaint();
			}
		});
		btnFinish_1.setEnabled(false);
		btnFinish_1.setBounds(234, 422, 89, 23);
		add(btnFinish_1);
		
		btnNewButton = new JButton("MANDATORY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFinish_1.setEnabled(true);
				btnFinish.setEnabled(true);
				btnNewButton.setEnabled(false);
				MyConnection con=new MyConnection();
				try 
				{
					
					PreparedStatement stmt=con.getConnection().prepareStatement("select subcode from subjects where semester=? and course=? and subtype=?");
					
					stmt.setInt(1, semester);
					stmt.setString(2, crse);
					stmt.setString(3, "MANDATORY");
					ResultSet rs=stmt.executeQuery();
					//JLabel l0=new JLabel();
					
					while(rs.next())
					{
						
			
						int k;
						for(k=1;k<=4;k++)
						{
						stmt=con.getConnection().prepareStatement("insert into attended values(?,?,?,?,?)");
						stmt.setLong(1, reg);
						stmt.setString(2, rs.getString(1));
						stmt.setInt(3, 0);
						stmt.setInt(4, 0);
						stmt.setInt(5, k);
						stmt.execute();
						}
						
						for(k=1;k<=3;k++)
						{
						stmt=con.getConnection().prepareStatement("insert into marks values(?,?,?,?)");
						stmt.setLong(1, reg);
						stmt.setString(2, rs.getString(1));
						stmt.setInt(3, 0);
						stmt.setInt(4, k);
						stmt.execute();
						}
						panel.add(new JLabel(rs.getString(1)));
						panel.revalidate();
						panel.repaint();
						}
					
					
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Invalid Details!");
					//e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(309, 346, 169, 45);
		add(btnNewButton);
		
		
		
		btnFinish = new JButton("ELECTIVES");
		btnFinish.setEnabled(false);
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection con=new MyConnection();
				try{
				
				PreparedStatement stmt=con.getConnection().prepareStatement("select subcode from subjects where semester=? and course=? and subtype=?");
				stmt.setInt(1, semester);
				stmt.setString(2, crse);
				stmt.setString(3, "ELECTIVE");
				ResultSet rs=stmt.executeQuery();
				while(rs.next())
				{
				subPanel p=new subPanel();
				btnFinish.setEnabled(false);
				btnFinish_1.setEnabled(true);
				panel.add(p.create(reg,semester,rs.getString(1)));
				panel.add(Box.createVerticalStrut(10));
				panel.revalidate();
	            panel.repaint();
				}
				}
				catch(Exception e1)
				{
					
				}
			}
		});
		btnFinish.setBounds(73, 346, 176, 45);
		add(btnFinish);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(74, 92, 408, 233);
		add(scrollPane);
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(20, 1, 1, 1));
		
		

	}
	


}
