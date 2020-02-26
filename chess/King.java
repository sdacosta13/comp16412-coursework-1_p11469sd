package chess;
import java.lang.Math;
public class King extends Piece{
	public King(PieceColour color){
		this.colour = color;
		if(color == PieceColour.WHITE){
			this.setSymbol("♔");
		} else {
			this.setSymbol("♚");
		}
	}

	public boolean isLegitMove(int x1, int y1, int x2, int y2){


		Square[][] b = Board.getBoard();
		int xDif = Math.abs(x1-x2);
		int yDif = Math.abs(y1-y2);
		if((xDif == 1 || xDif == 0) && (yDif == 1 || yDif == 0)){
			if(!b[y2][x2].hasPiece()){
				return true;
			} else {
				if(b[y2][x2].getPiece().getColour() == this.colour){
					return false;
				} else {
					return true;
				}
			}
		} else {
			return false;
		}
	}
}
