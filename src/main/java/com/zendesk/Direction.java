package com.zendesk;

public enum Direction {
  NORTH,
  EAST,
  SOUTH,
  WEST;

  public static Direction getValue(String val) {
    for (Direction d : Direction.values()) {
      if (d.name().equals(val)) {
        return d;
      }
    }
    return null;
  }
}
