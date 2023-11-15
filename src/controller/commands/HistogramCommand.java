package controller.commands;

import model.IImageModel;

public class HistogramCommand extends AbstractTransformCommand {

  public HistogramCommand(String imageName,
                          String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.histogram(this.imageName, this.destImageName);
  }
}