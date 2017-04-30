public class Calendar {
	
	protected User owner;
	protected String calendarName;
	protected String permissions;
	protected Event[] events;

	
	User getOwner() {
		return owner;
	}

	void setOwner(User owner) {
		this.owner = owner;
	}

	String getPermissions() {
		return permissions;
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
