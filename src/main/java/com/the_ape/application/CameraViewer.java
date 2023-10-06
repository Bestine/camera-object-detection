package com.the_ape.application;


//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
//import javafx.scene.web.WebEngine;
//import javafx.scene.web.WebView;
//import javafx.stage.Stage;
//import netscape.javascript.JSObject;
//
//public class CameraViewer extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        WebView webView = new WebView();
//        WebEngine webEngine = webView.getEngine();
//
//        // Load a simple HTML page that accesses the camera
//        webEngine.loadContent("<html><body><video id='video' width='640' height='480'></video><script>" +
//                "var video = document.getElementById('video');" +
//                "navigator.mediaDevices.getUserMedia({ video: true }).then(function (stream) {" +
//                "video.srcObject = stream;" +
//                "});</script></body></html>");
//
//        StackPane root = new StackPane();
//        root.getChildren().add(webView);
//
//        Scene scene = new Scene(root, 640, 480);
//
//        primaryStage.setTitle("Camera Viewer");
//        primaryStage.setScene(scene);
//        primaryStage.setOnCloseRequest(e -> System.exit(0)); // Exit the application when the window is closed
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class CameraViewer extends Application {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    private VideoCapture capture;
    private ImageView imageView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        imageView = new ImageView();
        root.getChildren().add(imageView);

        Scene scene = new Scene(root, 640, 480);

        primaryStage.setTitle("Camera Viewer");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> {
            stopCamera();
            System.exit(0);
        });
        primaryStage.show();

        startCamera();
    }

    private void startCamera() {
        capture = new VideoCapture(0); // 0 represents the default camera
        if (capture.isOpened()) {
            capture.set(Videoio.CAP_PROP_FRAME_WIDTH, 640);
            capture.set(Videoio.CAP_PROP_FRAME_HEIGHT, 480);

            Runnable frameGrabber = () -> {
                Mat frame = new Mat();
                if (capture.read(frame)) {
                    Image img = Utils.mat2Image(frame);
                    updateImageView(imageView, img);
                }
            };

            new Thread(() -> {
                while (true) {
                    frameGrabber.run();
                }
            }).start();
        }
    }

    private void stopCamera() {
        if (capture != null && capture.isOpened()) {
            capture.release();
        }
    }

    private void updateImageView(ImageView view, Image image) {
        // Run this on the JavaFX application thread
        javafx.application.Platform.runLater(() -> view.setImage(image));
    }
}
