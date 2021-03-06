package game;

import fixtures.Room;
import java.util.ArrayList;

public class RoomManager {

	private Room startingRoom;	
	private static ArrayList<Room> rooms = new ArrayList<>();
	
	public RoomManager() {
		this.init();
	}
	public void init() {
		Room foyer = new Room("Foyer", 
				"A small entryway",
				"Its a small entryway to a unsignificant house.  It's laminate floor leads northwards to the living"+
				" room.  There is a small nail on the wall just inside the door.");
		Room livingRoom = new Room("Living Room", 
				"A general area of comfort and relaxation for family and visitors",
				"No significant features.  To the west lies the kitchen.  To the north lies a den. To the east lies" +
				" a bedroom");
		Room kitchen = new Room("Kitchen",
				"A general place to make food to eat",
				"Meals are eaten here.  The only exit is the living room to the east");
		Room den = new Room("Den",
				"A less formal staging area for relaxation",
				"This den is set up with surround sound and a giant tv taking up one whole wall.  The only"
				+ " exit is the living room to the south");
		Room bedRoom = new Room("Bed Room",
				"Place where a person sleeps",
				"Just a normal bedroom with the only exit to the west.  It leads to the living room.");
		
		foyer.setRoomExit(livingRoom, "north");
		foyer.setActions("hang keys", "The keys you had when you walked in are now hanging on the nail.");
		livingRoom.setRoomExit(bedRoom, "east");
		livingRoom.setRoomExit(den, "north");
		livingRoom.setRoomExit(kitchen, "west");
		livingRoom.setRoomExit(foyer, "south");
		kitchen.setRoomExit(livingRoom, "east");
		den.setRoomExit(livingRoom, "south");
		bedRoom.setRoomExit(livingRoom, "west");
		startingRoom = foyer;
	}	
	
	public Room getStartingRoom(){
		return startingRoom;
	}
	
	public static void addRoom(Room room) {
		rooms.add(room);
	}
}
