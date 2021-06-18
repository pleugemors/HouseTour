package game;

import java.util.Scanner;
import fixtures.Room;

public class Main {
	private static Scanner in = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// set up rooms and player
		RoomManager rm = new RoomManager();
		String[] parsed;
		Player mover = new Player(rm);
		
		//Loop to ask what to do
		boolean quit = false;
		while(!quit) {
			
			//print screen and ask what to do
			printRoom(mover);
					
			//collect input
			parsed = collectInput();
			//parse
			if (parsed[0].equals("quit")){
				quit = true;
				continue;
			}
			else if(parsed[0].equals("help")) {
				printHelp();
				continue;
			}else {
				parse(parsed,mover);
			}
		}
			
		in.close();
	}
	
	public static void printHelp() {
		System.out.println("If you are wanting to change rooms type go followed by the direction of the exit.  like go north");
	}
	private static void printRoom(Player player) {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(player.getCurrentRoom().toString());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		player.getCurrentRoom().printExits();
		player.getCurrentRoom().printActions();
		System.out.println("What do you want to do?");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
	}
	
	private static String[] collectInput() {
		String input = in.nextLine();
		String[] parsed = input.split(" ");
		return parsed;
	}
	
	private static void parse(String[] command, Player player) {
		Room temp;
		switch (command[0].toLowerCase().trim()) {
		case "go":
			Room destination = player.getCurrentRoom().getExit(command[1].toLowerCase());
			if (destination != null)
				player.setCurrentRoom(destination);
			else
				System.out.println("No exit that way");
			break;
		case "hang":
			temp = player.getCurrentRoom();
			temp.addItems(command[1]);
			temp.removeActions(command[0]+" "+command[1]);
			temp.setActions("take keys", "The keys are taken off the wall");
			temp.setLongDescription("Its a small entryway to a unsignificant house.  It's laminate floor leads northwards to the living room.  There is a small nail now with some keys on it.");
			player.removeItem(command[1]);
			break;
		case "take":
			temp = player.getCurrentRoom();
			player.addItem(command[1]);
			temp.removeActions(command[0]+" "+command[1]);
			temp.setActions("hang keys", "The keys you had when you walked in are now hanging on the nail.");
			temp.setLongDescription("Its a small entryway to a unsignificant house.  It's laminate floor leads northwards to the living"+
					" room.  There is a small nail on the wall just inside the door.");
			temp.removeItem(command[1]);
			break;
		default:
			System.out.println("Invalid choice");
		}
	}
}
