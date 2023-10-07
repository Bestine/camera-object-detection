package com.the_ape.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CameraView extends JFrame implements ActionListener {
    CameraView(){
        /* Buttons to start and close the camera */
        //START CAMERA BUTTON
        JButton startButton = new JButton("START");
        startButton.setSize(80, 25);
        startButton.setLocation(100, 400);
        startButton.setFocusable(false);
        //startButton.addActionListener((ActionListener));

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

        // Add the frame components
        this.add(startButton);
        this.add(closeButton);
        this.add(webcamPanel);

        this.setTitle("The APE");
        this.setLayout(null);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
