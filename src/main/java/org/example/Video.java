package org.example;

import org.opencv.core.Mat;
import org.opencv.core.Range;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;

public class Video {

    public static void main(String[] args) {
        System.load("D:\\JavaLibs\\opencv-4.7.0\\build\\java\\x64\\opencv_java470.dll");
        Mat frame = new Mat();
//        VideoCapture camera = new VideoCapture("D:\\Ringelmann\\rev13\\Video\\recentvideo_1.mp4");
//        int numb = 401;
//        System.out.println("Start");
//        while (true) {
//            if (camera.read(frame)) {
//                Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
//                Range rowRange = new Range(148, 480); //95 837, top left// 436,837 top right,,//95 895,, btm left, //436, 895 btm right
//                Range colRange = new Range(0, 400);
//                frame = new Mat(frame, colRange, rowRange);
//                Imgcodecs.imwrite("D:\\Ringelmann\\rev13\\Frames\\Good_" + numb + ".jpg", frame);
//                numb++;
//            }
//        }
//        VideoCapture camera = new VideoCapture("D:\\Ringelmann\\rev13\\Video\\recentvideo_2.mp4");
//        int numb = 481;
//        System.out.println("Start");
//        while (true) {
//            if (camera.read(frame)) {
//                Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
//                Range rowRange = new Range(150, 480); //95 837, top left// 436,837 top right,,//95 895,, btm left, //436, 895 btm right
//                Range colRange = new Range(80, 335);
//                frame = new Mat(frame, colRange, rowRange);
//                Imgcodecs.imwrite("D:\\Ringelmann\\rev13\\Frames\\Good_" + numb + ".jpg", frame);
//                numb++;
//            }
//        }
//        VideoCapture camera = new VideoCapture("D:\\Ringelmann\\rev13\\Video\\20180227_092835.mp4");
//        int numb = 813;
//        System.out.println("Start");
//        while (true) {
//            if (camera.read(frame)) {
//                Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
//                Range rowRange = new Range(655, 1075); //95 837, top left// 436,837 top right,,//95 895,, btm left, //436, 895 btm right
//                Range colRange = new Range(50, 415);
//                frame = new Mat(frame, colRange, rowRange);
//                Imgcodecs.imwrite("D:\\Ringelmann\\rev13\\Frames\\Good_" + numb + ".jpg", frame);
//                numb++;
//            }
//        }
        //VideoCapture camera = new VideoCapture("D:\\Ringelmann\\rev13\\Video\\20180227_092835.mp4");
//        System.out.println("Start");
//        for(int i=802;i<=812;i++) {
//            Mat img = Imgcodecs.imread("D:\\Ringelmann\\rev13\\Frames\\Good_" + i + ".jpg");
//            Imgproc.cvtColor(img, img, Imgproc.COLOR_BGR2GRAY);
//            Imgcodecs.imwrite("D:\\Ringelmann\\rev13\\Frames\\Good_" + i + ".jpg", img);
//        }
        for(int i=401;i<481;i++) {
            System.out.println("Good\\Good_"+i+".jpg 1 0 0 332 400");
        }
        for(int i=481;i<802;i++) {
            System.out.println("Good\\Good_"+i+".jpg 1 0 0 330 255");
        }
        System.out.println("Good\\Good_802.jpg 1 0 0 500 346");
        System.out.println("Good\\Good_803.jpg 1 0 0 500 416");
        System.out.println("Good\\Good_804.jpg 1 0 0 500 496");
        System.out.println("Good\\Good_805.jpg 1 0 0 500 419");
        System.out.println("Good\\Good_806.jpg 1 0 0 500 372");
        System.out.println("Good\\Good_807.jpg 1 0 0 500 357");
        System.out.println("Good\\Good_808.jpg 1 0 0 500 407");
        System.out.println("Good\\Good_809.jpg 1 0 0 500 425");
        System.out.println("Good\\Good_810.jpg 1 0 0 500 495");
        System.out.println("Good\\Good_811.jpg 1 0 0 500 489");
        System.out.println("Good\\Good_812.jpg 1 0 0 500 497");
        for(int i=813;i<1631;i++) {
            System.out.println("Good\\Good_"+i+".jpg 1 0 0 420 365");
        }
    }
}
