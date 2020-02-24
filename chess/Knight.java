package chess;

public class Knight extends Piece{
  public Knight(PieceColour color){
    this.colour = color;
    if(color == PieceColour.WHITE){
			this.setSymbol("♘");
		} else {
			this.setSymbol("♞");
		}
  }

  public boolean isLegitMove(int x1, int y1, int x2, int y2){
    return true;
  }
}
