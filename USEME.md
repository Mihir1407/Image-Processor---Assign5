# USEME - Image Processor Application Usage Instructions

## Running Script Commands:

### Running a Script at Program Start:

To execute a script upon starting the application, use the following syntax in your command
terminal:

Syntax: `java -jar program.jar -file <filename>`

1. Place your script file (e.g., `commands.txt`) in the `res` folder of your project.
2. Run the `jar` file by using the command `java -jar program.jar -file res\commands.txt`.
3. The application will sequentially execute commands from `commands.txt`, outputting results to the
   specified directory`(res\images)`, and then exit the program execution.

### Running a Script After Program Start:

You can also run a script after the application has started by following these steps:

Syntax: `run <filename>`

1. Place your script file (e.g., `commands.txt`) in the `res` folder of your project.
2. Run the `jar` file by using the command `java -jar program.jar`.
3. When prompted for commands, enter: `run res/commands.txt` (Windows: `run res\commands.txt`).
4. The application will sequentially execute commands from `commands.txt`, outputting results to the
   specified directory`(res\images)`.

## Running Individual Commands via CLI:

Start `Application.java` and input commands as prompted. Below are the supported commands:

### Load Command:

- **Syntax**: `load <file path> <image name>`
- **Description**: Loads an image from the specified file path and assigns it an alias.
- **Example**: `load res/images/film_original.jpg film`

### Component Extraction Commands:

- **Syntax**: `<color-component> <source image name> <destination image name>`
- **Description**: Extracts a single RGB color component.
- **Examples**:
    - `red-component film filmRedComponent`
    - `green-component film filmGreenComponent`
    - `blue-component film filmBlueComponent`

### Sepia Command:

- **Syntax**: `sepia <source image name> <destination image name>`
- **Description**: Applies a sepia tone effect.
- **Example**: `sepia film filmSepia`

### Blur Command:

- **Syntax**: `blur <source image name> <destination image name>`
- **Description**: Applies a blur effect.
- **Example**: `blur film filmBlur`

### Sharpen Command:

- **Syntax**: `sharpen <source image name> <destination image name>`
- **Description**: Increases image sharpness.
- **Example**: `sharpen film filmSharpen`

### Greyscale Commands:

- **Syntax**: `<greyscale-method>-component <source image name> <destination image name>`
- **Description**: Converts to greyscale.
- **Examples**:
    - `value-component film filmValue`
    - `luma-component film filmLuma`
    - `intensity-component film filmIntensity`

### Flip Commands:

- **Syntax**: `<orientation-flip> <source image name> <destination image name>`
- **Description**: Flips the image.
- **Examples**:
    - `horizontal-flip film filmHFlip`
    - `vertical-flip film filmVFlip`

### Brighten/Darken Command:

- **Syntax**: `brighten <value> <source image name> <destination image name>`
- **Description**: Adjusts brightness.
- **Examples**:
    - `brighten 70 film filmBrighter`
    - `brighten -70 film filmDarker`

### RGB Split and Combine Commands:

- **Syntax**: `rgb-split <source image name> <red dest> <green dest> <blue dest>`
- **Description**: Splits into RGB components.
- **Example**: `rgb-split film redSplit greenSplit blueSplit`

- **Syntax**: `rgb-combine <dest image name> <red source> <green source> <blue source>`
- **Description**: Combines RGB components.
- **Example**: `rgb-combine filmCombined redSplit greenSplit blueSplit`

### Save Command:

- **Syntax**: `save <file path> <image name>`
- **Description**: Saves the image.
- **Example**: `save res/savedImage.jpg myImage`

### Additional Commands:

### Color Correction Command:

- **Syntax**: `color-correct <source image name> <destination image name>`
- **Description**: Adjusts the color balance of the image to correct any color casts and achieve a
  more natural look.
- **Example**: `color-correct film filmColorCorrect`

### Levels Adjustment Command:

- **Syntax
  **: `levels-adjust <black point value> <mid point value> <white point value> <source image name> <destination image name>`
- **Description**: Alters the shadows, midtones, and highlights of an image based on the provided
  black, mid, and white point values.
- **Example**: `levels-adjust 20 100 255 film filmLevelsAdjust`

### Compression Command:

- **Syntax**: `compress <percentage> <source image name> <destination image name>`
- **Description**: Reduces the image file size by the specified percentage through compression,
  which may affect image quality.
- **Example**: `compress 20 film filmCompress20`

### Histogram Creation Command:

- **Syntax**: `histogram <source image name> <destination image name>`
- **Description**: Generates a histogram image representing the distribution of pixel intensities in
  the source image.
- **Example**: `histogram film filmHist`

### Split Effect Commands:

- **Description**: The following commands can apply effects to a portion of the image.
- **Supported Commands
  **: `blur`, `sharpen`, `sepia`, `value`, `luma`, `intensity`, `color-correct`, `levels-adjust`
- **Syntax**: `<command> <source image name> <destination image name> split <percentage>`
- **Examples**:
    - `sepia film filmSepiaSplit50 split 50`
    - `blur film filmBlurSplit30 split 30`
    - `luma-component film filmLumaSplit60 split 60`

Please replace `<file path>`, `<image name>`, `<destination image name>`, and `<value>` with actual
paths, names, or numbers relevant to your images and the changes you want to make. Ensure that the
file paths used are valid and accessible from your application's current working directory.
Ensure to replace placeholders with actual values. The `<value>` for brightness can be positive (to
brighten) or negative (to darken). The `<percentage>` for split effect commands defines the
proportion of the image affected by the effect.
