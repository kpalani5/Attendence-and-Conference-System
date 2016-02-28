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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class subPanel1
{
	JPanel p1;
	JLabel l1;
	JTextField t1;
	JButton b1;
	
	JPanel create(final long reg,final String subc,final int period,final int total)
	{
		p1=new JPanel();
		p1.setLayout(new FlowLayout());
		l1=new JLabel(new Long(reg).toString());
		t1=new JTextField(6);
		b1=new JButton("UPDATE");
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(false);
				t1.setEditable(false);
				MyConnection con=new MyConnection();
				try 
				{
					
					PreparedStatement stmt=con.getConnection().prepareStatement("update attended set total_hours=?,hours_attended=? where regno=? and subcode=? and period=?");
					stmt.setInt(1, total);
					stmt.setInt(2, Integer.parseInt(t1.getText()));
					stmt.setLong(3, reg);
					stmt.setString(4, subc);
					stmt.setInt(5, period);
					stmt.execute();
					
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
public class SubjectAttendance extends JPanel {

	/**
	 * Create the panel.
	 */
	public SubjectAttendance(final JFrame F,final String subc,final int total,final int period) {
		setLayout(null);
		
		JLabel lblUpdateSubjectAttendance = new JLabel("UPDATE SUBJECT ATTENDANCE");
		lblUpdateSubjectAttendance.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblUpdateSubjectAttendance.setBounds(146, 11, 258, 37);
		add(lblUpdateSubjectAttendance);
		
		JLabel lblSubjectCode = new JLabel("SUBJECT CODE");
		lblSubjectCode.setBounds(141, 63, 91, 20);
		add(lblSubjectCode);
		
		JLabel lblNewLabel = new JLabel(subc);
		lblNewLabel.setBounds(348, 66, 46, 14);
		add(lblNewLabel);
		
		JLabel lblTotalHours = new JLabel("TOTAL HOURS");
		lblTotalHours.setBounds(141, 98, 91, 14);
		add(lblTotalHours);
		
		JLabel label = new JLabel(new Integer(total).toString());
		label.setBounds(348, 98, 46, 14);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 167, 394, 232);
		add(scrollPane);
		
		final JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(100, 1, 1, 1));
		
		final JButton btnFinish = new JButton("FINISH");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new AttendanceHome(F));
				p.revalidate();
				p.repaint();
			}
		});
		btnFinish.setEnabled(false);
		btnFinish.setBounds(310, 421, 143, 37);
		add(btnFinish);
		
		final JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection con=new MyConnection();
				btnView.setEnabled(false);
				btnFinish.setEnabled(true);
				try 
				{
					
					PreparedStatement stmt=con.getConnection().prepareStatement("select regno from attended where subcode=? and period=?");
					stmt.setString(1, subc);
					stmt.setInt(2, period);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						subPanel1 p=new subPanel1();
						panel.add(p.create(Long.parseLong(rs.getString(1)),subc,period,total));
						panel.revalidate();
						panel.repaint();
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Invalid Details!");
				}
				
			}
		});
		btnView.setBounds(109, 421, 143, 37);
		add(btnView);
		
		

	}

}
