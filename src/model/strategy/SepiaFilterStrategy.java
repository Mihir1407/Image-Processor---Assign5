package model.strategy;

import model.image.Image;
import model.image.Pixel;

public class SepiaFilterStrategy implements FilterStrategy {
  @Override
  public Image apply(Image image) {
    return image.toSepia();
  }
}
