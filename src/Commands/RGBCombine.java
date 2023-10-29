package Commands;

import Model.IImageModel;

public class RGBCombine implements ICommand{
  private final IImageModel model;
  private final String destImageName;

  private final String redImageName;

  private final String greenImageName;

  private final String blueImageName;

  public RGBCombine(String redImageName, String greenImageName, String blueImageName, String destImageName, IImageModel model) {
    this.model = model;
    this.destImageName = destImageName;
    this.redImageName = redImageName;
    this.greenImageName = greenImageName;
    this.blueImageName = blueImageName;

  }

  @Override
  public boolean execute() {
    boolean success = true;
    try {
      this.model.rgbCombine(redImageName, greenImageName, blueImageName, destImageName);
    } catch (Exception e) {
      success = false;
    }
    return success;
  }
}
