package game;

import java.util.List;
import java.util.ArrayList;

import fixtures.Room;

public class Player {
	
	private Room currentRoom;
	
	private List<String> items = new ArrayList<String>();
	
	
	public Player(RoomManager begginning) {
		this.currentRoom = begginning.getStartingRoom();
		items.add("keys");
		items.add("coat");
		items.add("watch");
	}
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room current) {
		this.currentRoom = current;
	}

	public void removeItem(String key) {
		int index = items.indexOf(key);
		items.remove(index);
	}
	public void addItem(String item) {
		items.add(item);
	}
}
