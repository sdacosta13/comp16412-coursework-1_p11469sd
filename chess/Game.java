package chess;
import java.io.Console;
public class Game {
	private static boolean gameEnd=false;

	public Game(){
		CheckInput checker = new CheckInput();
		Board b = new Board();
		b.initialisePieces();
		b.printBoard();
		String playerMove = "White";
		PieceColour playerColour = PieceColour.WHITE;
		while (!gameEnd){

			//write the game logic
			Console console = System.console();
			String in;

			int[] origin;
			int[] dest;
			in = console.readLine("------ " + playerMove + " move -------\n> Enter origin:\n");
			if (in.equals("END")){
				gameEnd = true;
			}
			if (checker.checkCoordinateValidity(in)){
				origin = this.convertToIndex(in);
				while (true){
					in = console.readLine("------ " + playerMove + " move -------\n> Enter destination:\n");
					if (in.equals("END")){
						gameEnd = true;
					}
					if (checker.checkCoordinateValidity(in)){
						dest = this.convertToIndex(in);

						break;
					} else {
						System.out.println("--------------------------\nInvalid move");
					}
				}


				//check move validity
				if (b.getSquareAt(origin[0],origin[1]).hasPiece() && !(dest == origin)){
					Square squareAtCoord = b.getSquareAt(origin[0],origin[1]);
					Piece pieceAtCoord = squareAtCoord.getPiece();
					if(pieceAtCoord.getColour() == playerColour){
						if (b.movePiece(origin[0],origin[1],dest[0],dest[1],pieceAtCoord)){
							gameEnd = true;
							System.out.println(playerMove + " Wins!");

						} else {

							if(playerMove.equals("White")){

								playerMove = "Black";
								playerColour = PieceColour.BLACK;
							} else {

								playerMove = "White";
								playerColour = PieceColour.WHITE;
							}
							b.printBoard();
						}
					} else {
						System.out.println("--------------------------\nInvalid move");
					}

				} else{
					System.out.println("--------------------------\nInvalid move");
				}

			} else {
				System.out.println("--------------------------\nInvalid move");
			}
		}
	}
	public int[] convertToIndex(String input){
		char originC;
		char originR;
		originR = input.charAt(0);
		originC = input.charAt(1);
		int[] list1 = new int[2];
		list1[0] = Integer.parseInt(Character.toString(originR))-1;
		switch (originC){
			case 'a':
				list1[1] = 0;
				break;
			case 'b':
				list1[1] = 1;
				break;
			case 'c':
				list1[1] = 2;
				break;
			case 'd':
				list1[1] = 3;
				break;
			case 'e':
				list1[1] = 4;
				break;
			case 'f':
				list1[1] = 5;
				break;
			case 'g':
				list1[1] = 6;
				break;
			case 'h':
				list1[1] = 7;
				break;

		}
		return list1;
	}

	public static void main (String args[]){
		Game g  = new Game();
	}
}
