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

	void CreateEvent(Date start, Date end,String loc)
	{
		this.startTime = start;
		this.endTime = end;
		this.location = loc;
	}
	
	
	
}
