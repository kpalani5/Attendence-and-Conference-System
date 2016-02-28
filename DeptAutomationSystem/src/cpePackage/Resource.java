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



@SuppressWarnings("unused")
class subPanelr
{
	JPanel p1;
	JLabel l1;
	JTextField t1;
	JButton b1;
	
	JPanel create(final CpeData d,final int ct)
	{
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,2,3,3));
		t1=new JTextField(12);
		b1=new JButton("ADD");
		p1.add(t1);
		p1.add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(false);
				t1.setEditable(false);
				d.setResource(t1.getText(), ct);
			}
		});
		p1.setVisible(true);
		return p1;
	}
}

@SuppressWarnings("serial")
public class Resource extends JPanel {

	/**
	 * Create the panel.
	 */
	int ct;
	public Resource(final JFrame F,final CpeData d) {
		ct=0;
		
		setLayout(null);
		
		JLabel lblAttendingStaff = new JLabel("RESOURCE PERSONS");
		lblAttendingStaff.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblAttendingStaff.setBounds(199, 22, 196, 29);
		add(lblAttendingStaff);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 86, 389, 225);
		add(scrollPane);
		
		final JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(20, 1, 1, 3));
		
		final JButton btnNewButton = new JButton("NEXT");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new Participants(F,d,ct));
				p.revalidate();
				p.repaint();
			}
		});
		btnNewButton.setBounds(279, 386, 149, 29);
		add(btnNewButton);
		
		final JButton btnAddStaff = new JButton("ADD RESOURCE PERSON");
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(true);
				panel.add(new subPanelr().create(d,ct));
				panel.revalidate();
				panel.repaint();
				ct++;
			}
		});
		btnAddStaff.setBounds(86, 386, 135, 29);
		add(btnAddStaff);
		
		
		
		JLabel lblStaffId = new JLabel("STAFF ID");
		lblStaffId.setBounds(130, 62, 67, 14);
		add(lblStaffId);
		

	}

}
