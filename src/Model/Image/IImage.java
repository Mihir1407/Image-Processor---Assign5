package Model.Image;

public interface IImage {
  IPixel[][] getPixels();
  IPixel getPixel(int x, int y);
  int getWidth();
  int getHeight();
  void setPixel(int x, int y, IPixel pixel);
}
