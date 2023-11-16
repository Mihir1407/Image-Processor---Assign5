package controller.commands;

import java.util.Optional;

import model.IImageModel;

/**
 * Represents a command to perform color correction on an image.
 * This command takes an image and produces a color-corrected version
 * of the image by adjusting color values.
 */
public class ColorCorrectCommand extends AbstractSplitCommand {


  /**
   * Constructs a new ColorCorrectCommand.
   *
   * @param imageName       The name of the source image.
   * @param destImageName   The name of the destination image.
   * @param model           A reference to the image model.
   * @param splitPercentage An optional split percentage for sepia effect.
   */
  public ColorCorrectCommand(String imageName, String destImageName, IImageModel model,
                             Optional<Double> splitPercentage) {
    super(imageName, destImageName, model, splitPercentage);
  }

  /**
   * Processes the image by directing the model to color correct the image.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.colorCorrect(this.imageName, this.destImageName, this.splitPercentage);
  }
}
