package attendancePackage;


import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import reportsPackage.AttendanceReportMain;

@SuppressWarnings("serial")
public class AttendanceHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public AttendanceHome(final JFrame F) {
		new AttendanceMenu(F);
		F.revalidate();
		setLayout(null);
		
		JLabel lblDepartmentAttendanceManagement = new JLabel("DEPARTMENT ATTENDANCE MANAGEMENT");
		lblDepartmentAttendanceManagement.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblDepartmentAttendanceManagement.setBounds(100, 11, 415, 73);
		add(lblDepartmentAttendanceManagement);
		
		JPanel panel = new JPanel();
		panel.setBounds(110, 99, 326, 303);
		add(panel);
		panel.setLayout(new GridLayout(7, 1, 1, 10));
		
		
		JButton btnAddStudentDetails = new JButton("ADD STUDENT DETAILS");
		btnAddStudentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new AddStudentPanel(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnAddStudentDetails);
		
		JButton btnAddSubjectDetails = new JButton("ADD SUBJECT DETAILS");
		btnAddSubjectDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new Subjects(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnAddSubjectDetails);
		
		JButton btnUpdateAttendance = new JButton("UPDATE ATTENDANCE");
		btnUpdateAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new attendanceUpdate(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnUpdateAttendance);
		
		JButton btnUpdateMarks = new JButton("UPDATE MARKS");
		btnUpdateMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new marksUpdate(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnUpdateMarks);
		
		JButton btnReports = new JButton("REPORTS");
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new AttendanceReportMain(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnReports);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.setJMenuBar(null);
				F.dispose();
			}
		});
		panel.add(btnNewButton);
		
		

	}
	
	public static void main(String args[])
	{
		JFrame F=new JFrame();
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.setSize(550, 500);
		F.setResizable(false);
		Container pane=F.getContentPane();
		pane.add(new AttendanceHome(F));
	}
}
