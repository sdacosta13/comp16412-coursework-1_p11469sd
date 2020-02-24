package chess;

public abstract class Piece {
  private int row;
  private int column;
  private String symbol;
  protected PieceColour colour;

  public Piece(){
    this.colour = colour;
  }
  public String getSymbol(){

    return symbol;
  }
  public void setSymbol(String str){
    //PieceColour returnColour;
    this.symbol = str;

    // int newInt = "♔♕♖♗♘♙".contains(symbol) ? 1:0;
    // if( newInt == -1){
    //   returnColour = PieceColour.BLACK;
    // } else {
    //   returnColour = PieceColour.WHITE;
    // }
    // colour = returnColour;
  }
  public PieceColour getColour(){
    return colour;
  }
  public void updateCoordinates(int x, int y){
    this.row = y;
    this.column = x;

  }

  public abstract boolean isLegitMove(int x1, int y1, int x2, int y2);

}
