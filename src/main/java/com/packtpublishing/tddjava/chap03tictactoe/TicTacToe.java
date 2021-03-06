package com.packtpublishing.tddjava.chap03tictactoe;

import com.packtpublishing.tddjava.chap03tictactoe.exceptions.PositionNotOnBoardException;
import com.packtpublishing.tddjava.chap03tictactoe.exceptions.PositionTakenException;

public class TicTacToe {

    private static int BOARD_SIZE = 3;

    Player[][] board = new Player[BOARD_SIZE][BOARD_SIZE];
    public Player lastPlayer = Player.X;

    public void play(int xPosition, int yPosition) {
        checkPositionIsOnBoard("X-position", xPosition);
        checkPositionIsOnBoard("Y-position", yPosition);
        checkPositionIsNotTaken(xPosition, yPosition);

        updateBoardCell(xPosition, yPosition);

        nextPlayer();

        printBoard();
    }

    private void updateBoardCell(int xPosition, int yPosition) {
        board[xPosition][yPosition] = lastPlayer;
    }

    private void printBoard() {
        StringBuilder sb = new StringBuilder();
        for(int xpos = 0; xpos < BOARD_SIZE; xpos++) {
            for (int ypos = 0; ypos < BOARD_SIZE; ypos++) {
                sb.append(board[xpos][ypos] + "  ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private Player nextPlayer() {
      if(lastPlayer == Player.X){
            lastPlayer = Player.O;
        } else {
            lastPlayer = Player.X;
        }
        return lastPlayer;
    }

    private void checkPositionIsNotTaken(int xPosition, int yPosition) {
        if(board[xPosition][yPosition] != null){
            throw new PositionTakenException(xPosition, yPosition);
        }
    }

    private void checkPositionIsOnBoard(String positionName, int position) {
        if(position < 0 || position >= BOARD_SIZE) {
            throw new PositionNotOnBoardException(positionName, position);
        }
    }

    public Player getNextPlayer() {
        return lastPlayer;
    }
}
