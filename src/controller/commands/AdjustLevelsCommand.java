package controller.commands;

import model.IImageModel;

public class AdjustLevelsCommand extends AbstractTransformCommand {
  private final int b;

  private final int m;

  private final int w;

  public AdjustLevelsCommand(int b, int m, int w, String imageName,
                             String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
    this.b = b;
    this.m = m;
    this.w = w;
  }

  @Override
  protected void processImage() throws Exception {
    this.model.adjustLevels(this.imageName, this.destImageName, this.b, this.m, this.w);
  }
}
