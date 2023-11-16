package controller.commands;

import controller.IImageFileParser;
import model.IImageModel;

/**
 * Represents a command to save an image to the specified file path.
 * The saving process uses the provided image name and path and relies on
 * an image parser to handle the file format and writing.
 */
public class SaveCommand extends AbstractLoaderSaverCommand {

  /**
   * Constructs a SaveCommand with the specified file path, image name, and
   * a reference to the model.
   *
   * @param imagePath The path where the image will be saved.
   * @param imageName The name of the image to save.
   * @param model     A reference to the image model.
   */
  public SaveCommand(String imagePath, String imageName, IImageModel model) {
    super(imagePath, imageName, model);
  }

  /**
   * Saves the image using the correct image parser.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    IImageFileParser imageParser = getImageObject(imagePath);
    imageParser.saveImage(imagePath, this.model.getImage(imageName));
  }
}
