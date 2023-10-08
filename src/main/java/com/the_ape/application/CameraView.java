package com.the_ape.application;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.highgui.HighGui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

public class CameraView extends JFrame implements ActionListener {
    JButton startButton;
    JButton closeButton;
    JPanel webcamPanel;
    Color defaultPanelColor;

    /*Definitions*/
    private DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;

    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();

    /*Class of threads*/
    class DaemonThread implements Runnable
    {
        protected volatile boolean runnable = false;

        @Override
        public  void run()
        {
            synchronized(this)
            {
                while(runnable)
                {
                    if(webSource.grab())
                    {
                        try
                        {
                            webSource.retrieve(frame);
                            Imgcodecs Highgui = null;
                            Highgui.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

                            BufferedImage buff = (BufferedImage) im;
                            Graphics g=webcamPanel.getGraphics();

                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight() -150 , 0, 0, buff.getWidth(), buff.getHeight(), null))

                                if(runnable == false)
                                {
                                    System.out.println("Going to wait()");
                                    this.wait();
                                }
                        }
                        catch(Exception ex)
                        {
                            System.out.println("Error");
                        }
                    }
                }
            }
        }
    }


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
        closeButton.setEnabled(false);
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
            //webcamPanel.setBackground(Color.BLACK);
            webSource =new VideoCapture(0); //video captured from default camera
            myThread = new DaemonThread(); //create object of thread class
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.runnable = true;

            t.start(); //starts thread
            startButton.setEnabled(false);  //start button
            closeButton.setEnabled(true);  // close button
        }
        if (e.getSource()==closeButton){
            System.out.println("Webcam closed");
            myThread.runnable = false; //stops the thread

            webcamPanel.setBackground(defaultPanelColor);
            closeButton.setEnabled(false);  // stop button
            startButton.setEnabled(true);  //start button

            webSource.release(); //Stop webcam
        }
    }
}
