package com.zendesk;

import com.zendesk.exception.CrushException;
import com.zendesk.exception.InvalidPositionException;
import java.util.HashMap;

public class Board {

  final static int sideLength = 5;

  private HashMap<Position, PlaceableEntity> grid;
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
    return isPositionOnBoard(position) && grid.get(position) == null;
  }

  public boolean isPositionOnBoard(Position position) {
    return grid.containsKey(position);
  }

  public void placeEntity(PlaceableEntity entity) throws InvalidPositionException {
    if (verifyPlacement(entity.getPosition())) {
      if(entity instanceof Robot robotEntity) {
        this.robot = robotEntity;
      }
      grid.put(entity.getPosition(), entity);
    } else {
      throw new InvalidPositionException("INVALID POSITION, WILL BE IGNORED.");
    }
  }

  public void moveRobot(Position newPosition) throws InvalidPositionException,CrushException {
    if (isPositionOnBoard(newPosition)) {
      if(!checkObstacle(newPosition)) {
        grid.put(robot.getPosition(), null);
        grid.put(newPosition, robot);
        robot.setPosition(newPosition);
      } else {
        throw new CrushException("CRUSHED!!!!!!!!");
      }
    } else {
      throw new InvalidPositionException("INVALID POSITION, WILL BE IGNORED.");
    }
  }

  private boolean checkObstacle(Position position) {
    return grid.get(position) instanceof Obstacle;
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
