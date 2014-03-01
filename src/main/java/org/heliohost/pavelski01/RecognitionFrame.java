package org.heliohost.pavelski01;
import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RecognitionFrame extends JFrame
{
	public RecognitionFrame()
	{
		setTitle("Image Recognition");
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		RecognitionPanel panel = new RecognitionPanel(this);
		add(panel);
		pack();
	}
	public static final int DEFAULT_WIDTH = 1080;
	public static final int DEFAULT_HEIGHT = 600;
}
