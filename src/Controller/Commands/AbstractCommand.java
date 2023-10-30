package Controller.Commands;

import Controller.IImageFileParser;
import Controller.JPEGParser;
import Controller.JPGParser;
import Controller.PNGParser;
import Controller.PPMParser;

abstract class AbstractCommand implements ICommand{
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
