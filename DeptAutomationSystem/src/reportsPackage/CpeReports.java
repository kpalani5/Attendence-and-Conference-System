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

import cpePackage.CpeData;
import cpePackage.CpeHome;

@SuppressWarnings("serial")
public class CpeReports extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public CpeReports(final JFrame F,final int ch) {
		setLayout(null);
		
		JLabel lblOrganizedEvents = new JLabel();
		switch(ch)
		{
		case 1:lblOrganizedEvents.setText("ORGANIZED EVENTS - STAFF");break;
		case 2:lblOrganizedEvents.setText("ORGANIZED EVENTS - STUDENTS");break;
		case 3:lblOrganizedEvents.setText("ORGANIZED EVENTS - ALL");break;
		}
		lblOrganizedEvents.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblOrganizedEvents.setBounds(150, 27, 284, 49);
		add(lblOrganizedEvents);
		
		JPanel panel = new JPanel();
		panel.setBounds(106, 107, 345, 198);
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
		
		JLabel lblStartDate = new JLabel("START DATE [dd/mm/yyyy]   ");
		panel.add(lblStartDate, "2, 2");
		
		textField = new JTextField();
		panel.add(textField, "12, 2, fill, default");
		textField.setColumns(10);
		
		JLabel lblEndDate = new JLabel("END DATE [dd/mm/yyyy]");
		panel.add(lblEndDate, "2, 8");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "12, 8, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblReportFileName = new JLabel("REPORT FILE NAME");
		panel.add(lblReportFileName, "2, 14");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "12, 14, fill, default");
		textField_2.setColumns(10);
		
		final JButton btnGenerate = new JButton("GENERATE");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGenerate.setEnabled(false);
				CpeData d=new CpeData();
				d.setDate(textField.getText());
				String start=d.getDate();
				d.setDate(textField_1.getText());
				String end=d.getDate();
				if(ch<=3)
				{
					MyConnection con=new MyConnection();
					
					try
					{
						int rct=0,cct=0;
						HSSFWorkbook workbook = new HSSFWorkbook();
						HSSFSheet sheet = workbook.createSheet("REPORT FOR EVENTS ORGANIZED");
						HSSFRow row = sheet.createRow(rct++);
						cct=0;
						HSSFCell cell = row.createCell(cct++);
						cell.setCellValue("REPORT FOR EVENTS ORGANIZED BETWEEN "+textField.getText()+" AND "+ textField_1.getText());
						
						row = sheet.createRow(rct++);
						cct=0;
						
						OutputStream file = new FileOutputStream(new File(textField_2.getText()+".pdf"));
						Document document=new Document();
						PdfWriter.getInstance(document, file);
						document.open();
						document.addTitle("ATTENDANCE FOR PERIOD "+textField_2.getText());
				        Paragraph paragraph = new Paragraph("REPORT FOR EVENTS ORGANIZED BETWEEN "+textField.getText()+" AND "+ textField_1.getText());
				      
				        PdfPTable pdfTable = new PdfPTable(8);
				        if(ch==3) pdfTable = new PdfPTable(7);
				        PdfPCell cell1 = new PdfPCell(new Phrase("EVENT NUMBER"));
				        pdfTable.addCell(cell1);
				        pdfTable.addCell(new PdfPCell(new Phrase("TITLE")));
				        pdfTable.addCell(new PdfPCell(new Phrase("DATE")));
				        pdfTable.addCell(new PdfPCell(new Phrase("TYPE")));
				        pdfTable.addCell(new PdfPCell(new Phrase("DURATION")));
				        pdfTable.addCell(new PdfPCell(new Phrase("SPONSOR")));
				        pdfTable.addCell(new PdfPCell(new Phrase("RESOURCE PERSONS")));
				        if(ch==1) pdfTable.addCell(new PdfPCell(new Phrase("NUMBER OF STAFF")));
				        if(ch==2) pdfTable.addCell(new PdfPCell(new Phrase("NUMBER OF STUDENTS")));
				        
				        cell = row.createCell(cct++);
						cell.setCellValue("EVENT NUMBER");
						cell = row.createCell(cct++);
						cell.setCellValue("TITLE");
						cell = row.createCell(cct++);
						cell.setCellValue("DATE");
						cell = row.createCell(cct++);
						cell.setCellValue("TYPE");
						cell = row.createCell(cct++);
						cell.setCellValue("DURATION");
						cell = row.createCell(cct++);
						cell.setCellValue("SPONSOR");
						cell = row.createCell(cct++);
						cell.setCellValue("RESOURCE PERSONS");
						cell = row.createCell(cct++);
						if(ch==1) cell.setCellValue("NUMBER OF STAFF");
						if(ch==2) cell.setCellValue("NUMBER OF STUDENTS");
				        
						row=sheet.createRow(rct++);
						 cct=0;
						
				        try
						{    
						PreparedStatement stmt1,stmt2;
						ResultSet rs1,rs2;
						stmt1=con.getConnection().prepareStatement("select * from organize where eventDate>=? and eventDate<=?");
						stmt1.setString(1,start);
						stmt1.setString(2,end);
						rs1=stmt1.executeQuery();
						while(rs1.next())
						{
							if(ch==3)
							{
								pdfTable.addCell(rs1.getString(1));
								pdfTable.addCell(rs1.getString(2));
								pdfTable.addCell(rs1.getString(3));
								pdfTable.addCell(rs1.getString(4));
								pdfTable.addCell(rs1.getString(5));
								pdfTable.addCell(rs1.getString(6));
								
								cell = row.createCell(cct++);
								cell.setCellValue(rs1.getString(1));
								cell = row.createCell(cct++);
								cell.setCellValue(rs1.getString(2));
								cell = row.createCell(cct++);
								cell.setCellValue(rs1.getString(3));
								cell = row.createCell(cct++);
								cell.setCellValue(rs1.getString(4));
								cell = row.createCell(cct++);
								cell.setCellValue(rs1.getString(5));
								cell = row.createCell(cct++);
								cell.setCellValue(rs1.getString(6));
								
								stmt1=con.getConnection().prepareStatement("select person from resource where sno=?");
								stmt1.setLong(1, Long.parseLong(rs1.getString(1)));
								ResultSet rs3=stmt1.executeQuery();
								StringBuilder rp=new StringBuilder("");
								int c1=1;
								while(rs3.next())
								{
									rp.append(new Integer(c1).toString()+". "+rs3.getString(1)+"   \n");
									c1++;
								}
								pdfTable.addCell(rp.toString());
								
								cell = row.createCell(cct++);
								cell.setCellValue(rp.toString());
								
								row=sheet.createRow(rct++);
								 cct=0;
							}
							if(ch==1)
							{
								stmt2=con.getConnection().prepareStatement("select count from participants where sno=? and participantType=?");
								stmt2.setLong(1, Long.parseLong(rs1.getString(1)));
								stmt2.setString(2, "STAFF");
								rs2=stmt2.executeQuery();
								if(rs2.first())
								{
									pdfTable.addCell(rs1.getString(1));
									pdfTable.addCell(rs1.getString(2));
									pdfTable.addCell(rs1.getString(3));
									pdfTable.addCell(rs1.getString(4));
									pdfTable.addCell(rs1.getString(5));
									pdfTable.addCell(rs1.getString(6));
									
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(1));
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(2));
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(3));
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(4));
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(5));
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(6));
									
									stmt1=con.getConnection().prepareStatement("select person from resource where sno=?");
									stmt1.setLong(1, Long.parseLong(rs1.getString(1)));
									ResultSet rs3=stmt1.executeQuery();
									StringBuilder rp=new StringBuilder("");
									int c1=1;
									while(rs3.next())
									{
										
										rp.append(new Integer(c1).toString()+". "+rs3.getString(1)+"   \n");
										c1++;
									}
									pdfTable.addCell(rp.toString());
									pdfTable.addCell(rs2.getString(1));
									
									cell = row.createCell(cct++);
									cell.setCellValue(rp.toString());
									cell = row.createCell(cct++);
									cell.setCellValue(rs2.getString(1));

									row=sheet.createRow(rct++);
									 cct=0;
									 
								}
							}
							if(ch==2)
							{
								stmt2=con.getConnection().prepareStatement("select count from participants where sno=? and participantType=?");
								stmt2.setLong(1, Long.parseLong(rs1.getString(1)));
								stmt2.setString(2, "UG STUDENTS");
								rs2=stmt2.executeQuery();
								if(rs2.first())
								{
									pdfTable.addCell(rs1.getString(1));
									pdfTable.addCell(rs1.getString(2));
									pdfTable.addCell(rs1.getString(3));
									pdfTable.addCell(rs1.getString(4));
									pdfTable.addCell(rs1.getString(5));
									pdfTable.addCell(rs1.getString(6));
									
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(1));
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(2));
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(3));
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(4));
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(5));
									cell = row.createCell(cct++);
									cell.setCellValue(rs1.getString(6));
									
									stmt1=con.getConnection().prepareStatement("select person from resource where sno=?");
									stmt1.setLong(1, Long.parseLong(rs1.getString(1)));
									ResultSet rs3=stmt1.executeQuery();
									StringBuilder rp=new StringBuilder("");
									int c1=1;
									while(rs3.next())
									{
										rp.append(new Integer(c1).toString()+". "+rs3.getString(1)+"   \n");
										c1++;
									}
									pdfTable.addCell(rp.toString());
									pdfTable.addCell(rs2.getString(1));
									
									cell = row.createCell(cct++);
									cell.setCellValue(rp.toString());
									cell = row.createCell(cct++);
									cell.setCellValue(rs2.getString(1));
									
									row=sheet.createRow(rct++);
									 cct=0;
								}
							}
						}
						paragraph.add(pdfTable);
						document.add(paragraph);
						document.close();
						file.close();
						
						FileOutputStream out = 
					            new FileOutputStream(new File(textField_2.getText()+".xls"));
					    workbook.write(out);
					    out.close();
					}
					catch(Exception e1)
					{
						//document.close();
					}
					}
					catch(Exception e2)
					{
						e2.printStackTrace();
					}
				}
			}
		});
		btnGenerate.setBounds(130, 359, 109, 36);
		add(btnGenerate);
		
		JButton btnFinish = new JButton("FINISH");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container p=F.getContentPane();
				p.removeAll();
				p.add(new CpeHome(F));
				p.revalidate();
				p.repaint();
			}
		});
		btnFinish.setBounds(292, 359, 109, 36);
		add(btnFinish);

	}

}
