package Commands;

import java.io.IOException;

import Model.IImageModel;

public class LoadCommand implements ICommand{
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
      this.model.loadImage(this.imagePath, this.imageName);
    } catch (Exception e) {
      success = false;
    }
    return success;
  }
}
