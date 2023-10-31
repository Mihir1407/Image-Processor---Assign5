package controller.commands;

import model.IImageModel;

/**
 * Represents an abstract command that operates on an image within a model.
 * This class provides the foundational structure for commands that need to
 * process an image.
 */
abstract class AbstractCommand implements ICommand {
  protected final IImageModel model;
  protected final String imageName;

  /**
   * Constructs an AbstractCommand with the provided image name
   * and a reference to the model.
   *
   * @param imageName The name of the image to be processed.
   * @param model     A reference to the image model.
   */
  public AbstractCommand(String imageName, IImageModel model) {
    this.model = model;
    this.imageName = imageName;
  }

  /**
   * Executes the image processing command.
   * This method attempts to process the image and returns a boolean value
   * indicating the success or failure of the operation.
   *
   * @return true if the image processing was successful, otherwise false.
   */
  @Override
  public boolean execute() {
    boolean success = true;
    try {
      processImage();
    } catch (Exception e) {
      success = false;
    }
    return success;
  }

  /**
   * Processes the image.
   * Derived classes should provide their specific image processing logic
   * by overriding this method.
   *
   * @throws Exception if an error occurs during image processing.
   */
  protected abstract void processImage() throws Exception;
}
