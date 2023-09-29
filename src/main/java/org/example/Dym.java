package org.example;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Dym {

    public static JFrame window;
    public static JLabel screen;
    public static Mat image;

    public static void main(String[] args) {

        System.load("D:\\JavaLibs\\opencv-4.7.0\\build\\java\\x64\\opencv_java470.dll");
        // Создаём окно для просмотра изображения.
        window = new JFrame("Window:");
        // Создаём контейнер для изображения.
        screen = new JLabel();
        // Установлимаем операцию закрытия по умолчанию.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно отображения контента видимым.
        window.setVisible(true);

        //Mat img = Imgcodecs.imread("D:\\Ringelmann\\Flare.jpg");
        String path = "D:\\Ringelmann\\rev10\\good.txt";
        System.out.println("Начал");
//        int count = 16;
//        for(int i=1;i<16;i++) {
//            Mat img = Imgcodecs.imread(path+"Good_color\\Good_"+i+".jpg");
//            if(img.empty()) {
//                System.out.println("Пустой"+i);
//            } else {
//                Imgproc.cvtColor(img, img, Imgproc.COLOR_BGR2GRAY);
//                Imgcodecs.imwrite(path + "Good\\Good_" + i + ".jpg", img);
//                count++;
//            }
//        }
        System.out.println("Завершил");

//        if (img.empty()) {
//            System.out.println("Не удалось загрузить изображение");
//            return;
//        }
//        Imgproc.cvtColor(img, img, Imgproc.COLOR_BGR2GRAY);
//        //CvUtilsFX.showImage(img, "Оригинал");
//        Mat img2 = img.submat(new Rect(350, 0, 666, 805)).clone();
//        //CvUtilsFX.showImage(img2, "Шаблон");
//        Mat result = new Mat();
//        Imgproc.matchTemplate(img, img2, result, Imgproc.TM_SQDIFF);
//        Core.MinMaxLocResult r = Core.minMaxLoc(result);
//        System.out.println(r.minVal + " " + r.minLoc);
//        Imgproc.rectangle(img, r.minLoc, new Point(r.minLoc.x + img2.width() - 1,
//                r.minLoc.y + img2.height() - 1), new Scalar(255,255,255));
//        showImage(img);
//        Mat result2 = new Mat();
//        Imgproc.matchTemplate(img, img2, result2, Imgproc.TM_CCOEFF);
//        Core.MinMaxLocResult r2 = Core.minMaxLoc(result2);
//        System.out.println(r2.maxVal + " " + r2.maxLoc);
//        img.release(); img2.release();
//        result.release(); result2.release();
        test();
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

    public static void test() {
        image = Imgcodecs.imread("D:\\Ringelmann\\rev15\\Good\\Good_25.jpg");
        //performGammaCorrection();
        //showImage(image);
        //Mat imgGray = new Mat();
        //Imgproc.cvtColor(image, imgGray, Imgproc.COLOR_BGR2GRAY);

//        Mat edges = new Mat();
//        Imgproc.Canny(image, edges, 50, 90);
//        showImage(edges);
//        Mat edgesCopy = edges.clone(); // Создаем копию
//        ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();
//        Mat hierarchy = new Mat();
//        Imgproc.findContours(edgesCopy, contours, hierarchy,
//                Imgproc.RETR_TREE,
//                Imgproc.CHAIN_APPROX_SIMPLE);
//        System.out.println(contours.size());
//        System.out.println(hierarchy.size());
//        System.out.println(hierarchy.dump());
//        Imgproc.drawContours(image, contours, -1, new Scalar(255,255,255));
        //showImage(image);

        Mat img2 = new Mat();
        Imgproc.cvtColor(image, img2, Imgproc.COLOR_BGR2GRAY);
//        for(int i=0;i<coords.size();i++) {
//            image.put(coords.get(i)[0], coords.get(i)[1], new double[]{255,20,147});
//        }
        CascadeClassifier classifier = new CascadeClassifier("D:\\Ringelmann\\rev15\\result\\cascade.xml");
        MatOfRect rectVector = new MatOfRect();
        classifier.detectMultiScale(image, rectVector);
        int threshold_level = 200;
        List<int[]> coords = new ArrayList<>();
        List<Rect> temp = rectVector.toList();
        Rect[] rects = rectVector.toArray();
        boolean flagInter = false;
        for (int i=0;i<temp.size()-1;i++) {
            for(int j=i+1;j<temp.size();j++) {
                if(intersect(temp.get(i), temp.get(j)).area() > 0) {
                    Rect newrect = merge(temp.get(i), temp.get(j));
                    temp.set(j, newrect);
                    flagInter = true;
                    //temp.add(newrect);
                }
            }
            if(flagInter)
                temp.set(i, new Rect());
            flagInter = false;
        }
        for (Rect rect : temp) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
            for (int i = rect.y; i <= rect.y + rect.height; i++) {
                for (int j = rect.x; j <= rect.x + rect.width; j++) {
                    if (Arrays.stream(img2.get(i, j)).toArray()[0] < threshold_level && !coords.contains(new int[]{i, j})) {
                        coords.add(new int[]{i, j});
                        //System.out.println(i+" "+j);
                    }
                }
            }
        }

        showImage(image);
        double sum = 0;
        for(int i=0;i<coords.size();i++) {
            double color = Arrays.stream(img2.get(coords.get(i)[0], coords.get(i)[1])).toArray()[0];
            if (color < 150 && color>=130) {
                sum+=0;
            }
            else if (color < 130 && color>=110) {
                sum+=1;
            }
            else if (color < 110 && color>=90) {
                sum+=2;
            }
            else if (color < 90 && color>=70) {
                sum+=3;
            }
            else if (color < 70 && color>=50) {
                sum+=4;
            }
            else if (color < 50 && color>=20) {
                sum+=5;
            }
        }
        System.out.println(sum*100/coords.size()/6);

    }

    private static byte saturate(double val) {
        int iVal = (int) Math.round(val);
        iVal = iVal > 255 ? 255 : (iVal < 0 ? 0 : iVal);
        return (byte) iVal;
    }

    private static void performGammaCorrection() {
        double gammaValue = 0.8;
        //double gammaValue = 100;
        Mat lookUpTable = new Mat(1, 256, CvType.CV_8U);
        byte[] lookUpTableData = new byte[(int) (lookUpTable.total()*lookUpTable.channels())];
        for (int i = 0; i < lookUpTable.cols(); i++) {
            lookUpTableData[i] = saturate(Math.pow(i / 255.0, gammaValue) * 255.0);
        }
        lookUpTable.put(0, 0, lookUpTableData);
        Mat img = new Mat();
        Core.LUT(image, lookUpTable, img);
        image = img;
    }

    public static Rect intersect(Rect A, Rect B) {
        int left = Integer.max(A.x, B.x);
        int top = Integer.max(A.y, B.y);
        int right = Integer.min(A.x + A.width, B.x + B.width);
        int bottom = Integer.min(A.y + A.height, B.y + B.height);
        if (left <= right && top <= bottom) return new Rect(left, top, right - left, bottom - top);
        else return new Rect();
    }

    public static Rect merge(Rect A, Rect B) {
        int left = Integer.min(A.x, B.x);
        int top = Integer.min(A.y, B.y);
        int right = Integer.max(A.x + A.width, B.x + B.width);
        int bottom = Integer.max(A.y + A.height, B.y + B.height);
        return new Rect(left, top, right - left, bottom - top);
    }
}
