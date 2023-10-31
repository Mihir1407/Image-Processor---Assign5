package Controller.Commands;

import Controller.IImageFileParser;
import Controller.JPEGParser;
import Controller.JPGParser;
import Controller.PNGParser;
import Controller.PPMParser;
import Model.IImageModel;

abstract class AbstractLoaderSaverCommand extends AbstractCommand{
  protected final String imagePath;

  public AbstractLoaderSaverCommand(String imagePath, String imageName, IImageModel model) {
    super(imageName, model);
    this.imagePath = imagePath;
  }
  protected String getFileExtension(String path) throws IllegalArgumentException {
    int lastIndex = path.lastIndexOf(".");
    if (lastIndex == -1) {
      throw new IllegalArgumentException("File path does not contain an extension.");
    }
    return path.substring(lastIndex + 1);
  }

  protected IImageFileParser getImageObject(String path) throws UnsupportedOperationException{
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
