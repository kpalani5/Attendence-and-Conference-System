package cpePackage;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
public class Attending extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Attending(final JFrame F,final long sn) {
		setLayout(null);
		
		JLabel lblAttending = new JLabel("ATTENDING");
		lblAttending.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblAttending.setBounds(199, 11, 150, 27);
		add(lblAttending);
		
		JPanel panel = new JPanel();
		panel.setBounds(70, 62, 423, 271);
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblSerialNumber = new JLabel("SERIAL NUMBER");
		panel.add(lblSerialNumber, "2, 2, 1, 2");
		
		textField = new JTextField();
		textField.setText(new Long(sn).toString());
		textField.setEditable(false);
		panel.add(textField, "10, 2, fill, default");
		textField.setColumns(10);
		
		JLabel lblConferenceName = new JLabel("EVENT NAME   ");
		panel.add(lblConferenceName, "2, 4, 1, 2");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "10, 4, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblConferenceDate = new JLabel("EVENT DATE [dd/mm/yyyy]");
		panel.add(lblConferenceDate, "2, 6, 1, 2");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "10, 6, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("EVENT DURATION    ");
		panel.add(lblNewLabel, "2, 8, 1, 2");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "10, 8, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblInstitution = new JLabel("INSTITUTION");
		panel.add(lblInstitution, "2, 10, 1, 2");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "10, 10, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblPlace = new JLabel("PLACE");
		panel.add(lblPlace, "2, 12, 1, 2");
		
		textField_5 = new JTextField();
		panel.add(textField_5, "10, 12, fill, default");
		textField_5.setColumns(10);
		
		JLabel lblConferenceType = new JLabel("EVENT TYPE");
		panel.add(lblConferenceType, "2, 14, 1, 2");
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CONFERENCE", "WORKSHOP", "SEMINAR", "VIDEO CONFERENCE (FDS)", "OTHERS"}));
		comboBox.setSelectedIndex(1);
		panel.add(comboBox, "10, 14, fill, default");
		
		JLabel lblSponsor = new JLabel("SPONSOR");
		panel.add(lblSponsor, "2, 16, 1, 2");
		
		textField_6 = new JTextField();
		panel.add(textField_6, "10, 16, fill, default");
		textField_6.setColumns(10);
		
		JLabel lblPayment = new JLabel("PAYMENT");
		panel.add(lblPayment, "2, 18");
		
		textField_7 = new JTextField();
		panel.add(textField_7, "10, 18, fill, default");
		textField_7.setColumns(10);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CpeData d=new CpeData();
				d.setSno(sn);
				d.setName(textField_1.getText());
				int chk=d.setDate(textField_2.getText());
				d.setDuration(textField_3.getText());
				d.setInst(textField_4.getText());
				d.setPlace(textField_5.getText());
				d.setSponsor(textField_6.getText());
				d.setPayment(textField_7.getText());
				d.setType(comboBox.getSelectedIndex());
				if(chk==1)
				{
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new AttendingStaff(F,d));
				p.revalidate();
				p.repaint();
				}
			}
		});
		btnNext.setBounds(199, 382, 89, 23);
		add(btnNext);

	}
}
