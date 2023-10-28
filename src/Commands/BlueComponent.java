package Commands;

import java.io.IOException;

import Model.IImageModel;

public class BlueComponent implements ICommand{
  private final IImageModel model;
  private final String destImageName;

  private final String imageName;

  public BlueComponent(String imageName, String destImageName, IImageModel model){
    this.model = model;
    this.imageName = imageName;
    this.destImageName = destImageName;
  }

  @Override
  public boolean execute() {
    boolean success = true;
    try {
      this.model.blueComponent(this.imageName, this.destImageName);
    } catch (Exception e) {
      success = false;
    }
    return success;
  }
}
