import java.util.Date;
import java.sql.*;

public class Event {

	/**
	 * @param args
	 */
	protected Calendar Cal;
	protected String EventName;
	protected Date startTime;
	protected Date endTime;
	protected String location;
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	}

	public Event(Calendar Cal,String EventName,Date startTime,Date endTime,String location){
		this.Cal = Cal;
		this.EventName = EventName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		String owner = Cal.getOwner().getUsername();
		String query = "INSERT INTO Events (owner,calendarName,eventName,startTime,endTime,location) VALUES ('"+owner+"','"+Cal.getCalendarName()+"','"+EventName+"'.'"+startTime+"','"+endTime+"','"+location+"')";
		try{
		DB.post(query);
		}catch(Exception e){System.out.println(e);}
		
		
	}
	
	ResultSet getEvents(String owner, String calendarName, String eventName)
	{
		String query = "SELECT * FROM Calendars WHERE owner='"+owner+"' AND calendarName='"+calendarName+"' AND eventName='"+eventName+"'";
		try
		{
		ResultSet rs = DB.select(query);
		return rs;
		}catch(Exception e){System.out.println(e);}
		return null;
	}
	
	String getEventName(){
		return EventName;
	}
	
	Date getStartTime() {
		return startTime;
	}

	void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	Date getEndTime() {
		return endTime;
	}

	void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	String getLocation() {
		return location;
	}

	void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
