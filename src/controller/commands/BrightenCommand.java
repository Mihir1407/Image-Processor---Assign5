package controller.commands;

import model.IImageModel;

/**
 * Represents a command that brightens an image by a specified increment.
 * This command uses the underlying image model to brighten the source image
 * and saves the resultant brightened image with a new name.
 */
public class BrightenCommand extends AbstractTransformCommand {
  private final int increment;

  /**
   * Constructs a BrightenCommand with the provided brightening increment,
   * source image, destination image and model.
   *
   * @param increment     The amount by which the image should be brightened.
   * @param imageName     The name of the source image to be brightened.
   * @param destImageName The name of the destination image after brightening.
   * @param model         A reference to the image model.
   */
  public BrightenCommand(int increment, String imageName,
                         String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
    this.increment = increment;
  }

  /**
   * Processes the image by directing the model to brighten the image.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.brightenCommand(this.increment, this.imageName, this.destImageName);
  }
}
