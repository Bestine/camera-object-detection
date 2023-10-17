package com.the_ape.application;


import com.github.sarxos.webcam.Webcam;
import org.opencv.core.Core;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class App{
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        System.out.println("Started over the application");
        //previously
        //-Djava.library.path=/home/ustadhi/java_libraries/opencv/build/java/opencv-480.jar
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME); //loads native library of opencv

//        System.loadLibrary("opencv_java480.dll");
//        new CameraView();


        /* Try with Webcam capture tutorial */
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        ImageIO.write(webcam.getImage(),
                "JPG",
                new File("first_capture.jpg"));
        
    }
}