package Controller.Commands;

import Controller.IImageFileParser;
import Model.IImageModel;

public class LoadCommand extends AbstractLoaderSaverCommand {

  public LoadCommand(String imagePath, String imageName, IImageModel model) {
    super(imagePath, imageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    IImageFileParser imageParser = getImageObject(imagePath);
    this.model.addImage(imageParser.loadImage(imagePath), imageName);
  }
}
