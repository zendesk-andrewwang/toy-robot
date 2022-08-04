package com.zendesk;

import java.util.ArrayList;
import java.util.List;

public class Robot {
  private Position position;
  private Direction direction;

  public Robot(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void turnLeft() {
    var directions = new ArrayList<>(List.of(Direction.values()));
    this.direction = Direction.values()[Math.floorMod((directions.indexOf(direction) - 1),Direction.values().length)];
  }

  public void turnRight() {
    var directions = new ArrayList<>(List.of(Direction.values()));
    this.direction = Direction.values()[Math.floorMod((directions.indexOf(direction) + 1),Direction.values().length)];
  }

  @Override
  public String toString() {
    return this.position.getIndexX() + "," + this.position.getIndexY() + "," + this.direction.name();
  }

  public Position scanNextMove() {
    return switch (direction) {
      case NORTH -> new Position(position.getIndexX(), position.getIndexY() + 1);
      case SOUTH -> new Position(position.getIndexX(), position.getIndexY() - 1);
      case EAST -> new Position(position.getIndexX() + 1, position.getIndexY());
      case WEST -> new Position(position.getIndexX() - 1, position.getIndexY());
      default -> position; //fixme: should throw exception
    };
  }
}
