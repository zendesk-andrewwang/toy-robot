package com.zendesk;

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
      switch (commands[0]) {
        case "PLACE":
          if (PlaceValidator.validate(commands)) {
            var placeArgs = commands[1].split(",");
            var position = new Position(Integer.parseInt(placeArgs[0]), Integer.parseInt(placeArgs[1]));
            if (board.verifyPlacement(position)) {
              //valid direction, check if the placement indexes are valid
                board.placeRobot(new Robot(position, Direction.getValue(placeArgs[2])));
            }
          } else {
            System.out.println("INVALID POSITION, WILL BE IGNORED.");
          }
          break;
        case "MOVE":
          var newPosition = board.getRobot().scanNextMove();
          if(board.verifyPlacement(newPosition)) {
            board.moveRobot(newPosition);
          } else {
            //ignore since out of the board
            System.out.println("Invalid move, will be ignored");
          }
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
        default:
          //invalid
          System.out.println("INVALID INPUT, WILL BE IGNORED.");
      }
    }
  }
}
