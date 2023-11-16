package model.strategy;

import model.image.Image;

/**
 * Implements the FilterStrategy interface to apply a luma-based filter to an image.
 * This strategy converts the image to a grayscale version using the luma component
 * which is a weighted sum of the RGB color channels.
 */
public class LumaFilterStrategy implements FilterStrategy {

  /**
   * Applies a luma-based filter to the provided image, converting it to grayscale.
   * This method relies on the toLumaComponent method of the Image class to calculate
   * the luma value and produce a grayscale image.
   *
   * @param image The image to be converted to grayscale using the luma component.
   * @return A new Image instance that is the grayscale version of the original image.
   */
  @Override
  public Image apply(Image image) {
    return image.toLumaComponent();
  }
}
