package chess;
import java.io.Console;

public class Game {
	private static boolean gameEnd=false;

	public Game(){
		Board b = new Board();
		b.initialisePieces();
		CheckInput checker = new CheckInput();
		b.printBoard();
		while (!gameEnd){
			//write the game logic
			Console console = System.console();
			String in;
			int playerMove;
			int[] origin;
			int[] dest;
			in = console.readLine("------ Whites move -------\n> Enter origin:\n");
			if (checker.checkCoordinateValidity(in)){
				origin = this.convertToIndex(in);
				while (true){
					in = console.readLine("------ Whites move -------\n> Enter destination:\n");
					if (checkCoordinateValidity(in)){
						dest = this.convertToIndex(in);
						break;
					} else {
						System.out.println("Invalid move");
					}
				}
				//check move validity
			} else {
				System.out.println("Invalid move");
			}

		}
	}
	public int[] convertToIndex(String input){
		char originC;
		char originR;
		originR = input.charAt(0);
		originC = input.charAt(1);
		int[] list1 = new int[2];
		list1[0] = Integer.parseInt(Character.toString(originR));
		switch (originC){
			case 'a':
				list1[1] = 1;
				break;
			case 'b':
				list1[1] = 2;
				break;
			case 'c':
				list1[1] = 3;
				break;
			case 'd':
				list1[1] = 4;
				break;
			case 'e':
				list1[1] = 5;
				break;
			case 'f':
				list1[1] = 6;
				break;
			case 'g':
				list1[1] = 7;
				break;
			case 'h':
				list1[1] = 8;
				break;

		}
		return list1;
	}
	public static void main (String args[]){
		Game g  = new Game();
	}
}
