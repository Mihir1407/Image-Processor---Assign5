package controller.commands;

import java.util.Optional;

import model.IImageModel;

/**
 * Represents an abstract command that provides the base functionality for
 * transforming images with an optional split functionality.
 * This class extends AbstractTransformCommand and adds support for an optional
 * split percentage.
 */
public abstract class AbstractSplitCommand extends AbstractTransformCommand {
  protected final Optional<Double> splitPercentage;

  /**
   * Constructs an AbstractSplitCommand with the provided source
   * image name, destination image name, a reference to the model, and an
   * optional split percentage.
   *
   * @param imageName       The name of the source image to be transformed.
   * @param destImageName   The name of the transformed destination image.
   * @param model           A reference to the image model.
   * @param splitPercentage An optional percentage indicating where to split the image.
   */
  public AbstractSplitCommand(String imageName, String destImageName,
                              IImageModel model, Optional<Double> splitPercentage) {
    super(imageName, destImageName, model);
    this.splitPercentage = splitPercentage;
  }
}
