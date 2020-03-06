import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

//
// Detects faces in an image, draws boxes around them, and writes the results
// to "faceDetection.png".
//



public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, OpenCV");

        // Load the native library.
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);


        new Main().run();
    }

    public void run() throws IOException {
        System.out.println("running camera");
        Imgcodecs ic = new Imgcodecs();
        VideoCapture capture = new VideoCapture();
        //capture.open("/dev/v4l/by-id/usb-046d_Logitech_Webcam_C930e_6E83756E-video-index0");
        //capture.open(0);
        //String file = "facedetection_input.jpg";
        //Mat matrix = Imgcodecs.imread(file);
        Mat matrix = new Mat();
        //capture.read(matrix);
        matrix = ic.imread("test.png");
        //ic.imwrite("test.png", matrix);
        Mat gray = new Mat();
        Imgproc.cvtColor(matrix, gray, Imgproc.COLOR_BGR2GRAY);
        ic.imwrite("grayscale.png", gray);
        Imgproc.medianBlur(gray, gray, 5);
        ic.imwrite("median.png", gray);
        Mat circles = new Mat();



        ic.imwrite("circles.png", matrix);
        Mat hsv = new Mat();
        Imgproc.cvtColor(matrix, hsv, Imgproc.COLOR_BGR2HSV);
        ic.imwrite("hsv.png", hsv);
        Scalar lower_bound = new Scalar(187, 182, 188);
        Scalar upper_bound = new Scalar(250, 251, 251);
        Mat dst = new Mat();
        Core.inRange(matrix, lower_bound, upper_bound, dst);
        ic.imwrite("dst.png", dst);
        Mat detect = new Mat();
        Core.bitwise_and(hsv, hsv, detect, dst);
        ic.imwrite("detect.png", detect);

        Imgproc.HoughCircles(gray, circles, Imgproc.HOUGH_GRADIENT, 1.0, (double) gray.rows()/16, 100.0, 30.0, 1, 50);

        Color color = new Color(187, 182, 188);
        for (int x=0; x < circles.cols(); x++) {
            double[] c = circles.get(0, x);
            Point center = new Point(Math.round(c[0]), Math.round(c[1]));
            Imgproc.circle(detect, center, 1, new Scalar(187, 182, 188), 1, 2, 0);
            int radius = (int) Math.round(c[2]);
            Imgproc.circle(detect, center, radius, new Scalar(250, 251, 251), 3, 8, 0);
        }

        ic.imwrite("test2.png",detect);
    }
}