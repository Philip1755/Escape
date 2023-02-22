package game;

import java.awt.Graphics2D;

import display.Display;
import scene.MenuScene;
import scene.SettingScene;
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
				scene = new SettingScene(this);
				break;
		}
	}

	public Display getDisplay() {
		return display;
	}
}
