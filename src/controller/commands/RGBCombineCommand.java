package controller.commands;

import model.IImageModel;

/**
 * Represents a command that combines separate red, green, and blue
 * components into a single RGB image.
 * This command encapsulates the logic required to merge the RGB
 * components of an image from individual color channels.
 */
public class RGBCombineCommand extends AbstractCombineSplitCommand {

  /**
   * Constructs an RGBCombineCommand with the provided image
   * names for the RGB channels and a reference to the model.
   *
   * @param ImageName      The name of the combined RGB image.
   * @param redImageName   The name of the source image for the red component.
   * @param greenImageName The name of the source image for the green component.
   * @param blueImageName  The name of the source image for the blue component.
   * @param model          A reference to the image model.
   */
  public RGBCombineCommand(String ImageName, String redImageName, String greenImageName,
                           String blueImageName, IImageModel model) {
    super(ImageName, redImageName, greenImageName, blueImageName, model);
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
    this.model.rgbCombine(this.imageName, this.redImageName,
            this.greenImageName, this.blueImageName);
  }
}
