package Commands;

import Model.IImageModel;

public class BrightenCommand implements ICommand{
  private final IImageModel model;
  private final String destImageName;
  private final int increment;
  private final String imageName;

  public BrightenCommand(int increment, String imageName, String destImageName, IImageModel model){
    this.model = model;
    this.imageName = imageName;
    this.destImageName = destImageName;
    this.increment = increment;
  }

  @Override
  public boolean execute() {
    boolean success = true;
    try {
      this.model.brightenCommand(this.increment, this.imageName, this.destImageName);
    } catch (Exception e) {
      success = false;
    }
    return success;
  }
}
