package reportsPackage;

import guiPackage.MyConnection;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import attendancePackage.AttendanceHome;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@SuppressWarnings("serial")
public class UtMarksheet extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public UtMarksheet(final JFrame F) {
		setLayout(null);
		
		JLabel lblPeriodwiseAttendance = new JLabel("UT MARKSHEET");
		lblPeriodwiseAttendance.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblPeriodwiseAttendance.setBounds(170, 23, 222, 35);
		add(lblPeriodwiseAttendance);
		
		JPanel panel = new JPanel();
		panel.setBounds(73, 81, 364, 234);
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
		
		JLabel lblSemester = new JLabel("SEMESTER");
		panel.add(lblSemester, "2, 2");
		
		textField = new JTextField();
		panel.add(textField, "13, 2, 4, 1, fill, default");
		textField.setColumns(10);
		
		JLabel lblSection = new JLabel("SECTION    ");
		panel.add(lblSection, "2, 6");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "13, 6, 4, 1, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblPeriod = new JLabel("UNIT TEST NUMBER    ");
		panel.add(lblPeriod, "2, 10");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "13, 10, 4, 1, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblReportFileName = new JLabel("REPORT FILE NAME   ");
		panel.add(lblReportFileName, "2, 14");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "13, 14, 4, 1, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblCourse = new JLabel("COURSE");
		panel.add(lblCourse, "2, 18");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "13, 18, 4, 1, fill, default");
		textField_4.setColumns(10);
		
		final JButton btnGenerate = new JButton("GENERATE");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGenerate.setEnabled(false);
				PreparedStatement stmt1,stmt2;
				ResultSet rs1,rs2;
				int sem=Integer.parseInt(textField.getText());
				String sc=textField_1.getText();
				String crse=textField_4.getText();
				int pd=Integer.parseInt(textField_2.getText());
				MyConnection con=new MyConnection();
				try
				{
					stmt1=con.getConnection().prepareStatement("select count(*) from subjects where semester=? and course=?");
					stmt1.setInt(1,sem);
					stmt1.setString(2, crse);
					rs1=stmt1.executeQuery();
					rs1.next();
					int ct=Integer.parseInt(rs1.getString(1));
					
					//xl
					int rct=0,cct=0;
					HSSFWorkbook workbook = new HSSFWorkbook();
					HSSFSheet sheet = workbook.createSheet("MARKSHEET FOR CSE "+sc+" SEMESTER "+textField.getText()+" UT "+textField_2.getText());
					HSSFRow row = sheet.createRow(rct++);
					cct=0;
					HSSFCell cel1=row.createCell(cct++);
					cel1.setCellValue("MARKSHEET FOR CSE "+sc+" SEMESTER "+textField.getText()+" UT "+textField_2.getText());
					row = sheet.createRow(rct++);
					cct=0;
					
					OutputStream file = new FileOutputStream(new File(textField_3.getText()+".pdf"));
					Document document=new Document();
					PdfWriter.getInstance(document, file);
					document.open();
					document.addTitle("ATTENDANCE FOR PERIOD "+textField_2.getText());
			        Paragraph paragraph = new Paragraph("MARKSHEET FOR CSE "+sc+" SEMESTER "+textField.getText()+" UT "+textField_2.getText());
			       
			        PdfPTable pdfTable = new PdfPTable(ct+1);
			        PdfPCell cell1 = new PdfPCell(new Phrase("REGISTER NUMBER"));
			        pdfTable.addCell(cell1);
			        
			        //xl
			        HSSFCell cell = row.createCell(cct++);
					cell.setCellValue("REGISTER NUMBER");
					
			        stmt1=con.getConnection().prepareStatement("select subcode from subjects where semester=? and course=?");
					stmt1.setInt(1,sem);
					stmt1.setString(2, crse);
					rs1=stmt1.executeQuery();
					while(rs1.next())
					{
						System.out.println(rs1.getString(1));
						pdfTable.addCell(new PdfPCell(new Phrase(rs1.getString(1))));
						
						//xl
						cell = row.createCell(cct++);
						cell.setCellValue(rs1.getString(1));
					}
					//pdfTable.setHeaderRows(1);
					
					//xl
					 row=sheet.createRow(rct++);
					 cct=0;
					 
					stmt1=con.getConnection().prepareStatement("select regno from student where semester=? and section=? and course=?");
					stmt1.setInt(1,sem);
					stmt1.setString(2, sc);
					stmt1.setString(3, crse);
					rs1=stmt1.executeQuery();
					while(rs1.next())
					{
						pdfTable.addCell(new PdfPCell(new Phrase(rs1.getString(1))));
						
						//xl
						cell = row.createCell(cct++);
						cell.setCellValue(rs1.getString(1));
						
						stmt1=con.getConnection().prepareStatement("select subcode from subjects where semester=? and course=?");
						stmt1.setInt(1,sem);
						stmt1.setString(2, crse);
						ResultSet rs3=stmt1.executeQuery();
						while(rs3.next())
						{
						stmt2=con.getConnection().prepareStatement("select subcode,mark from marks where regno=? and test_no=? and subcode=?");
						stmt2.setLong(1, Long.parseLong(rs1.getString(1)));
						stmt2.setInt(2, pd);
						stmt2.setString(3, rs3.getString(1));
						rs2=stmt2.executeQuery();
						int flg=0;
						while(rs2.next())
						{
							//System.out.println(rs2.getString(1));
							pdfTable.addCell(rs2.getString(2));
							
							//xl
							cell = row.createCell(cct++);
							cell.setCellValue(rs2.getString(2));
							
							flg=1;
						}
						if(flg==0)
						{
							pdfTable.addCell("-");
							
							//xl
							cell = row.createCell(cct++);
							cell.setCellValue("-");
						}
						}
						
						//xl
						row=sheet.createRow(rct++);
						 cct=0;
					}
					paragraph.add(pdfTable);
					document.add(paragraph);
					document.close();
					file.close();
					
					//xl
					FileOutputStream out = 
				            new FileOutputStream(new File(textField_3.getText()+".xls"));
				    workbook.write(out);
				    out.close();
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnGenerate.setBounds(84, 348, 126, 35);
		add(btnGenerate);
		
		JButton btnFinish = new JButton("FINISH");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new AttendanceHome(F));
				p.revalidate();
				p.repaint();
			}
		});
		btnFinish.setBounds(277, 348, 126, 35);
		add(btnFinish);

	}
	
	public static void main(String args[])
	{
		JFrame F=new JFrame();
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.setSize(550, 500);
		F.setResizable(false);
		Container pane=F.getContentPane();
		pane.add(new UtMarksheet(F));
		pane.revalidate();
		pane.repaint();
	}

}
