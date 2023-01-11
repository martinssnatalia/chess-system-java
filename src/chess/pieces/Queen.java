package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override 
	public String toString() {
		return "Q";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position aux = new Position(0,0);
		
		//above
				aux.setValues(position.getRow()-1, position.getColumn());
				while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					aux.setRow(aux.getRow()-1);
				}
				
				if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					aux.setRow(aux.getRow()-1);
				}
				
				//left
				aux.setValues(position.getRow(), position.getColumn()-1);
				while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					aux.setColumn(aux.getColumn()-1);
				}
				if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					
				}
				
				//right
				aux.setValues(position.getRow(), position.getColumn()+1);
				while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					aux.setColumn(aux.getColumn()+1);
				}
				if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					
				}
				
				//below
				aux.setValues(position.getRow()+1, position.getColumn());
				while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					aux.setRow(aux.getRow()+1);
				}
				if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					
				}
				
				//ne
				aux.setValues(position.getRow()-1, position.getColumn()+1);
				while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					aux.setValues(aux.getRow()-1, aux.getColumn()+1 );
				}
				
				if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					aux.setValues(aux.getRow()-1, aux.getColumn()+1 );
				}
				
				//nw
				aux.setValues(position.getRow()-1, position.getColumn()-1);
				while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					aux.setValues(aux.getRow()-1, aux.getColumn()-1 );
				}
				if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
				
				}
				
				//se
				aux.setValues(position.getRow()+1, position.getColumn()+1);
				while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					aux.setValues(aux.getRow()+1, aux.getColumn()+1 );
				}
				if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					
				}
				
				//sw
				aux.setValues(position.getRow()+1, position.getColumn()-1);
				while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					aux.setValues(aux.getRow()+1, aux.getColumn()-1 );
				}
				if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
					mat[aux.getRow()][aux.getColumn()]=true;
					
				}
		return mat;
	}

}
