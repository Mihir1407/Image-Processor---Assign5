package controller.commands;

import model.IImageModel;

public class RGBSplitCommand extends AbstractCombineSplitCommand{

  public RGBSplitCommand(String ImageName, String redImageName, String greenImageName, String blueImageName, IImageModel model) {
    super(ImageName, redImageName, greenImageName, blueImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.rgbSplit(this.imageName, this.redImageName, this.greenImageName, this.blueImageName);
  }
}
