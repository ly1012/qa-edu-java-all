package imagecomparison;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ComparisonResult;
import com.github.romankh3.image.comparison.model.ComparisonState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图片比对示例 <br>
 * 创建时间：2019/9/9 9:38<br>
 * 作者：李云
 */
public class Example {

  private static Logger logger = LoggerFactory.getLogger(Example.class);

  public static void compareImage(String actual, String expected, String result) throws IOException {
    logger.info("比较图片 {} 和 {} 的差异，输出到：{}",actual,expected,result);
    // load the images to be compared
    BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources(expected);
    BufferedImage actualImage = ImageComparisonUtil.readImageFromResources(actual);

    // where to save the result (leave null if you want to see the result in the UI)
    File resultDestination = new File(result);

    //Create ImageComparison object for it.
    ImageComparison imageComparison = new ImageComparison(expectedImage, actualImage, resultDestination);

    //Can be used another constructor for it, without destination.
    new ImageComparison(expected, actual);
    //or
    new ImageComparison(expectedImage, actualImage);

    //Also can be configured BEFORE comparing next properties:

    //Threshold - it's the max distance between non-equal pixels. By default it's 5.
    imageComparison.setThreshold(10);
    imageComparison.getThreshold();

    //RectangleListWidth - Width of the line that is drawn in the rectangle. By default it's 1.
    imageComparison.setRectangleLineWidth(5);
    imageComparison.getRectangleLineWidth();

    //Destination. Before comparing also can be added destination file for result image.
    imageComparison.setDestination(resultDestination);
    imageComparison.getDestination();

    //MaximalRectangleCount - It means that would get first x biggest rectangles for drawing.
    // by default all the rectangles would be drawn.
    //imageComparison.setMaximalRectangleCount(10);
    imageComparison.getMaximalRectangleCount();

    //MinimalRectangleSize - The number of the minimal rectangle size. Count as (width x height).
    // by default it's 1.
    //imageComparison.setMinimalRectangleSize(100);
    imageComparison.getMinimalRectangleSize();

    //Change the level of the pixel tolerance:
    imageComparison.setPixelToleranceLevel(0.2);
    imageComparison.getPixelToleranceLevel();

    //After configuring the ImageComparison object, can be executed compare() method:
    ComparisonResult comparisonResult = imageComparison.compareImages();

    //Can be found ComparisonState.
    ComparisonState comparisonState = comparisonResult.getComparisonState();

    if (comparisonState == ComparisonState.MISMATCH){
      //And Result Image
      BufferedImage resultImage = comparisonResult.getResult();

      //Image can be saved after comparison, using ImageComparisonUtil.
      ImageComparisonUtil.saveImage(resultDestination, resultImage);
    }

  }
}
