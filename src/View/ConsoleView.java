package View;

import java.util.Scanner;

public class ConsoleView implements IView {
  private final Scanner scanner;

  public ConsoleView() {
    this.scanner = new Scanner(System.in);
  }

  @Override
  public void showMessage(String message) {
    System.out.println(message);
  }

  @Override
  public String getInput() {
    return scanner.nextLine().trim();
  }

  @Override
  public void showError(String errorMessage) {
    System.err.println("ERROR: " + errorMessage);
  }
}