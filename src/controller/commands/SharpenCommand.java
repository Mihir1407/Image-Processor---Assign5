package controller.commands;

import java.util.Optional;

import model.IImageModel;

/**
 * Represents a command to apply a sharpening effect to an image.
 * The sharpening process uses the provided image name and destination name,
 * and relies on the image model to handle the actual transformation.
 */
public class SharpenCommand extends AbstractSplitCommand {

  /**
   * Constructs a SharpenCommand with the specified source image name,
   * destination image name, and a reference to the model.
   *
   * @param imageName       The name of the source image to be sharpened.
   * @param destImageName   The name where the sharpened image will be stored.
   * @param model           A reference to the image model.
   * @param splitPercentage An optional split percentage for sepia effect.
   */
  public SharpenCommand(String imageName, String destImageName, IImageModel model,
                        Optional<Double> splitPercentage) {
    super(imageName, destImageName, model, splitPercentage);
  }

  /**
   * Processes the image by directing the model to sharpen the image.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.sharpen(this.imageName, this.destImageName, this.splitPercentage);
  }
}