package com.zendesk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    private Robot subject;
    private Position position;

    @BeforeEach
    void setup() {
        position = new Position(0,0);
        subject = new Robot(position, Direction.NORTH);
    }
    @Test
    void toString_withPositionsSupplied() {
        assertEquals(subject.toString(), "0,0,NORTH");
    }

    void assertExpectedDirectionAndPosition(Direction direction) {
        assertEquals(subject.getDirection(), direction);
        assertEquals(subject.getPosition(), position);
    }
    @Test
    void turnLeft() {
        subject.turnLeft();
        assertExpectedDirectionAndPosition(Direction.WEST);
        subject.turnLeft();
        assertExpectedDirectionAndPosition(Direction.SOUTH);
        subject.turnLeft();
        assertExpectedDirectionAndPosition(Direction.EAST);
        subject.turnLeft();
        assertExpectedDirectionAndPosition(Direction.NORTH);
    }

    @Test
    void turnRight() {
        subject.turnRight();
        assertExpectedDirectionAndPosition(Direction.EAST);
        subject.turnRight();
        assertExpectedDirectionAndPosition(Direction.SOUTH);
        subject.turnRight();
        assertExpectedDirectionAndPosition(Direction.WEST);
        subject.turnRight();
        assertExpectedDirectionAndPosition(Direction.NORTH);
    }
}
