package controller.commands;

import controller.HistogramRenderer;
import model.IImageModel;
import model.image.Image;

/**
 * Command to generate a histogram for an image within the model.
 * This command extends AbstractTransformCommand and captures the histogram
 * representation of the pixel intensity distribution in the image.
 */
public class HistogramCommand extends AbstractTransformCommand {

  /**
   * Constructs a new HistogramCommand with the specified source and destination image names,
   * as well as a reference to the image model.
   *
   * @param imageName     the name of the source image from which to generate the histogram
   * @param destImageName the name to be assigned to the generated histogram image
   * @param model         the image model that provides image data and storage operations
   */
  public HistogramCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  /**
   * Executes the histogram creation process. Retrieves histogram data from the model for the
   * specified image and utilizes the HistogramRenderer to create a visual representation of
   * the histogram.
   *
   * @throws Exception if an error occurs during the histogram generation process, such as
   *                   issues with accessing the image data or during the rendering of the
   *                   histogram image
   */
  @Override
  protected void processImage() throws Exception {
    int[][] histograms = this.model.histogram(this.imageName);
    if (histograms != null) {
      Image histogramImage = HistogramRenderer.createHistogramImage(histograms);
      model.addImage(histogramImage, destImageName);
    }
  }
}
