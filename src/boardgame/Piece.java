package boardgame;

public class Piece {
	
	protected Position position; //protected cuz we don't want this visible at chess layer
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; //a piece initializes as if it wasn't on the board
	}

	protected Board getBoard() {
		return board;
	}


	
	
	
	
}
