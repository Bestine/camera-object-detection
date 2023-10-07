package com.the_ape.application;

import javax.swing.*;
import java.awt.*;

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

        /*Create a panel where webcam will open from */
        JPanel webcamPanel = new JPanel();
        webcamPanel.setLayout(null);
        webcamPanel.setSize(400, 350);
        webcamPanel.setLocation(50, 20);
        webcamPanel.setBackground(Color.BLACK);


        JFrame cameraFrame = new JFrame();
        // Add the frame components
        cameraFrame.add(startButton);
        cameraFrame.add(closeButton);
        cameraFrame.add(webcamPanel);

        cameraFrame.setTitle("The APE");
        cameraFrame.setLayout(null);
        cameraFrame.setSize(500, 500);
        cameraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cameraFrame.setVisible(true);
    }
}