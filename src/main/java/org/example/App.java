package org.example;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.opencv.imgproc.Imgproc.COLOR_RGB2GRAY;

public class App 
{
    public static void main( String[] args )
    {
        System.load("D:\\JavaLibs\\opencv\\build\\java\\x64\\opencv_java470.dll");
        // Создаём окно для просмотра изображения.
        JFrame window = new JFrame("Window:");
        // Создаём контейнер для изображения.
        JLabel screen = new JLabel();
        // Установлимаем операцию закрытия по умолчанию.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно отображения контента видимым.
        window.setVisible(true);

        Mat img = Imgcodecs.imread("D:\\Flare.jpg");
        //Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2HSV);
//        MatOfByte buf = new MatOfByte();
//        Imgcodecs.imencode(".jpg", img, buf);
//        /* Преобразуем массив пикселей в ImageIcon,
//           изображение которое будет отображатся. */
//        ImageIcon ic = new ImageIcon(buf.toArray());
//
//        // Привязываем изображение к контейнеру.
//        screen.setIcon(ic);
//        // Привязываем контейнер к окну отображения.
//        window.getContentPane().add(screen);
//        window.pack();
//        Imgcodecs.imwrite("D:\\Flare1.jpg",img);

        ////////////////////////////

//        Mat hueMask1 = new Mat();
//        Mat satMask2 = new Mat();
//        Mat valMask3 = new Mat();
//        Mat white2GrayMask = new Mat();
//
//        Imgproc.cvtColor(img, img, Imgproc.COLOR_BGR2HSV);
//        List<Mat> channels_HSV = new ArrayList<>();
//        Core.split(img,channels_HSV);
//
//        Core.inRange(channels_HSV.get(0),new Scalar(0),new Scalar(180),hueMask1);
//        Core.inRange(channels_HSV.get(1),new Scalar(0),new Scalar(20),satMask2);
//        Core.inRange(channels_HSV.get(2),new Scalar(70),new Scalar(255),valMask3);
//
//        Core.bitwise_and(hueMask1,satMask2,white2GrayMask);
//        Core.bitwise_and(white2GrayMask,valMask3,white2GrayMask);
//
//        MatOfByte buf = new MatOfByte();
//        Imgcodecs.imencode(".jpg", white2GrayMask, buf);
//        /* Преобразуем массив пикселей в ImageIcon,
//           изображение которое будет отображатся. */
//        ImageIcon ic = new ImageIcon(buf.toArray());
//
//        // Привязываем изображение к контейнеру.
//        screen.setIcon(ic);
//        // Привязываем контейнер к окну отображения.
//        window.getContentPane().add(screen);
//        window.pack();

        Mat hsv = new Mat();
        Imgproc.cvtColor(img, hsv, Imgproc.COLOR_BGR2HSV);

        Mat h = new Mat();
        Core.extractChannel(img, h, 0);
        Mat img2 = new Mat();
        Core.inRange(h, new Scalar(40), new Scalar(80), img2);
        MatOfByte buf = new MatOfByte();
        Imgcodecs.imencode(".jpg", img2, buf);

        ImageIcon ic = new ImageIcon(buf.toArray());
        screen.setIcon(ic);
        window.getContentPane().add(screen);
        window.pack();


        Core.inRange(h, new Scalar(100), new Scalar(140), img2);
        buf = new MatOfByte();
        Imgcodecs.imencode(".jpg", img2, buf);

        ic = new ImageIcon(buf.toArray());
        screen.setIcon(ic);
        window.getContentPane().add(screen);
        window.pack();
//
//        Core.inRange(img, new Scalar(0, 200, 200),
//                new Scalar(20, 256, 256), img2);
//        ic = new ImageIcon(buf.toArray());
//        screen.setIcon(ic);
//        window.getContentPane().add(screen);
//        window.pack();
////
//        Core.inRange(img, new Scalar(0, 0, 0),
//                new Scalar(0, 0, 50), img2);
//        ic = new ImageIcon(buf.toArray());
//        screen.setIcon(ic);
//        window.getContentPane().add(screen);
//        window.pack();
//
//        img.release(); img2.release(); h.release();
    }
}
