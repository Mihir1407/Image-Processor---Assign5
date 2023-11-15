package controller.commands;

import model.IImageModel;
import java.util.Optional;
/**
 * Represents a command that produces a sepia-toned version of an image.
 * This command uses the underlying image model to apply the sepia tone
 * to the source image and saves the resultant image with a new name.
 */
public class SepiaCommand extends AbstractTransformCommand {
  private final Optional<Integer> splitPercentage;

  /**
   * Constructs a SepiaCommand with the provided source
   * image name, destination image name, and a reference to the model.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The name of the destination image.
   * @param model         A reference to the image model.
   */
  public SepiaCommand(String imageName, String destImageName, IImageModel model,
                      Optional<Integer> splitPercentage) {
    super(imageName, destImageName, model);
    this.splitPercentage = splitPercentage;
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
    this.model.sepia(this.imageName, this.destImageName, this.splitPercentage);
  }
}
