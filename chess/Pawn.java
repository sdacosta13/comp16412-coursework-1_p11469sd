package chess;

public class Pawn extends Piece{
	private boolean firstMove;
	public Board[][] b; 
	public Pawn(PieceColour color){
		this.colour = color;
		this.firstMove = true;
		if(color == PieceColour.WHITE){
			this.setSymbol("♙");
		} else {
			this.setSymbol("♟");
		}
	}

	public boolean isLegitMove(int x1, int y1, int x2, int y2){
		System.out.println(firstMove);

		if(colour == PieceColour.BLACK){
			if((y2 > y1) && (x1 == x2)){
				if((y2 == (y1 + 2)) && this.firstMove){

					this.firstMove = false;
					return true;
				} else if (y2 == y1+ 1){
					this.firstMove = false;
					return true;
				} else {
					this.firstMove = false;
					return false;
				}


			} else {
				return false;
			}

		} else {
			return true;
		}
	}
}
