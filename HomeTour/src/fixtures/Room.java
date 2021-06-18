package fixtures;

import java.util.Map;

import game.RoomManager;

import java.util.HashMap;

public class Room extends Fixture {

	private Map<String, Room> exits = new HashMap<String, Room>();
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		RoomManager.addRoom(this);
	}
	
	public Map<String, Room> getExits() {
		return exits;
	}
	
	public Room getExit(String direction) {
		return exits.get(direction);
	}
	
	public void setRoomExit(Room exit, String direction) {
		exits.put(direction, exit);
	}
	
	public String toString() {
		return this.name + "\n\n" + this.shortDescription +"\n\n" + this.longDescription + "\n";
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void printExits() {
		
		System.out.println("Exits:");
		for( String key: exits.keySet()) {
			Room value = exits.get(key);
			System.out.println(key +":" + value.getName());
		}
	}
}
