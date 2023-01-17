package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	
	private ChessMatch chesssMatch;

	public Pawn(Board board, Color color, ChessMatch chesssMatch) {
		super(board, color);
		this.chesssMatch = chesssMatch;
	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position aux = new Position(0, 0);

		if (getColor() == Color.WHITE) {

			aux.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)) {
				mat[aux.getRow()][aux.getColumn()] = true;
			}

			aux.setValues(position.getRow() - 2, position.getColumn());
			Position aux2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux) && getBoard().positionExists(aux2)
					&& !getBoard().thereIsAPiece(aux2) && getMoveCount() == 0) {
				mat[aux.getRow()][aux.getColumn()] = true;
			}

			aux.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
				mat[aux.getRow()][aux.getColumn()] = true;
			}

			aux.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
				mat[aux.getRow()][aux.getColumn()] = true;
			}
			
			//special move en passant white
			if (position.getRow() ==3) {
				Position leftPawn = new Position (position.getRow(), position.getColumn()-1);
				if (getBoard().positionExists(leftPawn) && isThereOpponentPiece(leftPawn) && chesssMatch.getEnPassantVulnerable() == getBoard().piece(leftPawn)) {
					mat[leftPawn.getRow()-1][leftPawn.getColumn()] = true;
				}
				
				Position rightPawn = new Position (position.getRow(),position.getColumn()+1);
				if(getBoard().positionExists(rightPawn) && isThereOpponentPiece(rightPawn) && chesssMatch.getEnPassantVulnerable() == getBoard().piece(rightPawn)) {
					mat[rightPawn.getRow()-1][rightPawn.getColumn()]= true;
				}
			}

		} else {
			// black pawn logic
			aux.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)) {
				mat[aux.getRow()][aux.getColumn()] = true;
			}

			aux.setValues(position.getRow() + 2, position.getColumn());
			Position aux2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux) && getBoard().positionExists(aux2)
					&& !getBoard().thereIsAPiece(aux2) && getMoveCount() == 0) {
				mat[aux.getRow()][aux.getColumn()] = true;
			}

			aux.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
				mat[aux.getRow()][aux.getColumn()] = true;
			}

			aux.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
				mat[aux.getRow()][aux.getColumn()] = true;
			}
			
			//special move en passant black
			if (position.getRow() == 4) {
				Position leftPawn = new Position(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(leftPawn) && isThereOpponentPiece(leftPawn) && getBoard().piece(leftPawn) == chesssMatch.getEnPassantVulnerable()) {
					mat[leftPawn.getRow()+1][leftPawn.getColumn()] = true;
				}
				
				Position rightPawn = new Position(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(rightPawn) && isThereOpponentPiece(rightPawn) && getBoard().piece(rightPawn) == chesssMatch.getEnPassantVulnerable()){
					mat[rightPawn.getRow()+1][rightPawn.getColumn()] = true;
				}
			}
		}
		return mat;
	}

}
