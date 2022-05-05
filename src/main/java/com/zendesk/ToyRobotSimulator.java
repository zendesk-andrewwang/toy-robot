package com.zendesk;

import java.util.Scanner;

public class ToyRobotSimulator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final var board = new Board();

    while (true) {
      var input = scanner.nextLine();
      var commands = input.split(" ");

      switch (commands[0]) {
        case "PLACE":
          if (commands.length == 2 && commands[1] != null && commands[1].split(",").length == 3) {
            var placeArgs = commands[1].split(",");
            var direction = Direction.getValue(placeArgs[2]);
            var position = new Position(Integer.parseInt(placeArgs[0]),
                Integer.parseInt(placeArgs[1]));
            if (direction != null && board.verifyPlacement(position)) {
              //valid direction, check if the placement indexes are valid
                board.placeRobot(new Robot(position, direction));

            } else {
              System.out.println("INVALID DIRECTION, WILL BE IGNORED.");
            }
          } else {
            //invalid
            System.out.println("INVALID INPUT, WILL BE IGNORED.");
          }
          break;
        case "MOVE":
          break;
        case "LEFT":
          break;
        case "RIGHT":
          break;
        case "REPORT":
          board.report();
          break;
        default:
          //invalid
          System.out.println("INVALID INPUT, WILL BE IGNORED.");
      }
    }
  }
}
