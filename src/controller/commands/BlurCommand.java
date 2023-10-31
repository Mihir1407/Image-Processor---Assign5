package controller.commands;

import model.IImageModel;

/**
 * Represents a command that applies a blur effect to an image.
 * This command uses the underlying image model to blur the source image
 * and saves the resultant blurred image with a new name, as specified.
 */
public class BlurCommand extends AbstractTransformCommand {

  /**
   * Constructs a BlurCommand with the provided source
   * image name, destination image name, and a reference to the model.
   *
   * @param imageName     The name of the source image to be blurred.
   * @param destImageName The name of the destination image after blurring.
   * @param model         A reference to the image model.
   */
  public BlurCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  /**
   * Processes the image.
   * Derived classes should provide their specific image processing logic
   * by overriding this method.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.blur(this.imageName, this.destImageName);
  }
}