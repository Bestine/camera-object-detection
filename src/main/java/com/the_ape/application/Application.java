package com.the_ape.application;


import org.opencv.core.Core;

public class Application{
    public static void main(String[] args) {
        System.out.println("Started over the application");
        //previously
        //-Djava.library.path=/home/ustadhi/java_libraries/opencv/build/java/opencv-480.jar
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME); //loads native library of opencv
        System.loadLibrary("opencv_java480.dll");
        new CameraView();
    }
}