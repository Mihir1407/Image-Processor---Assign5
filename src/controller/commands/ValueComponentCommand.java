package controller.commands;

import java.util.Optional;

import model.IImageModel;

/**
 * Represents a command that extracts and processes
 * the value component of an image.
 * This command uses the underlying image model to extract the value component
 * of the source image and saves the resultant image with a new name.
 */
public class ValueComponentCommand extends AbstractSplitCommand {

  /**
   * Constructs a ValueComponentCommand with the provided source
   * image name, destination image name, and a reference to the model.
   *
   * @param imageName       The name of the source image.
   * @param destImageName   The name of the destination image.
   * @param model           A reference to the image model.
   * @param splitPercentage An optional split percentage for sepia effect.
   */
  public ValueComponentCommand(String imageName, String destImageName,
                               IImageModel model,
                               Optional<Double> splitPercentage) {
    super(imageName, destImageName, model, splitPercentage);
  }

  /**
   * Processes the image by directing the model to get the value component of the image.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.valueComponent(this.imageName, this.destImageName, this.splitPercentage);
  }
}