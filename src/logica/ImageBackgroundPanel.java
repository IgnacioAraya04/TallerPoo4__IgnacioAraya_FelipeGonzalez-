package logica;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageBackgroundPanel extends JPanel{
	private Image backgroundImage;

    public ImageBackgroundPanel(String imagePath) {
        // Load the image file
        this.backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Clears the screen and respects opaque rules
        // Draw the image scaled to fit the entire panel size
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
