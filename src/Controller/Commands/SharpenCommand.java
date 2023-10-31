package Controller.Commands;

import Model.IImageModel;

public class SharpenCommand extends AbstractTransformCommand {

  public SharpenCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.sharpen(this.imageName, this.destImageName);
  }
}