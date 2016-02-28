package reportsPackage;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cpePackage.CpeHome;

@SuppressWarnings("serial")
public class CpeReportMain extends JPanel {

	/**
	 * Create the panel.
	 */
	public CpeReportMain(final JFrame F) {
		setLayout(null);
		
		JLabel lblReportGeneration = new JLabel("REPORT GENERATION");
		lblReportGeneration.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblReportGeneration.setBounds(200, 23, 202, 25);
		add(lblReportGeneration);
		
		JPanel panel = new JPanel();
		panel.setBounds(84, 69, 365, 292);
		add(panel);
		panel.setLayout(new GridLayout(6, 1, 3, 5));
		
		JButton btnOStaff = new JButton("ORGANIZED EVENTS - STAFF");
		btnOStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeReports(F,1));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnOStaff);
		
		JButton btnOStudent = new JButton("ORGANIZED EVENTS - STUDENTS");
		btnOStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeReports(F,2));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnOStudent);
		
		JButton btnOAll = new JButton("ORGANIZED EVENTS - ALL");
		btnOAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeReports(F,3));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnOAll);
		
		JButton btnAtStaff = new JButton("ATTENDED EVENTS - STAFF");
		btnAtStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeStaffReports(F,1));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnAtStaff);
		
		JButton btnLecStaff = new JButton("GUEST LECTURES - STAFF");
		btnLecStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeStaffReports(F,2));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnLecStaff);
		
		JButton btnMainMenu = new JButton("MAIN MENU");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeHome(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnMainMenu);

	}

}
