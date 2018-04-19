
import org.im4java.core.IM4JavaException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, IM4JavaException {

        String folderPath = "/Users/a.kuznetsov/Documents/diff";

        String actualImgName = "Ac.png";
        String expectedImgName = "Ex.png";
        String diffImgName = "Diff.png";


        String actualImg = folderPath + "/"+actualImgName;
        String expectedImg = folderPath + "/"+expectedImgName;
        String  diffImg = folderPath + "/"+diffImgName;

        File exImg = new File(folderPath + "/"+ expectedImgName);

        BufferedImage bimg = ImageIO.read(exImg);
        int width = bimg.getWidth();
        int height = bimg.getHeight();

        immageCompare.resizeImg(actualImg, width, height);
        immageCompare.createDiff(actualImg, expectedImg, diffImg);
    }
}
