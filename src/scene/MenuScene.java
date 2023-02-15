package scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import game.Game;
import input.MouseHandler;
import game.GameStates;
import ui.MyButton;
import util.Constants;

public class MenuScene extends Scene {

	private Font headingFont;
	private String displayText;
	private float textX, textY;

	private MyButton playButton, settingButton, quitButton;

	public MenuScene(Game game) {
		super(game);

		headingFont = new Font("Monospaced", Font.BOLD, 30 * Constants.SCALE);
		displayText = "Menu";
		textX = 0;
		textY = 0;
		playButton = new MyButton("Play", Constants.SCREEN_WIDTH / 2,
				Constants.SCREEN_HEIGHT / 3 + Constants.SCREEN_HEIGHT / 8, Constants.SCREEN_WIDTH / 5,
				Constants.SCREEN_HEIGHT / 9, 8 * Constants.SCALE);
		settingButton = new MyButton("Settings", Constants.SCREEN_WIDTH / 2,
				Constants.SCREEN_HEIGHT / 2 + Constants.SCREEN_HEIGHT / 8, Constants.SCREEN_WIDTH / 5,
				Constants.SCREEN_HEIGHT / 9, 8 * Constants.SCALE);
		quitButton = new MyButton("Quit", Constants.SCREEN_WIDTH / 2,
				(int) (Constants.SCREEN_HEIGHT / 1.5f + Constants.SCREEN_HEIGHT / 8), Constants.SCREEN_WIDTH / 5,
				Constants.SCREEN_HEIGHT / 9, 8 * Constants.SCALE);
	}

	@Override
	public void update() {
		updateButtons();
	}

	private void updateButtons() {
		playButton.update();
		settingButton.update();
		quitButton.update();

		if (playButton.isHover() && MouseHandler.mouseButtonDown(1))
			game.setState(GameStates.PLAY);

		if (settingButton.isHover() && MouseHandler.mouseButtonDown(1))
			game.setState(GameStates.OPTIONS);

		if (quitButton.isHover() && MouseHandler.mouseButtonDown(1))
			System.exit(0);
	}

	@Override
	public void render(Graphics2D g) {
		renderBackground(g);
		renderMenuText(g);
		renderButtons(g);
	}

	private void renderButtons(Graphics2D g) {
		playButton.render(g);
		settingButton.render(g);
		quitButton.render(g);
	}

	private void renderBackground(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
	}

	private void renderMenuText(Graphics2D g) {
		g.setColor(Color.black);
		g.setFont(headingFont);

		textX = (float) ((Constants.SCREEN_WIDTH / 2.0f)
				- (g.getFontMetrics().getStringBounds(displayText, g).getWidth() / 2.0f));
		textY = Constants.SCREEN_HEIGHT / 5;

		g.drawString(displayText, textX, textY);
	}
}
