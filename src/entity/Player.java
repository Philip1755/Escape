package entity;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import input.KeyHandler;
import util.Constants;

public class Player extends Entity {

	public Player() {
		super(500, 500, 3.5f);
	}

	@Override
	public void update() {
		updatePosition();
	}

	private void updatePosition() {
		xDir = 0;
		yDir = 0;
		
		if(KeyHandler.isKeyPressed(KeyEvent.VK_W))
			yDir--;
		if(KeyHandler.isKeyPressed(KeyEvent.VK_A))
			xDir--;
		if(KeyHandler.isKeyPressed(KeyEvent.VK_S))
			yDir++;
		if(KeyHandler.isKeyPressed(KeyEvent.VK_D))
			xDir++;
		
		worldX += xDir * speed;
		worldY += yDir * speed;
	}

	@Override
	public void render(Graphics2D g) {
		renderPlayer(g);
	}

	private void renderPlayer(Graphics2D g) {
		g.fillRect(getWorldXInt(), getWorldYInt(), Constants.TILE_SIZE, Constants.TILE_SIZE);
	}

}
