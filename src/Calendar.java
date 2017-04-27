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

	public Calendar(User owner)
	{
		this.owner = owner;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//DB.getConnection();
		System.out.println("WORKING");
	}

}
