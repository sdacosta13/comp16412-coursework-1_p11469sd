package chess;


//This class is partially implemented
public class Square {
	private int i;
	private int j;
	private boolean hasPiece;
	private Piece p;

	public Square(int iIn, int jIn){
		i=iIn;
		j=jIn;
	}


	public boolean hasPiece(){
		return hasPiece;
	}
	public Piece getPiece(){
		return p;
	}
	public void setPiece(Piece newPiece){
		p = newPiece;
		hasPiece = true;
	}
	public void removePiece(){
		hasPiece = false;
		this.p = null;
	}
	public int getI(){
		return i;
	}
	public int getJ(){
		return j;
	}

}
