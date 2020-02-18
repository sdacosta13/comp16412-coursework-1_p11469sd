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
					if (checker.checkCoordinateValidity(in)){
						dest = this.convertToIndex(in);
						break;
					} else {
						System.out.println("Invalid move");
					}
				}
				System.out.println(origin[0]+ " " + origin[1]);
				System.out.println(dest[0] + " " + dest[1]);
				//check move validity
				if (b.getSquareAt(origin[0],origin[1]).hasPiece()){
					Square squareAtCoord = b.getSquareAt(origin[0],origin[1]);
					Piece pieceAtCoord = squareAtCoord.getPiece();

					if (pieceAtCoord.isLegitMove(origin[0],origin[1],dest[0],dest[1])){
						b.movePiece(origin[0],origin[0],dest[0],dest[1],pieceAtCoord);
						b.printBoard();

					} else {
						System.out.println("Invalid move");
					}
				} else{
					System.out.println("Invalid move");
				}

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
		list1[1] = Integer.parseInt(Character.toString(originR))-1;
		switch (originC){
			case 'a':
				list1[0] = 0;
				break;
			case 'b':
				list1[0] = 1;
				break;
			case 'c':
				list1[0] = 2;
				break;
			case 'd':
				list1[0] = 3;
				break;
			case 'e':
				list1[0] = 4;
				break;
			case 'f':
				list1[0] = 5;
				break;
			case 'g':
				list1[0] = 6;
				break;
			case 'h':
				list1[0] = 7;
				break;

		}
		return list1;
	}
	public static void main (String args[]){
		Game g  = new Game();
	}

}
