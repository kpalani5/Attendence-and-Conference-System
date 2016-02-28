package attendancePackage;

import guiPackage.MyConnection;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Subjects extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Subjects(final JFrame F) {
		setLayout(null);
		
		JLabel lblSubjects = new JLabel("ADD SUBJECTS");
		lblSubjects.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblSubjects.setBounds(207, 22, 131, 28);
		add(lblSubjects);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 102, 415, 252);
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("SUBJECT CODE");
		panel.add(lblNewLabel, "2, 2");
		
		textField = new JTextField();
		panel.add(textField, "13, 2, 6, 1, fill, default");
		textField.setColumns(10);
		
		JLabel lblSubjectName = new JLabel("SUBJECT NAME");
		panel.add(lblSubjectName, "2, 6");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "13, 6, 6, 1, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblSemester = new JLabel("SEMESTER");
		panel.add(lblSemester, "2, 10");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "13, 10, 6, 1, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblCourse = new JLabel("COURSE");
		panel.add(lblCourse, "2, 14");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "13, 14, 6, 1, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblSubjectType = new JLabel("SUBJECT TYPE");
		panel.add(lblSubjectType, "2, 18");
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MANDATORY", "ELECTIVE"}));
		panel.add(comboBox, "13, 18, 6, 1, fill, default");
		
		JButton btnAddSubject = new JButton("ADD SUBJECT");
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection con=new MyConnection();
				try 
				{
					
					PreparedStatement stmt=con.getConnection().prepareStatement("insert into subjects values(?,?,?,?,?)");
					stmt.setString(1,textField.getText());
					stmt.setString(2,textField_1.getText());
					stmt.setInt(3,Integer.parseInt(textField_2.getText()));
					stmt.setString(4, textField_3.getText());
					if(comboBox.getSelectedIndex()==0)
						stmt.setString(5, "MANDATORY");
					else
						stmt.setString(5, "ELECTIVE");
					stmt.execute();
					Container p=F.getContentPane();
					p.removeAll();
					p.add(new AttendanceHome(F));
					p.revalidate();
					p.repaint();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Invalid Details!");	
				}
			}
		});
		btnAddSubject.setBounds(182, 382, 115, 42);
		add(btnAddSubject);

	}
}
