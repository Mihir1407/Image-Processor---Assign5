package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Image.IImage;
import Image.IPixel;
import Image.Image;
import Image.Pixel;

public class LoaderSaver {

  public IImage load(String imagePath) throws IOException {
    IImage image;
    String extension = imagePath.substring(imagePath.lastIndexOf(".") + 1);
    switch (extension.toLowerCase()) {
      case "ppm":

      case "png":
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        image = new Image(new Pixel[height][width]);

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
      default:
        throw new IOException("Unsupported image format: " + extension);
    }
  }

  public void save(String savePath, IImage image) throws IOException {
    if (image.getPixels() == null) {
      throw new IOException("No image data to save.");
    }

    int height = image.getHeight();
    int width = image.getWidth();

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

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

    String extension = getFileExtension(savePath);
    ImageIO.write(bufferedImage, extension, new File(savePath));
  }

  private String getFileExtension(String path) throws IllegalArgumentException {
    int lastIndex = path.lastIndexOf(".");
    if (lastIndex == -1) {
      throw new IllegalArgumentException("File path does not contain an extension.");
    }
    return path.substring(lastIndex + 1);
  }
}
