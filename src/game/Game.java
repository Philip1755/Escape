package game;

import java.awt.Graphics2D;

import display.Display;

public class Game {

	private Display display;
	
	public Game() {
		startGame();
	}

	public void update() {
		
	}
	
	public void render(Graphics2D g) {
		
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
