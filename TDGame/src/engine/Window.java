package engine;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame frame = new JFrame();
	Map map = new Map();
	Player player = new Player();
	
	public Window(){
		
		frame.setSize(1920, 1080);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.add(map);
	}
	
	public Map getMap(){
		return map;
	}
	
}
