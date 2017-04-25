import java.util.Date;

public class Event {

	/**
	 * @param args
	 */
	protected Date startTime;
	protected Date endTime;
	protected String location;
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

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
