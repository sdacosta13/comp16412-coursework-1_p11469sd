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
    if(this.isGoingDiagonal(x1,y1,x2,y2)||this.isGoingStraight(x1,y1,x2,y2)){
      if(b[y2][x2].hasPiece()){
        if(b[y2][x2].getPiece().getColour() == this.getColour()){
          return false;
        } else {
          return true;
        }
      } else {
        return true;
      }
    } else {
      return false;
    }
	}
}
