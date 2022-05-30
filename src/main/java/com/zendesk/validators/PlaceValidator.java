package com.zendesk.validators;

import com.zendesk.Direction;

public class PlaceValidator implements Validator {
    public static boolean validate(String[] commands) {
        if (commands.length == 2 && commands[1] != null && commands[1].split(",").length == 3) {
            var placeArgs = commands[1].split(",");
            var direction = Direction.getValue(placeArgs[2]);
            if (direction != null) {
                return true;
            } else {
                System.out.println("INVALID DIRECTION, WILL BE IGNORED.");
            }
        } else {
            //invalid
            System.out.println("INVALID INPUT, WILL BE IGNORED.");
        }
        return false;
    }
}
