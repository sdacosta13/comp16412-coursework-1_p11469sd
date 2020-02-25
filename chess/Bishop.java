package chess;

public class Bishop extends Piece{
  public Bishop(PieceColour color){
    this.colour = color;
    if(color == PieceColour.WHITE){
			this.setSymbol("♗");
		} else {
			this.setSymbol("♝");
		}
  }
  public boolean isLegitMove(int x1, int y1, int x2, int y2){

    Square[][] b = Board.getBoard();
    if(this.isGoingDiagonal(x1,y1,x2,y2)){
      if(b[x2][y2].hasPiece()){
        if(b[x2][y2].getPiece().getColour() == this.colour){
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
