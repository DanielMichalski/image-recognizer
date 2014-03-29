package edu.ninjaapps.recognizer;

import javax.swing.*;
import java.awt.*;

public class RecognitionProject {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                RecognitionFrame frame = new RecognitionFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}