package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;
import input.KeyHandler;
import input.MouseHandler;
import util.Constants;

public class Display extends JPanel {
	
	private Game game;
	private JFrame frame;
	
	public Display(Game game) {
		this.game = game;
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		this.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT));
		this.setDoubleBuffered(true);
		this.setBackground(Color.white);
		this.addKeyListener(KeyHandler.get());
		this.addMouseListener(MouseHandler.get());
		this.addMouseMotionListener(MouseHandler.get());
		this.setFocusable(true);
		frame.add(this);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		game.render(g2d);
		
		g2d.dispose();
	}
	
}
