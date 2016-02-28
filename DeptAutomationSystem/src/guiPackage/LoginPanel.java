package guiPackage;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import attendancePackage.AttendanceMenu;
import cpePackage.CpeMenu;

@SuppressWarnings({ "serial"})
public class LoginPanel extends JPanel {
	private JTextField userName;
	private JPasswordField password;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblDepartmentAutomationSystem;

	/**
	 * Create the panel.
	 */
	public LoginPanel(final JFrame F) {
				
						JButton btnLogin = new JButton("LOGIN");
						btnLogin.setBounds(219, 279, 97, 34);
						btnLogin.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									MyConnection connection = new MyConnection();
											
									PreparedStatement preparedStatement = connection.getConnection().prepareStatement("select * from validation where userName=?");
									preparedStatement.setString(1, userName.getText().trim());
									ResultSet resultSet = preparedStatement.executeQuery();
									String pw = new String(password.getPassword());
									if (resultSet.next()) {
										if (pw.equals(resultSet.getString(2))) {
											String s = resultSet.getString(3);
											switch (s) {
											case "1":
												Switcher.changePanel("libraryMainPanel");
												break;
											case "2":
												Switcher.changePanel("attendanceMainPanel");
												new AttendanceMenu(F);
												break;
											case "3":
												Switcher.changePanel("consumablesMainPanel");
												break;
											case "4":
												Switcher.changePanel("conferenceMainPanel");
												new CpeMenu(F);
												break;
											}

										}

									} else {
										System.out.println("Error");
									}

								} 
								catch(Exception e1)
								{
									
								}
							}

						});
												setLayout(null);
										
												lblDepartmentAutomationSystem = new JLabel(
														"DEPARTMENT AUTOMATION SYSTEM");
												lblDepartmentAutomationSystem.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
												lblDepartmentAutomationSystem.setBounds(114, 60, 305, 27);
												add(lblDepartmentAutomationSystem);
								
										lblNewLabel = new JLabel("User Name");
										lblNewLabel.setBounds(114, 142, 83, 14);
										add(lblNewLabel);
								
										userName = new JTextField();
										userName.setBounds(329, 139, 90, 20);
										add(userName);
										userName.setColumns(10);
						
								lblNewLabel_1 = new JLabel("Password");
								lblNewLabel_1.setBounds(117, 197, 97, 14);
								add(lblNewLabel_1);
						
								password = new JPasswordField();
								password.setBounds(329, 194, 90, 20);
								add(password);
						add(btnLogin);

	}

}
