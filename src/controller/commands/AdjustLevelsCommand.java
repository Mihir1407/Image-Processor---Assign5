package controller.commands;

import java.util.Optional;

import model.IImageModel;

/**
 * Represents a command to adjust levels in an image.
 * This command takes an image and produces a version of the image
 * with adjusted brightness, midtones, and white levels.
 */
public class AdjustLevelsCommand extends AbstractSplitCommand {

  /**
   * The adjustment value for brightness.
   */
  private final int b;

  /**
   * The adjustment value for midtones.
   */
  private final int m;

  /**
   * The adjustment value for white levels.
   */
  private final int w;


  /**
   * Constructs a new AdjustLevelsCommand.
   *
   * @param b               The adjustment value for brightness.
   * @param m               The adjustment value for midtones.
   * @param w               The adjustment value for white levels.
   * @param imageName       The name of the source image.
   * @param destImageName   The name of the destination image.
   * @param model           A reference to the image model.
   * @param splitPercentage An optional split percentage for sepia effect.*
   */
  public AdjustLevelsCommand(int b, int m, int w, String imageName,
                             String destImageName, IImageModel model,
                             Optional<Double> splitPercentage) {
    super(imageName, destImageName, model, splitPercentage);
    this.b = b;
    this.m = m;
    this.w = w;
  }

  /**
   * Processes the image by directing the model to adjust the levels of the image.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.adjustLevels(this.imageName, this.destImageName, this.b, this.m, this.w,
            this.splitPercentage);
  }
}
