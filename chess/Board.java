package chess;


//This class is partially implemented. Some methods need to have their body written, some other are fine as they are and other may need to be extended.

public class Board {
	private static Square [][] board = new Square[8][8];

	public Board(){
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++)
					board[i][j]=new Square(i,j);
		}
	}

	public static Square[][] getBoard(){
		return board;
	}

	public void initialisePieces(){

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
			this.setPiece(row, 0, rook);
			Knight knight = new Knight(cType);
			this.setPiece(row, 1, knight);
			Bishop bishop = new Bishop(cType);
			this.setPiece(row, 2, bishop);
			Queen queen = new Queen(cType);
			this.setPiece(row, 3, queen);
			King king = new King(cType);
			this.setPiece(row, 4,  king);
			bishop = new Bishop(cType);
			this.setPiece(row, 5, bishop);
			knight = new Knight(cType);
			this.setPiece(row, 6, knight);
			rook = new Rook(cType);
			this.setPiece(row, 7, rook);
			for(int j = 0; j < 8; j++){
				Pawn pawn = new Pawn(cType);
				if(i == 0){
					this.setPiece(1,j, pawn);
				} else {
					this.setPiece(6,j, pawn);
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
					if ((j==0) && board[i][j].hasPiece()){
						System.out.print(row+" ");
						System.out.print(board[i][j].getPiece().getSymbol());
					} else if ((j==0) && !board[i][j].hasPiece())
						System.out.print(row+"  " );

					else if (board[i][j].hasPiece()){
						System.out.print("|");
						System.out.print(board[i][j].getPiece().getSymbol());
					}else
						System.out.print("| ");
				}
				System.out.print("  "+row+"\n");
		}
		System.out.print("  -----------------");
		System.out.print("\n  a b c d e f g h \n");

	}


	public boolean movePiece(int i0, int j0, int i1, int j1, Piece p){
		Boolean kingDeath = false;
		if(this.getSquareAt(i1,j1).hasPiece()){
			if(this.getPiece(i1,j1) instanceof King){
				kingDeath = true;
			} else {
				kingDeath = false;
			}

		}
		if(p.isLegitMove(i0,j0,i1,j1)){
			this.setPiece(i1,j1,p);
			this.removePiece(i0,j0);
			return kingDeath;
		} else {
			return false;
		}
	}

	public void setPiece(int iIn, int jIn, Piece p){
		board[iIn][jIn].setPiece(p);
	}
	public Square getSquareAt(int i, int j){
		return board[i][j];
	}
	public Piece getPiece(int iIn, int jIn){
		return board[iIn][jIn].getPiece();
	}
	public void removePiece(int i, int j){
		board[i][j].removePiece();
	}
	public boolean hasPiece(int i, int j){
		return board[i][j].hasPiece();
	}
	public static void main (String args[]){
		Board x = new Board();
		x.printBoard();
	}

}
