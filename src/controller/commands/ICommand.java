package controller.commands;

/**
 * Represents a command in the image processing application.
 * Commands that implement this interface are responsible
 * for carrying out specific image processing operations.
 */
public interface ICommand {

  /**
   * Executes the image processing command.
   * This method attempts to process the image and returns a boolean value
   * indicating the success or failure of the operation.
   *
   * @return true if the image processing was successful, otherwise false.
   */
  boolean execute();
}