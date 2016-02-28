package attendancePackage;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import reportsPackage.AttendanceReportMain;
import reportsPackage.CumulativeAttendance;
import reportsPackage.PeriodwiseAttendance;
import reportsPackage.SubjectMarksheet;
import reportsPackage.SubjectwiseAttendance;
import reportsPackage.UtMarksheet;

public class AttendanceMenu {
	JMenuBar M;
	JMenu home,rep,quit;
	JMenuItem h1,h2,h3,h4,h5,h6;
	JMenuItem r1,r2,r3,r4,r5;
	JMenuItem q1;
	public AttendanceMenu(final JFrame F)
	{
		M=new JMenuBar();
		home=new JMenu("HOME");
		rep=new JMenu("REPORTS");
		quit=new JMenu("QUIT");
		h1=new JMenuItem("Add Subject");
		h1.setIcon(new ImageIcon("images/SubjectIcon.jpg"));
		h2=new JMenuItem("Add Student");
		h2.setIcon(new ImageIcon("images/StudentIcon.png"));
		h3=new JMenuItem("Update Attendance");
		h3.setIcon(new ImageIcon("images/AttendanceIcon.jpg"));
		h4=new JMenuItem("Update Marks");
		h4.setIcon(new ImageIcon("images/MarksheetIcon.png"));
		h5=new JMenuItem("Reports Home");
		h5.setIcon(new ImageIcon("images/ReportIcon.png"));
		h6=new JMenuItem("Attendance Home");
		h6.setIcon(new ImageIcon("images/HomeIcon.png"));
		r1=new JMenuItem("Subjectwise Attendance");
		r2=new JMenuItem("Periodwise Attendance");
		r3=new JMenuItem("Cumulative Attendance");
		r4=new JMenuItem("Unit Test Marksheet");
		r5=new JMenuItem("Subjectwise Marksheet");
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
		home.add(h6);
		
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
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new Subjects(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		h2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new AddStudentPanel(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		h3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new attendanceUpdate(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		h4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new marksUpdate(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		h5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new AttendanceReportMain(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		h6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new AttendanceHome(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new SubjectwiseAttendance(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new PeriodwiseAttendance(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		r3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CumulativeAttendance(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		r4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new UtMarksheet(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		r5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new SubjectMarksheet(F));
				p.revalidate();
				p.repaint();
			}
		});
		
		q1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.setJMenuBar(null);
				F.dispose();
			}
		});
	}
}
