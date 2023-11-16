package controller.commands;

import model.IImageModel;

/**
 * Represents a command to apply a horizontal flip transformation on an image.
 * This command takes an image and produces a horizontally flipped version
 * of the image.
 */
public class HorizontalFlipCommand extends AbstractTransformCommand {

  /**
   * Constructs a new HorizontalFlipCommand.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The name of the destination image.
   * @param model         A reference to the image model.
   */
  public HorizontalFlipCommand(String imageName,
                               String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  /**
   * Processes the image by directing the model to horizontally flip the image.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.horizontalFlip(this.imageName, this.destImageName);
  }
}