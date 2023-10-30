package Model.Image;


public class Image implements IImage {
  private IPixel[][] pixels;

  public Image(IPixel[][] pixels) {
    this.pixels = pixels;
  }

  @Override
  public IPixel[][] getPixels() {
    return pixels;
  }

  @Override
  public IPixel getPixel(int x, int y) {
    return pixels[y][x];
  }

  @Override
  public int getWidth() {
    return pixels[0].length;
  }

  @Override
  public int getHeight() {
    return pixels.length;
  }

  @Override
  public void setPixel(int x, int y, IPixel pixel) {
    pixels[y][x] = pixel;
  }

}
