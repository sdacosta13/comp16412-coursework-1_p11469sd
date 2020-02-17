package chess;

public class Pawn extends Piece{
	public Pawn(PieceColour color){

		if(color == PieceColour.WHITE){
			this.setSymbol("♙");
		} else {
			this.setSymbol("♟");
		}
	}
	public boolean isLegitMove(int x1, int y1, int x2, int y2){
		return true;
	}
}
