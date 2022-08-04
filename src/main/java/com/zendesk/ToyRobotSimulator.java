package com.zendesk;

import com.zendesk.exception.InvalidPositionException;
import com.zendesk.validators.PlaceValidator;
import java.util.Scanner;

public class ToyRobotSimulator {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    final var board = new Board();

    while (true) {
      var input = scanner.nextLine();
      var commands = input.split(" ");
      System.out.println("input: " + input);
      try {
        switch (commands[0]) {
          case "PLACE":
            if (PlaceValidator.validate(commands)) {
              var placeArgs = commands[1].split(",");
              var position = new Position(Integer.parseInt(placeArgs[0]), Integer.parseInt(placeArgs[1]));
              board.placeRobot(new Robot(position, Direction.getValue(placeArgs[2])));
            }
            break;
          case "MOVE":
            var newPosition = board.getRobot().scanNextMove();
            board.moveRobot(newPosition);
            break;
          case "LEFT":
            board.getRobot().turnLeft();
            break;
          case "RIGHT":
            board.getRobot().turnRight();
            break;
          case "REPORT":
            board.report();
            break;
          case "STOP":
            return;
          default:
            //invalid
            System.out.println("INVALID INPUT, WILL BE IGNORED.");
        }
      } catch (InvalidPositionException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
