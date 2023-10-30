package Model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Model.Image.IImage;
import Model.Image.IPixel;
import Model.Image.Image;
import Model.Image.Pixel;

public class ImageModel implements IImageModel {

  private final Map<String, IImage> imageMap;

  public ImageModel() {
    this.imageMap = new HashMap<>();
  }

  @Override
  public void addImage(IImage image, String imageName) throws IOException {
    if (image != null) {
      imageMap.put(imageName, image);
    } else {
      throw new IOException("Model.Image not loaded.");
    }
  }

  @Override
  public IImage getImage(String imageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      return image;
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void redComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] redPixels = new IPixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          IPixel originalPixel = image.getPixel(x, y);
          redPixels[y][x] = new Pixel(originalPixel.getRed(), 0, 0);
        }
      }
      IImage redComponentImage = new Image(redPixels);
      imageMap.put(destImageName, redComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void greenComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] greenPixels = new IPixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          IPixel originalPixel = image.getPixel(x, y);
          greenPixels[y][x] = new Pixel(0, originalPixel.getGreen(), 0);
        }
      }
      IImage greenComponentImage = new Image(greenPixels);
      imageMap.put(destImageName, greenComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void blueComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] bluePixels = new IPixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          IPixel originalPixel = image.getPixel(x, y);
          bluePixels[y][x] = new Pixel(0, 0, originalPixel.getBlue());
        }
      }
      IImage blueComponentImage = new Image(bluePixels);
      imageMap.put(destImageName, blueComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void valueComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] valuePixels = new IPixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          IPixel originalPixel = image.getPixel(x, y);
          int maxPixelVal = Math.max(originalPixel.getRed(),Math.max(originalPixel.getGreen(),originalPixel.getBlue()));
          valuePixels[y][x] = new Pixel(maxPixelVal, maxPixelVal, maxPixelVal);        }
      }
      IImage valueComponentImage = new Image(valuePixels);
      imageMap.put(destImageName, valueComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void lumaComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] lumaPixels = new IPixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          IPixel originalPixel = image.getPixel(x, y);
          int lumaPixelVal = (int) (0.2126 * originalPixel.getRed() + 0.7152 * originalPixel.getGreen() + 0.0722 * originalPixel.getBlue());
          lumaPixels[y][x] = new Pixel(lumaPixelVal, lumaPixelVal, lumaPixelVal);
        }
      }
      IImage lumaComponentImage = new Image(lumaPixels);
      imageMap.put(destImageName, lumaComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void intensityComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] intensityPixels = new IPixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          IPixel originalPixel = image.getPixel(x, y);
          int intensityPixelVal = ((originalPixel.getRed() + originalPixel.getGreen() + originalPixel.getBlue()) / 3);
          intensityPixels[y][x] = new Pixel(intensityPixelVal, intensityPixelVal, intensityPixelVal);
        }
      }
      IImage intensityComponentImage = new Image(intensityPixels);
      imageMap.put(destImageName, intensityComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void horizontalFlip(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] hFlipPixels = new IPixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          hFlipPixels[y][x] = image.getPixel(width-1-x,y);
        }
      }
      IImage hFlipComponentImage = new Image(hFlipPixels);
      imageMap.put(destImageName, hFlipComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }


  @Override
  public void verticalFlip(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] vFlipPixels = new IPixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          vFlipPixels[y][x] = image.getPixel(x,height-1-y);
        }
      }
      IImage vFlipComponentImage = new Image(vFlipPixels);
      imageMap.put(destImageName, vFlipComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void brightenCommand(int increment, String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] brightenPixels = new IPixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          IPixel originalPixel = image.getPixel(x, y);
          int red = originalPixel.getRed() + increment > 255 ? 255 :
                  Math.max(originalPixel.getRed() + increment, 0);
          int green = originalPixel.getGreen() + increment > 255 ? 255 :
                  Math.max(originalPixel.getGreen() + increment, 0);
          int blue = originalPixel.getBlue() + increment > 255 ? 255 :
                  Math.max(originalPixel.getBlue() + increment, 0);
          brightenPixels[y][x] = new Pixel(red,green,blue);
        }
      }
      IImage brightenComponentImage = new Image(brightenPixels);
      imageMap.put(destImageName, brightenComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void blur(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] blurredPixels = new IPixel[height][width];

      double[][] kernel = {
              {1.0/16, 1.0/8, 1.0/16},
              {1.0/8, 1.0/4, 1.0/8},
              {1.0/16, 1.0/8, 1.0/16}
      };

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          double redSum = 0;
          double greenSum = 0;
          double blueSum = 0;

          for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

              if (x + i < 0 || x + i >= width || y + j < 0 || y + j >= height) continue;

              IPixel neighboringPixel = image.getPixel(x + i, y + j);
              redSum += neighboringPixel.getRed() * kernel[i + 1][j + 1];
              greenSum += neighboringPixel.getGreen() * kernel[i + 1][j + 1];
              blueSum += neighboringPixel.getBlue() * kernel[i + 1][j + 1];
            }
          }
          int newRed = (int) Math.round(redSum);
          int newGreen = (int) Math.round(greenSum);
          int newBlue = (int) Math.round(blueSum);

          blurredPixels[y][x] = new Pixel(newRed, newGreen, newBlue);
        }
      }
      IImage blurredComponentImage = new Image(blurredPixels);
      imageMap.put(destImageName, blurredComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void sharpen(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] sharpenedPixels = new IPixel[height][width];

      double[][] kernel = {
              {-1.0/8, -1.0/8, -1.0/8, -1.0/8, -1.0/8},
              {-1.0/8, 1.0/4, 1.0/4, 1.0/4, -1.0/8},
              {-1.0/8, 1.0/4, 1, 1.0/4, -1.0/8},
              {-1.0/8, 1.0/4, 1.0/4, 1.0/4, -1.0/8},
              {-1.0/8, -1.0/8, -1.0/8, -1.0/8, -1.0/8}
      };

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          double redSum = 0;
          double greenSum = 0;
          double blueSum = 0;

          for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {

              if (x + i < 0 || x + i >= width || y + j < 0 || y + j >= height) continue;

              IPixel neighboringPixel = image.getPixel(x + i, y + j);
              redSum += neighboringPixel.getRed() * kernel[i + 2][j + 2];
              greenSum += neighboringPixel.getGreen() * kernel[i + 2][j + 2];
              blueSum += neighboringPixel.getBlue() * kernel[i + 2][j + 2];
            }
          }

          int newRed = Math.min(255, Math.max(0, (int) Math.round(redSum)));
          int newGreen = Math.min(255, Math.max(0, (int) Math.round(greenSum)));
          int newBlue = Math.min(255, Math.max(0, (int) Math.round(blueSum)));

          sharpenedPixels[y][x] = new Pixel(newRed, newGreen, newBlue);
        }
      }
      IImage sharpenedComponentImage = new Image(sharpenedPixels);
      imageMap.put(destImageName, sharpenedComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void sepia(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      IPixel[][] sepiaPixels = new IPixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          IPixel originalPixel = image.getPixel(x, y);

          int originalRed = originalPixel.getRed();
          int originalGreen = originalPixel.getGreen();
          int originalBlue = originalPixel.getBlue();

          int newRed = (int) (0.393 * originalRed + 0.769 * originalGreen + 0.189 * originalBlue);
          int newGreen = (int) (0.349 * originalRed + 0.686 * originalGreen + 0.168 * originalBlue);
          int newBlue = (int) (0.272 * originalRed + 0.534 * originalGreen + 0.131 * originalBlue);

          newRed = Math.min(255, newRed);
          newGreen = Math.min(255, newGreen);
          newBlue = Math.min(255, newBlue);

          sepiaPixels[y][x] = new Pixel(newRed, newGreen, newBlue);
        }
      }
      IImage sepiaComponentImage = new Image(sepiaPixels);
      imageMap.put(destImageName, sepiaComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void rgbSplit(String imageName, String destImageNameRed, String destImageNameGreen,
                       String destImageNameBlue) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      redComponent(imageName,destImageNameRed);
      blueComponent(imageName,destImageNameBlue);
      greenComponent(imageName,destImageNameGreen);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  @Override
  public void rgbCombine(String destImageName, String redImageName, String greenImageName, String blueImageName) throws IOException {
    IImage redImage = imageMap.get(redImageName);
    IImage greenImage = imageMap.get(greenImageName);
    IImage blueImage = imageMap.get(blueImageName);
    if (redImage != null || greenImage != null || blueImage != null ) {
      int height = blueImage.getHeight();
      int width = blueImage.getWidth();
      IPixel[][] combinePixels = new IPixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          int red = redImage.getPixel(x, y).getRed();
          int green = greenImage.getPixel(x, y).getGreen();
          int blue = blueImage.getPixel(x, y).getBlue();

          combinePixels[y][x] = new Pixel(red, green, blue);
        }
      }
      IImage combineComponentImage = new Image(combinePixels);
      imageMap.put(destImageName, combineComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }
}
