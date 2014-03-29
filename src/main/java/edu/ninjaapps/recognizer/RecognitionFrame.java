package edu.ninjaapps.recognizer;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class RecognitionFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 1080;
    public static final int DEFAULT_HEIGHT = 600;
    public RecognitionFrame() {
        setTitle("Image Recognition");
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        RecognitionPanel panel = new RecognitionPanel(this);
        add(panel);
        pack();
    }
}
