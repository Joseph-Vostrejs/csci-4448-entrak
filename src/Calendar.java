import java.sql.*;
public class Calendar {
	
	protected User owner;
	protected String calendarName;
	protected String permissions;
	protected Event[] events;

	
	User getOwner() {
		return owner;
	}
	
	String getCalendarName(){
		return calendarName;
	}
	
	void setOwner(User owner) {
		this.owner = owner;
	}
	
	String getPermissions(String User) {
		String query = "SELECT permissions FROM Calendars WHERE owner='"+User+"'";
		try
		{
		ResultSet rs = DB.select(query);
		return rs.getString("permissions");
		}catch(Exception e){System.out.println(e);}
		return null;
	}
	
	void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	Event[] getEvents() {
		return events;
	}

	void setEvents(Event[] events) {
		this.events = events;
	}

	public Calendar() {
	}

	public Calendar(User owner,String calendarName,String permissions)
	{
		this.owner = owner;
		this.calendarName = calendarName;
		this.permissions = permissions;
		String query = "INSERT INTO Calendars (owner,calendarName,permissions) VALUES ('"+owner.username+"','"+calendarName+"','"+permissions+"')";
		try{
		DB.post(query);
		}catch(Exception e){System.out.println(e);}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		//System.out.println("WORKING");
	}

}
