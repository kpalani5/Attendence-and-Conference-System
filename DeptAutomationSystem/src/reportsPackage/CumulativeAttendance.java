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
public class CumulativeAttendance extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public CumulativeAttendance(final JFrame F) {
		setLayout(null);
		
		JLabel lblPeriodwiseAttendance = new JLabel("CUMULATIVE ATTENDANCE");
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
		
		JLabel lblPeriod = new JLabel("SUBJECT CODE");
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
				String scode=textField_2.getText();
				String crse=textField_4.getText();
				MyConnection con=new MyConnection();
				try
				{
					int rct=0,cct=0;
					HSSFWorkbook workbook = new HSSFWorkbook();
					HSSFSheet sheet = workbook.createSheet("ATTENDANCE FOR CSE "+sc+" SEMESTER "+textField.getText()+" SUBJECT "+textField_2.getText());
					HSSFRow row = sheet.createRow(rct++);
					cct=0;
					HSSFCell cel1=row.createCell(cct++);
					cel1.setCellValue("ATTENDANCE FOR CSE "+sc+" SEMESTER "+textField.getText()+" SUBJECT "+textField_2.getText());
					row = sheet.createRow(rct++);
					cct=0;
					
					OutputStream file = new FileOutputStream(new File(textField_3.getText()+".pdf"));
					Document document=new Document();
					PdfWriter.getInstance(document, file);
					document.open();
					document.addTitle("ATTENDANCE FOR PERIOD "+textField_2.getText());
			        Paragraph paragraph = new Paragraph("ATTENDANCE FOR CSE "+sc+" SEMESTER "+textField.getText()+" SUBJECT "+textField_2.getText());
			       
			        PdfPTable pdfTable = new PdfPTable(5);
			        PdfPCell cell1 = new PdfPCell(new Phrase("REGISTER NUMBER"));
			        pdfTable.addCell(cell1);
			        
			        HSSFCell cell = row.createCell(cct++);
					cell.setCellValue("REGISTER NUMBER");
			        
			        pdfTable.addCell(new PdfPCell(new Phrase("P1")));
			        pdfTable.addCell(new PdfPCell(new Phrase("P1+P2")));
			        pdfTable.addCell(new PdfPCell(new Phrase("P1+P2+P3")));
			        pdfTable.addCell(new PdfPCell(new Phrase("P1+P2+P3+P4")));
			        
			        cell = row.createCell(cct++);
					cell.setCellValue("P1");
					cell = row.createCell(cct++);
					cell.setCellValue("P1+P2");
					cell = row.createCell(cct++);
					cell.setCellValue("P1+P2+P3");
					cell = row.createCell(cct++);
					cell.setCellValue("P1+P2+P3+P4");
					
					//pdfTable.setHeaderRows(1);
					row=sheet.createRow(rct++);
					 cct=0;
					 
					
					 stmt1=con.getConnection().prepareStatement("select distinct student.regno from student,attended where semester=? and section=? and course=? and attended.subcode=? and student.regno=attended.regno");
						stmt1.setInt(1,sem);
						stmt1.setString(2, sc);
						stmt1.setString(3, crse);
						stmt1.setString(4, textField_2.getText());
					rs1=stmt1.executeQuery();
					while(rs1.next())
					{
						pdfTable.addCell(new PdfPCell(new Phrase(rs1.getString(1))));
						
						cell = row.createCell(cct++);
						cell.setCellValue(rs1.getString(1));
						
						stmt2=con.getConnection().prepareStatement("select period,hours_attended,total_hours from attended where regno=? and subcode=?");
						stmt2.setLong(1, Long.parseLong(rs1.getString(1)));
						stmt2.setString(2, scode);
						rs2=stmt2.executeQuery();
						int t1=0,t2=0;
						while(rs2.next())
						{
							t1=t1+Integer.parseInt(rs2.getString(2));
							t2=t2+Integer.parseInt(rs2.getString(3));
							pdfTable.addCell(new Integer(t1).toString()+" / "+new Integer(t2).toString());
							
							cell = row.createCell(cct++);
							cell.setCellValue(new Integer(t1).toString()+" / "+new Integer(t2).toString());
						}
						
						row=sheet.createRow(rct++);
						 cct=0;
					}
					paragraph.add(pdfTable);
					document.add(paragraph);
					document.close();
					file.close();
					
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
		pane.add(new CumulativeAttendance(F));
		pane.revalidate();
		pane.repaint();
	}

}
