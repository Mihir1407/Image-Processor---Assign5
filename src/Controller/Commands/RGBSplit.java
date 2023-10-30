package Controller.Commands;

import Model.IImageModel;

public class RGBSplit implements ICommand{
  private final IImageModel model;
  private final String destImageNameRed;

  private final String destImageNameGreen;
  private final String destImageNameBlue;
  private final String imageName;

  public RGBSplit(String imageName, String destImageNameRed, String destImageNameGreen, String destImageNameBlue, IImageModel model){
    this.model = model;
    this.imageName = imageName;
    this.destImageNameRed = destImageNameRed;
    this.destImageNameGreen = destImageNameGreen;
    this.destImageNameBlue = destImageNameBlue;
  }

  @Override
  public boolean execute() {
    boolean success = true;
    try {
      this.model.rgbSplit(this.imageName, this.destImageNameRed, this.destImageNameGreen, this.destImageNameBlue);
    } catch (Exception e) {
      success = false;
    }
    return success;
  }
}
