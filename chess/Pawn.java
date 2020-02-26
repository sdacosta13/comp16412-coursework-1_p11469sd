package chess;

public class Pawn extends Piece{
	private boolean firstMove;
	public Pawn(PieceColour color){
		this.colour = color;
		this.firstMove = true;
		if(color == PieceColour.WHITE){
			this.setSymbol("♙");
		} else {
			this.setSymbol("♟");
		}
	}
	public void setFirstMove(boolean bool){
		this.firstMove = bool;
	}
	public Boolean getFirstMove(){
		return this.firstMove;
	}
	public boolean isLegitMove(int x1, int y1, int x2, int y2){
		Square[][] b = Board.getBoard();
		int yDif = Math.abs(y2-y1);
		int xDif = Math.abs(x2-x1);
		System.out.println(xDif);
		System.out.println(yDif);

		if(this.colour == PieceColour.BLACK){
			if(x2 > x1){
				if( xDif == 2 && x1 == 1 && yDif == 0 && !b[x2][y2].hasPiece() && !b[x2-1][y2].hasPiece()){
					this.setFirstMove(false);
					System.out.println("rnu2");
					return true;
				} else if (xDif == 1 && yDif == 0 && !b[x2][y2].hasPiece()) {
					return true;
				} else if (xDif == 1 && yDif == 1 && b[x2][y2].hasPiece()) {
					if (b[x2][y2].getPiece().colour != this.colour){
						return true;
					} else {
						return false;
					}
				} else {
					System.out.println("moved too far");
					return false;
				}
			} else {
				System.out.println("WrongDir");
				return false;
			}
		} else {
			if(x1 > x2){
				if( xDif == 2 && x1 == 6 && yDif == 0 && !b[x2][y2].hasPiece() && !b[x2+1][y2].hasPiece()){
					this.setFirstMove(false);
					System.out.println("rnu");
					return true;
				} else if (xDif == 1 && yDif == 0 && !b[x2][y2].hasPiece()) {
					return true;
				} else if (xDif == 1 && yDif == 1 && b[x2][y2].hasPiece()) {
					if (b[x2][y2].getPiece().colour != this.colour){
						return true;
					} else {
						return false;
					}
				} else {
					System.out.println("moved too far");
					return false;
				}
			} else {
				System.out.println("WrongDir");
				return false;
			}
		}
	}
}
