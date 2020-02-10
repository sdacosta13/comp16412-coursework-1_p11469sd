
package chess;

public class CheckInput {


	public boolean checkCoordinateValidity(String input){
		if(input.matches("[12345678][abcdefgh]")){
			return true;
		}else{
			return false;
		}
	}
}
