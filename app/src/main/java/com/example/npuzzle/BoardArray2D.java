package com.example.npuzzle;
import android.widget.TextView;

import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class BoardArray2D extends AbstractBoard {
    protected int board[][];

    /**
     * Reads board from given array
     */

    public int[][] sizedArr(){
        int count=0;
        int sX= sizeX;
        int sY=sizeY;
        int arr[][] = new int[sX][sY];
        for (int i=0;i<sX;i++){
            for (int j=0;j<sY;j++){
                count++;
                arr[i][j]=count;
            }
        }
        arr[sX-1][sY-1]=0;
        return arr;
    }

    public void showBoard(TextView[][] views){
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                views[i][j].setText(" ");
            }
        }
        for (int i=0;i<sizeX;i++){
            for (int j=0;j<sizeY;j++){
                views[i][j].setText(String.valueOf(cell(i,j)));
            }
        }
    }

    public void shuffle(){
        Random r =new Random();
        for(int i=0;i<sizeX*sizeY*3;i++){
            int rand = r.nextInt(4);
            if(rand==0){
                this.move('U');
            }else if(rand==1){
                this.move('D');
            }else if(rand==2){
                this.move('L');
            }else{
                this.move('R');
            }
        }
    }

    public void readFromArray(int[][] arr){
        board = new int[sizeX][sizeY];
        for(int i=0;i<sizeX;i++){
            for(int j=0;j<sizeY;j++){
                board[i][j]=arr[i][j];
            }
        }
    }
    public void setNumberOfMoves(int moves){
        numberOfMoves=moves;
    }
    public int getNumberOfMoves(){
        return numberOfMoves;
    }
    /**
     * Returns cell content
     */
    public int cell(int x, int y) {
        if (x <= sizeX && y <= sizeY) {
            return board[x][y];
        } else {
            System.out.println("Invalid indexes. Terminating.");
            System.exit(0);
            return 0;
        }
    }

    /**
     * Makes move in given direction
     */
    public boolean move(char direction) {
        int emptyCelli = 0, emptyCellj = 0, iFactor = 0, jFactor = 0;
        if (direction == 'Q')
            System.exit(0); // If Q is inputted exits the program
        /* Finds the empty cell */
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (board[i][j] == 0) {
                    emptyCelli = i;
                    emptyCellj = j;
                }
            }
        }
        int temp = board[emptyCelli][emptyCellj];

        switch (direction) {
            /* Checks if the move is valid if so changes i or j factors */
            case 'U':
            case 'u':
                if (emptyCelli == 0 || board[emptyCelli - 1][emptyCellj] == 0)
                    return false;
                else
                    iFactor = -1;
                theLastMove = 'U';
                break;
            case 'D':
            case 'd':
                if (emptyCelli == sizeX - 1 || board[emptyCelli + 1][emptyCellj] == 0)
                    return false;
                else
                    iFactor = 1;
                theLastMove = 'D';
                break;
            case 'R':
            case 'r':
                if (emptyCellj == sizeY - 1 || board[emptyCelli][emptyCellj + 1] == 0)
                    return false;
                else
                    jFactor = 1;
                theLastMove = 'R';
                break;
            case 'L':
            case 'l':
                if (emptyCellj == 0 || board[emptyCelli][emptyCellj - 1] == 0)
                    return false;
                else
                    jFactor = -1;
                theLastMove = 'L';
                break;
            default:
                return false;
        }
        /* Replaces cells */
        board[emptyCelli][emptyCellj] = board[emptyCelli + iFactor][emptyCellj + jFactor];
        board[emptyCelli + iFactor][emptyCellj + jFactor] = temp;
        return true;

    }
}
