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
public class Organizing extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Organizing(final JFrame F,final long sn) {
		setLayout(null);
		
		JLabel lblOrganizing = new JLabel("ORGANIZING");
		lblOrganizing.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblOrganizing.setBounds(199, 28, 126, 29);
		add(lblOrganizing);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 94, 434, 289);
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
				ColumnSpec.decode("default:grow"),
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblSerialNumber = new JLabel("SERIAL NUMBER");
		panel.add(lblSerialNumber, "2, 2, 1, 2");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(new Long(sn).toString());
		panel.add(textField, "7, 2, 10, 1, fill, default");
		textField.setColumns(10);
		
		JLabel lblConferenceName = new JLabel("EVENT NAME");
		panel.add(lblConferenceName, "2, 4, 1, 2");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "7, 4, 10, 1, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblConferenceDate = new JLabel("EVENT DATE [dd/mm/yyyy]    ");
		panel.add(lblConferenceDate, "2, 6, 1, 2");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "7, 6, 10, 1, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblConferenceDuration = new JLabel("EVENT DURATION     ");
		panel.add(lblConferenceDuration, "2, 8, 1, 2");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "7, 8, 10, 1, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblConferenceType = new JLabel("EVENT TYPE");
		panel.add(lblConferenceType, "2, 10, 1, 2");
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CONFERENCE", "WORKSHOP", "SEMINAR", "VIDEO CONFERENCE (FDS)", "OTHER"}));
		comboBox.setSelectedIndex(1);
		panel.add(comboBox, "7, 10, 10, 1, fill, default");
		
		JLabel lblSponsor = new JLabel("SPONSOR");
		panel.add(lblSponsor, "2, 12, 1, 2");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "7, 12, 10, 1, fill, default");
		textField_4.setColumns(10);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CpeData d=new CpeData();
				d.setSno(sn);
				d.setName(textField_1.getText());
				int chk=d.setDate(textField_2.getText());
				d.setDuration(textField_3.getText());
				d.setType(comboBox.getSelectedIndex());
				d.setSponsor(textField_4.getText());
				if(chk==1)
				{
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new Resource(F,d));
				p.revalidate();
				p.repaint();
				}
			}
		});
		btnNext.setBounds(199, 394, 89, 23);
		add(btnNext);

	}

}
