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
        CommandHandler.handleInput(commands, board);
      } catch (InvalidPositionException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
