package controller.commands;

import model.IImageModel;

/**
 * Represents a command that extracts and processes
 * the red component of an image.
 * This command uses the underlying image model to extract the red component
 * of the source image and saves the resultant image with a new name.
 */
public class RedComponentCommand extends AbstractTransformCommand {

  /**
   * Constructs a RedComponentCommand with the provided source
   * image name, destination image name, and a reference to the model.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The name of the destination image.
   * @param model         A reference to the image model.
   */
  public RedComponentCommand(String imageName,
                             String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  /**
   * Processes the image by directing the model to extract the red component of the image.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.redComponent(this.imageName, this.destImageName);
  }
}