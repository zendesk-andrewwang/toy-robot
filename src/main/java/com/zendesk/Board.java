package com.zendesk;

import java.util.HashMap;

public class Board {

  final static int sideLength = 5;

  private HashMap<Position, Robot> grid;
  private Robot robot;

  public Board() {
    this.grid = new HashMap<>();
    for (int i = 0; i < sideLength; i++) {
      for (int j = 0; j < sideLength; j++) {
        grid.put(new Position(i, j), null);
      }
    }
  }

  public boolean verifyPlacement(Position position) {
    if (grid.containsKey(position)) {
      return true;
    }
    return false;
  }

  public void placeRobot(Robot robot) {
    this.robot = robot;
    grid.put(robot.getPosition(), robot);
  }

  public void moveRobot(Position newPosition) {
    grid.put(robot.getPosition(), null);
    grid.put(newPosition, robot);
    robot.setPosition(newPosition);
  }

  public Robot getRobot() { return this.robot; }

  public void report() {
    grid.keySet().forEach(position -> {
      if(grid.get(position) == robot) {
        System.out.printf("Output: %d, %d, %s%n", position.getIndexX(), position.getIndexY(), robot.getDirection());
      }
    });
  }
}
