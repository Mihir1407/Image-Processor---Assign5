package controller.commands;

import model.IImageModel;

public class BlurCommand extends AbstractTransformCommand {

  public BlurCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.blur(this.imageName, this.destImageName);
  }
}