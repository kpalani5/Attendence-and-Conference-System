package cpePackage;

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

@SuppressWarnings("serial")
public class Participants extends JPanel {
	private JTextField[] textField;
	JLabel[] lbl;

	/**
	 * Create the panel.
	 */
	public Participants(final JFrame F,final CpeData d,final int ct) {
		setLayout(null);
		
		JLabel lblParticipants = new JLabel("PARTICIPANTS");
		lblParticipants.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblParticipants.setBounds(199, 24, 142, 20);
		add(lblParticipants);
		
		JPanel panel = new JPanel();
		panel.setBounds(74, 80, 387, 313);
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
		
		lbl=new JLabel[5];
		
		lbl[0] = new JLabel("UG STUDENTS");
		panel.add(lbl[0], "2, 2");
		
		textField=new JTextField[5];
		
		textField[0] = new JTextField();
		textField[0].setText("0");
		panel.add(textField[0], "14, 2, fill, default");
		textField[0].setColumns(10);
		
		lbl[1] = new JLabel("PG STUDENTS");
		panel.add(lbl[1], "2, 6");
		
		textField[1] = new JTextField();
		textField[1].setText("0");
		panel.add(textField[1], "14, 6, fill, default");
		textField[1].setColumns(10);
		
		lbl[2] = new JLabel("STAFF");
		panel.add(lbl[2], "2, 10");
		
		textField[2] = new JTextField();
		textField[2].setText("0");
		panel.add(textField[2], "14, 10, fill, default");
		textField[2].setColumns(10);
		
		lbl[3] = new JLabel("RESEARCH SCHOLARS");
		panel.add(lbl[3], "2, 14");
		
		textField[3] = new JTextField();
		textField[3].setText("0");
		panel.add(textField[3], "14, 14, fill, default");
		textField[3].setColumns(10);
		
		lbl[4] = new JLabel("OTHERS");
		panel.add(lbl[4], "2, 18");
		
		textField[4] = new JTextField();
		textField[4].setText("0");
		panel.add(textField[4], "14, 18, fill, default");
		textField[4].setColumns(10);
		
		JLabel lblCount = new JLabel("COUNT");
		lblCount.setBounds(376, 52, 57, 14);
		add(lblCount);
		
		JButton btnFinish = new JButton("FINISH");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection con=new MyConnection();
				try
				{
					PreparedStatement stmt=con.getConnection().prepareStatement("insert into organize values (?,?,?,?,?,?)");
					stmt.setLong(1, d.getSno());
					stmt.setString(2, d.getName());
					stmt.setString(3, d.getDate());
					stmt.setString(4, d.getType());
					stmt.setString(5, d.getDuration());
					stmt.setString(6, d.getSponsor());
					stmt.execute();
					
					int j;
					for(j=0;j<ct;j++)
					{
					stmt=con.getConnection().prepareStatement("insert into resource values (?,?)");
					stmt.setLong(1, d.getSno());
					stmt.setString(2, d.getResource(j));
					stmt.execute();
					}
					
					int k;
					for(k=0;k<=4;k++)
					{
						if(!textField[k].getText().equals("0"))
						{
							stmt=con.getConnection().prepareStatement("insert into participants values (?,?,?)");
							stmt.setLong(1, d.getSno());
							stmt.setString(2, lbl[k].getText());
							stmt.setInt(3, Integer.parseInt(textField[k].getText()));
							stmt.execute();
						}
					}
					Container p=F.getContentPane();
					p.removeAll();
					p.add(new CpeHome(F));
					p.revalidate();
					p.repaint();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Invalid Details!");
				}
			}
		});
		btnFinish.setBounds(199, 404, 89, 23);
		add(btnFinish);

	}
	
	/*public static void main(String args[])
	{
		JFrame F=new JFrame();
		CpeData d=new CpeData();
		Participants p=new Participants(F,d);
		F.add(p);
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/

}
