package com.zendesk;

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

  @Override
  public String toString() {
    return this.position.getIndexX() + "," + this.position.getIndexY() + "," + this.direction.name();
  }
}
