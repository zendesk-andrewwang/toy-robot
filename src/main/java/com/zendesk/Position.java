package com.zendesk;

import java.util.Objects;

public class Position {
  private int indexX;
  private int indexY;
  private int indexZ;

  public Position(int indexX, int indexY, int indexZ) {
    this.indexX = indexX;
    this.indexY = indexY;
    this.indexZ = indexZ;
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

  public int getIndexZ() {
    return indexZ;
  }

  public void setIndexZ(int indexZ) {
    this.indexZ = indexZ;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Position position = (Position) o;

    if (indexX != position.indexX) return false;
    if (indexY != position.indexY) return false;
    return indexZ == position.indexZ;
  }

  @Override
  public int hashCode() {
    int result = indexX;
    result = 31 * result + indexY;
    result = 31 * result + indexZ;
    return result;
  }
}
