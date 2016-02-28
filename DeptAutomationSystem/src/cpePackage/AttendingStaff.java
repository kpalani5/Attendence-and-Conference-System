package cpePackage;

import guiPackage.MyConnection;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class subPanel
{
	JPanel p1;
	JLabel l1;
	JTextField t1,t2;
	JButton b1;
	
	JPanel create(final CpeData d)
	{
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,3,3,3));
		t1=new JTextField(6);
		t2=new JTextField(6);
		b1=new JButton("ADD");
		p1.add(t1);
		p1.add(t2);
		p1.add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(false);
				t1.setEditable(false);
				t2.setEditable(false);
				MyConnection con=new MyConnection();
				try 
				{
					
					PreparedStatement stmt=con.getConnection().prepareStatement("insert into attending values (?,?,?,?,?,?,?,?,?,?,?)");
					stmt.setLong(1, d.getSno());
					stmt.setString(2, d.getName());
					stmt.setString(3, d.getDate());
					stmt.setString(4, d.getType());
					stmt.setString(5, d.getDuration());
					stmt.setString(6, d.getSponsor());
					stmt.setString(7, d.getPayment());
					stmt.setString(8, t2.getText());
					stmt.setString(9, t1.getText());
					stmt.setString(10, d.getInst());
					stmt.setString(11, d.getPlace());
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
public class AttendingStaff extends JPanel {

	/**
	 * Create the panel.
	 */
	public AttendingStaff(final JFrame F,final CpeData d) {
		setLayout(null);
		
		JLabel lblAttendingStaff = new JLabel("ATTENDING STAFF");
		lblAttendingStaff.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblAttendingStaff.setBounds(199, 22, 196, 29);
		add(lblAttendingStaff);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 86, 389, 225);
		add(scrollPane);
		
		final JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(20, 1, 1, 3));
		
		final JButton btnNewButton = new JButton("FINISH");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeHome(F));
				p.revalidate();
				p.repaint();
			}
		});
		btnNewButton.setBounds(279, 386, 149, 29);
		add(btnNewButton);
		
		final JButton btnAddStaff = new JButton("ADD STAFF");
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddStaff.setText("ADD ANOTHER STAFF");
				btnNewButton.setEnabled(true);
				panel.add(new subPanel().create(d));
				panel.revalidate();
				panel.repaint();
			}
		});
		btnAddStaff.setBounds(86, 386, 135, 29);
		add(btnAddStaff);
		
		
		
		JLabel lblStaffId = new JLabel("STAFF ID");
		lblStaffId.setBounds(130, 62, 67, 14);
		add(lblStaffId);
		
		JLabel lblStaffName = new JLabel("STAFF NAME");
		lblStaffName.setBounds(279, 62, 78, 14);
		add(lblStaffName);

	}

}
