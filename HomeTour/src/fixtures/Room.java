package fixtures;

public class Room extends Fixture {

	Room[] exits;
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[4];
	}
	
	public Room[] getExits() {
		return exits;
	}
	
	public Room getExit(String direction) {
		switch (direction.toLowerCase()) {
		case "west":
			return this.exits[0];
		case "north":
			return this.exits[1];
		case "east":
			return this.exits[2];
		case "south":
			return this.exits[3];
		default:
			return null;
		}
	}
	
	public void setRoomExit(Room exit, String direction) {
		switch (direction.toLowerCase()) {
		case "west":
			exits[0] = exit;
			break;
		case "north":
			exits[1] = exit;
			break;
		case "east":
			exits[2] = exit;
			break;
		case "south":
			exits[3] = exit;
			break;
		}
	}
	
	@Override
	public String toString() {
		return this.name + "\n\n" + this.shortDescription +"\n\n" + this.longDescription + "\n";
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void printExits() {
		String [] directions = {"west", "north", "east", "south"};
		System.out.println("Exits: \n");
		for(int i = 0 ; i < exits.length;  i ++) {
			if (exits[i] != null)
				System.out.println(directions[i] + ": " + exits[i].getName());
		}
	}
}
