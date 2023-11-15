package controller.commands;

import model.IImageModel;

public class CompressCommand extends AbstractTransformCommand {
  private final int compressionRatio;
  public CompressCommand(int compressionRatio, String imageName,
                         String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
    this.compressionRatio = compressionRatio;
  }

  @Override
  protected void processImage() throws Exception {
     this.model.compressImage(this.imageName, this.destImageName, this.compressionRatio);
  }
}
