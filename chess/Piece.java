package chess;

public abstract class Piece {
  private int row;
  private int column;
  private String symbol;
  protected PieceColour colour;
  public Piece(){

  }
  public String getSymbol(){
    return this.symbol;
  }
  public void setSymbol(String str){
    this.symbol = str;
  }
  public PieceColour getColour(){
    return colour;
  }
  public void updateCoordinates(int x, int y){
    this.row = y;
    this.column = x;
  }
  public boolean isGoingDiagonal(int x1, int y1, int x2, int y2){
    Square[][] b = Board.getBoard();
    int xDif = x2-x1;
    int yDif = y2-y1;
    boolean valid = true;
    int testposX;
    int testposY;
    int unitX;
    int unitY;
    if(Math.abs(xDif) == Math.abs(yDif)){
      if(x2 > x1){
        if(y2 > y1){
          unitX = 1;
          unitY = 1;
        } else {
          unitX = 1;
          unitY = -1;
        }
      } else {
        if(y2 > y1){
          unitX = -1;
          unitY = 1;
        } else {
          unitX = -1;
          unitY = -1;
        }
      }
    } else {
      return false;
    }
    for(int i = 1; i < Math.abs(xDif); i++){
      testposX = x1 + unitX*i;
      testposY = y1 + unitY*i;
      System.out.println(testposX + " " + testposY);
      if (b[testposX][testposY].hasPiece()){
        valid = false;
      }
    }
    return valid;
  }
  public boolean isGoingStraight(int x1, int y1, int x2, int y2){
    Square[][] b = Board.getBoard();
    int xDif = x2-x1;
    int yDif = y2-y1;
    boolean valid = true;
    int testpos;
    if (xDif ==0){
      for(int i = 1; i < Math.abs(yDif); i++){
        if(yDif > 0){
          testpos = y1 + i;
        } else {
          testpos = y1 - i;
        }

        if(b[x1][testpos].hasPiece()){
          valid = false;
        }
      }
      return valid;
    } else if (yDif == 0){
      for(int i = 1; i < Math.abs(xDif); i++){
        if(xDif > 0){
          testpos = x1 + i;
        } else{
          testpos = x1 - i;
        }

        if(b[testpos][y1].hasPiece()){
          valid = false;
        }
      }
      return valid;
    } else {
      return false;
    }
  }
  public abstract boolean isLegitMove(int x1, int y1, int x2, int y2);
}
