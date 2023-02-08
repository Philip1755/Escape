package game;

import java.awt.Graphics2D;

import display.Camera;
import display.Display;
import entity.Player;

public class Game {

	private Display display;

	private Player player;
	
	public Game() {
		player = new Player();
		Camera.focusOn(player);
		
		startGame();
	}

	public void update() {
		player.update();
		
		Camera.update();
	}
	
	public void render(Graphics2D g) {
		player.render(g);
	}
	
	private void startGame() {
		display = new Display(this);
		new GameLoop(this);
	}

	//Getter and Setter
	
	public Display getDisplay() {
		return display;
	}
}
