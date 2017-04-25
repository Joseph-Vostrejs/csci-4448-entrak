import java.util.ArrayList;

public class ToDoList {
	private ArrayList<String> itemsToDo;
	private User owner;

	void addItem(String item){
		itemsToDo.add(item);
	}
	
	ArrayList<String> getItemsToDo() {
		return itemsToDo;
	}
	
	void setItemsToDo(ArrayList<String> itemsToDo) {
		this.itemsToDo = itemsToDo;
	}
	
	User getOwner() {
		return owner;
	}
	
	void setOwner(User owner) {
		this.owner = owner;
	}
	
	void removeItem(String item){
		itemsToDo.remove(item);
	}
	
	void editItem(String item, String newitem){
		int index = itemsToDo.indexOf(item);
		itemsToDo.set(index, newitem);
	}
}