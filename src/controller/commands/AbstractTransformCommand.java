package controller.commands;

import model.IImageModel;

/**
 * Represents an abstract command that provides the base functionality for
 * transforming images.
 * This class offers a foundational structure for commands that need to
 * transform an image.
 */
public abstract class AbstractTransformCommand extends AbstractCommand {
  protected final String destImageName;

  /**
   * Constructs an AbstractTransformCommand with the provided source
   * image name, destination image name, and a reference to the model.
   *
   * @param imageName     The name of the source image to be transformed.
   * @param destImageName The name of the transformed destination image.
   * @param model         A reference to the image model.
   */
  public AbstractTransformCommand(String imageName, String destImageName,
                                  IImageModel model) {
    super(imageName, model);
    this.destImageName = destImageName;
  }
}
