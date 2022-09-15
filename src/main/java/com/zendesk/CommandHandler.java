package com.zendesk;

import com.zendesk.exception.InvalidPositionException;
import com.zendesk.validators.PlaceValidator;

public class CommandHandler {
    public static void handleInput(String[] commands, Board board) throws InvalidPositionException {
        if(board.getRobot() == null && !("PLACE".equals(commands[0]))) {
            System.out.println("Ignoring commands... Robot not placed");
            return;
        }
        switch (commands[0]) {
            case "PLACE":
                if (PlaceValidator.validate(commands)) {
                    var placeArgs = commands[1].split(",");
                    var position = new Position(Integer.parseInt(placeArgs[0]), Integer.parseInt(placeArgs[1]), 0);
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
                System.out.println(board.report());
                break;
            case "STOP":
                return;
            case "ROTOR-START":
                board.getRobot().setRotorState(RotorState.OPEN);
                break;
            case "ROTOR-STOP":
                board.getRobot().stopRotor();
                break;
            case "UP":
                board.getRobot().up();
                break;
            case "DOWN":
                board.getRobot().down();
                break;
            default:
                //invalid
                System.out.println("INVALID INPUT, WILL BE IGNORED.");
        }
    }
}
