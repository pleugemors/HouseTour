package game;

import java.util.HashMap;

import fixtures.Room;

public class Player {
	
	private Room currentRoom;
	
	private HashMap<String, String> items = new HashMap<String, String>();
	
	
	public Player(RoomManager begginning) {
		this.currentRoom = begginning.getStartingRoom();
	}
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room current) {
		this.currentRoom = current;
	}

}
