package com.example.checkers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainBoardConnector
{
    GameManager gameManager;
    private BoardView boardView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = findViewById(R.id.boardView);
        boardView.mainBoardConnector= this;
        gameManager = new GameManager();
    }
    @Override
    public CheckersPiece getPieceByLoc(int row, int col)
    {
        return gameManager.getPieceByLoc(row, col);
    }
    public String getColorByPiece(CheckersPiece currentPiece)
    {
        return gameManager.getColorByPiece(currentPiece);
    }

}