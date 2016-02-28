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

import attendancePackage.AttendanceHome;

@SuppressWarnings("serial")
public class AttendanceReportMain extends JPanel {

	/**
	 * Create the panel.
	 */
	public AttendanceReportMain(final JFrame F) {
		setLayout(null);
		
		JLabel lblReportGeneration = new JLabel("REPORT GENERATION");
		lblReportGeneration.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblReportGeneration.setBounds(200, 23, 202, 25);
		add(lblReportGeneration);
		
		JPanel panel = new JPanel();
		panel.setBounds(84, 69, 365, 292);
		add(panel);
		panel.setLayout(new GridLayout(6, 1, 3, 5));
		
		JButton btnPeriodwiseAttendance = new JButton("PERIODWISE ATTENDANCE");
		btnPeriodwiseAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new PeriodwiseAttendance(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnPeriodwiseAttendance);
		
		JButton btnSubjectwiseAttendance = new JButton("SUBJECTWISE ATTENDANCE");
		btnSubjectwiseAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new SubjectwiseAttendance(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnSubjectwiseAttendance);
		
		JButton btnCumulativeAttendance = new JButton("CUMULATIVE ATTENDANCE");
		btnCumulativeAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CumulativeAttendance(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnCumulativeAttendance);
		
		JButton btnUnitTestMarksheet = new JButton("UNIT TEST MARKSHEET");
		btnUnitTestMarksheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new UtMarksheet(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnUnitTestMarksheet);
		
		JButton btnOverallMarksheet = new JButton("SUBJECTWISE MARKSHEET");
		btnOverallMarksheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new SubjectMarksheet(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnOverallMarksheet);
		
		JButton btnMainMenu = new JButton("MAIN MENU");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new AttendanceHome(F));
				p.revalidate();
				p.repaint();
			}
		});
		panel.add(btnMainMenu);

	}

}
