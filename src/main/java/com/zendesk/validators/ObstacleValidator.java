package com.zendesk.validators;

public class ObstacleValidator implements Validator{
  public static boolean validate(String[] commands) {
    //OBSTACLE X,Y
    if (commands.length == 2 && commands[1] != null && commands[1].split(",").length == 2) {
      return true;
    } else {
      //invalid
      System.out.println("INVALID INPUT, WILL BE IGNORED.");
      return false;
    }
  }
}
