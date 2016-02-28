package attendancePackage;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
public class AddStudentPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public AddStudentPanel(final JFrame F) {
		setLayout(null);
		
		JLabel lblAddStudent = new JLabel("ADD STUDENT");
		lblAddStudent.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblAddStudent.setBounds(202, 11, 148, 44);
		add(lblAddStudent);
		
		JPanel panel = new JPanel();
		panel.setBounds(109, 139, 331, 164);
		add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblRegistrationNumber = new JLabel("REGISTRATION NUMBER");
		panel.add(lblRegistrationNumber, "2, 2");
		
		textField = new JTextField();
		panel.add(textField, "8, 2, fill, default");
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("FIRST NAME");
		panel.add(lblName, "2, 4");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "8, 4, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblName2 = new JLabel("LAST NAME");
		panel.add(lblName2, "2, 6");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "8, 6, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblCourse = new JLabel("COURSE");
		panel.add(lblCourse, "2, 8");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "8, 8, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblsem = new JLabel("SEMESTER");
		panel.add(lblsem, "2, 10");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "8, 10, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblSection = new JLabel("SECTION");
		panel.add(lblSection, "2, 12");
		
		textField_5 = new JTextField();
		panel.add(textField_5, "8, 12, fill, default");
		textField_5.setColumns(10);
		
		JButton btnAddStudent = new JButton("NEXT");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Student s=new Student();
				s.setRegno(Long.parseLong(textField.getText()));
				s.setfname(textField_1.getText());
				s.setlname(textField_2.getText());
				s.setCourse(textField_3.getText());
				s.setsem(Integer.parseInt(textField_4.getText()));
				s.setSection(textField_5.getText());
				s.addNew();
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new StudentSubjects(F,Long.parseLong(textField.getText()),Integer.parseInt(textField_4.getText()),textField_3.getText()));
				p.revalidate();
				p.repaint();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Invalid Details");
					//e1.printStackTrace();
				}
			}
		});
		btnAddStudent.setBounds(203, 348, 101, 23);
		add(btnAddStudent);

	}
	
	/*public static void main(String args[])
	{
		JFrame F=new JFrame();
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.add(new AddStudentPanel());
	}*/
}
