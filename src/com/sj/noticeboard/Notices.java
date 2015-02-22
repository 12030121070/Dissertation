package com.sj.noticeboard;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Notices {
	
	int n_id;
	String n_title;
	String n_part1;
	String n_part2;
	String n_part3;
	String n_part4;
	Date sdate;
	Date edate;
	int author;
	int priority;
	
	public int getNid()
	{
		return n_id;
	}
	public void setNid(int n_id)
	{
		this.n_id=n_id;
	}
	
	public String getNtitle()
	{
		return n_title;
	}
	public void setNtitle(String n_title)
	{
		this.n_title=n_title;
	}
	
	public String getNpart1()
	{
		return n_part1;
	}
	public void setNpart1(String n_part1)
	{
		this.n_part1=n_part1;
	}
	public String getNpart2()
	{
		return n_part2;
	}
	public void setNpart2(String n_part2)
	{
		this.n_part2=n_part2;
	}
	public String getNpart3()
	{
		return n_part3;
	}
	public void setNpart3(String n_part3)
	{
		this.n_part3=n_part3;
	}
	public String getNpart4()
	{
		return n_part4;
	}
	public void setNpart4(String n_part4)
	{
		this.n_part4=n_part4;
	}
	
	public Date getSdate()
	{
		return sdate;
	}
	public void setSdate(String sdate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		try {
			 
			Date date = formatter.parse(sdate);
			this.sdate=date;
	 
		} catch (ParseException e) {
			
		}
	}
	public Date getEdate()
	{
		return sdate;
	}
	public void setEdate(String edate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		try {
			 
			Date date = formatter.parse(edate);
			this.edate=date;
	 
		} catch (ParseException e) {
			
		}
	}
	
	public int getAid()
	{
		return author;
	}
	public void setAid(int author)
	{
		this.author=author;
	}
	
	public int getPriority()
	{
		return priority;
	}
	public void setPriority(int priority)
	{
		this.priority=priority;
	}

}
