package controller.commands;

import model.IImageModel;

public class IntensityComponentCommand extends AbstractTransformCommand {

  public IntensityComponentCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.intensityComponent(this.imageName, this.destImageName);
  }
}