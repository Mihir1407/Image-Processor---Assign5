package View;

public interface IView {
  /**
   * Displays a message to the user.
   *
   * @param message Message to be displayed.
   */
  void showMessage(String message);

  /**
   * Get the next command input from the user.
   *
   * @return User's command input.
   */
  String getInput();

  /**
   * Display an error message to the user.
   *
   * @param errorMessage Error message to be displayed.
   */
  void showError(String errorMessage);
}