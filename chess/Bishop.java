package chess;

public class Bishop extends Piece{
  public Bishop(PieceColour color){
    if(color == PieceColour.WHITE){
			this.setSymbol("♗");
		} else {
			this.setSymbol("♝");
		}
  }
  public boolean isLegitMove(int x1, int y1, int x2, int y2){
    return true;
  }
}
