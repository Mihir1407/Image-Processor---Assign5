package Controller.Commands;

import Model.IImageModel;

public class RGBCombineCommand extends AbstractCombineSplitCommand{

  public RGBCombineCommand(String ImageName, String redImageName, String greenImageName, String blueImageName, IImageModel model) {
    super(ImageName, redImageName, greenImageName, blueImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.rgbCombine(this.imageName, this.redImageName, this.greenImageName, this.blueImageName);
  }
}
