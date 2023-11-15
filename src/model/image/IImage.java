package model.image;

public interface IImage {
  Pixel[][] getPixels();

  Pixel getPixel(int x, int y) throws IllegalArgumentException;

  int getWidth();

  int getHeight();

  void setPixel(int x, int y, Pixel pixel);
}
