package fixtures;

import java.util.Map;

import game.RoomManager;
import java.util.ArrayList;
import java.util.HashMap;

public class Room extends Fixture {
	
	//class fields
	private Map<String, Room> exits = new HashMap<String, Room>();
	private Map<String, String> actions = new HashMap<String, String>();
	private ArrayList<String> items = new ArrayList<String>();

	//constructors
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		RoomManager.addRoom(this);
	}
	
	//setters
	public void setActions(String key, String action) {
		this.actions.put(key, action);
	}
	
	public void setRoomExit(Room exit, String direction) {
		exits.put(direction, exit);
	}
	
	public void setLongDescription(String description) {
		this.longDescription = description;
	}
	
	public void addItems(String item) {
		this.items.add(item);
	}

	public void removeItem(String item) {
		this.items.remove(item);
	}
	
	public void removeActions(String key) {
		actions.remove(key);
	}
	
	//getters
	public Room getExit(String direction) {
		return exits.get(direction);
	}

	public String getName() {
		return this.name;
	}
	
	//for printing
	public String toString() {
		return this.name + "\n\n" + this.shortDescription +"\n\n" + this.longDescription + "\n";	
	}
		
	public void printExits() {
		System.out.println("Exits:");
		for( String key: exits.keySet()) {
			Room value = exits.get(key);
			System.out.println(key +":" + value.getName());
		}
	}
	
	public void printActions() {
		System.out.println("Actions:");
		for (String key: actions.keySet()) {
			System.out.println(key);
		}
	}
}
