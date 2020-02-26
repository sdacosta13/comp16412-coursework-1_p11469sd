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
	public void setFirstMove(boolean newBool){
		this.firstMove = newBool;
	}
	public boolean getFirstMove(){
		return this.firstMove;
	}

	public boolean isLegitMove(int x1, int y1, int x2, int y2){


		Square[][] b = Board.getBoard();
		int yDif = Math.abs(y2-y1);
		int xDif = Math.abs(x2-x1);
		if(this.colour == PieceColour.BLACK){
			if(y2 > y1){
				if( yDif == 2 && this.getFirstMove() && xDif == 0 && !b[y2][x2].hasPiece() && !b[y2-1][x2].hasPiece()){
					this.setFirstMove(false);
					return true;
				} else if (yDif == 1 && xDif == 0 && !b[y2][x2].hasPiece()) {
					return true;
				} else if (yDif == 1 && xDif == 1 && b[y2][x2].hasPiece()) {
					if (b[y2][x2].getPiece().colour != this.colour){
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
			if(y1 > y2){
				if( yDif == 2 && this.getFirstMove() && xDif == 0 && !b[y2][x2].hasPiece()&& !b[y2+1][x2].hasPiece()){
					this.setFirstMove(false);
					return true;
				} else if (yDif == 1 && xDif == 0 && !b[y2][x2].hasPiece()) {
					return true;
				} else if (yDif == 1 && xDif == 1 && b[y2][x2].hasPiece()) {
					if (b[y2][x2].getPiece().colour != this.colour){
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
