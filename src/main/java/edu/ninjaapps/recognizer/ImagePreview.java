package edu.ninjaapps.recognizer;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

@SuppressWarnings("serial")
public class ImagePreview extends JLabel {
    public static final int DEFAULT_WIDTH = 100;
    public static final int DEFAULT_HEIGHT = 100;
    public ImagePreview(JFileChooser chooser) {
        super("", SwingConstants.CENTER);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setBorder(BorderFactory.createEtchedBorder());
        chooser.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
                    File file = (File) event.getNewValue();
                    if (file == null) {
                        setIcon(null);
                        return;
                    }
                    ImageIcon icon = new ImageIcon(file.getPath());
                    if (icon.getIconWidth() > getPreferredSize().width)
                        icon = new ImageIcon(icon.getImage().getScaledInstance(
                                getPreferredSize().width, -1, Image.SCALE_DEFAULT));
                    setIcon(icon);
                }
            }
        });
    }
}
