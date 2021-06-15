package game;

import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in)
			;
	public static void main(String[] args) {
		// set up rooms
		RoomManager rm = new RoomManager();
		rm.init();
		
		// set up player
		Player mover = new Player();
		mover.setCurrentRoom(rm.getStartingRoom());
		
		// game - loop
			//display prompt
			//collect input
			//parse input
		
		boolean quit = false;
		while(!quit) {
			System.out.println(mover.getCurrentRoom().toString());
			
		}
	}
	
	private static void printRoom(Player player) {
		
	}
	
	private static String[] collectInput() {
		String[] welcome= new String[1];
		return welcome;
	}

	private static void parse(String[] command, Player player) {
		
	}
}
