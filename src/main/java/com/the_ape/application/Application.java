package com.the_ape.application;

import com.the_ape.application.CameraSnapshotJavaFX;

public class Application {
    static CameraSnapshotJavaFX cameraframe;
    public static void main(String []args){
        System.out.println("Hello Mustafa");
        cameraframe = new CameraSnapshotJavaFX();
        cameraframe.open_camera();
    }
}
