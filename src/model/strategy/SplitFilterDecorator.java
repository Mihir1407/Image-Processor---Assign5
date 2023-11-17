package model.strategy;

import model.image.Image;
import model.image.Pixel;

/**
 * A decorator for FilterStrategy that applies a given filter strategy to only a portion of the
 * image.
 * This class allows a filter to be applied up to a specified percentage split point horizontally,
 * while the rest of the image remains unfiltered.
 */
public class SplitFilterDecorator implements FilterStrategy {
  private final FilterStrategy originalStrategy;
  private final double splitPercentage;

  /**
   * Constructs a SplitFilterDecorator with a given filter strategy and a split percentage.
   *
   * @param strategy        The original filter strategy to be applied to a part of the image.
   * @param splitPercentage The percentage of the image width at which the filter effect is split.
   */
  public SplitFilterDecorator(FilterStrategy strategy, double splitPercentage) {
    if (splitPercentage < 0 || splitPercentage > 100 ) {
      throw new IllegalArgumentException("Split percentage value needs to between 0 and 100.");
    }
    this.originalStrategy = strategy;
    this.splitPercentage = splitPercentage;
  }

  /**
   * Applies the decorated filter strategy to the image up to the specified split point.
   * Pixels to the left of the split point are processed by the original strategy,
   * while pixels to the right remain as in the original image.
   *
   * @param originalImage The original image to which the filter strategy is to be applied.
   * @return A new Image instance with the filter applied up to the split point.
   */
  @Override
  public Image apply(Image originalImage) {
    Image filteredImage = originalStrategy.apply(originalImage);
    int splitPoint = (int) (originalImage.getWidth() * (splitPercentage / 100.0));

    Pixel[][] mixedPixels = new Pixel[originalImage.getHeight()][originalImage.getWidth()];

    for (int y = 0; y < originalImage.getHeight(); y++) {
      for (int x = 0; x < originalImage.getWidth(); x++) {
        if (x < splitPoint) {
          mixedPixels[y][x] = filteredImage.getPixel(x, y);
        } else {
          mixedPixels[y][x] = originalImage.getPixel(x, y);
        }
      }
    }

    return new Image(mixedPixels);
  }
}
