package bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OrderBean 
{
	private String oid;
	private String uid;
	private String date;
	private String time;
	private String total;
	
	public OrderBean(String uid,String total) 
	{
		LocalDate d= LocalDate.now();
		DateTimeFormatter dateformat= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		LocalTime t=LocalTime.now();
		DateTimeFormatter timeforrmat= DateTimeFormatter.ofPattern("HH:mm:ss a");
		
		this.uid=uid;
		this.date=d.format(dateformat).toString();
		this.time=t.format(timeforrmat).toString();
		this.total=total;
	}
	
	

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	
	
}
