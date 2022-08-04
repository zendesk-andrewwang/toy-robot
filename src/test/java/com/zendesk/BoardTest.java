package com.zendesk;

import com.zendesk.exception.InvalidPositionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BoardTest {

  private Board board;

  @BeforeEach
  void setup() {
    board = new Board();
  }

  @Test
  void report_NoRobotInGrid() {
    assertNull(board.report());
  }

  @Test
  void report_RobotInGrid() {
    try {
      board.placeRobot(new Robot(new Position(0, 0), Direction.NORTH));
      assertEquals(board.report(), "Output: 0,0,NORTH");
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  void report_RobotOutOfGrid() {
    Throwable exception = assertThrows(InvalidPositionException.class,
        () -> board.placeRobot(new Robot(new Position(-1, 0), Direction.NORTH)));
    assertEquals("INVALID POSITION, WILL BE IGNORED.", exception.getMessage());
  }

  @Test
  void verifyPlacement() {
    final var validPosition = new Position(0, 0);
    final var invalidPosition = new Position(-1, -1);

    assertTrue(board.verifyPlacement(validPosition));
    assertFalse(board.verifyPlacement(invalidPosition));
  }

  @Test
  void moveRobot_validMovement() {
    //todo: place - move - get
  }

  @Test
  void moveRobot_invalidMovement() {
    //todo: should throw exception when the movement is invalid.
  }
}
