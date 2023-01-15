package com.example.checkers;

import java.util.ArrayList;

public class Board
{
    public ArrayList<CheckersPiece> board= new ArrayList<CheckersPiece>();
    public ArrayList<WhiteChecker> whiteCheckers= new ArrayList<WhiteChecker>();;
    public ArrayList<BlackChecker> blackCheckers= new ArrayList<BlackChecker>();;

    public static final int boardDimension = 8;

    public Board()
    {
        board = new ArrayList<CheckersPiece>();
        resetBoard();
    }

    public void resetBoard()
    {
        /*board.clear();
        whiteCheckers.clear();;
        blackCheckers.clear();*/
        for (int i = 0; i < boardDimension; i+=2)
        {
            board.add(new WhiteChecker(0,i));
            whiteCheckers.add(new WhiteChecker(0,i));
            board.add(new WhiteChecker(1,i+1));
            whiteCheckers.add(new WhiteChecker(1,i+1));
            board.add(new WhiteChecker(2,i));
            whiteCheckers.add(new WhiteChecker(2,i));

            board.add(new BlackChecker(5,i+1));
            blackCheckers.add(new BlackChecker(5,i+1));
            board.add(new BlackChecker(6,i));
            blackCheckers.add(new BlackChecker(6,i));
            board.add(new BlackChecker(7,i+1));
            blackCheckers.add(new BlackChecker(7,i+1));

        }
    }

    public CheckersPiece getPieceByLoc(int row, int col)
    {
        for (int i = 0; i < board.size(); i++)
        {
            CheckersPiece currentPiece = board.get(i);
            if(currentPiece.getRow() == row && currentPiece.getCol() == col)
            {
                return board.get(i);
            }
        }
        return null;
    }


    public String getColorByPiece(CheckersPiece currentPiece)
    {
        for (int i = 0; i < whiteCheckers.size(); i++)
        {
            if(currentPiece.getRow() == whiteCheckers.get(i).getRow() && currentPiece.getCol() == whiteCheckers.get(i).getCol())
            {
                return "WHITE";
            }
        }
        for (int i = 0; i < blackCheckers.size(); i++)
        {
            if(currentPiece.getRow() == blackCheckers.get(i).getRow() && currentPiece.getCol() == blackCheckers.get(i).getCol())
            {
                return "BLACK";
            }
        }
        return "WHITE";    }


}
