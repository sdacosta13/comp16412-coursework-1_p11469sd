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

    int [] dest = {x2,y2};
    int[][] moves = {{x1-2,y1-1},
    {x1-2,y1+1},
    {x1-1,y1-2},
    {x1-1,y1+2},
    {x1+1,y1-2},
    {x1+1,y1+2},
    {x1+2,y1-1},
    {x1+2,y1+1}
    };
    boolean valid = false;
    for(int i = 0; i < moves.length; i++){
      if((dest[0] == moves[i][0])&&(dest[1] == moves[i][1])){
        valid = true;
      }
    }
    if(b.getSquareAt(dest[0],dest[1]).hasPiece()){
      if(b.getPiece(dest[0],dest[1]).getColour() == this.colour){
        valid = false;
      }
    }

    return valid;
  }
}
