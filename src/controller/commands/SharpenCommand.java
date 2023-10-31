package controller.commands;

import model.IImageModel;

/**
 * Represents a command to apply a sharpening effect to an image.
 * The sharpening process uses the provided image name and destination name,
 * and relies on the image model to handle the actual transformation.
 */
public class SharpenCommand extends AbstractTransformCommand {

  /**
   * Constructs a SharpenCommand with the specified source image name,
   * destination image name, and a reference to the model.
   *
   * @param imageName      The name of the source image to be sharpened.
   * @param destImageName  The name where the sharpened image will be stored.
   * @param model          A reference to the image model.
   */
  public SharpenCommand(String imageName, String destImageName, IImageModel model) {
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
    this.model.sharpen(this.imageName, this.destImageName);
  }
}