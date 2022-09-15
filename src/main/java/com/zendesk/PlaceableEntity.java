package com.zendesk;

public class PlaceableEntity {
  public Position position;

  public PlaceableEntity(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }
}
