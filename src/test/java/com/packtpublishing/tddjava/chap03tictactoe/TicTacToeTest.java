package com.packtpublishing.tddjava.chap03tictactoe;

import com.packtpublishing.tddjava.chap03tictactoe.exceptions.PositionNotOnBoardException;
import com.packtpublishing.tddjava.chap03tictactoe.exceptions.PositionTakenException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeTest {

    public static TicTacToe ticTacToe;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void init(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void givenAGameWhenPlacingXPositionOutOfTheBoardThenPositionOutOfBoardExceptionIsThrown(){
        exception.expect(PositionNotOnBoardException.class);
        ticTacToe.play(3, 0);
    }

    @Test
    public void givenAGameWhenPlacingYPositionOutOfTheBoardThenPositionOutOfBoardExceptionIsThrown(){
        exception.expect(PositionNotOnBoardException.class);
        ticTacToe.play(0, 3);
    }

    @Test
    public void givenAGameWhenMovingToAnOccupiedPositionThenPositionTakenExceptionIsThrown(){
        ticTacToe.play(2, 1);
        exception.expect(PositionTakenException.class);
        ticTacToe.play(2, 1);
    }


}
