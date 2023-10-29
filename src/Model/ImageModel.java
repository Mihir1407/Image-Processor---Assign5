package Model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Image.IImage;

public class ImageModel implements IImageModel {

  private Map<String, IImage> imageMap;

  public ImageModel() {
    this.imageMap = new HashMap<>();
  }

  @Override
  public void addImage(IImage image, String imageName) throws IOException {
    if (image != null) {
      imageMap.put(imageName, image);
    } else {
      throw new IOException("Image not loaded.");
    }
  }

  @Override
  public IImage getImage(String imageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      return image;
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void redComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.redComponent());
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void greenComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.greenComponent());
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void blueComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.blueComponent());
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void valueComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.valueComponent());
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void lumaComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.lumaComponent());
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void intensityComponent(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.intensityComponent());
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void horizontalFlip(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.horizontalFlip());
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void verticalFlip(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.verticalFlip());
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void brightenCommand(int increment, String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.brightenCommand(increment));
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void blur(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.blur());
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void sharpen(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.sharpen());
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void sepia(String imageName, String destImageName) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.sepia());
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void rgbSplit(String imageName, String destImageNameRed, String destImageNameGreen,
                       String destImageNameBlue) throws IOException {
    IImage image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageNameRed, image.redComponent());
      imageMap.put(destImageNameGreen, image.greenComponent());
      imageMap.put(destImageNameBlue, image.blueComponent());
    } else {
      throw new IOException("Image not found.");
    }
  }
}
