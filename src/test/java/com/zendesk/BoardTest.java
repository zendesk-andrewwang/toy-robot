package com.zendesk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BoardTest {

    private Board board;
    @BeforeEach
    void setup() {
        board = new Board();
    }
    @Test
    void report_NoRobotInGrid(){
        assertNull(board.report());
    }

    @Test
    void report_RobotInGrid() {
        board.placeRobot(new Robot(new Position(0,0), Direction.NORTH));
        assertEquals(board.report(), "Output: 0,0,NORTH");
    }
}
