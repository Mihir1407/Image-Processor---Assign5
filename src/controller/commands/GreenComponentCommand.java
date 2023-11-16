package controller.commands;

import model.IImageModel;

/**
 * Represents a command that extracts and processes
 * the green component of an image.
 * This command uses the underlying image model to extract the green component
 * of the source image and saves the resultant image with a new name.
 */
public class GreenComponentCommand extends AbstractTransformCommand {

  /**
   * Constructs a GreenComponentCommand with the provided source
   * image name, destination image name, and a reference to the model.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The name of the destination image.
   * @param model         A reference to the image model.
   */
  public GreenComponentCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  /**
   * Processes the image by directing the model to extract the green component of the image.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.greenComponent(this.imageName, this.destImageName);
  }
}