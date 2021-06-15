package game;

import fixtures.Room;

public class Player {
	
	private Room currentRoom;
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room current) {
		this.currentRoom = current;
	}

}
