package Commands;

import Model.IImageModel;

public class ValueComponent implements ICommand{
  private final IImageModel model;
  private final String destImageName;

  private final String imageName;

  public ValueComponent(String imageName, String destImageName, IImageModel model){
    this.model = model;
    this.imageName = imageName;
    this.destImageName = destImageName;
  }

  @Override
  public boolean execute() {
    boolean success = true;
    try {
      this.model.valueComponent(this.imageName, this.destImageName);
    } catch (Exception e) {
      success = false;
    }
    return success;
  }
}
