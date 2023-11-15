package model.strategy;

import model.image.Image;

public interface FilterStrategy {
  Image apply(Image image);
}
