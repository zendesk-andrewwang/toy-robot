package com.zendesk;

public enum Direction {
  NORTH,
  SOUTH,
  WEST,
  EAST;

  public static Direction getValue(String val) {
    for (Direction d : Direction.values()) {
      if (d.name().equals(val)) {
        return d;
      }
    }
    return null;
  }
}
