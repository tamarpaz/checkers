package com.example.checkers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BoardView extends View
{
    public BoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        createImg();
    }
    Paint paint = new Paint();
    private final int DARK_COLOR = Color.rgb(107,62,46);
    private final int BRIGHT_COLOR = Color.rgb(227,192,153);

    private final float X_START_POSITION = (float)2.5;
    private final float Y_START_POSITION = 2;
    private final float SQUARE_LENGTH = 133;
    private final int NUM_SQUARES = 8;

    public MainBoardConnector mainBoardConnector;
    private final int BOARD_DIMENSION = 7;
    private final HashMap<Integer, Bitmap> images = new HashMap<Integer, Bitmap>();
    private boolean isBoardDrawn = false;
    private boolean isPieceSelected = false;
    


    @Override
    public void onDraw(Canvas canvas)
    {
        drawSquares(canvas);
        drawPieces(canvas);
    }

    private void drawSquares(Canvas canvas)
    {
        int color;
        float xShift, yShift;
        for (int i = 0; i < NUM_SQUARES; i++)
        {
            yShift = i * SQUARE_LENGTH;
            for (int j = 0; j < NUM_SQUARES; j++)
            {
                xShift = j * SQUARE_LENGTH;
                color = ((i + j) % 2 == 0) ? BRIGHT_COLOR : DARK_COLOR;
                paint.setColor(color);
                canvas.drawRect(X_START_POSITION + xShift, Y_START_POSITION + yShift,
                        X_START_POSITION + xShift + SQUARE_LENGTH,
                        Y_START_POSITION + yShift + SQUARE_LENGTH, paint);
            }
        }
    }
    private void createImg()
    {
        HashSet<Integer> imagesIds = new HashSet<>();
        imagesIds.add(R.drawable.whitepawn);
        imagesIds.add(R.drawable.whitequeen);
        imagesIds.add(R.drawable.blackpawn);
        imagesIds.add(R.drawable.blackqueen);

        for (int id: imagesIds)
        {
            Bitmap currentImg = BitmapFactory.decodeResource(getResources(), id);
            images.put(id, currentImg);
        }
    }

    private void drawPieces(Canvas canvas)
    {
        for (int row = 0; row < NUM_SQUARES; row++)
        {
            for (int col = 0; col < NUM_SQUARES; col++)
            {
                CheckersPiece currentPiece = mainBoardConnector.getPieceByLoc(row, col);
                if(currentPiece != null)
                {
                    String colorOfLoc= mainBoardConnector.getColorByPiece(currentPiece);
                    if (colorOfLoc.equals("WHITE"))
                    {
                        drawPieceByLoc(canvas, row, col, R.drawable.whitepawn);
                    }
                    else
                    {
                        drawPieceByLoc(canvas, row, col, R.drawable.blackpawn);
                    }
                }
            }
        }
    }

    private void drawPieceByLoc(Canvas canvas, int row, int col, int resId)
    {
        Bitmap currentPiece = images.get(resId);
        int xShift = (int) (X_START_POSITION + col * SQUARE_LENGTH);
        int yShift = (int) (Y_START_POSITION + (BOARD_DIMENSION - row) * SQUARE_LENGTH);
        canvas.drawBitmap(currentPiece, null, new Rect(xShift, yShift, (int)(xShift + SQUARE_LENGTH), (int)(yShift + SQUARE_LENGTH)), paint);
    }


}
