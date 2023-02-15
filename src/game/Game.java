package game;

import java.awt.Graphics2D;

import display.Camera;
import display.Display;
import entity.Player;
import scene.MenuScene;
import scene.OptionScene;
import scene.PlayScene;
import scene.Scene;

public class Game {

	private Display display;

	private Scene scene;
	
	public Game() {
		setState(GameStates.MENU);
		
		startGame();
	}

	public void update() {
		scene.update();
	}
	
	public void render(Graphics2D g) {
		scene.render(g);
	}
	
	private void startGame() {
		display = new Display(this);
		new GameLoop(this);
	}

	//Getter and Setter

	public void setState(GameStates state) {
		switch (state) {
			case MENU:
				scene = new MenuScene(this);
				break;
			case PLAY:
				scene = new PlayScene(this);
				break;
			case OPTIONS:
				scene = new OptionScene(this);
				break;
		}
	}

	public Display getDisplay() {
		return display;
	}
}
