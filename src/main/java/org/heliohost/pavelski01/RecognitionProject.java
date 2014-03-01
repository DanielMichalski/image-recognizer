package org.heliohost.pavelski01;
import java.awt.EventQueue;
import javax.swing.JFrame;
/**
 * @author pavelski01
 *
 */
public class RecognitionProject
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
			{
				public void run()
				{
					RecognitionFrame frame = new RecognitionFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			});
	}
}