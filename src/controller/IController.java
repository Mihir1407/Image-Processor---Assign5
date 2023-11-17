package controller;

/**
 * Represents the interface for a controller in the MVC pattern.
 * The primary role of the controller is to handle user input and
 * manage interactions between the model and the view.
 */
public interface IController {

  /**
   * Initiates the execution of the controller logic.
   * This method serves as the starting point for the
   * controller's operations.
   */
  void execute();

  /**
   * Parses a script file and executes a list of commands.
   * This method allows batch processing of multiple commands.
   *
   * @param filePath Path to the script file containing a list of commands.
   */
  void runScript(String filePath);
}
