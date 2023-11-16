package model.strategy;

import model.image.Image;

/**
 * Implements the FilterStrategy to convert an image to its intensity component.
 * This strategy applies an intensity filter that typically averages the color
 * channels to produce a grayscale image based on the intensity of the colors.
 */
public class IntensityFilterStrategy implements FilterStrategy {

  /**
   * Applies an intensity filter to the given image. The filter converts the image
   * into a grayscale version using the intensity of the colors. The conversion
   * process is handled by the toIntensityComponent method of the Image class.
   *
   * @param image The image to which the intensity filter is to be applied.
   * @return A new Image instance representing the grayscale version based on intensity.
   */
  @Override
  public Image apply(Image image) {
    return image.toIntensityComponent();
  }
}
