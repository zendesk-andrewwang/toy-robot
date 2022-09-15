package com.zendesk;

import java.util.ArrayList;
import java.util.List;

public class Robot {
  private static final int HEIGHT_LIMIT = 4;
  private Position position;
  private Direction direction;

  private RotorState rotorState;

  private boolean isDamaged;

  public Robot(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
    this.isDamaged = false;
    this.rotorState = RotorState.CLOSED;
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

  public RotorState getRotorState() {
    return rotorState;
  }

  public void setRotorState(RotorState rotorState) {
    this.rotorState = rotorState;
  }

  public boolean isDamaged() {
    return isDamaged;
  }

  public void setDamaged(boolean damaged) {
    isDamaged = damaged;
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
    return this.position.getIndexX() + "," + this.position.getIndexY() + "," + this.position.getIndexZ() + "," + this.direction.name() + "," + this.rotorState.name();
  }

  public Position scanNextMove() {
    return switch (direction) {
      case NORTH -> new Position(position.getIndexX(), position.getIndexY() + 1, position.getIndexZ());
      case SOUTH -> new Position(position.getIndexX(), position.getIndexY() - 1, position.getIndexZ());
      case EAST -> new Position(position.getIndexX() + 1, position.getIndexY(), position.getIndexZ());
      case WEST -> new Position(position.getIndexX() - 1, position.getIndexY(), position.getIndexZ());
      default -> position; //fixme: should throw exception
    };
  }

  public void stopRotor() {
    this.rotorState = RotorState.CLOSED;
    this.position.setIndexZ(0);
    // TODO: check obstacle
  }

  public void up() {
    if(rotorState == RotorState.OPEN) {
      var indexZ = this.position.getIndexZ();
      if(indexZ < HEIGHT_LIMIT) {
        this.position.setIndexZ(indexZ + 1);
      }
    }
  }

  public void down() {
    if(rotorState == RotorState.OPEN) {
      var indexZ = this.position.getIndexZ();
      if(indexZ > 0) {
        this.position.setIndexZ(indexZ - 1);
      }
    }
  }
}
