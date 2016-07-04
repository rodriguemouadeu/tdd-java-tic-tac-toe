package com.packtpublishing.tddjava.chap03tictactoe.exceptions;

/**
 * Created by rodrigue on 16-07-04.
 */
public class PositionNotOnBoardException extends RuntimeException {
    public PositionNotOnBoardException(String positionName, int position){
        super(positionName + "'s value '" + position + "' is out of bounds !" );
    }
}
