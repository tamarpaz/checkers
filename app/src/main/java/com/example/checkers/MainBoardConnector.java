package com.example.checkers;

public interface MainBoardConnector {
    CheckersPiece getPieceByLoc(int row, int col);
    String getColorByPiece(CheckersPiece currentPiece);
}
