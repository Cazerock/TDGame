package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage image;
	private boolean inGame = false;
	private Player player = new Player();
	private Timer timer;

	public Map(){

		inGame = true;
		setDoubleBuffered(true);
		setBackground(Color.BLACK);

		try{
			image = ImageIO.read(new File("res\\Untitled.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addKeyListener(new TAdapter());
		timer = new Timer(25, this);
		timer.start();

	}
	@Override
	public void paintComponent(Graphics g){

		if (inGame){
			super.paintComponent(g);
			doDrawing(g);
		} else {
			System.out.println("Not in Game");
		}
	}

	private void doDrawing(Graphics g){

		for (int i = 0; i<100; i++){
			for (int j = 0; j<100; j++){
				g.drawImage(image, j*64, i*64, null);
			}
		}

		g.drawImage(player.getImage(), player.getX(), player.getY(), null);

		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.move();
		repaint(); 
		System.out.println(player.getX() + ", " + player.getY());
		if (!inGame){
			timer.stop();
		}
	}

	private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
	
}

