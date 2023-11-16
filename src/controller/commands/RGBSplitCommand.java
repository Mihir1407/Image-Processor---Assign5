package controller.commands;

import model.IImageModel;

/**
 * Represents a command that splits an RGB image into
 * red, green, and blue components.
 * This command encapsulates the logic required to extract RGB components
 * of an image.
 */
public class RGBSplitCommand extends AbstractCombineSplitCommand {

  /**
   * Constructs an RGBSplitCommand with the provided image names for
   * the destination RGB channels and a reference to the model.
   *
   * @param imageName      The name of the source RGB image to be split.
   * @param redImageName   Destination image for the red component.
   * @param greenImageName Destination image for the green component.
   * @param blueImageName  Destination image for the blue component.
   * @param model          A reference to the image model.
   */
  public RGBSplitCommand(String imageName, String redImageName,
                         String greenImageName, String blueImageName, IImageModel model) {
    super(imageName, redImageName, greenImageName, blueImageName, model);
  }

  /**
   * Processes the image by directing the model to split the image.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.rgbSplit(this.imageName, this.redImageName,
            this.greenImageName, this.blueImageName);
  }
}
