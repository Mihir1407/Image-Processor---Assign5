package Image;

public interface IImage {
  IPixel[][] getPixels();
  IPixel getPixel(int x, int y);
  int getWidth();
  int getHeight();
  void setPixel(int x, int y, IPixel pixel);

  IImage redComponent();

  IImage blueComponent();

  IImage greenComponent();

  IImage valueComponent();

  IImage lumaComponent();

  IImage intensityComponent();

  IImage verticalFlip();

  IImage horizontalFlip();

  IImage sepia();

  IImage sharpen();

  IImage blur();
}
