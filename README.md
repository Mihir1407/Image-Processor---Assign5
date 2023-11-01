# Image Processing Application
# SRC Folder: MVC Architecture

## Model:

### IImageModel.java:
- An interface for the model of the image processing application, which provides methods for all the commands supported by the image processing application.

### ImageModel.java:
- An implementation of IImageModel.java which holds all images being processed in the application and implements all methods, corresponding to commands supported by the image processor.

### Image.java:
- Represents an image, made up of pixels.

### Pixel.java:
- Describes a pixel with channels RGB, used for constructing images.

## Controller:

### Commands:

#### ICommand.java:
- An interface for the commands supported by the image processing application.

#### AbstractCommand.java:
- Implements ICommand.java providing common methods for all commands.

#### AbstractCombineSplitCommand.java:
- Extends AbstractCommand.java, includes common methods and constructors for RGB combine and split commands.

#### AbstractLoaderSaverCommand.java:
- Extends AbstractCommand.java, includes common methods and constructors for Load and Save Commands.

#### AbstractTransformCommand.java:
- Extends AbstractCommand.java, includes common methods and constructors for other commands supported by the application.

#### Individual command classes (e.g., BlueComponentCommand.java, BlurCommand.java etc.):
- These classes execute each command supported by the image processing application and are responsible for the execution flow into the model.

#### IController.java:
- An interface for the controller.

#### ImageController:
- Processes user input from the view, instantiates the corresponding command, and ensures operations proceed as expected.

#### IImageFileParser.java:
- An interface for a parser aiding in loading and saving image files.

#### AbstractImageParser.java:
- Implements IImageFileParser.java, contains common parsing methods for different image file formats.

#### Image format specific parsers (e.g., JPEGParser.java, JPGParser.java etc.):
- These classes are responsible for saving and loading specific image file formats. They are used in combination with the LoadCommand.java and SaveCommand.java depending on the image type.

#### IScriptParser.java:
- An interface for reading command files when the user uses a 'run <filename>' command.

#### ScriptParser.java:
- Implements IScriptParser.java, utilized by the controller to read commands from the specified file during the 'run' command.

## View:

### IView.java:
- An interface for the user-facing view in the MVC architecture.

### ConsoleView.java:
- Implements IView.java, providing a CLI-based view for the image processing application.

## Main Execution:

### Application.java:
- Initializes objects of ConsoleView, ImageModel, and ImageController, kickstarting the image processing application's execution.

# Running Script Commands:

To execute a series of commands from a script:

1. Ensure you have `commands.txt` in the `res` folder of your project.
2. Run the `Application.java` file.
3. Once the application starts, type in the command:
  
   run res\commands.txt
4. This will execute all the commands specified in the `commands.txt` script file.
5. All generated images will be saved in the `res` folder.

# Image Citation:
The image used in this project is sourced from Pixabay(https://pixabay.com/), a platform for high-quality stock photos free from copyright restrictions. The specific image can be accessed here - https://pixabay.com/illustrations/film-negative-photographs-slides-1668918/.

## Terms of Usage:
The image is released under the Pixabay License(https://pixabay.com/service/license-summary/) which grants permission to use the content without the need for giving credit to the artist under the following conditions:

- For both commercial and non-commercial use.
- No attribution required.

However, redistributing the image on other stock photo platforms is prohibited.

