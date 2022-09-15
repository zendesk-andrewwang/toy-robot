package com.zendesk;

import com.zendesk.exception.InvalidPositionException;
import java.util.HashMap;

public class Board {

  final static int sideLength = 5;

  private HashMap<Position, Robot> grid;
  private Robot robot;

  public Board() {
    this.grid = new HashMap<>();
    for (int i = 0; i < sideLength; i++) {
      for (int j = 0; j < sideLength; j++) {
        grid.put(new Position(i, j, 0), null);
      }
    }
  }

  public boolean verifyPlacement(Position position) {
    return grid.containsKey(position);
  }

  public void placeRobot(Robot robot) throws InvalidPositionException {
    if (verifyPlacement(robot.getPosition())) {
      this.robot = robot;
      grid.put(robot.getPosition(), robot);
    } else {
      throw new InvalidPositionException("INVALID POSITION, WILL BE IGNORED.");
    }
  }

  public void moveRobot(Position newPosition) throws InvalidPositionException {
    if (verifyPlacement(newPosition)) {
      grid.put(robot.getPosition(), null);
      grid.put(newPosition, robot);
      robot.setPosition(newPosition);
    } else {
      throw new InvalidPositionException("INVALID POSITION, WILL BE IGNORED.");
    }
  }

  public Robot getRobot() {
    return this.robot;
  }

  public String report() {
    for (var robot : grid.values()) {
      if (robot != null) {
        return "Output: " + robot;
      }
    }
    return null;
  }
}
