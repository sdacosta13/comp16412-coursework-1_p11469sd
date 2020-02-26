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
    Square[][] b = Board.getBoard();
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
    if(b[dest[1]][dest[0]].hasPiece()){
      if(b[dest[1]][dest[0]].getPiece().getColour() == this.colour){
        valid = false;
      }
    }

    return valid;
  }
}
