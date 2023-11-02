package controller.commands;

import model.IImageModel;

/**
 * Represents an abstract command for operations that involve
 * combining or splitting the RGB channels of an image.
 * This class provides the foundation for commands that
 * work with separate red, green, and blue channel images.
 */
abstract class AbstractCombineSplitCommand extends AbstractCommand {
  protected final String redImageName;
  protected final String greenImageName;
  protected final String blueImageName;

  /**
   * Constructs an AbstractCombineSplitCommand with the provided image names
   * and a reference to the model.
   *
   * @param imageName      The name of the original image.
   * @param redImageName   The name of the image representing the red channel.
   * @param greenImageName The name of the image representing the green channel.
   * @param blueImageName  The name of the image representing the blue channel.
   * @param model          A reference to the image model.
   */
  public AbstractCombineSplitCommand(String imageName, String redImageName, String greenImageName,
                                     String blueImageName, IImageModel model) {
    super(imageName, model);
    this.redImageName = redImageName;
    this.greenImageName = greenImageName;
    this.blueImageName = blueImageName;
  }
}
