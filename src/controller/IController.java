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

  void runScript(String filePath);
}
