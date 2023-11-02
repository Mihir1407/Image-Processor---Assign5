package view;

import java.util.Scanner;

/**
 * Represents a console-based view in the MVC pattern.
 * Implements the IView interface to provide methods
 * for displaying messages, getting user input, and showing error messages.
 */
public class ConsoleView implements IView {

  /**
   * Scanner object to read user input from the console.
   */
  private final Scanner scanner;

  /**
   * Initializes a new instance of the ConsoleView with a
   * Scanner to read from the console.
   */
  public ConsoleView() {
    this.scanner = new Scanner(System.in);
  }

  /**
   * Displays a message to the user through the console.
   *
   * @param message Message to be displayed.
   */
  @Override
  public void showMessage(String message) {
    System.out.println(message);
  }

  /**
   * Gets the next command input from the user through the console.
   *
   * @return User's command input.
   */
  @Override
  public String getInput() {
    return scanner.nextLine().trim();
  }

  /**
   * Displays an error message to the user through the console.
   *
   * @param errorMessage Error message to be displayed.
   */
  @Override
  public void showError(String errorMessage) {
    System.err.println("ERROR: " + errorMessage);
  }
}

