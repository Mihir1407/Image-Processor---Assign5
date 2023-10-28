package Commands;

import java.io.IOException;

import Model.IImageModel;

public class SaveCommand implements ICommand{
  private final IImageModel model;
  private final String savePath;

  private final String imageName;

  public SaveCommand(String savePath, String imageName, IImageModel model){
    this.model = model;
    this.imageName = imageName;
    this.savePath = savePath;
  }

  @Override
  public boolean execute() {
    boolean success = true;
    try {
      this.model.saveImage(this.savePath, this.imageName);
    } catch (Exception e) {
      success = false;
    }
    return success;
  }
}
