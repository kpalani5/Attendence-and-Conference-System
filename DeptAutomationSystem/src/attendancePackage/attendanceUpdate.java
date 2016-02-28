package attendancePackage;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class attendanceUpdate extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public attendanceUpdate(final JFrame F) {
		setLayout(null);
		
		JLabel lblUpdateAttendance = new JLabel("UPDATE ATTENDANCE");
		lblUpdateAttendance.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblUpdateAttendance.setBounds(188, 11, 202, 40);
		add(lblUpdateAttendance);
		
		JPanel panel = new JPanel();
		panel.setBounds(78, 108, 395, 279);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER REGISTRATION NUMBER");
		lblNewLabel.setBounds(6, 6, 185, 14);
		panel.add(lblNewLabel);
		
		JButton btnByStudent = new JButton("BY STUDENT");
		btnByStudent.setBounds(139, 83, 133, 23);
		panel.add(btnByStudent);
		
		textField = new JTextField();
		textField.setBounds(201, 3, 142, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterSubjectCode = new JLabel("ENTER SUBJECT CODE");
		lblEnterSubjectCode.setBounds(6, 133, 154, 14);
		panel.add(lblEnterSubjectCode);
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 129, 142, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBySubject = new JButton("BY SUBJECT");
	
		btnBySubject.setBounds(139, 233, 133, 23);
		panel.add(btnBySubject);
		
		JLabel lblPeriod = new JLabel("PERIOD");
		lblPeriod.setBounds(6, 42, 46, 14);
		panel.add(lblPeriod);
		
		textField_2 = new JTextField();
		textField_2.setBounds(201, 37, 142, 23);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPeriod_1 = new JLabel("PERIOD");
		lblPeriod_1.setBounds(6, 206, 60, 14);
		panel.add(lblPeriod_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(201, 202, 142, 23);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTotalHours = new JLabel("TOTAL HOURS");
		lblTotalHours.setBounds(6, 167, 108, 14);
		panel.add(lblTotalHours);
		
		textField_4 = new JTextField();
		textField_4.setBounds(201, 163, 142, 23);
		panel.add(textField_4);
		textField_4.setColumns(10);
		btnByStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new StudentAttendance(F,Long.parseLong(textField.getText()),Integer.parseInt(textField_2.getText())));
				p.revalidate();
				p.repaint();
			}
		});
		
		btnBySubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new SubjectAttendance(F,textField_1.getText(),Integer.parseInt(textField_4.getText()),Integer.parseInt(textField_3.getText())));
				p.revalidate();
				p.repaint();
			}
		});

	}

}
