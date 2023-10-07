package com.the_ape.application;

import javax.swing.*;

public class Application{
    public static void main(String[] args){
        System.out.println("Started over the application");
        /* Buttons to start and close the camera */
        //START CAMERA BUTTON
        JButton startButton = new JButton("START");
        startButton.setSize(80, 25);
        startButton.setLocation(100, 400);
        startButton.setFocusable(false);

        //CLOSE CAMERA BUTTON
        JButton closeButton = new JButton("CLOSE");
        closeButton.setSize(80, 25);
        closeButton.setLocation(300, 400);
        closeButton.setFocusable(false);



        JFrame cameraFrame = new JFrame();
        // Add the frame components
        cameraFrame.add(startButton);
        cameraFrame.add(closeButton);

        cameraFrame.setTitle("The APE");
        cameraFrame.setLayout(null);
        cameraFrame.setSize(500, 500);
        cameraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cameraFrame.setVisible(true);
    }
}