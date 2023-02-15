package scene;

import game.Game;
import game.GameStates;
import input.MouseHandler;
import ui.MyButton;
import util.Constants;

import java.awt.*;

public class OptionScene extends Scene {

	private Font headingFont;
	private String displayText;
	private float textX, textY;
	
	private MyButton menuButton;

	public OptionScene(Game game) {
		super(game);

		headingFont = new Font("Monospaced", Font.BOLD, 25 * Constants.SCALE);
		displayText = "Settings";
		textX = 0;
		textY = 0;
		menuButton = new MyButton("Back to Menu", Constants.SCREEN_WIDTH / 10, (int) (Constants.SCREEN_HEIGHT / 1.15f),
				Constants.SCREEN_WIDTH / 8, Constants.SCREEN_HEIGHT / 12, 3 * Constants.SCALE);
	}

	@Override
	public void update() {
		updateButton();
	}

	private void updateButton() {
		menuButton.update();

		if (menuButton.isHover() && MouseHandler.mouseButtonDown(1))
			game.setState(GameStates.MENU);
	}

	@Override
	public void render(Graphics2D g) {
		renderBackground(g);
		renderSettingsText(g);
		renderButton(g);
	}

	private void renderSettingsText(Graphics2D g) {
		g.setColor(Color.black);
		g.setFont(headingFont);

		textX = (float) ((Constants.SCREEN_WIDTH / 2.0f)
				- (g.getFontMetrics().getStringBounds(displayText, g).getWidth() / 2.0f));
		textY = Constants.SCREEN_HEIGHT / 6;

		g.drawString(displayText, textX, textY);
	}

	private void renderBackground(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
	}

	private void renderButton(Graphics2D g) {
		menuButton.render(g);
	}
}
