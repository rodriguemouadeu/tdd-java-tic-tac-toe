package com.packtpublishing.tddjava.chap03tictactoe.exceptions;

/**
 * Created by rodrigue on 16-07-04.
 */
public class PositionTakenException extends RuntimeException {

    public PositionTakenException(int xPosition, int yPosition){
        super(String.format("Position {%s, %s} already taken !", xPosition, yPosition));
    }
}
