package controller.commands;

import controller.IImageFileParser;
import model.IImageModel;

public class SaveCommand extends AbstractLoaderSaverCommand {

  public SaveCommand(String imagePath, String imageName, IImageModel model) {
    super(imagePath, imageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    IImageFileParser imageParser = getImageObject(imagePath);
    imageParser.saveImage(imagePath, this.model.getImage(imageName));
  }
}
