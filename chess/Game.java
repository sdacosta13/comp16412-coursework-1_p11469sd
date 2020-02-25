package chess;
import java.io.Console;

public class Game {
	private static boolean gameEnd=false;
	public Game(){
		/*
		Board b = new Board();
		//Black pieces
		b.setPiece(0,0,new Rook(PieceColour.BLACK));
		b.setPiece(0,1,new Knight(PieceColour.BLACK));
		b.setPiece(0,2,new Bishop(PieceColour.BLACK));
		b.setPiece(0,3,new Queen(PieceColour.BLACK));
		b.setPiece(0,4,new King(PieceColour.BLACK));
		b.setPiece(0,5,new Bishop(PieceColour.BLACK));
		b.setPiece(0,6,new Knight(PieceColour.BLACK));
		b.setPiece(0,7,new Rook(PieceColour.BLACK));
		b.setPiece(1,0,new Pawn(PieceColour.BLACK));
		b.setPiece(2,1,new Pawn(PieceColour.BLACK));
		b.setPiece(3,2,new Pawn(PieceColour.BLACK));
		b.setPiece(1,3,new Pawn(PieceColour.BLACK));
		b.setPiece(3,4,new Pawn(PieceColour.BLACK));
		b.setPiece(3,5,new Pawn(PieceColour.BLACK));
		b.setPiece(1,6,new Pawn(PieceColour.BLACK));
		b.setPiece(1,7,new Pawn(PieceColour.BLACK));

		//White pieces
		b.setPiece(6,0,new Pawn(PieceColour.WHITE));
		b.setPiece(6,1,new Pawn(PieceColour.WHITE));
		b.setPiece(4,2,new Pawn(PieceColour.WHITE));
		b.setPiece(5,3,new Pawn(PieceColour.WHITE));
		b.setPiece(4,4,new Pawn(PieceColour.WHITE));
		b.setPiece(6,5,new Pawn(PieceColour.WHITE));
		b.setPiece(6,6,new Pawn(PieceColour.WHITE));
		b.setPiece(5,7,new Pawn(PieceColour.WHITE));
		b.setPiece(7,0,new Rook(PieceColour.WHITE));
		b.setPiece(7,1,new Knight(PieceColour.WHITE));
		b.setPiece(7,2,new Bishop(PieceColour.WHITE));
		b.setPiece(7,3,new Queen(PieceColour.WHITE));
		b.setPiece(7,4,new King(PieceColour.WHITE));
		b.setPiece(7,5,new Bishop(PieceColour.WHITE));
		b.setPiece(7,6,new Knight(PieceColour.WHITE));
		b.setPiece(7,7,new Rook(PieceColour.WHITE));
		Piece p = b.getPiece(3,5);
		b.printBoard();
		b.setPiece(4,5,p);
		b.printBoard();
		System.out.println(p.isLegitMove(3,5,4,5));
		*/

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
						System.out.println("--------------------------\nInvalid move");
					}
				}


				//check move validity
				if (b.getSquareAt(origin[0],origin[1]).hasPiece() && !(dest == origin)){
					Square squareAtCoord = b.getSquareAt(origin[0],origin[1]);
					Piece pieceAtCoord = squareAtCoord.getPiece();

					if (b.movePiece(origin[0],origin[1],dest[0],dest[1],pieceAtCoord)){
						b.printBoard();

					} else {
						System.out.println("--------------------------\nInvalid move");
						b.printBoard();
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
