package com.the_ape.application;
//
//import com.the_ape.application.CameraSnapshotJavaFX;
//import com.the_ape.application.CameraViewer;
//
//public class Application {
//    static CameraSnapshotJavaFX cameraframe;
//    static CameraViewer cameraViewer;
//    public static void main(String []args){
//        System.out.println("Hello Mustafa");
////        cameraframe = new CameraSnapshotJavaFX();
////        cameraframe.open_camera();
//        cameraViewer = new CameraViewer();
//    }
//}

//import org.bytedeco.javacv.CanvasFrame;
//import org.bytedeco.javacv.OpenCVFrameGrabber;
//import org.opencv.core.Mat;
//
//import javax.swing.*;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.image.BufferedImage;
//
//public class Application {
//
//    private CanvasFrame canvasFrame;
//    private OpenCVFrameGrabber grabber;
//    private boolean isCameraActive;
//
//    public Application() {
//        canvasFrame = new CanvasFrame("Camera Viewer", CanvasFrame.getDefaultGamma() / 2.2);
//        canvasFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        canvasFrame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                stopCamera();
//                System.exit(0);
//            }
//        });
//        startCamera();
//    }
//
//    public void startCamera() {
//        try {
//            grabber = OpenCVFrameGrabber.createDefault(0); // 0 represents the default camera
//            grabber.start();
//            isCameraActive = true;
//
//            while (isCameraActive) {
//                Mat frame = grabber.grab();
//                if (frame != null) {
//                    BufferedImage image = (BufferedImage) canvasFrame.imageToBufferedImage(frame);
//                    canvasFrame.showImage(image);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void stopCamera() {
//        if (grabber != null && isCameraActive) {
//            isCameraActive = false;
//            try {
//                grabber.stop();
//                grabber.release();
//                canvasFrame.dispose();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new Application());
//    }
//}

