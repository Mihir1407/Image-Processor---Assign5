package Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Image.IImage;
import Model.Image.Image;
import Model.Image.Pixel;
import Model.Image.IPixel;

public class JPEGParser implements IImageFileParser{
  @Override
  public IImage loadImage(String path) throws IOException {
    BufferedImage bufferedImage = ImageIO.read(new File(path));

    int width = bufferedImage.getWidth();
    int height = bufferedImage.getHeight();

    IImage image = new Image(new IPixel[height][width]);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int argb = bufferedImage.getRGB(x, y);

        int red = (argb >> 16) & 0xff;
        int green = (argb >> 8) & 0xff;
        int blue = argb & 0xff;

        image.setPixel(x, y, new Pixel(red, green, blue));
      }
    }
    return image;
  }

  @Override
  public void saveImage(String path, IImage image) throws IOException {
    if (image.getPixels() == null) {
      throw new IOException("No image data to save.");
    }

    int height = image.getHeight();
    int width = image.getWidth();

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        IPixel pixel = image.getPixel(x, y);

        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();

        int argb = (255 << 24) | (red << 16) | (green << 8) | blue;

        bufferedImage.setRGB(x, y, argb);
      }
    }
    ImageIO.write(bufferedImage, "jpeg", new File(path));
  }
}
