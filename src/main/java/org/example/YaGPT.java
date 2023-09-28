package org.example;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class YaGPT {
    public static JFrame window;
    public static JLabel screen;

    public static void main(String[] args) {
        System.load("D:\\JavaLibs\\opencv-4.7.0\\build\\java\\x64\\opencv_java470.dll");

        window = new JFrame("Window:");
        // Создаём контейнер для изображения.
        screen = new JLabel();
        // Установлимаем операцию закрытия по умолчанию.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно отображения контента видимым.
        window.setVisible(true);


        Mat img = Imgcodecs.imread("D:\\Ringelmann\\rev13\\Good\\Good_8.jpg");
        Mat src = new Mat();
        Imgproc.cvtColor(img, src, Imgproc.COLOR_BGR2GRAY);
        Imgproc.adaptiveThreshold(src, src, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 27,4);
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        Imgproc.findContours(src, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        for (MatOfPoint contour : contours) {
            double area = Imgproc.contourArea(contour);
            if (area > 1000) {
                RotatedRect boundingRect = Imgproc.minAreaRect(new MatOfPoint2f(contour.toArray()));
                if (boundingRect.size.width > boundingRect.size.height) {
                    System.out.println("Smoke detected!");
                }
            }
        }
        Imgproc.drawContours(img, contours, -1, new Scalar(255, 0, 0), 1);
        showImage(img);
    }
    public static void showImage(Mat img) {
        MatOfByte buf = new MatOfByte();
        Imgcodecs.imencode(".jpg", img, buf);
        /* Преобразуем массив пикселей в ImageIcon,
           изображение которое будет отображатся. */
        ImageIcon ic = new ImageIcon(buf.toArray());

        // Привязываем изображение к контейнеру.
        screen.setIcon(ic);
        // Привязываем контейнер к окну отображения.
        window.getContentPane().add(screen);
        window.pack();
    }
}
