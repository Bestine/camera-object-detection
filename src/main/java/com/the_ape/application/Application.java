package com.the_ape.application;

import javax.swing.*;

public class Application{
    public static void main(String[] args){
        System.out.println("Started over the application");

        JFrame cameraFrame = new JFrame();
        cameraFrame.setTitle("The APE");
        cameraFrame.setSize(320, 320);
        cameraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cameraFrame.setVisible(true);
    }
}