package Controller.Commands;

import Controller.IImageFileParser;
import Model.IImageModel;

public class LoadCommand extends AbstractCommand{
  private final IImageModel model;
  private final String imagePath;

  private final String imageName;

  public LoadCommand(String imagePath, String imageName, IImageModel model){
    this.model = model;
    this.imageName = imageName;
    this.imagePath = imagePath;
  }

  @Override
  public boolean execute() {
    boolean success = true;
    try {
      IImageFileParser imageParser = getImageObject(imagePath);
      this.model.addImage(imageParser.loadImage(imagePath), imageName);
    } catch (Exception e) {
      success = false;
    }
    return success;
  }
}
