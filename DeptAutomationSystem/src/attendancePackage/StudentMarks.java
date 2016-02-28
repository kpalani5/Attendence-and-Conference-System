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

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

class subPanel3
{
	JPanel p1;
	JLabel l1;
	JTextField t1,t2;
	JButton b1;
	
	JPanel create(final long reg,final String subc,final int test)
	{
		p1=new JPanel();
		p1.setLayout(new FlowLayout());
		l1=new JLabel(subc);
		t1=new JTextField(6);
		t2=new JTextField(6);
		b1=new JButton("UPDATE");
		p1.add(l1);
		p1.add(t1);
		p1.add(new JLabel("/"));
		p1.add(t2);
		t2.setText("100");
		t2.setEditable(false);
		p1.add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(false);
				t1.setEditable(false);
				MyConnection con=new MyConnection();
				try 
				{
					
					PreparedStatement stmt=con.getConnection().prepareStatement("update marks set mark=? where regno=? and subcode=? and test_no=?");
					stmt.setInt(1, Integer.parseInt(t1.getText()));
					stmt.setLong(2, reg);
					stmt.setString(3, subc);
					stmt.setInt(4, test);
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
public class StudentMarks extends JPanel {

	/**
	 * Create the panel.
	 */
	public StudentMarks(final JFrame F,final long reg,final int test) {
		setLayout(null);
		
		JLabel lblStudentMarksUpdate = new JLabel("STUDENT MARKS UPDATE");
		lblStudentMarksUpdate.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblStudentMarksUpdate.setBounds(149, 11, 257, 35);
		add(lblStudentMarksUpdate);
		
		JPanel panel = new JPanel();
		panel.setBounds(113, 64, 324, 117);
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
				FormFactory.DEFAULT_COLSPEC,},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		Student a=new Student();
		a=a.retrieve(reg);
		
		JLabel lblRegisterNumber = new JLabel("REGISTER NUMBER");
		panel.add(lblRegisterNumber, "2, 2");
		
		JLabel lblNewLabel = new JLabel(new Long(reg).toString());
		panel.add(lblNewLabel, "16, 2");
		
		JLabel lblCourse = new JLabel("COURSE");
		panel.add(lblCourse, "2, 4");
		
		JLabel label = new JLabel(a.getCourse());
		panel.add(label, "16, 4");
		
		JLabel lblYear = new JLabel("SEMESTER");
		panel.add(lblYear, "2, 6");
		
		JLabel label_1 = new JLabel(new Integer(a.getsem()).toString());
		panel.add(label_1, "16, 6");
		
		JLabel lblSection = new JLabel("SECTION");
		panel.add(lblSection, "2, 8");
		
		JLabel label_2 = new JLabel(a.getSection());
		panel.add(label_2, "16, 8");
		
		JLabel lblName = new JLabel("NAME");
		panel.add(lblName, "2, 10");
		
		JLabel lblNewLabel_1 = new JLabel(a.getfname()+" "+a.getlname());
		panel.add(lblNewLabel_1, "16, 10");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 211, 409, 176);
		add(scrollPane);
		
		final JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(20, 1, 1, 1));
		
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
		btnFinish.setBounds(290, 418, 147, 40);
		add(btnFinish);
		
		final JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyConnection con=new MyConnection();
				try 
				{
					btnView.setEnabled(false);
					btnFinish.setEnabled(true);
					PreparedStatement stmt=con.getConnection().prepareStatement("select subcode from marks where regno=? and test_no=?");
					stmt.setLong(1, reg);
					stmt.setInt(2, test);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						panel_1.add(new subPanel3().create(reg,rs.getString(1),test));
						panel_1.revalidate();
						panel_1.repaint();
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Invalid Details!");
				}
				
			}
		});
		btnView.setBounds(70, 418, 143, 40);
		add(btnView);
		
		
		
	
		
		

	}
	
	


}
