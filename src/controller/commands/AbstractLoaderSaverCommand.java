package controller.commands;

import controller.IImageFileParser;
import controller.JPEGParser;
import controller.JPGParser;
import controller.PNGParser;
import controller.PPMParser;
import model.IImageModel;

/**
 * Represents an abstract command that provides the base functionality for
 * loading or saving images from/to various file formats.
 * This class encapsulates the logic for determining file extensions and
 * associating them with the appropriate image file parsers, such as PNG, JPG,
 * JPEG, and PPM.
 */
abstract class AbstractLoaderSaverCommand extends AbstractCommand {
  protected final String imagePath;

  /**
   * Constructs an AbstractLoaderSaverCommand with the provided image path,
   * image name, and a reference to the model.
   *
   * @param imagePath The path to the image file.
   * @param imageName The name of the image to be processed.
   * @param model     A reference to the image model.
   */
  public AbstractLoaderSaverCommand(String imagePath, String imageName, IImageModel model) {
    super(imageName, model);
    this.imagePath = imagePath;
  }

  /**
   * Extracts the file extension from the provided path.
   *
   * @param path The file path from which the extension should be extracted.
   * @return The extracted file extension.
   * @throws IllegalArgumentException if the path does not contain a file extension.
   */
  protected String getFileExtension(String path) throws IllegalArgumentException {
    int lastIndex = path.lastIndexOf(".");
    if (lastIndex == -1) {
      throw new IllegalArgumentException("File path does not contain an extension.");
    }
    return path.substring(lastIndex + 1);
  }

  /**
   * Returns the appropriate image file parser based on the file extension.
   *
   * @param path The path of the image file.
   * @return Appropriate IImageFileParser instance based on the file extension.
   * @throws UnsupportedOperationException if the file extension is not supported.
   */
  protected IImageFileParser getImageObject(String path)
          throws UnsupportedOperationException {
    String extension = getFileExtension(path);

    switch (extension) {
      case "png":
        return new PNGParser();
      case "jpg":
        return new JPGParser();
      case "jpeg":
        return new JPEGParser();
      case "ppm":
        return new PPMParser();
      default:
        throw new UnsupportedOperationException();
    }
  }
}
