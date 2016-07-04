package com.packtpublishing.tddjava.chap03tictactoe;

import com.packtpublishing.tddjava.chap03tictactoe.exceptions.PositionNotOnBoardException;
import com.packtpublishing.tddjava.chap03tictactoe.exceptions.PositionTakenException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void givenAGameWhenMakingFirstMoveThenPlayerXFirstPlays(){
        assertEquals(Player.X, ticTacToe.getNextPlayer());
    }

    @Test
    public void givenAGameWhenMakingSecondMoveThenPlayerOPlays(){
        ticTacToe.play(0, 0);
        assertEquals(Player.O, ticTacToe.getNextPlayer());
    }

    @Test
    public void givenAGameWhenPlayerOPlaysThenPlayerXPlaysNext(){
        ticTacToe.play(0, 0);
        assertEquals(Player.O, ticTacToe.getNextPlayer());
        ticTacToe.play(1, 0);
        assertEquals(Player.X, ticTacToe.getNextPlayer());
    }



}
