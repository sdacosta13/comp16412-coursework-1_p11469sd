package chess;


//This class is partially implemented. Some methods need to have their body written, some other are fine as they are and other may need to be extended.

public class Board {
	private static Square [][] board = new Square[8][8];

	public Board(){
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++){
				board[i][j]=new Square(i,j);
			}
		}
	}

	public static Square[][] getBoard(){
		return board;
	}

	public void initialisePieces(){
		/*
		this.setPiece(0,0,new Rook(PieceColour.BLACK));
		this.setPiece(0,1,new Knight(PieceColour.BLACK));
		this.setPiece(0,2,new Bishop(PieceColour.BLACK));
		this.setPiece(0,3,new Queen(PieceColour.BLACK));
		this.setPiece(0,4,new King(PieceColour.BLACK));
		this.setPiece(0,5,new Bishop(PieceColour.BLACK));
		this.setPiece(0,6,new Knight(PieceColour.BLACK));
		this.setPiece(0,7,new Rook(PieceColour.BLACK));
		this.setPiece(1,0,new Pawn(PieceColour.BLACK));
		this.setPiece(2,1,new Pawn(PieceColour.BLACK));
		this.setPiece(3,2,new Pawn(PieceColour.BLACK));
		this.setPiece(1,3,new Pawn(PieceColour.BLACK));
		this.setPiece(3,4,new Pawn(PieceColour.BLACK));
		this.setPiece(3,5,new Pawn(PieceColour.BLACK));
		this.setPiece(1,6,new Pawn(PieceColour.BLACK));
		this.setPiece(1,7,new Pawn(PieceColour.BLACK));

		//White pieces
		this.setPiece(6,0,new Pawn(PieceColour.WHITE));
		this.setPiece(6,1,new Pawn(PieceColour.WHITE));
		this.setPiece(4,2,new Pawn(PieceColour.WHITE));
		this.setPiece(5,3,new Pawn(PieceColour.WHITE));
		this.setPiece(4,4,new Pawn(PieceColour.WHITE));
		this.setPiece(6,5,new Pawn(PieceColour.WHITE));
		this.setPiece(6,6,new Pawn(PieceColour.WHITE));
		this.setPiece(5,7,new Pawn(PieceColour.WHITE));
		this.setPiece(7,0,new Rook(PieceColour.WHITE));
		this.setPiece(7,1,new Knight(PieceColour.WHITE));
		this.setPiece(7,2,new Bishop(PieceColour.WHITE));
		this.setPiece(7,3,new Queen(PieceColour.WHITE));
		this.setPiece(7,4,new King(PieceColour.WHITE));
		this.setPiece(7,5,new Bishop(PieceColour.WHITE));
		this.setPiece(7,6,new Knight(PieceColour.WHITE));
		this.setPiece(7,7,new Rook(PieceColour.WHITE));
		*/

		PieceColour cType;
		int row;
		for(int i = 0; i < 2; i++){
			if(i == 0){
				cType = PieceColour.BLACK;
				row = 0;
			} else {
				cType = PieceColour.WHITE;
				row = 7;
			}
			Rook rook = new Rook(cType);
			this.setPiece(0, row, rook);
			Knight knight = new Knight(cType);
			this.setPiece(1, row, knight);
			Bishop bishop = new Bishop(cType);
			this.setPiece(2, row, bishop);
			Queen queen = new Queen(cType);
			this.setPiece(3, row, queen);
			King king = new King(cType);
			this.setPiece(4, row,  king);
			bishop = new Bishop(cType);
			this.setPiece(5, row, bishop);
			knight = new Knight(cType);
			this.setPiece(6, row, knight);
			rook = new Rook(cType);
			this.setPiece(7, row, rook);
			for(int j = 0; j < 8; j++){
				Pawn pawn = new Pawn(cType);
				if(i == 0){
					this.setPiece(j, 1, pawn);
				} else {
					this.setPiece(j, 6, pawn);
				}
			}
		}
	}

	public void printBoard(){
		System.out.print("\n  a b c d e f g h \n");
		System.out.print("  -----------------\n");
		String wsp=" ";String bar="|";

		for (int i=0; i<board[0].length; i++){
			int row=i+1;
			for (int j=0; j<board[1].length; j++){
				if ((j==0) && board[j][i].hasPiece()){
					System.out.print(row+" ");
					System.out.print(board[j][i].getPiece().getSymbol());
				} else if ((j==0) && !board[j][i].hasPiece()){
					System.out.print(row+"  " );
				} else if (board[j][i].hasPiece()){
					System.out.print("|");
					System.out.print(board[j][i].getPiece().getSymbol());
				} else {
					System.out.print("| ");
				}
			}
			System.out.print("  "+row+"\n");
		}
		System.out.print("  -----------------");
		System.out.print("\n  a b c d e f g h \n");

	}


	public boolean movePiece(int i0, int j0, int i1, int j1, Piece p){
		System.out.println(((Object)p).getClass());
		if (p.isLegitMove(i0,j0,i1,j1)){

			board[i0][j0].removePiece();
			this.setPiece(i1, j1, p);
			p.updateCoordinates(i1,j1);
			return true;
		} else {
			return false;
		}
	}

	public void setPiece(int iIn, int jIn, Piece p){
		board[iIn][jIn].setPiece(p);
	}

	public Piece getPiece(int iIn, int jIn){
		return board[iIn][jIn].getPiece();
	}

	public Square getSquareAt(int x, int y){
		return board[x][y];
	}
	public boolean hasPiece(int i, int j){
		if(board[i][j].hasPiece()){
			return true;
		} else {
			return false;
		}
	}
	//public static void main (String args[]){
	//	Board x = new Board();
	//	x.printBoard();
	//}

}
