package com.example.npuzzle;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class AbstractBoard {
    static private int numberOfBoards = 0;
    protected char theLastMove = 'S';
    protected int numberOfMoves = 0;
    protected int sizeX = 0, sizeY = 0;

    AbstractBoard() {
        numberOfBoards++;
    }

    /**
     * Reads the board from an array
     */
    public abstract void readFromArray(int[][] arr);

    /**
     * Makes a move on given direction
     * @param direction 'U', 'D', 'R' or 'L' for wanted direction
     * @return If moves succesful
     */
    public abstract boolean move(char direction);

    /**
     * Reads the board from given text file
     * @param fileName Filename with extention
     * @return
     */

    /**
     * Returns cell content for given x and y values
     * @param x X coordinate
     * @param y Y coordinate
     * @return Cell content
     */
    public abstract int cell(int x, int y);

    /**
     * Checks if the given two boards are sequential
     * @param board2 Board to compare with
     * @return  If boards are sequential returns true else false
     */
    public boolean seqCheck(AbstractBoard board2){
        int numberOfDifferences=0;
        int[] diffX = new int[2];
        int[] diffY = new int[2];
        if(sizeX!=board2.sizeX | sizeY!=board2.sizeY){
            return false;
        }
        for(int i=0;i<sizeX;i++){
            for(int j=0;j<sizeY;j++){
                if(cell(i, j)!=board2.cell(i,j)){
                    if(numberOfDifferences<2){
                        diffX[numberOfDifferences]=i;
                        diffY[numberOfDifferences]=j;
                    }
                    numberOfDifferences++;
                }
            }
        }
        if(numberOfDifferences!=2){
            return false;
        }
        if(Math.abs(diffX[0]-diffX[1])<=1 && Math.abs(diffY[0]-diffY[1])<=1){
            return true;
        }
        return false;

    }

    /**
     * Checks if given board is the solution
     * @return returns if board is the solution
     */
    public boolean isSolved() {
        BoardArray2D solution = new BoardArray2D();
        solution.board = new int[sizeX][sizeY];
        int count = 1;
        solution.setSize(sizeX, sizeY);
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                solution.board[i][j] = count;
                count++;
            }
        }
        solution.board[sizeX - 1][sizeY - 1] = 0;
        return this.Equals(solution);
    }

    /**
     * Writes the board to given text file
     * @param fileName Filename with .txt extention
     */
    public void writeToFile(String fileName) {
        try {
            PrintWriter out = new PrintWriter(fileName);
            out.print(toString());
            out.close();
        } catch (Exception e) {
            System.out.println("Error occurred while writing to file.");
        }

    }

    /**
     * Produces board as string
     */
    public String toString() {
        String boardStr = new String();
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (cell(i, j) == 0) {
                    boardStr = boardStr.concat("bb ");
                } else if (cell(i, j) < 10) {
                    boardStr = boardStr.concat("0").concat(Integer.toString(cell(i, j))).concat(" ");
                } else {
                    boardStr = boardStr.concat(Integer.toString(cell(i, j))).concat(" ");
                }

            }
            boardStr = boardStr.concat("\n");
        }
        return boardStr;
    }

    /**
     * Checks if two boards are same
     * @param board2  Board to compare
     * @return  Result of comparison
     */
    public boolean Equals(AbstractBoard board2) {
        if (sizeX != board2.sizeX | sizeY != board2.sizeY) {
            return false;
        } else {
            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    if (cell(i, j) != board2.cell(i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Sets the size to given x and y parameters
     * @param x X coordinate
     * @param y y coordinate
     */
    public void setSize(int x, int y) {
        if (x<3){
            sizeX=3;
        }else {
        sizeX = x;}
        if (y<3){
            sizeY=3;
        }else {
            sizeY = y;}
    }

    /**
     * Returns the number of boards
     * @return  Number of the boards created
     */
    public static int numberOfBoards() {
        return numberOfBoards;
    }

    /**
     * Returns the number of moves
     * @return  Number of the moves done
     */
    public int numberOfMoves() {
        return numberOfMoves;
    }

    /**
     * Returns the last move
     * @return  The last move
     */
    public char lastMove() {
        return theLastMove;
    }
}
