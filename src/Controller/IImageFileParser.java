package Controller;

import java.io.IOException;

import Image.IImage;

public interface IImageFileParser {
  IImage loadImage(String path) throws IOException;
  void saveImage(String path, IImage image) throws IOException;
}