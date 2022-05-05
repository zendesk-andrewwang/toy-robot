package com.zendesk;

import java.util.Objects;

public class Position {
  private int indexX;
  private int indexY;

  public Position(int indexX, int indexY) {
    this.indexX = indexX;
    this.indexY = indexY;
  }

  public int getIndexX() {
    return indexX;
  }

  public void setIndexX(int indexX) {
    this.indexX = indexX;
  }

  public int getIndexY() {
    return indexY;
  }

  public void setIndexY(int indexY) {
    this.indexY = indexY;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return indexX == position.indexX && indexY == position.indexY;
  }

  @Override
  public int hashCode() {
    return Objects.hash(indexX, indexY);
  }
}
