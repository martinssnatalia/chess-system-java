package boardgame;

public abstract class Piece {
	
	protected Position position; //protected cuz we don't want this visible at chess layer
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; //a piece initializes as if it wasn't on the board
	}

	protected Board getBoard() {
		return board;
	}

	//abstract cuz we don't know possible moves of a generic piece, each piece have one rule. 
	public abstract boolean[][] possibleMoves();
	
	//hook method
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}	
}
