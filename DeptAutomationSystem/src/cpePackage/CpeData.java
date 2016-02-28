package cpePackage;

import java.sql.Date;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class CpeData {
	
	long sno;
	String cname;
	String ctype;
	String cdate;
	String duration;
	String sponsor;
	String[] resource;
	String inst;
	String place;
	String topic;
	String payment;
	
	public CpeData()
	{
		resource=new String[30];
	}
	
	public void setSno(long n)
	{
		sno=n;
	}
	
	public void setName(String n)
	{
		cname=n;
	}
	
	public void setType(int n)
	{
		switch(n)
		{
		case 0: ctype="Conference";break;
		case 1: ctype="Workshop";break;
		case 2: ctype="Seminar";break;
		case 3: ctype="Video Conference";break;
		default: ctype="Others";break;
		}
	}
	
	public void setDuration(String n)
	{
		duration=n;
	}
	
	public void setSponsor(String n)
	{
		sponsor=n;
	}
	
	public void setResource(String n,int i)
	{
		resource[i]=n;
	}
	
	public void setInst(String n)
	{
		inst=n;
	}
	
	public void setPlace(String n)
	{
		place=n;
	}
	
	public void setTopic(String n)
	{
		topic=n;
	}
	
	public void setPayment(String n)
	{
		payment=n;
	}
	
	public int setDate(String n)
	{
		try
		{
		String var[]=n.split("/");
		@SuppressWarnings("deprecation")
		java.sql.Date cdate1=new java.sql.Date(Integer.parseInt(var[2])-1900,Integer.parseInt(var[1])-1,Integer.parseInt(var[0])); 
		cdate=cdate1.toString();
		return 1;
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invalid Date Format");
			return 0;
		}
	}
	
	public long getSno()
	{
		return sno;
	}
	
	public String getName()
	{
		return cname;
	}
	
	public String getType()
	{
		return ctype;
	}
	
	public String getDuration()
	{
		return duration;
	}
	
	public String getSponsor()
	{
		return sponsor;
	}
	
	public String getResource(int i)
	{
		return resource[i];
	}
	
	public String getInst()
	{
		return inst;
	}
	
	public String getPlace()
	{
		return place;
	}
	
	public String getTopic()
	{
		return topic;
	}
	
	public String getDate()
	{
		return cdate;
	}
	
	public String getPayment()
	{
		return payment;
	}
	
}
