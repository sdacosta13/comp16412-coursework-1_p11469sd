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
		if(colour == PieceColour.BLACK){
			if((y2 > y1) && (x1 == x2)){
				if (!b.getSquareAt(x2,y2).hasPiece()){
					if((y2 == (y1 + 2)) && this.firstMove){

						this.firstMove = false;
						return true;
					} else if (y2 == y1+ 1){
						this.firstMove = false;
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}

			} else if(((x1+1==x2)&&(y1+1==y2))||((x1-1==x2)&&(y1+1==y2))){
				if(b.getSquareAt(x2,y2).hasPiece()){
					if(b.getPiece(x2,y2).getColour()==PieceColour.BLACK){
						return false;
					} else {
						return true;
					}

				} else {
					return false;
				}
			} else {
				return false;
			}

		} else {
			return true;
		}
	}
}
