import java.util.ArrayList;

public class ToDoList {
	private ArrayList<String> itemsToDo;
	private User owner;

	void addItem(String item){
		itemsToDo.add(item);
	}
	
	public ArrayList<String> getItemsToDo() {
		return itemsToDo;
	}
	
	public void setItemsToDo(ArrayList<String> itemsToDo) {
		this.itemsToDo = itemsToDo;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	void removeItem(String item){
		itemsToDo.remove(item);
	}
}