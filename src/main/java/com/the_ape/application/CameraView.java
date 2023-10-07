package com.the_ape.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CameraView extends JFrame implements ActionListener {
    JButton startButton;
    JButton closeButton;
    JPanel webcamPanel;
    Color defaultPanelColor;
    CameraView(){
        /* Buttons to start and close the camera */
        //START CAMERA BUTTON
        startButton = new JButton("START");
        startButton.setSize(80, 25);
        startButton.setLocation(100, 400);
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        //CLOSE CAMERA BUTTON
        closeButton = new JButton("CLOSE");
        closeButton.setSize(80, 25);
        closeButton.setLocation(300, 400);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        /*Create a panel where webcam will open from */
        webcamPanel = new JPanel();
        webcamPanel.setLayout(null);
        webcamPanel.setSize(400, 350);
        webcamPanel.setLocation(50, 20);
        defaultPanelColor = webcamPanel.getBackground();

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
        if(e.getSource()==startButton){
            System.out.println("Webcam started");
            webcamPanel.setBackground(Color.BLACK);
        }
        if (e.getSource()==closeButton){
            System.out.println("Webcam closed");
            webcamPanel.setBackground(defaultPanelColor);
        }
    }
}
