import java.util.ArrayList;

public class Group {
	private ArrayList<User> members;
	private String name;
	
	void inviteMember(User member){
		members.add(member);
	}
	
	void removeMember(User member){
		members.remove(member);
	}

	public ArrayList<User> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}