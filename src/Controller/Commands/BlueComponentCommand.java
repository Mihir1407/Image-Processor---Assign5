package Controller.Commands;

import Model.IImageModel;

public class BlueComponentCommand extends AbstractTransformCommand {

  public BlueComponentCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.blueComponent(this.imageName, this.destImageName);
  }
}