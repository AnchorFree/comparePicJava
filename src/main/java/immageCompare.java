import java.io.File;
import java.io.IOException;
import org.im4java.core.CompareCmd;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.process.StandardStream;

public class immageCompare {

    public static void createDiff(String exp, String cur, String diff) {
        CompareCmd compare = new CompareCmd();

        compare.setErrorConsumer(StandardStream.STDERR);
        IMOperation cmpOp = new IMOperation();
        cmpOp.metric("mae");


        cmpOp.addImage(exp);

        cmpOp.addImage(cur);

        cmpOp.addImage(diff);

        try {
            compare.run(cmpOp);
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }

    public static void resizeImg(String filePath, int width, int height) throws IOException, InterruptedException, IM4JavaException {
        try {
            ConvertCmd cmd = new ConvertCmd();
            IMOperation op = new IMOperation();
            op.addImage(filePath);
            op.resize(width, height);
            op.addImage(filePath);
            cmd.run(op);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
