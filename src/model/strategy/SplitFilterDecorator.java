package model.strategy;

import model.image.Image;
import model.image.Pixel;

public class SplitFilterDecorator implements FilterStrategy {
  private final FilterStrategy originalStrategy;
  private final int splitPercentage;

  public SplitFilterDecorator(FilterStrategy strategy, int splitPercentage) {
    this.originalStrategy = strategy;
    this.splitPercentage = splitPercentage;
  }

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
