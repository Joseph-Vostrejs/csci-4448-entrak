
public class Course extends Event {

	protected String professor;
	protected int courseNumber;
	
	public Course() 
	{
		// TODO Auto-generated constructor stub
	}

	public Course(String prof){
		this.professor = prof;
	}
	
	public Course(int course){
		this.courseNumber = course;
	}
	
	public Course(String prof, int course)
	{
		this.professor = prof;
		this.courseNumber = course;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
