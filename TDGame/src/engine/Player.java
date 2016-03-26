package engine;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Player extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int x, y, dx, dy;
	private BufferedImage image;

	public Player(){

		try{
			image = ImageIO.read(new File("res\\Player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public BufferedImage getImage(){
		return image;
	}

	public void move() {
		x += dx;
		y += dy;
	}


	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_A) {
			dx = -10;
		}

		if (key == KeyEvent.VK_D) {
			dx = 10;
		}

		if (key == KeyEvent.VK_W) {
			dy = -10;
		}

		if (key == KeyEvent.VK_S) {
			dy = 10;
		}
	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_A) {
			dx = 0;
		}

		if (key == KeyEvent.VK_D) {
			dx = 0;
		}

		if (key == KeyEvent.VK_W) {
			dy = 0;
		}

		if (key == KeyEvent.VK_S) {
			dy = 0;
		}
	}
}
