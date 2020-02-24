package chess;
import java.lang.Math;

public class Queen extends Piece{
  public Queen(PieceColour color){
    this.colour = color;
    if(color == PieceColour.WHITE){
			this.setSymbol("♕");
		} else {
			this.setSymbol("♛");
		}
	}

	public boolean isLegitMove(int x1, int y1, int x2, int y2){
    Square[][] b = Board.getBoard();
    int xDifA = Math.abs(x1-x2);
    int yDifA = Math.abs(y1-y2);
    int xDif = x2-x1;
    int yDif = y2-y1;
    boolean valid = true;
    if((xDifA == yDifA)){
      
      return valid;
    } else if (((xDifA==0) ^ (yDifA==0))) {
      return false;
    } else {
      return false;
    }
	}
}
