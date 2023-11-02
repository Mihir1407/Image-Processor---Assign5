package controller.commands;

import model.IImageModel;

/**
 * Represents a command that extracts and processes
 * the luma component of an image.
 * This command uses the underlying image model to extract the luma component
 * of the source image and saves the resultant image with a new name.
 */
public class LumaComponentCommand extends AbstractTransformCommand {

  /**
   * Constructs a LumaComponentCommand with the provided source
   * image name, destination image name, and a reference to the model.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The name of the destination image.
   * @param model         A reference to the image model.
   */
  public LumaComponentCommand(String imageName,
                              String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
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
    this.model.lumaComponent(this.imageName, this.destImageName);
  }
}