package controller.commands;

import controller.IImageFileParser;
import model.IImageModel;

/**
 * Represents a command to load an image into the model.
 * This command retrieves an image from the specified path
 * and loads it into the model with a given name.
 */
public class LoadCommand extends AbstractLoaderSaverCommand {

  /**
   * Constructs a new LoadCommand.
   *
   * @param imagePath The path from where the image will be loaded.
   * @param imageName The name to assign to the loaded image in the model.
   * @param model     A reference to the image model.
   */
  public LoadCommand(String imagePath, String imageName, IImageModel model) {
    super(imagePath, imageName, model);
  }

  /**
   * Loads the image using appropriate image parser.
   *
   * @throws Exception if an error occurs during image processing.
   */
  @Override
  protected void processImage() throws Exception {
    IImageFileParser imageParser = getImageObject(imagePath);
    this.model.addImage(imageParser.loadImage(imagePath), imageName);
  }
}
