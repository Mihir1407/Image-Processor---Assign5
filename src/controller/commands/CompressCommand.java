package controller.commands;

import model.IImageModel;

/**
 * This command handles the compression of an image using the Haar Wavelet Transform.
 * The compression is done based on a specified compression ratio.
 */
public class CompressCommand extends AbstractTransformCommand {

  private final int compressionRatio;

  /**
   * Constructs a new {@code CompressCommand} object.
   *
   * @param compressionRatio the ratio by which the image is to be compressed.
   * @param imageName        the name of the image to compress.
   * @param destImageName    the name under which the compressed image will be saved.
   * @param model            the image model that performs the compression operation.
   */
  public CompressCommand(int compressionRatio, String imageName,
                         String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
    this.compressionRatio = compressionRatio;
  }

  /**
   * Processes the image by compressing it using the model's compression method.
   * The compression ratio provided during instantiation is used.
   *
   * @throws Exception if an error occurs during the compression process.
   */
  @Override
  protected void processImage() throws Exception {
    this.model.compressImage(this.imageName, this.destImageName, this.compressionRatio);
  }
}
