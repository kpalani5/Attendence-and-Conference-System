package Users;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RegisterPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("rawtypes")
	public RegisterPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(95, 118, 312, 124);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("STAFF ID");
		label.setBounds(0, 3, 107, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(213, 0, 99, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("STAFF NAME");
		label_1.setBounds(0, 29, 107, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 26, 99, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("PASSWORD");
		label_2.setBounds(0, 55, 107, 14);
		panel.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(213, 52, 99, 20);
		panel.add(passwordField);
		
		JLabel label_3 = new JLabel("CONFIRM PASSWORD");
		label_3.setBounds(0, 81, 107, 14);
		panel.add(label_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(213, 78, 99, 20);
		panel.add(passwordField_1);
		
		JLabel label_4 = new JLabel("USER TYPE");
		label_4.setBounds(0, 107, 107, 14);
		panel.add(label_4);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(213, 104, 99, 20);
		panel.add(comboBox);
		
		JLabel label_5 = new JLabel("REGISTER USER");
		label_5.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		label_5.setBounds(170, 11, 134, 54);
		add(label_5);
		
		JButton button = new JButton("REGISTER");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterUser r=new RegisterUser();
				r.u.setID(textField.getText());
				r.u.setfname(textField_1.getText());
				if(comboBox.getSelectedIndex()==1)
				{
					r.u.setType("LIBRARY");
				}
				else if(comboBox.getSelectedIndex()==2)
				{
					r.u.setType("OFFICE");
				}
				else
				{
					r.u.setType("CPE");
				}
			}
		});
		button.setBounds(202, 333, 110, 31);
		add(button);

	}

}
