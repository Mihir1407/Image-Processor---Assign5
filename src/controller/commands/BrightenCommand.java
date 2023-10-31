package controller.commands;

import model.IImageModel;

public class BrightenCommand extends AbstractTransformCommand {
  private final int increment;

  public BrightenCommand(int increment, String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
    this.increment = increment;
  }

  @Override
  protected void processImage() throws Exception {
    this.model.brightenCommand(this.increment, this.imageName, this.destImageName);
  }
}
