package com.example.checkers;

public class GameManager {
    private Board board;

    public GameManager()
    {
        board = new Board();
    }

    public CheckersPiece getPieceByLoc(int row, int col)
    {
        return board.getPieceByLoc(row, col);
    }
    public String getColorByPiece(CheckersPiece currentPiece) { return board.getColorByPiece(currentPiece);}
}
