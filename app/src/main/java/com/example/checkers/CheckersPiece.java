package com.example.checkers;

public class CheckersPiece {
    protected int row;
    protected int col;
    private boolean crownStatus;
    private int color;

    public CheckersPiece(int row, int column){
        this.row = row;
        this.col = column;
        this.crownStatus = false;
    }

    public CheckersPiece(CheckersPiece checker){
        this.row = checker.getRow();
        this.col = checker.getCol();
        this.crownStatus = checker.isCrownStatus();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int column) {
        this.col = column;
    }

    public boolean isCrownStatus() {
        return crownStatus;
    }

    public void setCrownStatus(boolean crownStatus) {
        this.crownStatus = crownStatus;
    }


    public void  setPosition(int row, int col)
    {
        this.col = col;
        this.row = row;
    }

}
