package Controller.Commands;

import Model.IImageModel;

public class HorizontalFlipCommand extends AbstractTransformCommand {

  public HorizontalFlipCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.horizontalFlip(this.imageName, this.destImageName);
  }
}