package game;

import java.util.Scanner;
import fixtures.Room;

public class Main {
	private static Scanner in = new Scanner(System.in)
			;
	public static void main(String[] args) {
		// set up rooms
		RoomManager rm = new RoomManager();
		rm.init();
		String[] parsed;
		
		// set up player
		Player mover = new Player();
		mover.setCurrentRoom(rm.getStartingRoom());
		
		// game - loop
			//display prompt
			//collect input
			//parse input
		boolean quit = false;
		while(!quit) {
			
			//print screen and ask what to do
			printRoom(mover);
					
			//collect input
			parsed = collectInput();

			if (parsed[0].equals("quit")){
				quit = true;
				continue;
			}
			
			parse(parsed,mover);
			
		}
			
	}
	
	
	private static void printRoom(Player player) {
		System.out.println(player.getCurrentRoom().toString());
		player.getCurrentRoom().printExits();
		System.out.println("What do you want to do?");
	}
	
	private static String[] collectInput() {
		String input = in.nextLine();
		String[] parsed = input.split(" ");
		return parsed;
	}

	private static void parse(String[] command, Player player) {
		switch (command[0].toLowerCase().trim()) {
		case "go":
			Room destination = player.getCurrentRoom().getExit(command[1]);
			if (destination != null)
				player.setCurrentRoom(destination);
			else
				System.out.println("No exit that way");
			break;
		default:
			System.out.println("Invalid choice");
		}
	}
}
