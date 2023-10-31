package controller.commands;

import model.IImageModel;

public class LumaComponentCommand extends AbstractTransformCommand {

  public LumaComponentCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.lumaComponent(this.imageName, this.destImageName);
  }
}